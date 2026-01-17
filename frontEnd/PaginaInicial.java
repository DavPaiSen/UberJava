package frontEnd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PaginaInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaginaInicial frame = new PaginaInicial();
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
	public PaginaInicial() {
		setTitle("UberLand");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnUsurio = new JButton("Usuário");
		btnUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUsurio.setBounds(30, 124, 150, 55);
		contentPane.add(btnUsurio);
		
		JButton btnMotorista = new JButton("Motorista");
		btnMotorista.setBounds(269, 124, 150, 55);
		contentPane.add(btnMotorista);
		
		JLabel lblSelecioneUmaOpo = new JLabel("Selecione uma opção:");
		lblSelecioneUmaOpo.setBackground(Color.DARK_GRAY);
		lblSelecioneUmaOpo.setBounds(151, 35, 143, 49);
		contentPane.add(lblSelecioneUmaOpo);

	}
}
