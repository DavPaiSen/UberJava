package backEnd;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Principal {
	private static ArrayList<Motorista> motoristas; //nao inclui leitura de motoristas e usuarios ja salvos, sem leitura de arquivos!!
	private static ArrayList<Usuario> usuarios;
	private static ArrayList<Corrida> corridas; //id da corrida e a sua posicao no arraylist
	private static boolean ehCliente;
	private static Motorista logadoMotorista = null;
	private static Usuario logadoUsuario = null;
	private static Corrida corridaAtiva = null;
	private static int categoria; //so por conveniencia

	public static Corrida getCorrida(int i) {
		if (i+1 > corridas.size()) {
			return null;
		}
		return corridas.get(i);
	}
	public static Usuario getUsuario(int i) {
		if (usuarios.size() < i-1) {
			return null;
		}
		return usuarios.get(i);
	}
	
	public static void adicionaCorrida(Corrida corrida) {
		corridas.add(corrida);
	}
	
	public static int getCategoria() {
		return categoria;
	}

	public static void setCategoria(int categoria) {
		Principal.categoria = categoria;
	}

	public static Corrida getCorridaAtiva() {
		return corridaAtiva;
	}

	public static void setCorridaAtiva(Corrida corridaAtiva) {
		Principal.corridaAtiva = corridaAtiva;
	}

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
	
	public static void salvaUsuarios(){
		try {
			Persistencia.salvar(usuarios, "usuarios.dat");
		} catch (IOException erro){
			System.out.println(erro);
		}
	}
	
	public static void adicionaUsuario(Usuario adicionar) throws IOException {
		usuarios.add(adicionar);
		Persistencia.salvar(usuarios, "usuarios.dat");
		//System.out.println("O arquivo foi salvo em: " + new java.io.File("usuarios.dat").getAbsolutePath());
		//System.out.println(adicionar.toString());
	}
	
	public static void removerUsuario(Usuario remover) {
		usuarios.remove(remover);
		//tratar as exceções quando tiver a aula
	}
	
	public static void adicionarMotorista(Motorista adicionar) throws IOException {
		motoristas.add(adicionar);
		Persistencia.salvar(motoristas, "motoristas.dat");
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
				procurando.ativar();
				return true;
			}
		}
		return false;
	}
	
	public static boolean achaUsuario(String cpf, String email) {
		Usuario procurando = null;
		for (int i = 0; i < usuarios.size(); i++) {
			procurando = usuarios.get(i);
			if (procurando.getCpfString().trim().equals(cpf.trim()) && procurando.getEmailString().trim().equals(email.trim())) {
				logadoUsuario = procurando;
				return true;
			}
		}
		return false;
	}
	
	public static Motorista getLogadoMotorista() {
		return logadoMotorista;
	}

	public static Usuario getLogadoUsuario() {
		return logadoUsuario;
	}

	public static void setLogadoMotorista(Motorista logadoMotorista) {
		Principal.logadoMotorista = logadoMotorista;
	}

	public static void setLogadoUsuario(Usuario logadoUsuario) {
		Principal.logadoUsuario = logadoUsuario;
	}
	
	public static Motorista procuraMotorista(Class<?> categoria) {
		Motorista atual = null;
		for (int i = 0; i < motoristas.size(); i++) {
			atual = motoristas.get(i);
			if (categoria.isInstance(atual.veiculoAtivo())) {
				return atual;
			}
		}
		return null;
	}
	
	public static Corrida procuraCorrida(Class<?> categoria) {
		Corrida atual = null;
		for (int i = 0; i < corridas.size(); i++) {
			atual = corridas.get(i);
			if (categoria.isInstance(atual) && !atual.isEncerrada()) {
				return atual;
			}
		}
		return null;
	}
	
	public static void finalizaCorrida() {
		corridaAtiva.finalizada();
	}

	public static void inicio() throws ClassNotFoundException, IOException {
		File motoristasFile = new File("motoristas.dat");
		File usuariosFile = new File("usuarios.dat");
		File corridasFile = new File("corridas.dat");
		if (motoristasFile.exists()) {
			motoristas = (ArrayList<Motorista>) Persistencia.carregar("motoristas.dat");
		} else {
			motoristas = new ArrayList<Motorista>();
		}
		if (usuariosFile.exists()) {
			usuarios = (ArrayList<Usuario>) Persistencia.carregar("usuarios.dat");
		} else {
			usuarios = new ArrayList<Usuario>();
		}
		if (corridasFile.exists()) {
			corridas = (ArrayList<Corrida>) Persistencia.carregar("corridas.dat");
			
		} else {
			corridas = new ArrayList<Corrida>();
		}
	}
	
	public static void salvaMotoristas(){
		try {
			Persistencia.salvar(motoristas, "motoristas.dat");
		} catch (IOException erro) {
			System.out.println(erro);
		}
	}
}
