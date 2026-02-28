package frontEnd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backEnd.Persistencia;
import backEnd.Principal;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AvaliarMotorista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AvaliarMotorista frame = new AvaliarMotorista();
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
		
		JCheckBox checkBox = new JCheckBox("1");
		panel_2.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("2");
		panel_2.add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("3");
		panel_2.add(checkBox_2);
		
		JCheckBox checkBox_3 = new JCheckBox("4");
		panel_2.add(checkBox_3);
		
		JCheckBox checkBox_4 = new JCheckBox("5");
		panel_2.add(checkBox_4);
		
		ButtonGroup avaliacao = new ButtonGroup();
		avaliacao.add(checkBox_4);
		avaliacao.add(checkBox_3);
		avaliacao.add(checkBox_2);
		avaliacao.add(checkBox_1);
		avaliacao.add(checkBox);
		
		JLabel lblComoFoiA = new JLabel("Avalie como foi a viagem:");
		lblComoFoiA.setHorizontalAlignment(SwingConstants.CENTER);
		splitPane.setLeftComponent(lblComoFoiA);
		
		JPanel panel = new JPanel();
		splitPane_1.setRightComponent(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btnAvaliar = new JButton("Avaliar");
		btnAvaliar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float nota;
				if (checkBox.isSelected()) {
					nota = 1;
				} else if (checkBox_1.isSelected()) {
					nota = 2;
				} else if (checkBox_2.isSelected()) {
					nota = 3;
				} else if (checkBox_3.isSelected()) {
					nota = 4;
				} else if (checkBox_4.isSelected()) {
					nota = 5;
				} else {
					setTitle("Selecione alguma nota!");
					return;
				}
				Principal.getCorridaAtiva().getMotorista().atualizaMedia(nota);
				Principal.getCorridaAtiva().finalizada();
				Principal.salvaMotoristas();
				Principal.salvaUsuarios();
				dispose();
			}
		});
		btnAvaliar.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(btnAvaliar);

	}

}
