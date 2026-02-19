package frontEnd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class EscolherVeiculo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textPlaca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EscolherVeiculo frame = new EscolherVeiculo();
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
	public EscolherVeiculo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JSplitPane splitPane = new JSplitPane();
		panel.add(splitPane);
		
		JLabel lblInsiraAPlaca = new JLabel("Insira a placa do veiculo a ser selecionado:");
		splitPane.setLeftComponent(lblInsiraAPlaca);
		
		textPlaca = new JTextField();
		splitPane.setRightComponent(textPlaca);
		textPlaca.setColumns(10);
		
		JButton btnBuscarVeiculo = new JButton("Buscar veiculo");
		panel.add(btnBuscarVeiculo);
		
		JButton btnCadastrarVeiculo = new JButton("Cadastrar veiculo");
		btnCadastrarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel label = new JLabel("                                                                                                                                                             ");
		panel.add(label);
		panel.add(btnCadastrarVeiculo);
		
		JLabel lblnnnnnnnnnn = new JLabel("                                                                                                                                                                                                                                                                                                                                                                        ");
		panel.add(lblnnnnnnnnnn);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton);

	}

}
