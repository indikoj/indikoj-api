package br.com.uaijug.indikoj.constants;

import br.com.uaijug.indikoj.exception.NotImplementationConstructionException;

public class AppConstants {

	// Auxs Constants for Controllers
	public static final String RESPONSE_UNSUCCESS = "unsuccess";

	public static final String RESPONSE_SUCCESS = "success";

	public static final String CURRENT_USER = "root@localhost";
	
	public static final String DADOS_DELETADOS = "Dados Deletados!";

	private AppConstants() {
		throw new NotImplementationConstructionException("Classe não pode ser instanciada");
	}

}
