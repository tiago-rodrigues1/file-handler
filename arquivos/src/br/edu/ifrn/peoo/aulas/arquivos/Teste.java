package br.edu.ifrn.peoo.aulas.arquivos;

import br.edu.ifrn.peoo.aulas.arquivos.atividade1.Pessoa;

public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Pessoa meuObjeto = new Pessoa("Henrique", 17);
		
		ManipuladorArquivoObjeto.gravar(meuObjeto, "teste.txt");
	}

}
