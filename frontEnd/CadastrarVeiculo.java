package frontEnd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backEnd.Persistencia;
import backEnd.Principal;
import backEnd.UberBlack;
import backEnd.UberComfort;
import backEnd.UberPrioridade;
import backEnd.UberX;

import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CadastrarVeiculo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNroChassi;
	private JTextField textPlaca;
	private JTextField textCor;
	private JTextField textPassageiros;
	private JTextField textCapacidadeMalas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarVeiculo frame = new CadastrarVeiculo();
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
	public CadastrarVeiculo() {
		setResizable(false);
		setTitle("Cadastrar veiculo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel.add(splitPane);
		
		JCheckBox chckbxUberx = new JCheckBox("UberX");
		splitPane.setLeftComponent(chckbxUberx);
		
		JCheckBox chckbxUberblack = new JCheckBox("UberBlack");
		splitPane.setRightComponent(chckbxUberblack);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel.add(splitPane_1);
		
		JCheckBox chckbxUbercomfort = new JCheckBox("UberComfort");
		splitPane_1.setLeftComponent(chckbxUbercomfort);
		
		JCheckBox chckbxUberprioridade = new JCheckBox("UberPrioridade");
		splitPane_1.setRightComponent(chckbxUberprioridade);
		
		JLabel label = new JLabel("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 ");
		panel.add(label);
		
		ButtonGroup tipos = new ButtonGroup();
		tipos.add(chckbxUberprioridade);
		tipos.add(chckbxUbercomfort);
		tipos.add(chckbxUberblack);
		tipos.add(chckbxUberx);
		
		JSplitPane splitPane_4 = new JSplitPane();
		panel.add(splitPane_4);
		
		JLabel lblPlaca = new JLabel("Placa:");
		splitPane_4.setLeftComponent(lblPlaca);
		
		textPlaca = new JTextField();
		splitPane_4.setRightComponent(textPlaca);
		textPlaca.setColumns(10);
		
		JSplitPane splitPane_5 = new JSplitPane();
		panel.add(splitPane_5);
		
		JLabel lblCor = new JLabel("Cor:");
		splitPane_5.setLeftComponent(lblCor);
		
		textCor = new JTextField();
		splitPane_5.setRightComponent(textCor);
		textCor.setColumns(10);
		
		JSplitPane splitPane_6 = new JSplitPane();
		panel.add(splitPane_6);
		
		textPassageiros = new JTextField();
		textPassageiros.setToolTipText("COLOCAR APENAS NUMEROS!");
		splitPane_6.setRightComponent(textPassageiros);
		textPassageiros.setColumns(10);
		
		JLabel lblCapacidadeDePassageiros = new JLabel("Capacidade de passageiros:");
		splitPane_6.setLeftComponent(lblCapacidadeDePassageiros);
		
		JSplitPane splitPane_3 = new JSplitPane();
		panel.add(splitPane_3);
		
		textNroChassi = new JTextField();
		splitPane_3.setRightComponent(textNroChassi);
		textNroChassi.setColumns(10);
		
		JLabel lblNumeroDoChassis = new JLabel("Numero do chassi:");
		splitPane_3.setLeftComponent(lblNumeroDoChassis);
		
		JLabel label_1 = new JLabel("                                                                                                                                                                                                        ");
		panel.add(label_1);
		
		JSplitPane splitPane_2 = new JSplitPane();
		panel.add(splitPane_2);
		
		JLabel lblParaUberx = new JLabel("Para UberX");
		splitPane_2.setLeftComponent(lblParaUberx);
		
		JPanel panel_1 = new JPanel();
		splitPane_2.setRightComponent(panel_1);
		
		JCheckBox chckbxArCondicionado = new JCheckBox("Ar condicionado");
		panel_1.add(chckbxArCondicionado);
		
		JCheckBox chckbxComfortoBasico = new JCheckBox("Comforto basico");
		panel_1.add(chckbxComfortoBasico);
		
		JLabel label_2 = new JLabel("                                                                                                                                                                                                                                                ");
		panel.add(label_2);
		
		JSplitPane splitPane_7 = new JSplitPane();
		splitPane_7.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel.add(splitPane_7);
		
		JLabel lblParaUbercomfort = new JLabel("Para UberComfort");
		lblParaUbercomfort.setHorizontalAlignment(SwingConstants.CENTER);
		splitPane_7.setLeftComponent(lblParaUbercomfort);
		
		JPanel panel_2 = new JPanel();
		splitPane_7.setRightComponent(panel_2);
		
		JCheckBox chckbxEspacoExtra = new JCheckBox("Espaco extra");
		panel_2.add(chckbxEspacoExtra);
		
		JCheckBox chckbxArCondicionadoDual = new JCheckBox("Ar condicionado dual zone");
		panel_2.add(chckbxArCondicionadoDual);
		
		JCheckBox chckbxBancoReclinavel = new JCheckBox("Banco reclinavel");
		panel_2.add(chckbxBancoReclinavel);
		
		JLabel label_3 = new JLabel("                                                                                                                                            ");
		panel.add(label_3);
		
		JSplitPane splitPane_8 = new JSplitPane();
		splitPane_8.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel.add(splitPane_8);
		
		JLabel lblParaUberblack = new JLabel("Para UberBlack");
		splitPane_8.setLeftComponent(lblParaUberblack);
		
		JPanel panel_3 = new JPanel();
		splitPane_8.setRightComponent(panel_3);
		
		JCheckBox chckbxInteriorPremium = new JCheckBox("Interior premium");
		panel_3.add(chckbxInteriorPremium);
		
		JCheckBox chckbxRodasDeLiga = new JCheckBox("Rodas de liga leve");
		panel_3.add(chckbxRodasDeLiga);
		
		JSplitPane splitPane_9 = new JSplitPane();
		panel.add(splitPane_9);
		
		JLabel lblCapacidadeDeMalas = new JLabel("Capacidade de malas");
		splitPane_9.setLeftComponent(lblCapacidadeDeMalas);
		
		textCapacidadeMalas = new JTextField();
		textCapacidadeMalas.setToolTipText("inserir apenas numeros!");
		splitPane_9.setRightComponent(textCapacidadeMalas);
		textCapacidadeMalas.setColumns(10);
		
		JLabel label_4 = new JLabel("                                                                                                                                            ");
		panel.add(label_4);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String placa = textPlaca.getText();
				String cor = textCor.getText();
				String chassi = textNroChassi.getText();
				int capacidadePassageiros;
				try {
					capacidadePassageiros = Integer.parseInt(textPassageiros.getText());
				} catch (NumberFormatException e1) {
					setTitle("Colocar apenas numeros na capacidade de passageiros!");
					return;
				}
				
				if (chckbxUberx.isSelected()) {
					boolean arCondicionado = chckbxArCondicionado.isSelected();
					boolean confortoBasico = chckbxComfortoBasico.isSelected();
					UberX adicionar = new UberX(placa, chassi, cor, capacidadePassageiros, arCondicionado, confortoBasico);
					try {
						Principal.getLogadoMotorista().adicionarVeiculo(adicionar);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (chckbxUberblack.isSelected()) {
					boolean interiorPremium = chckbxInteriorPremium.isSelected();
					boolean rodaLigaLeve = chckbxRodasDeLiga.isSelected();
					int capacidadeMalas;
					try {
						capacidadeMalas = Integer.parseInt(textCapacidadeMalas.getText());
					} catch (NumberFormatException e1) {
						setTitle("Colocar apenas numeros na capacidade de malas!");
						return;
					}
					UberBlack adicionar = new UberBlack(placa, chassi, cor, capacidadePassageiros, capacidadeMalas, interiorPremium, rodaLigaLeve);
					try {
						Principal.getLogadoMotorista().adicionarVeiculo(adicionar);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (chckbxUbercomfort.isSelected()) {
					boolean espacoExtra = chckbxEspacoExtra.isSelected();
					boolean arDualZone = chckbxArCondicionadoDual.isSelected();
					boolean bancoReclinavel = chckbxBancoReclinavel.isSelected();
					UberComfort adicionar = new UberComfort(placa, chassi, cor, capacidadePassageiros, espacoExtra, arDualZone, bancoReclinavel);
					try {
						Principal.getLogadoMotorista().adicionarVeiculo(adicionar);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (chckbxUberprioridade.isSelected()) {
					UberPrioridade adicionar = new UberPrioridade(placa, chassi, cor, capacidadePassageiros);
					try {
						Principal.getLogadoMotorista().adicionarVeiculo(adicionar);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					setTitle("Por favor selecione alguma categoria!");
				}
				EscolherVeiculo escolherVeiculo = new EscolherVeiculo();
				escolherVeiculo.setVisible(true);
				dispose();
			}
		});
		panel.add(btnCadastrar);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EscolherVeiculo escolherVeiculo = new EscolherVeiculo();
				escolherVeiculo.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnNewButton, BorderLayout.SOUTH);

	}

}
