package frontEnd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class CadastroCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

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
		
		textField = new JTextField();
		textField.setColumns(10);
		splitPane.setRightComponent(textField);
		
		JSplitPane splitPane_1 = new JSplitPane();
		contentPane.add(splitPane_1);
		
		JLabel lblCpf = new JLabel("CPF:");
		splitPane_1.setLeftComponent(lblCpf);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		splitPane_1.setRightComponent(textField_1);
		
		JSplitPane splitPane_2 = new JSplitPane();
		contentPane.add(splitPane_2);
		
		JLabel lblNewLabel = new JLabel("Nome social:");
		splitPane_2.setLeftComponent(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		splitPane_2.setRightComponent(textField_2);
		
		JSplitPane splitPane_3 = new JSplitPane();
		contentPane.add(splitPane_3);
		
		JLabel lblNewLabel_1 = new JLabel("Nro de celular:");
		splitPane_3.setLeftComponent(lblNewLabel_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		splitPane_3.setRightComponent(textField_3);
		
		JSplitPane splitPane_4 = new JSplitPane();
		contentPane.add(splitPane_4);
		
		JLabel lblEmail = new JLabel("Email:");
		splitPane_4.setLeftComponent(lblEmail);
		
		textField_4 = new JTextField();
		splitPane_4.setRightComponent(textField_4);
		textField_4.setColumns(10);
		
		JSplitPane splitPane_5 = new JSplitPane();
		contentPane.add(splitPane_5);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento:");
		splitPane_5.setLeftComponent(lblDataDeNascimento);
		
		textField_5 = new JTextField();
		splitPane_5.setRightComponent(textField_5);
		textField_5.setColumns(10);
		
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
		contentPane.add(btnCadastrar);

	}

}
