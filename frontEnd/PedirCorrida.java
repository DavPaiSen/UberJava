package frontEnd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backEnd.Corrida;
import backEnd.Motorista;
import backEnd.Principal;
import backEnd.UberBlack;
import backEnd.UberComfort;
import backEnd.UberPrioridade;
import backEnd.UberX;

import java.awt.FlowLayout;
import java.awt.desktop.QuitEvent;

import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;

public class PedirCorrida extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textDistancia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PedirCorrida frame = new PedirCorrida();
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
		
		JCheckBox chckbxUberx = new JCheckBox("UberX");
		chckbxUberx.setActionCommand("0");
		splitPane.setLeftComponent(chckbxUberx);
		
		JCheckBox chckbxUbercomfort = new JCheckBox("UberComfort");
		splitPane.setRightComponent(chckbxUbercomfort);
		chckbxUbercomfort.setActionCommand("1");
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel.add(splitPane_1);
		
		JCheckBox chckbxUberprioridade = new JCheckBox("UberPrioridade");
		chckbxUberprioridade.setActionCommand("2");
		splitPane_1.setRightComponent(chckbxUberprioridade);
		
		JCheckBox chckbxUberblack = new JCheckBox("UberBlack");
		chckbxUberblack.setActionCommand("3");
		splitPane_1.setLeftComponent(chckbxUberblack);
		
		JSplitPane splitPane_2 = new JSplitPane();
		panel.add(splitPane_2);
		
		JLabel lblInsiraADistncia = new JLabel("Insira a distância até o destino:");
		splitPane_2.setLeftComponent(lblInsiraADistncia);
		
		textDistancia = new JTextField();
		textDistancia.setToolTipText("Apenas numeros, por favor");
		splitPane_2.setRightComponent(textDistancia);
		textDistancia.setColumns(10);
		
		JSplitPane splitPane_3 = new JSplitPane();
		panel.add(splitPane_3);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		splitPane_3.setLeftComponent(btnSair);
		
		
		
		ButtonGroup categoria = new ButtonGroup();
		categoria.add(chckbxUberblack);
		categoria.add(chckbxUberx);
		categoria.add(chckbxUberprioridade);
		categoria.add(chckbxUbercomfort);
		
		JButton btnPedirCorrida = new JButton("Pedir corrida");
		btnPedirCorrida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float distancia = 0f;
				try {
					distancia = Float.parseFloat(textDistancia.getText());
				} catch (NumberFormatException e1) {
					setTitle("Inserir apenas numeros na distancia!");
					return;
				}
				Class<?> categoria = null;
				if (chckbxUberx.isSelected()) {
					Principal.setCategoria(0);
					categoria = UberX.class;
				} else if (chckbxUbercomfort.isSelected()) {
					Principal.setCategoria(1);
					categoria = UberComfort.class;
				} else if (chckbxUberblack.isSelected()) {
					Principal.setCategoria(2);
					categoria = UberBlack.class;
				} else if (chckbxUberprioridade.isSelected()) {
					Principal.setCategoria(3);
					categoria = UberPrioridade.class;
				} else {
					setTitle("Por favor selecione uma categoria!");
					return;
				}
				Corrida corrida = new Corrida(null, Principal.getLogadoUsuario(), distancia, categoria);
				Principal.setCorridaAtiva(corrida);
				ProcurarCorridas procurarCorridas = new ProcurarCorridas();
				procurarCorridas.setVisible(true);
				dispose();
			}
		});
		splitPane_3.setRightComponent(btnPedirCorrida);

	}

}
