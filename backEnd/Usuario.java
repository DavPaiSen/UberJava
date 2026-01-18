package backEnd;

public class Usuario extends Pessoa{
	private String nroCelularString;
	private String emailString;
	private String dataNascimentoString;
	private int sexo;
	private static int viagensParaVip;
	private boolean vip;
	private float desconto; //nao fala como que a porcentagem de desconto e definida?????
	/**
	 * 0 - masculino
	 * 1 - feminino
	 * 2 - outros? TODO ver se esse nome aqui ta ok
	 */

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

	@Override
	public void atualizaMedia(float nota) {
		super.atualizaMedia(nota);
		if (numeroViagens >= viagensParaVip) {
			vip = true;
		}
	}

	public Usuario(String cpfString, String nomeString, String nomeSocialString, String nroCelularString, String emailString,
			String dataNascimentoString, int sexo) {
		super(cpfString, nomeString, nomeSocialString);
		this.nroCelularString = nroCelularString;
		this.emailString = emailString;
		this.dataNascimentoString = dataNascimentoString;
		this.sexo = sexo;
		vip = false;
		desconto = 0;
	}
	
	
}
