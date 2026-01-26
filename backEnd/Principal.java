package backEnd;

import java.util.ArrayList;

public class Principal {
	private ArrayList<Motorista> motoristas = new ArrayList<Motorista>(); //nao inclui leitura de motoristas e usuarios ja salvos, sem leitura de arquivos!!
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private ArrayList<Corrida> corridas = new ArrayList<Corrida>(); //id da corrida eh a sua posicao no arraylist
	
	
	public ArrayList<Integer> corridasAtivas() { //retorna os ids das corridas ativas
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
}
