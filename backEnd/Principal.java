package backEnd;

import java.util.ArrayList;

public class Principal {
	private static ArrayList<Motorista> motoristas = new ArrayList<Motorista>(); //nao inclui leitura de motoristas e usuarios ja salvos, sem leitura de arquivos!!
	private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private static ArrayList<Corrida> corridas = new ArrayList<Corrida>(); //id da corrida e a sua posicao no arraylist
	private static boolean ehCliente;
	private static Motorista logadoMotorista = null;
	private static Usuario logadoUsuario = null;

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
		//System.out.println(adicionar.toString());
	}
	
	public static void removerUsuario(Usuario remover) {
		usuarios.remove(remover);
		//tratar as exceções quando tiver a aula
	}
	
	public static void adicionarMotorista(Motorista adicionar) {
		motoristas.add(adicionar);
		//System.out.println(adicionar.toString());
	}
	
	public static void removerMotorista(Motorista remover) {
		motoristas.remove(remover);
		//tratar as exceções quando tiver a aula
	}
	
	public static boolean achaMotorista(String nome, String cnh) {
		Motorista procurando = null;
		for (int i = 0; i < motoristas.size(); i++) {
			procurando = motoristas.get(i);
			if (procurando.getCnhString().equals(cnh) && procurando.getNomeString().equals(nome)) {
				logadoMotorista = procurando;
				return true;
			}
		}
		return false;
	}
	
	public static boolean achaUsuario(String cpf, String email) {
		Usuario procurando = null;
		for (int i = 0; i < usuarios.size(); i++) {
			procurando = usuarios.get(i);
			if (procurando.getCpfString().equals(cpf) && procurando.getEmailString().equals(email)) {
				logadoUsuario = procurando;
				return true;
			}
		}
		return false;
	}
}
