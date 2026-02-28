package frontEnd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backEnd.Corrida;
import backEnd.Principal;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EscolherCorrida extends JFrame {
	private int i = 0;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EscolherCorrida frame = new EscolherCorrida();
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
	public EscolherCorrida() {
		setTitle("Escolher corrida");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel labelDistancia = new JLabel("");
		contentPane.add(labelDistancia);
		labelDistancia.setText("Distancia: " + String.valueOf(Principal.getCorrida(0).getDistancia()));
		
		JLabel labelNomePassageiro = new JLabel("");
		contentPane.add(labelNomePassageiro);
		labelNomePassageiro.setText("Nome do passageiro: " + Principal.getCorrida(0).getUsuario().getNomeSocialString());
		
		JButton btnAceitar = new JButton("Aceitar");
		btnAceitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.setCorridaAtiva(Principal.getCorrida(i));
				EmCorridaMotorista emCorridaMotorista = new EmCorridaMotorista();
				emCorridaMotorista.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnAceitar);
		
		JButton btnRecusar = new JButton("Recusar");
		btnRecusar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i++;
				Corrida atual = Principal.getCorrida(i);
				if (atual == null) {
					setTitle("Acabaram as corridas!");
					return;
				}
				labelDistancia.setText(String.valueOf(atual.getDistancia()));
				labelNomePassageiro.setText(atual.getUsuario().getNomeSocialString());
			}
		});
		contentPane.add(btnRecusar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnSair);

	}

}
