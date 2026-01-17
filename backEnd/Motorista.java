package backEnd;
import java.awt.List;
import java.util.ArrayList;

public class Motorista extends Pessoa{
	private String enderecoString;
	private String nascimentoString;
	private boolean ativo;
	private ArrayList<Veiculo> veiculos = new ArrayList<>();
	
	
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
		for (int i = 0; i < veiculos.size(); i++) {
			veiculos.get(i).ativo = false;
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

	public Motorista(String cpfString, String nomeString, String enderecoString, String nascimentoString) {
		super(cpfString, nomeString);
		this.enderecoString = enderecoString;
		this.nascimentoString = nascimentoString;
		this.ativo = false;
	}
	
	
}
