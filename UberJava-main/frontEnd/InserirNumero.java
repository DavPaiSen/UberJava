package frontEnd;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InserirNumero extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InserirNumero dialog = new InserirNumero();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InserirNumero() {
		setTitle("Por favor insira apenas números na distância");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JSplitPane splitPane = new JSplitPane();
			contentPanel.add(splitPane);
			{
				JLabel lblPorFavorInsira = new JLabel("Por favor, insira apenas números na distância:");
				splitPane.setLeftComponent(lblPorFavorInsira);
			}
			{
				textField = new JTextField();
				textField.setToolTipText("Apenas números");
				splitPane.setRightComponent(textField);
				textField.setColumns(10);
			}
		}
	}

}
