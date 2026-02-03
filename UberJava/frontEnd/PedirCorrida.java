package frontEnd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

public class PedirCorrida extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public PedirCorrida() {
		setTitle("Pedir corrida");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSelecioneOServio = new JLabel("Selecione o serviço que voce deseja:");
		lblSelecioneOServio.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblSelecioneOServio, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel.add(splitPane);
		
		JButton btnUberx = new JButton("UberX");
		splitPane.setLeftComponent(btnUberx);
		
		JButton btnUbercomfort = new JButton("UberComfort");
		splitPane.setRightComponent(btnUbercomfort);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel.add(splitPane_1);
		
		JButton btnUberblack = new JButton("UberBlack");
		splitPane_1.setLeftComponent(btnUberblack);
		
		JButton btnUberprioridade = new JButton("UberPrioridade");
		splitPane_1.setRightComponent(btnUberprioridade);
		
		JSplitPane splitPane_2 = new JSplitPane();
		contentPane.add(splitPane_2, BorderLayout.SOUTH);
		
		JLabel lblInsiraADistncia = new JLabel("Insira a distância até o destino:");
		splitPane_2.setLeftComponent(lblInsiraADistncia);
		
		textField = new JTextField();
		textField.setToolTipText("Apenas numeros, por favor");
		splitPane_2.setRightComponent(textField);
		textField.setColumns(10);

	}

}
