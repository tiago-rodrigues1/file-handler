package br.edu.ifrn.peoo.aulas.arquivos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import br.edu.ifrn.peoo.aulas.arquivos.atividade1.Pessoa;

public class ManipuladorArquivoObjeto {

	//O objeto meuObject deve implementar a interface java.io.Serializable
	public static void gravar(Object meuObjeto, final String nomeArquivo) {

		ObjectOutputStream objectOutputStream = null;
		FileOutputStream fileOutputStream = null;

		try {

			fileOutputStream = new FileOutputStream(nomeArquivo);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(meuObjeto);

		} catch (FileNotFoundException e) {

			System.out.println(e.getMessage());
		} catch (IOException e) {

			System.out.println(e.getMessage());
		}
		finally {

			if (objectOutputStream != null) {

				try {
					objectOutputStream.close(); //tenta fechar o arquivo
				}
				catch (IOException e) {

					System.out.println("Erro ao tentar fechar o arquivo. Motivo: " + e.getMessage());
				}
			}
		}
	}


	public static void ler (final String nomeArquivo) {

		ObjectInputStream objectInputStream = null;
		FileInputStream fileInputStream = null;

		try {

			fileInputStream = new FileInputStream(nomeArquivo);
			objectInputStream = new ObjectInputStream(fileInputStream);
			Object meuObj = objectInputStream.readObject(); // A classe deve existir no seu projeto
			
			//Agora você deve fazer o casting de meuObj para o tipo da classe que foi gravada no arquivo.
			//Exemplo:
			//Funcionario f = (Funcionario) meuObj;
			Pessoa p = (Pessoa) meuObj;
			System.out.println(p.getNome());
			System.out.println(p.getIdade());

		} catch (FileNotFoundException e) {

			System.out.println(e.getMessage());
		} catch (IOException e) {

			System.out.println(e.getMessage());
			
		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());
		}
		finally {

			if (objectInputStream != null) {

				try {
					objectInputStream.close(); //tenta fechar o arquivo
				}
				catch (IOException e) {

					System.out.println("Erro ao tentar fechar o arquivo. Motivo: " + e.getMessage());
				}
			}
		}
	}
}
