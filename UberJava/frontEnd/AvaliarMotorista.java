package frontEnd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.Component;

public class AvaliarMotorista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public AvaliarMotorista() {
		setTitle("Avalie sua viagem");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(0.5);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane_1);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.5);
		splitPane_1.setLeftComponent(splitPane);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		
		JPanel panel_2 = new JPanel();
		splitPane.setRightComponent(panel_2);
		
		JButton button = new JButton("1");
		panel_2.add(button);
		
		JButton button_1 = new JButton("2");
		panel_2.add(button_1);
		
		JButton button_2 = new JButton("3");
		panel_2.add(button_2);
		
		JButton button_3 = new JButton("4");
		panel_2.add(button_3);
		
		JButton button_4 = new JButton("5");
		panel_2.add(button_4);
		
		JLabel lblComoFoiA = new JLabel("Avalie como foi a viagem:");
		lblComoFoiA.setHorizontalAlignment(SwingConstants.CENTER);
		splitPane.setLeftComponent(lblComoFoiA);
		
		JPanel panel = new JPanel();
		splitPane_1.setRightComponent(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btnAvaliar = new JButton("Avaliar");
		btnAvaliar.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(btnAvaliar);

	}

}
