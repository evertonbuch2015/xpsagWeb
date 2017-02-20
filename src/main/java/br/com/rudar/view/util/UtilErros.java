package br.com.rudar.view.util;

public class UtilErros {

	//procura a exceção de nivel mais baixo. 
	public static String getMensagemErro(Exception ex){
		while(ex.getCause() != null){
			ex = (Exception) ex.getCause();
		}
		
		String retorno = ex.getMessage();
		return retorno;
	}
}

