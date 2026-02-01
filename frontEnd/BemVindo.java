package frontEnd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.JSeparator;
import javax.swing.UIManager;

public class BemVindo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblBemVindoAo = new JLabel("Bem vindo ao UberLand, por favor selecione uma opção:");
	private final JPanel panel = new JPanel();
	private final JSplitPane splitPane = new JSplitPane();
	private final JButton btnCliente = new JButton("Cliente");
	private final JButton btnMotorista = new JButton("Motorista");
	private final JPanel panel_1 = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BemVindo frame = new BemVindo();
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
	public BemVindo() {
		setTitle("Bem vindo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		contentPane.add(panel, BorderLayout.SOUTH);
		
		panel.add(splitPane);
		
		splitPane.setLeftComponent(btnCliente);
		
		splitPane.setRightComponent(btnMotorista);
		
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.add(lblBemVindoAo);
		lblBemVindoAo.setVerticalAlignment(SwingConstants.TOP);
		lblBemVindoAo.setHorizontalAlignment(SwingConstants.CENTER);

	}

}
