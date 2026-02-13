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
			JButton btnLogar = new JButton("Entrar");
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
			contentPanel.add(btnLogar);
		}
		{
			JButton btnCriarContaNova = new JButton("Cadastrar");
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
			contentPanel.add(btnCriarContaNova);
		}
	}

}
