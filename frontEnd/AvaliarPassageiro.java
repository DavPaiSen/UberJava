package frontEnd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class AvaliarPassageiro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AvaliarPassageiro frame = new AvaliarPassageiro();
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
	public AvaliarPassageiro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.5);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(0.5);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setLeftComponent(splitPane_1);
		
		JLabel lblAvalieOPassageiro = new JLabel("Avalie o passageiro:");
		lblAvalieOPassageiro.setHorizontalAlignment(SwingConstants.CENTER);
		splitPane_1.setLeftComponent(lblAvalieOPassageiro);
		
		JPanel panel = new JPanel();
		splitPane_1.setRightComponent(panel);
		
		JButton button = new JButton("1");
		panel.add(button);
		
		JButton button_1 = new JButton("2");
		panel.add(button_1);
		
		JButton button_2 = new JButton("3");
		panel.add(button_2);
		
		JButton button_3 = new JButton("4");
		panel.add(button_3);
		
		JButton button_4 = new JButton("5");
		panel.add(button_4);
		
		JButton btnAvaliar = new JButton("Avaliar");
		splitPane.setRightComponent(btnAvaliar);

	}

}
