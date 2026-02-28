package frontEnd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backEnd.Motorista;
import backEnd.Pessoa;

import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.Principal;
import java.awt.event.ActionEvent;

public class CadastroMotorista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtNomeSocial;
	private JTextField txtDataDeNascimento;
	private JTextField txtEndereco;
	private JTextField txtCnh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroMotorista frame = new CadastroMotorista();
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
	public CadastroMotorista() {
		setTitle("Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JSplitPane splitPane = new JSplitPane();
		contentPane.add(splitPane);
		
		JLabel lblNome = new JLabel("Nome:");
		splitPane.setLeftComponent(lblNome);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		splitPane.setRightComponent(txtNome);
		
		JSplitPane splitPane_1 = new JSplitPane();
		contentPane.add(splitPane_1);
		
		JLabel lblCpf = new JLabel("CPF:");
		splitPane_1.setLeftComponent(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		splitPane_1.setRightComponent(txtCpf);
		
		JSplitPane splitPane_2 = new JSplitPane();
		contentPane.add(splitPane_2);
		
		JLabel lblNewLabel = new JLabel("Nome social:");
		splitPane_2.setLeftComponent(lblNewLabel);
		
		txtNomeSocial = new JTextField();
		txtNomeSocial.setColumns(10);
		splitPane_2.setRightComponent(txtNomeSocial);
		
		JSplitPane splitPane_5 = new JSplitPane();
		contentPane.add(splitPane_5);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento:");
		splitPane_5.setLeftComponent(lblDataDeNascimento);
		
		txtDataDeNascimento = new JTextField();
		txtDataDeNascimento.setColumns(10);
		splitPane_5.setRightComponent(txtDataDeNascimento);
		
		JSplitPane splitPane_9 = new JSplitPane();
		contentPane.add(splitPane_9);
		
		JLabel lblEndereco = new JLabel("Endereco:");
		splitPane_9.setLeftComponent(lblEndereco);
		
		txtEndereco = new JTextField();
		splitPane_9.setRightComponent(txtEndereco);
		txtEndereco.setColumns(10);
		
		JSplitPane splitPane_10 = new JSplitPane();
		contentPane.add(splitPane_10);
		
		JLabel lblCnh = new JLabel("CNH:");
		splitPane_10.setLeftComponent(lblCnh);
		
		txtCnh = new JTextField();
		splitPane_10.setRightComponent(txtCnh);
		txtCnh.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtNome.getText();
				String nomeSocial = txtNomeSocial.getText();
				String cpf = txtCpf.getText();
				String cnh = txtCnh.getText();
				String dataNascimento = txtDataDeNascimento.getText();
				String endereco = txtEndereco.getText();
				
				
				if (Pessoa.cpfValido(cpf)) {
					try {
						Motorista motorista = new Motorista(cpf, nome, nomeSocial, endereco, dataNascimento, cnh);
						backEnd.Principal.adicionarMotorista(motorista);
						backEnd.Principal.setLogadoMotorista(motorista);
					} catch (IOException e1) {
						System.out.println("Erro ao abrir o arquivo!");
						e1.printStackTrace();
					}
					EscolherVeiculo escolherVeiculo = new EscolherVeiculo();
					escolherVeiculo.setVisible(true);
					dispose();
				} else {
					setTitle("CPF invalido, tentar novamente!");
				}
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CriarOuLogar criarOuLogar = new CriarOuLogar();
				criarOuLogar.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnCancelar);
		contentPane.add(btnCadastrar);

	}

}
