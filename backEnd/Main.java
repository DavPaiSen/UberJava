package backEnd;

import frontEnd.BemVindo;

public abstract class Main {

	public static void main(String[] args) {
		Usuario.setViagensParaVip(10);
		UberX.setValorKm(1f); //valor por km e taxa minima do prioridade sao o dobro do UberX
		UberX.setTaxaMinima(5f);
		UberBlack.setValorKm(2f);
		UberBlack.setTaxaMinima(10f);
		UberComfort.setValorKm(3f);
		UberComfort.setTaxaMinima(15f);;
		Corrida.setPorcentagemMotorista(0.6f);
		BemVindo bemVindo = new BemVindo();
		bemVindo.setVisible(true);
		
		
	}

}
