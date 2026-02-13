package frontEnd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.Principal;
import java.awt.event.ActionEvent;

public class CadastroMotorista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

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
		
		JSplitPane splitPane_5 = new JSplitPane();
		contentPane.add(splitPane_5);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento:");
		splitPane_5.setLeftComponent(lblDataDeNascimento);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		splitPane_5.setRightComponent(textField_5);
		
		JSplitPane splitPane_9 = new JSplitPane();
		contentPane.add(splitPane_9);
		
		JLabel lblEndereco = new JLabel("Endereco:");
		splitPane_9.setLeftComponent(lblEndereco);
		
		textField_6 = new JTextField();
		splitPane_9.setRightComponent(textField_6);
		textField_6.setColumns(10);
		
		JSplitPane splitPane_10 = new JSplitPane();
		contentPane.add(splitPane_10);
		
		JLabel lblCnh = new JLabel("CNH:");
		splitPane_10.setLeftComponent(lblCnh);
		
		textField_7 = new JTextField();
		splitPane_10.setRightComponent(textField_7);
		textField_7.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		contentPane.add(btnCadastrar);

	}

}
