package backEnd;

import java.io.Serializable;

public abstract class Veiculo implements Serializable{ //classe abstrata
	protected String placaString;
	protected String chassiString;
	protected String corString;
	protected int capacidadePassageiros;
	protected boolean ativo; // tem que ativar o veiculo pelo motorista
	protected int status;
	public abstract float getTaxaMinima(); //metodo abstrato
	public abstract float getValorKm(); //outro metodo abstrato
	/** Status:
	 * 0 - disponivel
	 * 1 - nao disponivel
	 * 2 - em viagem
	 * 3 - finalizando viagem (5 minutos)
	 */
	
	public float valor(float distancia) {
		return (getTaxaMinima() + getValorKm() * distancia);
	}
	
	public String getPlacaString() {
		return placaString;
	}
	public String getChassiString() {
		return chassiString;
	}
	public String getCorString() {
		return corString;
	}
	public int getCapacidadePassageiros() {
		return capacidadePassageiros;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public void ativar() {
		ativo = true;
	}
	
	public void desativar() {
		ativo = false;
	}
	public Veiculo(String placaString, String chassiString, String corString, int capacidadePassageiros) {
		this.placaString = placaString;
		this.chassiString = chassiString;
		this.corString = corString;
		this.capacidadePassageiros = capacidadePassageiros;
		ativo = false; //comeca desativado
		status = 0; //comeca indisponivel
	}
}
