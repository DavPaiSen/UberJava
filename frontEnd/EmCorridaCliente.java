package frontEnd;

import java.awt.EventQueue;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.TemporalUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backEnd.Principal;

import javax.swing.JLabel;

public class EmCorridaCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public EmCorridaCliente() {
		Principal.getCorridaAtiva().setHoraInicio(LocalDateTime.now());
		setTitle("Em corrida");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNomeDoMotorista = new JLabel("Nome do motorista:");
		contentPane.add(lblNomeDoMotorista);
		
		JLabel labelNomeMotorista = new JLabel("");
		contentPane.add(labelNomeMotorista);
		labelNomeMotorista.setText(Principal.getCorridaAtiva().getNomeMotorista());
		
		JLabel lblNewLabel = new JLabel("                                                                                                                                                                                                                                                                        ");
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tempo estimado ate o fim da corrida:");
		contentPane.add(lblNewLabel_1);
		
		JLabel labelTempoRestante = new JLabel("");
		contentPane.add(labelTempoRestante);
		Duration duracao = Duration.between(Principal.getCorridaAtiva().getHoraInicio(), LocalDateTime.now());
		float distancia = Principal.getCorridaAtiva().getDistancia();
		float tempoEstimadoHoras = distancia / 40f; //assumindo uma media de 40km\h
		float tempoRestanteHoras = tempoEstimadoHoras - duracao.toHours();
		labelTempoRestante.setText(String.valueOf(tempoRestanteHoras * 60.0f) + "minutos");
		

	}

}
