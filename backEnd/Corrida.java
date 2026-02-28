package backEnd;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Corrida implements Serializable{
	private Class<?> categoria;
	private Motorista motorista;
	private Usuario usuario;
	private float distancia;
	private LocalDateTime horaSolicitacao;
	private LocalDateTime horaInicio;//hora que o motorista chegou a origem
	private LocalDateTime horaDestino;//hora que chegaram ao destino
	private int cancelada;
	private boolean encerrada; //colocar um atributo boolean pago???? se for pagar no dinheiro para o motorista e importante ter
	/**
	 * 0 - nao cancelada
	 * 1 - cancelada pelo usuario
	 * 2 - cancelada pelo motorista
	 */
	private static float porcentagemMotorista;
	private Veiculo veiculo = null;
	
	
	
	public void adicionaMotorista(Motorista motorista) {
		this.motorista = motorista;
		veiculo = motorista.veiculoAtivo();
		veiculo.setStatus(2); //nao disponivel
	}

	public void cancela(Pessoa quem) {
		if (quem instanceof Usuario) {
			cancelada = 1;
		} else if (quem instanceof Motorista) {
			cancelada = 2;
		}
		encerrada = true;
		finalizada();
	}
	
	
	public static float getPorcentagemMotorista() {
		return porcentagemMotorista;
	}

	public static void setPorcentagemMotorista(float porcentagemMotorista) {
		Corrida.porcentagemMotorista = porcentagemMotorista;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public float getDistancia() {
		return distancia;
	}

	public LocalDateTime getHoraSolicitacao() {
		return horaSolicitacao;
	}
	
	public LocalDateTime getHoraInicio() {
		return horaInicio;
	}

	public LocalDateTime getHoraDestino() {
		return horaDestino;
	}

	public int getCancelada() {
		return cancelada;
	}

	public boolean isEncerrada() {
		return encerrada;
	}

	public float valor() {
		if (usuario.isVip()) {
			return veiculo.valor(distancia) * (1 - usuario.getDesconto());
		}
		return veiculo.valor(distancia);
	}
	
	public void finalizando() {
		veiculo.setStatus(3);
	}
	
	public String getNomeMotorista() {
		return motorista.getNomeSocialString();
	}
	
	public void finalizada() {
		Veiculo veiculo = motorista.veiculoAtivo();
		if (cancelada == 1) { //se foi cancelada pelo usuario o motorista recebe uma porcentagem do valor total
			motorista.pagar(veiculo.valor(distancia) * 0.5f); //50%, valor arbitrario
		} else {
			motorista.pagar(veiculo.valor(distancia));
		}
		//recebe as notas do frontend e usa motorista.atualizarMedia() e usuario.atualizarMedia()
		//finge que acontece coisas do pagamento preferencial do usuario???
		veiculo.setStatus(0);
		usuario.numeroViagens++;
	}
	
	public void iniciarCorrida() {

	    if (cancelada != 0 || encerrada) {
	        return; // não pode iniciar se já foi cancelada
	    }

	    this.horaInicio = LocalDateTime.now();

	    if (veiculo != null) {
	        veiculo.setStatus(2);
	    }
	}
	
	public void alocarMotorista(Motorista motorista) {
	    if (motorista == null) return;
	    this.motorista = motorista;
	    this.veiculo = motorista.veiculoAtivo();
	    if (this.veiculo != null) {
	   
	        this.veiculo.setStatus(1);
	    }
	}
	
	public void setHoraInicio(LocalDateTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Corrida(Motorista motorista, Usuario usuario, float distancia, Class<?> categoria) {
		this.motorista = motorista;
		this.usuario = usuario;
		this.distancia = distancia;
		horaSolicitacao = LocalDateTime.now();
		cancelada = 0;
		encerrada = false;
		this.categoria = categoria;
	}
}