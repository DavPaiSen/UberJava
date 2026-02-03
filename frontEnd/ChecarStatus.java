package frontEnd; 


import javax.swing.*;
import java.awt.*;


public class ChecarStatus extends JPanel{

  private Uberland appPagina;
	private JButton btnLogin = new JButton("login");
	private JButton btnCadastro = new JButton("cadastro");
	
	
	public ChecarStatus(Uberland pagina) {
        this.appPagina = pagina;
        setLayout(new GridLayout(1, 2 , 10, 10)); // setei uma linha e 2 colunas de espaço 10..arrumar igual nos outros botoes..mais limpo
        setBorder(BorderFactory.createEmptyBorder(40, 80, 40, 80));
      
        add(btnLogin);
        add(btnCadastro);
        
        btnLogin.addActionListener(e ->
            pagina.navegarPaginas(new Login(pagina),"login")
        );
        
           btnCadastro.addActionListener(e ->
            pagina.navegarPaginas(new Cadastro(pagina),"cadastro")
        );  
        
        
        
  }


}