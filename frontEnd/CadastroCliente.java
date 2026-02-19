package frontEnd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backEnd.Pessoa;
import backEnd.Usuario;

import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textCpf;
	private JTextField textNomeSocial;
	private JTextField textNroCelular;
	private JTextField textEmail;
	private JTextField textNascimento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCliente frame = new CadastroCliente();
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
	public CadastroCliente() {
		setTitle("Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JSplitPane splitPane = new JSplitPane();
		contentPane.add(splitPane);
		
		JLabel lblNome = new JLabel("Nome:");
		splitPane.setLeftComponent(lblNome);
		
		textNome = new JTextField();
		textNome.setColumns(10);
		splitPane.setRightComponent(textNome);
		
		JSplitPane splitPane_1 = new JSplitPane();
		contentPane.add(splitPane_1);
		
		JLabel lblCpf = new JLabel("CPF:");
		splitPane_1.setLeftComponent(lblCpf);
		
		textCpf = new JTextField();
		textCpf.setColumns(10);
		splitPane_1.setRightComponent(textCpf);
		
		JSplitPane splitPane_2 = new JSplitPane();
		contentPane.add(splitPane_2);
		
		JLabel lblNewLabel = new JLabel("Nome social:");
		splitPane_2.setLeftComponent(lblNewLabel);
		
		textNomeSocial = new JTextField();
		textNomeSocial.setColumns(10);
		splitPane_2.setRightComponent(textNomeSocial);
		
		JSplitPane splitPane_3 = new JSplitPane();
		contentPane.add(splitPane_3);
		
		JLabel lblNewLabel_1 = new JLabel("Nro de celular:");
		splitPane_3.setLeftComponent(lblNewLabel_1);
		
		textNroCelular = new JTextField();
		textNroCelular.setColumns(10);
		splitPane_3.setRightComponent(textNroCelular);
		
		JSplitPane splitPane_4 = new JSplitPane();
		contentPane.add(splitPane_4);
		
		JLabel lblEmail = new JLabel("Email:");
		splitPane_4.setLeftComponent(lblEmail);
		
		textEmail = new JTextField();
		splitPane_4.setRightComponent(textEmail);
		textEmail.setColumns(10);
		
		JSplitPane splitPane_5 = new JSplitPane();
		contentPane.add(splitPane_5);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento:");
		splitPane_5.setLeftComponent(lblDataDeNascimento);
		
		textNascimento = new JTextField();
		splitPane_5.setRightComponent(textNascimento);
		textNascimento.setColumns(10);
		
		JSplitPane splitPane_6 = new JSplitPane();
		splitPane_6.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane_6);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setHorizontalAlignment(SwingConstants.CENTER);
		splitPane_6.setLeftComponent(lblSexo);
		
		JSplitPane splitPane_7 = new JSplitPane();
		splitPane_6.setRightComponent(splitPane_7);
		
		JSplitPane splitPane_8 = new JSplitPane();
		splitPane_7.setRightComponent(splitPane_8);
		
		JCheckBox chckbxMasculino = new JCheckBox("masculino");
		splitPane_8.setLeftComponent(chckbxMasculino);
		
		JCheckBox chckbxFeminino = new JCheckBox("feminino");
		splitPane_8.setRightComponent(chckbxFeminino);
		
		JCheckBox chckbxOutro = new JCheckBox("outro");
		splitPane_7.setLeftComponent(chckbxOutro);
		
		JSplitPane splitPane_9 = new JSplitPane();
		splitPane_9.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane_9);
		
		JLabel lblFormaDePagamento = new JLabel("Forma de pagamento preferida:");
		splitPane_9.setLeftComponent(lblFormaDePagamento);
		
		JSplitPane splitPane_10 = new JSplitPane();
		splitPane_9.setRightComponent(splitPane_10);
		
		JSplitPane splitPane_11 = new JSplitPane();
		splitPane_10.setLeftComponent(splitPane_11);
		
		JCheckBox chckbxCartaoDeDebito = new JCheckBox("Cartao de debito");
		splitPane_11.setLeftComponent(chckbxCartaoDeDebito);
		
		JCheckBox chckbxCartaoDeCredito = new JCheckBox("Cartao de credito");
		splitPane_11.setRightComponent(chckbxCartaoDeCredito);
		
		JSplitPane splitPane_12 = new JSplitPane();
		splitPane_10.setRightComponent(splitPane_12);
		
		JCheckBox chckbxPix = new JCheckBox("PIX");
		splitPane_12.setLeftComponent(chckbxPix);
		
		JCheckBox chckbxDinheiro = new JCheckBox("Dinheiro");
		splitPane_12.setRightComponent(chckbxDinheiro);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		
		//ButtonGroup e para que nao tenha mais de uma opcao selecionada no mesmo grupo (forma de pagamento e sexo)
		
		ButtonGroup pagamentoButtonGroup = new ButtonGroup();
		pagamentoButtonGroup.add(chckbxDinheiro);
		pagamentoButtonGroup.add(chckbxPix);
		pagamentoButtonGroup.add(chckbxCartaoDeCredito);
		pagamentoButtonGroup.add(chckbxCartaoDeDebito);
		
		ButtonGroup sexoButtonGroup = new ButtonGroup();
		sexoButtonGroup.add(chckbxOutro);
		sexoButtonGroup.add(chckbxMasculino);
		sexoButtonGroup.add(chckbxFeminino);
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nroCelular = textNroCelular.getText();
				String cpf = textCpf.getText();
				String nome = textNome.getText();
				String nomeSocial = textNomeSocial.getText();
				String email = textEmail.getText();
				String nascimento = textNascimento.getText();
				
				int pagamento = -1;
				if (chckbxCartaoDeCredito.isSelected()) {
					pagamento = 0;
				} else if (chckbxCartaoDeDebito.isSelected()) {
					pagamento = 1;
				} else if (chckbxPix.isSelected()) {
					pagamento = 2;
				} else if (chckbxPix.isSelected()) {
					pagamento = 3;
				}
				
				int sexo = -1;
				if (chckbxMasculino.isSelected()) {
					sexo = 0;
				} else if (chckbxFeminino.isSelected()) {
					sexo = 1;
				} else if (chckbxOutro.isSelected()) {
					sexo = 2;
				}
				if (sexo != -1 && pagamento != -1 && Pessoa.cpfValido(cpf)) {
					Usuario usuario = new Usuario(cpf, nome, nomeSocial, nroCelular, email, nascimento, sexo, pagamento);
					backEnd.Principal.adicionaUsuario(usuario);
				} else if (sexo == -1){
					setTitle("É preciso selecionar algum sexo!");
				} else if (pagamento == -1) {
					setTitle("É preciso selecionar alguma forma de pagameto!");
				} else {
					setTitle("Cpf invalido!!");
				}
				
				PedirCorrida pedirCorrida = new PedirCorrida();
				pedirCorrida.setVisible(true);
				dispose();
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
