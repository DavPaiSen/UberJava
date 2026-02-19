package frontEnd;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backEnd.Principal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import javax.swing.JLabel;

public class CriarOuLogar extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CriarOuLogar dialog = new CriarOuLogar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CriarOuLogar() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JSplitPane splitPane = new JSplitPane();
			contentPanel.add(splitPane);
			{
				JButton btnLogar = new JButton("Entrar");
				splitPane.setLeftComponent(btnLogar);
				{
					JButton btnCriarContaNova = new JButton("Cadastrar");
					splitPane.setRightComponent(btnCriarContaNova);
					{
						JButton btnCancelar = new JButton("Cancelar");
						btnCancelar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								BemVindo bemVindo = new BemVindo();
								bemVindo.setVisible(true);
								dispose();
							}
						});
						getContentPane().add(btnCancelar, BorderLayout.SOUTH);
					}
					btnCriarContaNova.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (Principal.isCliente()) {
								CadastroCliente cadastroCliente = new CadastroCliente();
								cadastroCliente.setVisible(true);
								dispose();
							} else {
								CadastroMotorista cadastroMotorista = new CadastroMotorista();
								cadastroMotorista.setVisible(true);
								dispose();
							}
						}
					});
				}
				btnLogar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (Principal.isCliente()) {
							LoginCliente loginCliente = new LoginCliente();
							loginCliente.setVisible(true);
							dispose();
						} else {
							LoginMotorista loginMotorista = new LoginMotorista();
							loginMotorista.setVisible(true);
							dispose();
						}
					}
				});
			}
		}
	}

}
