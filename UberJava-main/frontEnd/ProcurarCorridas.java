package frontEnd;

import backEnd.*;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProcurarCorridas extends JFrame {

    private static final long serialVersionUID = 1L;
    private static final DateTimeFormatter HORA_FMT = DateTimeFormatter.ofPattern("HH:mm");

    private JLabel lblStatus;
    private JLabel lblPassageiro;
    private JLabel lblServico;
    private JLabel lblDistancia;
    private JLabel lblMotorista;
    private JButton btnCancelar;

    private Timer timerBusca;
    
    
   
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProcurarCorridas frame = new ProcurarCorridas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

    
    
    

    public ProcurarCorridas() {
        super("Procurando Motorista...");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(480, 340);
        setLocationRelativeTo(null);

        initComponents();
        carregarDadosIniciais();


        iniciarBuscaMotorista();
    }

    private void initComponents() {
        JPanel contentPane = new JPanel(new BorderLayout(10, 10));
        contentPane.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        setContentPane(contentPane);

       
        lblStatus = new JLabel("Buscando motorista disponível...", SwingConstants.CENTER);
        contentPane.add(lblStatus, BorderLayout.NORTH);

        JPanel panelInfo = new JPanel(new GridLayout(0, 2, 12, 10));
        panelInfo.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        addLabelPair(panelInfo, "Passageiro:", lblPassageiro = new JLabel("—"));
        addLabelPair(panelInfo, "Serviço:",     lblServico   = new JLabel("—"));
        addLabelPair(panelInfo, "Distância:",   lblDistancia = new JLabel("— km"));
        addLabelPair(panelInfo, "Motorista:",   lblMotorista = criarLabelMotorista());

        contentPane.add(panelInfo, BorderLayout.CENTER);
        
        JPanel rodape = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 12));
        btnCancelar = new JButton("Cancelar solicitação");
        btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnCancelar.setPreferredSize(new Dimension(220, 40));
        btnCancelar.addActionListener(e -> cancelarSolicitacao());
        rodape.add(btnCancelar);

        contentPane.add(rodape, BorderLayout.SOUTH);
    }

    private void addLabelPair(JPanel panel, String texto, JLabel valor) {
        JLabel label = new JLabel(texto, SwingConstants.RIGHT);
        panel.add(label);
        panel.add(valor);
    }

    private JLabel criarLabelMotorista() {
        JLabel lbl = new JLabel("Aguardando alocação...");
        return lbl;
    }

    private void carregarDadosIniciais() {
        Usuario usuario = Principal.getLogadoUsuario();
        lblPassageiro.setText(usuario != null ? usuario.getNomeString() : "—");

        String servico = switch (Principal.getCategoria()) {
            case 0 -> "UberX";
            case 1 -> "UberComfort";
            case 2 -> "UberBlack";
            case 3 -> "UberPrioridade";
            default -> "Categoria desconhecida";
        };
        lblServico.setText(servico);

        Corrida corrida = Principal.getCorridaAtiva();
        if (corrida != null) {
            lblDistancia.setText(String.format("%.1f km", corrida.getDistancia()));
        }
    }

    private void iniciarBuscaMotorista() {
        timerBusca = new Timer(3500, e -> tentarAlocarMotorista());
        timerBusca.setRepeats(true);
        timerBusca.start();
    }

    private void tentarAlocarMotorista() {
        Corrida corrida = Principal.getCorridaAtiva();
        if (corrida == null || corrida.isEncerrada()) {
            pararBusca("Corrida não existe ou foi finalizada");
            return;
        }

        Class<? extends Veiculo> tipoVeiculo = mapearCategoriaParaTipoVeiculo(Principal.getCategoria());
        if (tipoVeiculo == null) {
            pararBusca("Categoria de serviço inválida");
            return;
        }

        Motorista motorista = Principal.procuraMotorista(tipoVeiculo);
        if (motorista == null) {
            lblStatus.setText("Ainda procurando... " + LocalDateTime.now().format(HORA_FMT));
            return;
        }

        
        pararBusca(null);
        lblStatus.setText("Motorista a caminho!");


        Veiculo veiculo = motorista.veiculoAtivo();
        String info = motorista.getNomeString();
        if (veiculo != null) {
            info += " • " + veiculo.getPlacaString();
        }
        lblMotorista.setText(info);
        

        btnCancelar.setText("Cancelar (em andamento)");

      
       corrida.alocarMotorista(motorista);
       corrida.iniciarCorrida();  

        SwingUtilities.invokeLater(() -> {
            new EmCorridaCliente().setVisible(true);
            dispose();
        });
    }

    private Class<? extends Veiculo> mapearCategoriaParaTipoVeiculo(int categoria) {
        return switch (categoria) {
            case 0 -> UberX.class;
            case 1 -> UberComfort.class;
            case 2 -> UberBlack.class;
            case 3 -> UberPrioridade.class;
            default -> null;
        };
    }

    private void pararBusca(String mensagem) {
        if (timerBusca != null) {
            timerBusca.stop();
        }
        if (mensagem != null) {
            lblStatus.setText(mensagem);
          
        }
    }

    private void cancelarSolicitacao() {
        Corrida corrida = Principal.getCorridaAtiva();
        if (corrida != null) {
            corrida.cancela(Principal.getLogadoUsuario());
            Principal.setCorridaAtiva(null);
        }
        dispose();
        // ver sobre naavegação e janela enceramentos
    }

}