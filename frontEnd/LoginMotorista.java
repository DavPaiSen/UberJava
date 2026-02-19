package frontEnd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backEnd.Principal;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginMotorista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCnh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginMotorista frame = new LoginMotorista();
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
	public LoginMotorista() {
		setTitle("Login motorista");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Por favor insira as suas informações de login:");
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		panel.add(splitPane);
		
		JLabel lblNome = new JLabel("Nome:");
		splitPane.setLeftComponent(lblNome);
		
		txtNome = new JTextField();
		splitPane.setRightComponent(txtNome);
		txtNome.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JSplitPane splitPane_1 = new JSplitPane();
		panel.add(splitPane_1);
		
		JLabel lblCnh = new JLabel("CNH:");
		splitPane_1.setLeftComponent(lblCnh);
		
		txtCnh = new JTextField();
		splitPane_1.setRightComponent(txtCnh);
		txtCnh.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JSplitPane splitPane_2 = new JSplitPane();
		panel.add(splitPane_2);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CriarOuLogar criarOuLogar = new CriarOuLogar();
				criarOuLogar.setVisible(true);
				dispose();
			}
		});
		splitPane_2.setLeftComponent(btnCancelar);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtNome.getText();
				String cnh = txtCnh.getText(); 
				if (Principal.achaMotorista(nome, cnh)) {
					EscolherVeiculo escolherVeiculo = new EscolherVeiculo();
					escolherVeiculo.setVisible(true);
					dispose();
				} else {
					setTitle("Nao foi possivel encontrar um motorista com essas informacoes de login!");
				}
			}
		});
		splitPane_2.setRightComponent(btnEntrar);

	}

}
