package backEnd;

import java.util.ArrayList;

public class Principal {
	private ArrayList<Motorista> motoristas = new ArrayList<Motorista>(); //nao inclui leitura de motoristas e usuarios ja salvos, sem leitura de arquivos!!
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private ArrayList<Corrida> corridas = new ArrayList<Corrida>(); //id da corrida e a sua posicao no arraylist
	
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
	
	public Principal() {
		Usuario.setViagensParaVip(10);
		UberX.setValorKm(1f); //valor por km e taxa minima do prioridade sao o dobro do UberX
		UberX.setTaxaMinima(5f);
		UberBlack.setValorKm(2f);
		UberBlack.setTaxaMinima(10f);
		UberComfort.setValorKm(3f);
		UberComfort.setTaxaMinima(15f);;
		Corrida.setPorcentagemMotorista(0.6f);
		boolean ehUsuario;
		if (ehUsuario) {
			paginaUsuario();//TODO
		} else {
			paginaMotorista();//TODO
		}
	}
}
