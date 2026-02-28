package frontEnd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backEnd.Principal;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmCorridaMotorista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmCorridaMotorista frame = new EmCorridaMotorista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EmCorridaMotorista() {
		setTitle("Em corrida");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNomePassageiro = new JLabel("Nome do passageiro: " + Principal.getCorridaAtiva().getUsuario().getNomeSocialString());
		contentPane.add(lblNomePassageiro);
		
		JLabel lblDistanciaTotal = new JLabel(String.valueOf("Distancia total da corrida: " + Principal.getCorridaAtiva().getDistancia()) + "Km");
		contentPane.add(lblDistanciaTotal);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.getCorridaAtiva().cancela(Principal.getLogadoMotorista());
				//System.out.println(Principal.getCorridaAtiva().getCancelada());
				dispose();
			}
		});
		
		JLabel labelNotaPassageiro = new JLabel("Nota do passageiro: " + String.valueOf(Principal.getCorridaAtiva().getUsuario().getMedia()));
		contentPane.add(labelNotaPassageiro);
		contentPane.add(btnCancelar);
		
		JButton btnAvancarAteO = new JButton("Avancar para o fim da corrida");
		btnAvancarAteO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AvaliarPassageiro avaliarPassageiro = new AvaliarPassageiro();
				avaliarPassageiro.setVisible(true);
				dispose();
				
			}
		});
		contentPane.add(btnAvancarAteO);

	}

}
