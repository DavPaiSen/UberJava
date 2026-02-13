package frontEnd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JButton;

public class LoginCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginCliente frame = new LoginCliente();
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
	public LoginCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPorFavorInsira = new JLabel("Por favor insira as suas informações de login:");
		lblPorFavorInsira.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblPorFavorInsira, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		panel.add(splitPane);
		
		JLabel lblEmail = new JLabel("Email:");
		splitPane.setLeftComponent(lblEmail);
		
		textField = new JTextField();
		splitPane.setRightComponent(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JSplitPane splitPane_1 = new JSplitPane();
		panel.add(splitPane_1);
		
		JLabel lblCpf = new JLabel("CPF:");
		splitPane_1.setLeftComponent(lblCpf);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Inserir apenas numeros");
		splitPane_1.setRightComponent(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		panel.add(lblNewLabel);
		
		JSplitPane splitPane_2 = new JSplitPane();
		panel.add(splitPane_2);
		
		JButton btnCancelar = new JButton("Cancelar");
		splitPane_2.setLeftComponent(btnCancelar);
		
		JButton btnEnviar = new JButton("Enviar");
		splitPane_2.setRightComponent(btnEnviar);
		

	}

}
