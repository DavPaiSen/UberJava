package frontEnd; 


import javax.swing.*;
import java.awt.*;


public class Uberland extends JFrame{

    private CardLayout layout;
    private JPanel panel;
    
    public Uberland() {
		  setTitle("Uberland");
		  setResizable(false);
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  setBounds(400,450, 450, 300);
		  layout = new CardLayout();
		  panel = new JPanel(layout);
		  setContentPane(panel);
  }
  
  public void navegarPaginas(JPanel panel2, String nome){
      panel.add(panel2, nome);
      layout.show(panel, nome);
  }
  

}



