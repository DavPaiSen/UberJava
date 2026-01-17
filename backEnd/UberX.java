package backEnd;

public class UberX extends Veiculo{
	private static float taxaMinima;
	private static float valorKm;
	private final boolean arCondicionado;
	private final boolean confortoBasico;
	
	public boolean isArCondicionado() {
		return arCondicionado;
	}

	public boolean isConfortoBasico() {
		return confortoBasico;
	}

	public static void setTaxaMinima(float taxaMinima) {
		UberX.taxaMinima = taxaMinima;
	}

	public static void setValorKm(float valorKm) {
		UberX.valorKm = valorKm;
	}

	@Override
	public float getTaxaMinima() {
		return UberX.taxaMinima;
	}

	@Override
	public float getValorKm() {
		return UberX.valorKm;
	}

	@Override
	public float valor(float distancia) {
		if (arCondicionado || confortoBasico) {
			return super.valor(distancia) + taxaMinima;
		}
		return super.valor(distancia);
	}

	public UberX(String placaString, String chassiString, String corString, int capacidadePassageiros,
			boolean arCondicionado, boolean confortoBasico) {
		super(placaString, chassiString, corString, capacidadePassageiros);
		this.arCondicionado = arCondicionado;
		this.confortoBasico = confortoBasico;
	}
	
}