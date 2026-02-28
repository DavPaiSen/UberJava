package backEnd;

import java.io.IOException;

public class Teste {
	public static void criaMotoristas() throws IOException {
		Motorista m1 = new Motorista("51494538032", "motorista um", "motorista uberX", "bem na esquina", "32/12/2027", "chn");
		UberX uberX = new UberX("placa uberX", "chassi", "gelo", 4, true, false);
		m1.adicionarVeiculo(uberX);
		Motorista m2 = new Motorista("20719720079", "motorista dois", "motorista uberComfort", "logo ali", "29/02/-3", "chn bonita");
		UberComfort uberComfort = new UberComfort("placa comfort", "chassiComfort", "ferrugem", 4, false, true, false);
		m2.adicionarVeiculo(uberComfort);
		Motorista m3 = new Motorista("89190399099", "motorista tres", "motorista prioridade", "perto do carinha que mora logo ali", "0/13/00", "cnh valida");
		UberPrioridade uberPrioridade = new UberPrioridade("aaaa-00000000000000", "chassi raspado", "cor pra irritar os outros no stop", 4);
		m3.adicionarVeiculo(uberPrioridade);
		Motorista m4 = new Motorista("49794641065", "motorista quatro", "motorista black", "fenda do biquini", "45/03/2006", "bela cnh");
		UberBlack uberBlack = new UberBlack("acabou a criatividade", "abc123", "fuxia", 4, 3, true, true);
		m4.adicionarVeiculo(uberBlack);
		m1.ativar();
		m2.ativar();
		m3.ativar();
		m4.ativar();
		uberX.ativar();
		uberComfort.ativar();
		uberBlack.ativar();
		uberPrioridade.ativar();
		Principal.adicionarMotorista(m1);
		Principal.adicionarMotorista(m2);
		Principal.adicionarMotorista(m3);
		Principal.adicionarMotorista(m4);
	}
	
	public static void criaCliente() throws IOException {
		Usuario u = new Usuario("90372561047", "usuario1", "usuario 1 social", "123345", "email1@email.com", "00/00/00", 0, 0);
		Principal.adicionaUsuario(u);
		
	}
	
	public static void solicitaCorridas(Class<?> categoria) {
		Corrida corrida = new Corrida(null, Principal.getUsuario(0), 10f, categoria);
		Principal.adicionaCorrida(corrida);	
	}
}
