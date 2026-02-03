package backEnd;

import java.util.ArrayList;

public class Motorista extends Pessoa{
	private String enderecoString;
	private String nascimentoString;
	private String cnhString;
	private boolean ativo;
	private ArrayList<Veiculo> veiculos = new ArrayList<>();
	private float saldo;
	
	public void pagar(float valor) {
		saldo += valor;
	}
	
	public void sacar() {
		saldo = 0;//finge que passa pra conta bancaria do motorista
	}
	
	public float getSaldo() {
		return saldo;
	}

	public void adicionarVeiculo(Veiculo adicionar) {
		veiculos.add(adicionar);
	}
	
	public boolean removerVeiculo(Veiculo remover) {
		return veiculos.remove(remover); //o metodo remove ja retorna true se achar o objeto na lista
	}
	
	public boolean removerVeiculo(String placa) {
		for (int i = 0; i < veiculos.size(); i++) {
			if (veiculos.get(i).placaString.equals(placa)) {
				veiculos.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public boolean ativarVeiculo(String placa) {
		if (veiculos.isEmpty() || veiculoAtivo() != null) {
			return false; //tem que ter veiculos cadastrados e nao pode existir um veiculo ja ativo
		}
		for (int i = 0; i < veiculos.size(); i ++) {
			Veiculo atual = veiculos.get(i);
			if (atual.getPlacaString().equals(placa)) {
				atual.ativo = true;
				return true;
			}
		}
		return false;//nao achou
	}
	
	public void apagarTodosVeiculos() { //quando for remover o motorista, remove tambem os seus veiculos
		while (!veiculos.isEmpty()) {
			veiculos.removeFirst();
		}
	}
	
	public boolean apagarVeiculo(String placa) {
		if (veiculos.isEmpty()) {
			return false;
		}
		for (int i = 0; i < veiculos.size(); i ++) {
			Veiculo atual = veiculos.get(i);
			if (atual.getPlacaString().equals(placa)) {
				veiculos.remove(i);
				return true;
			}
		}
		return false; //nao achou
	}
	
	public String getCnhString() {
		return cnhString;
	}

	public void setCnhString(String cnhString) {
		this.cnhString = cnhString;
	}

	public String getEnderecoString() {
		return enderecoString;
	}
	public void setEnderecoString(String enderecoString) {
		this.enderecoString = enderecoString;
	}
	public String getNascimentoString() {
		return nascimentoString;
	}
	public void setNascimentoString(String nascimentoString) {
		this.nascimentoString = nascimentoString;
	}
	
	public void ativar() {
		ativo = true;
	}
	
	public void desativar() {
		ativo = false;
		for (int i = 0; i < veiculos.size(); i++) { //garante que todos os veiculos sejam desativados quando o motorista e desativado
			veiculos.get(i).desativar();;
		}
	}
	
	public boolean getAtivo() {
		return ativo;
	}
	
	public Veiculo veiculoAtivo() {
		for (int i = 0; i < veiculos.size(); i++) {
			if (veiculos.get(i).ativo) {
				return veiculos.get(i);
			}
		}
		return null;
	}

	public Motorista(String cpfString, String nomeString, String nomeSocialString, String enderecoString, String nascimentoString, String cnhString) {
		super(cpfString, nomeString, nomeSocialString);
		this.enderecoString = enderecoString;
		this.nascimentoString = nascimentoString;
		this.ativo = false;
		this.cnhString = cnhString;
		saldo = 0f;
	}
	
	
}
