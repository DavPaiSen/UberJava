package backEnd;

public class UberComfort extends Veiculo{
	private static float taxaMinima;
	private static float valorKm;
	private final boolean espacoExtra;
	private final boolean arDualZone;
	private final boolean bancoReclinavel;

	public boolean isEspacoExtra() {
		return espacoExtra;
	}

	public boolean isArDualZone() {
		return arDualZone;
	}
	
	public boolean isBancoReclinavel() {
		return bancoReclinavel;
	}

	public static void setTaxaMinima(float taxaMinima) {
		UberComfort.taxaMinima = taxaMinima;
	}

	public static void setValorKm(float valorKm) {
		UberComfort.valorKm = valorKm;
	}

	@Override
	public float getTaxaMinima() {
		return UberComfort.taxaMinima;
	}

	@Override
	public float getValorKm() {
		return UberComfort.valorKm;
	}

	@Override
	public float valor(float distancia) {
		if (arDualZone || espacoExtra || bancoReclinavel) {
			return super.valor(distancia) + 2 * taxaMinima;
		}
		return super.valor(distancia);
	}

	public UberComfort(String placaString, String chassiString, String corString, int capacidadePassageiros,
			boolean espacoExtra, boolean arDualZone, boolean bancoReclinavel) {
		super(placaString, chassiString, corString, capacidadePassageiros);
		this.espacoExtra = espacoExtra;
		this.arDualZone = arDualZone;
		this.bancoReclinavel = bancoReclinavel;
	}	
}