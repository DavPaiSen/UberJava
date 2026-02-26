package backEnd;

import java.io.Serializable;

public class Usuario extends Pessoa implements Serializable{
	private String nroCelularString;
	private String emailString;
	private String dataNascimentoString;
	private int sexo;
	/**
	 * 0 - masculino
	 * 1 - feminino
	 * 2 - outro
	 */
	private int pagamento;
	/**
	 * 0 - cartao credito
	 * 1 - cartao debito
	 * 2 - pix
	 * 3 - dinheiro
	 */
	private boolean vip;
	private float desconto; //nao fala como que a porcentagem de desconto e definida?????
	private static int viagensParaVip;
	
	public String toString() {
		String retorno = ("Nome: " + getNomeString() + "\nCpf: " + getCpfString() + "\nNome social: " + getNomeSocialString() + "\nData de nascimento: " + getDataNascimentoString() + "\nNumero de celular: " + getNroCelularString() + "\nEmail: " + getEmailString() + "\nSexo: ");
		if (sexo == 0) {
			retorno = retorno.concat("maculino");
		} else if (sexo == 1) {
			retorno = retorno.concat("feminino");
		} else {
			retorno = retorno.concat("outro");
		}
		retorno = retorno.concat("\nPagamento preferido: ");
		
		if (pagamento == 0) {
			retorno = retorno.concat("cartao de credito");
		} else if (pagamento == 1) {
			retorno = retorno.concat("cartao de debito");
		} else if (pagamento == 2) {
			retorno = retorno.concat("pix");
		} else {
			retorno = retorno.concat("dinheiro");
		}
		return retorno;
	}
	
	
	public static int getViagensParaVip() {
		return viagensParaVip;
	}

	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}

	public static void setViagensParaVip(int viagensParaVip) {
		Usuario.viagensParaVip = viagensParaVip;
	}

	public String getNroCelularString() {
		return nroCelularString;
	}

	public void setNroCelularString(String nroCelularString) {
		this.nroCelularString = nroCelularString;
	}

	public String getEmailString() {
		return emailString;
	}

	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}

	public String getDataNascimentoString() {
		return dataNascimentoString;
	}

	public void setDataNascimentoString(String dataNascimentoString) {
		this.dataNascimentoString = dataNascimentoString;
	}

	public int getSexo() {
		return sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
	}

	public boolean isVip() {
		return vip;
	}

	public float getDesconto() {
		return desconto;
	}

	public int getPagamento() {
		return pagamento;
	}

	public void setPagamento(int pagamento) {
		this.pagamento = pagamento;
	}

	@Override
	public void atualizaMedia(float nota) {
		super.atualizaMedia(nota);
		if (numeroViagens >= viagensParaVip) {
			vip = true;
		}
	}

	public Usuario(String cpfString, String nomeString, String nomeSocialString, String nroCelularString, String emailString, String dataNascimentoString, int sexo, int pagamento) {
		super(cpfString, nomeString, nomeSocialString);
		this.nroCelularString = nroCelularString;
		this.emailString = emailString;
		this.dataNascimentoString = dataNascimentoString;
		this.sexo = sexo;
		this.pagamento = pagamento;
		vip = false;
		desconto = 0;
	}
	
	
}
