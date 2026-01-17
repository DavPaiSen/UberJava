
package backEnd;

public class Pessoa {
	protected String cpfString;
	protected String nomeString;
	protected int numeroViagens;
	protected float media;
	
	public int getNumeroViagens() {
		return numeroViagens;
	}
	
	public void atualizaMedia(float nota) {
		if (nota > 5) {
			nota = 5;
		} else if (nota < 0) {
			nota = 0;
		}
		numeroViagens++;
		media = media + (nota - media) / numeroViagens;
	}
	
	public float getMedia() {
		return media;
	}

	public String getCpfString() {
		return cpfString;
	}
	
	public boolean setCpfString(String cpf) {
		if (cpfValido(cpf)) {
			this.cpfString = cpf;
			return true;
		}
		return false;
	}

	public String getNomeString() {
		return nomeString;
	}
	
	public void setNomeString(String nomeString) {
		this.nomeString = nomeString;
	}



	public boolean cpfValido(String validar) {
		
		if (validar.length() != 11) {
			return false;
		}
		
		int[] vetor = new int[11];
		
		for (int i = 0; i < 11; i++) {
			vetor[i] = validar.charAt(i) - '0';
		}

		int total = 0;
		
		for (int i = 0; i < 9; i++) {
			total += vetor[i] * (10 - i);
		}
		
		total = total % 11;
		
		if ((total == 1 || total == 0) && vetor[9] != 0) {
			return false;
		} else if (vetor[9] != (11 - total)) {
			return false;
		}
		
		total = 0;
		
		for (int i = 0; i < 10; i++) {
			total += vetor[i] * (11 - i);
		}
		
		total = total % 11;
		
		if ((total == 1 || total == 0) && vetor[10] != 0) {
			return false;
		} else if (vetor[10] != (11 - total)) {
			return false;
		}
		
		return true;
	}



	public Pessoa(String cpfString, String nomeString) {
		setCpfString(cpfString);
		setNomeString(nomeString);
		numeroViagens = 0;
		media = 5;
	}
	
	
}