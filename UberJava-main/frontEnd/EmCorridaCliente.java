package frontEnd;

import backEnd.Corrida;
import backEnd.Principal;

import javax.swing.*;
import java.awt.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EmCorridaCliente extends JFrame {

    private static final long serialVersionUID = 1L;
    private static final DateTimeFormatter FMT_HORA = DateTimeFormatter.ofPattern("HH:mm:ss");

    private JLabel lblNomeMotorista;
    private JLabel lblTempoDecorrido;
    private JLabel lblTempoEstimadoRestante;
    private Timer timerAtualizacao;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmCorridaCliente frame = new EmCorridaCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    
    
    public EmCorridaCliente() {
        super("Corrida em Andamento");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(520, 380);
        setLocationRelativeTo(null);

        initComponents();
        atualizarInformacoesIniciais();

        // Atualiza a cada 10 segundos  
        timerAtualizacao = new Timer(10000, e -> atualizarTempo());
        timerAtualizacao.start();
    }

    private void initComponents() {
        JPanel contentPane = new JPanel(new BorderLayout(10, 10));
        contentPane.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        setContentPane(contentPane);

        JLabel lblTitulo = new JLabel("Sua corrida está em andamento", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        contentPane.add(lblTitulo, BorderLayout.NORTH);

        JPanel panelInfo = new JPanel(new GridLayout(0, 2, 12, 12));
        panelInfo.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        panelInfo.add(new JLabel("Motorista:", SwingConstants.RIGHT));
        lblNomeMotorista = new JLabel("—");
        lblNomeMotorista.setFont(new Font("Segoe UI", Font.BOLD, 15));
        panelInfo.add(lblNomeMotorista);

        panelInfo.add(new JLabel("Início da corrida:", SwingConstants.RIGHT));
        JLabel lblInicio = new JLabel("—");
        panelInfo.add(lblInicio);

        panelInfo.add(new JLabel("Tempo decorrido:", SwingConstants.RIGHT));
        lblTempoDecorrido = new JLabel("—");
        panelInfo.add(lblTempoDecorrido);

        panelInfo.add(new JLabel("Tempo estimado restante:", SwingConstants.RIGHT));
        lblTempoEstimadoRestante = new JLabel("—");
        panelInfo.add(lblTempoEstimadoRestante);

        contentPane.add(panelInfo, BorderLayout.CENTER);

        // com botão de cancelar ou finalizar 
        JPanel rodape = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        JButton btnCancelar = new JButton("Cancelar Corrida (se permitido)");
        btnCancelar.setForeground(new Color(200, 0, 0));
        btnCancelar.addActionListener(e -> tentarCancelar());
        rodape.add(btnCancelar);

        contentPane.add(rodape, BorderLayout.SOUTH);
    }

    private void atualizarInformacoesIniciais() {
        Corrida corrida = Principal.getCorridaAtiva();
        if (corrida == null || corrida.getMotorista() == null) {
            lblNomeMotorista.setText("Motorista não alocado ainda");
            lblTempoEstimadoRestante.setText("—");
            return;
        }

        lblNomeMotorista.setText(corrida.getNomeMotorista());
        
       
    }

    private void atualizarTempo() {
        Corrida corrida = Principal.getCorridaAtiva();
        if (corrida == null || corrida.getHoraInicio() == null) return;

        Duration decorrido = Duration.between(corrida.getHoraInicio(), LocalDateTime.now());
        long minutosDecorridos = decorrido.toMinutes();
        String textoDecorrido = String.format("%d min %02d s", minutosDecorridos, decorrido.getSeconds() % 60);
        lblTempoDecorrido.setText(textoDecorrido);

        // pode melhorar depois
        float distanciaKm = corrida.getDistancia();
        float velocidadeMediaKmH = 40f;
        float tempoTotalHoras = distanciaKm / velocidadeMediaKmH;
        long tempoTotalSegundos = (long) (tempoTotalHoras * 3600);
        long segundosRestantes = tempoTotalSegundos - decorrido.getSeconds();

        if (segundosRestantes > 0) {
            long minRest = segundosRestantes / 60;
            long segRest = segundosRestantes % 60;
            lblTempoEstimadoRestante.setText(String.format("~ %d min %02d s", minRest, segRest));
        } else {
            lblTempoEstimadoRestante.setText("Chegando em breve");
        }
    }

    private void tentarCancelar() {
        Corrida corrida = Principal.getCorridaAtiva();
        if (corrida == null) return;

        int resposta = JOptionPane.showConfirmDialog(this,
                "Deseja realmente cancelar a corrida?\nPode haver cobrança de taxa.",
                "Confirmar cancelamento", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            corrida.cancela(Principal.getLogadoUsuario());
            Principal.setCorridaAtiva(null);
            timerAtualizacao.stop();
            JOptionPane.showMessageDialog(this, "Corrida cancelada.");
            dispose();
  
        }
    }

    @Override
    public void dispose() {
        if (timerAtualizacao != null) {
            timerAtualizacao.stop();
        }
        super.dispose();
    }

  
}