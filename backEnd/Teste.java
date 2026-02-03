package backEnd;

import frontEnd.*;
import java.awt.EventQueue;


public class Teste {

	public static void main(String[] args) {
		Motorista motorista = new Motorista("13289273695", "Motoristo da Silva","carlos", "Rua dos bobos numero 0", "14062006","1234");
		if (motorista.cpfValido(motorista.getCpfString())) {
			System.out.println("Sim");
		} else {
			System.out.println("Nao");
		}
		System.out.println("Ativo? " + motorista.getAtivo());
		System.out.println("Media: " + motorista.getMedia());
		motorista.atualizaMedia((float)2.0);
		motorista.atualizaMedia((float)5.0);
		motorista.atualizaMedia((float)20000000000000000.0);
		System.out.println("Nova media: " + motorista.getMedia());
		
		
				// Interface
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Uberland frame = new Uberland();
					frame.navegarPaginas(new BemVindo(frame),"bemVindo");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
		
	

}