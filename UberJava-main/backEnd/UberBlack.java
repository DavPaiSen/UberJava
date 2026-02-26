package backEnd;

public class UberBlack extends Veiculo{
	private static float taxaMinima;
	private static float valorKm;
	private final int capacidadeMalas;
	private final boolean interiorPremium;
	private final boolean rodaLigaLeve;
	
	public int getCapacidadeMalas() {
		return capacidadeMalas;
	}
	
	public boolean isInteriorPremium() {
		return interiorPremium;
	}

	public boolean isRodaLigaLeve() {
		return rodaLigaLeve;
	}

	public static void setTaxaMinima(float taxaMinima) {
		UberBlack.taxaMinima = taxaMinima;
	}

	public static void setValorKm(float valorKm) {
		UberBlack.valorKm = valorKm;
	}

	@Override
	public float getTaxaMinima() {
		return UberBlack.taxaMinima;
	}

	@Override
	public float getValorKm() {
		return UberBlack.valorKm;
	}
	
	@Override
	public float valor(float distancia) {
		return super.valor(distancia) + capacidadeMalas * taxaMinima;
	}

	public UberBlack(String placaString, String chassiString, String corString, int capacidadePassageiros,
			int capacidadeMalas, boolean interiorPremium, boolean rodaLigaLeve) {
		super(placaString, chassiString, corString, capacidadePassageiros);
		this.capacidadeMalas = capacidadeMalas;
		this.interiorPremium = interiorPremium;
		this.rodaLigaLeve = rodaLigaLeve;
	}
	
	
}
