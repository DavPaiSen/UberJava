package backEnd;

import java.util.ArrayList;

public class Principal {
	private static ArrayList<Motorista> motoristas = new ArrayList<Motorista>(); //nao inclui leitura de motoristas e usuarios ja salvos, sem leitura de arquivos!!
	private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private static ArrayList<Corrida> corridas = new ArrayList<Corrida>(); //id da corrida e a sua posicao no arraylist
	private static boolean ehCliente;
	
	public static boolean isCliente() {
		return ehCliente;
	}

	public static void setCliente(boolean ehCliente) {
		Principal.ehCliente = ehCliente;
	}

	public static ArrayList<Integer> corridasAtivas() { //retorna os ids das corridas ativas
		ArrayList<Integer> retorno = new ArrayList<Integer>();
		Corrida atual = null;
		for (int i = 0; i < corridas.size(); i++) {
			atual = corridas.get(i);
			if (!atual.isEncerrada()) {
				retorno.add(i);
			}
		}
		return retorno;
	}
	
	public static void adicionaUsuario(Usuario adicionar) {
		usuarios.add(adicionar);
	}
	
	public static void removerUsuario(Usuario remover) {
		usuarios.remove(remover);
	}
	
	public static void adicionarMotorista(Motorista adicionar) {
		motoristas.add(adicionar);
	}
}
