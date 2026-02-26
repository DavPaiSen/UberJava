package backEnd;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Persistencia {
	public static void salvar(Object salvar, String arquivo) throws IOException {
		FileOutputStream gravarArquivo = new FileOutputStream(arquivo);
		ObjectOutputStream objGravar = new ObjectOutputStream(gravarArquivo);
		objGravar.writeObject(salvar);
		objGravar.flush();
		objGravar.close();
		gravarArquivo.flush();
		gravarArquivo.close();
	}
	
	public static Object carregar(String arquivo) throws ClassNotFoundException, IOException {
		Object object = null;
		FileInputStream arquivoLeitura = null;
		ObjectInputStream objLeitura = null;
		arquivoLeitura = new FileInputStream(arquivo);
		objLeitura = new ObjectInputStream(arquivoLeitura);
		object = objLeitura.readObject();
		objLeitura.close();
		arquivoLeitura.close();
		return object;
	}
}
