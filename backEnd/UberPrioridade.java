package backEnd;

public class UberPrioridade extends Veiculo{ //requisito extra item 7, autoexplicativo, e mais caro pela prioridade
	private static float taxaMinima;
	private static float valorKm;
	
	@Override
	public float getTaxaMinima() {
		return taxaMinima;
	}

	@Override
	public float getValorKm() {
		return valorKm;
	}

	public static void setTaxaMinima(float taxaMinima) {
		UberPrioridade.taxaMinima = taxaMinima;
	}

	public static void setValorKm(float valorKm) {
		UberPrioridade.valorKm = valorKm;
	}

	public UberPrioridade(String placaString, String chassiString, String corString, int capacidadePassageiros) {
		super(placaString, chassiString, corString, capacidadePassageiros);
	}	
}
