package frontEnd;

import java.awt.EventQueue;


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

public class BemVindo extends JPanel { // daqui segue opção: Logar ou Cadastrar?

  private Uberland appPagina;
	private static final long serialVersionUID = 1L;
	private final JLabel lblBemVindoAo = new JLabel("Bem vindo ao UberLand, selecione por favor  uma opção:");
	private final JPanel panel = new JPanel();
	private final JSplitPane splitPane = new JSplitPane();
	private final JButton btnCliente = new JButton("Cliente");
	private final JButton btnMotorista = new JButton("Motorista");
	private final JPanel panel_1 = new JPanel();

	/**
	 * Create the frame.
	 */
	public BemVindo(Uberland pagina) {

    this.appPagina = pagina;
		setBorder(new EmptyBorder(5, 5, 5, 5));

		setLayout(new BorderLayout(0, 0));
		
		add(panel, BorderLayout.SOUTH);
		
		panel.add(splitPane);
		
		btnCliente.addActionListener(e -> pagina.navegarPaginas(new ChecarStatus(pagina),"checarStatus"));

    splitPane.setLeftComponent(btnCliente);
		splitPane.setRightComponent(btnMotorista);
		
		add(panel_1, BorderLayout.CENTER);
		panel_1.add(lblBemVindoAo);
		lblBemVindoAo.setVerticalAlignment(SwingConstants.TOP);
		lblBemVindoAo.setHorizontalAlignment(SwingConstants.CENTER);

	}

}
