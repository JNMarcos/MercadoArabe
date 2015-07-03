package br.ufrpe.negocio.utilidades;

public class PessoaUtilidades {
	private static final int N_MINIMO_CARACTERES_SENHA = 8;
	private static final int N_MAXIMO_CARACTERES_SENHA = 24;
	private static final int N_MINIMO_CARACTERES_NOME_USUARIO = 4;
	private static final int N_MAXIMO_CARACTERES_NOME_USUARIO = 30;
	//pra ver se comita

		//põe nomes no formato "Pablo Alexandre do Arrocha" (primeiras letras de cada palavra em maiúscula e sem espaço no fim dos nomes)
	public static String porNomesNoPadrao(String nome){
		String nomePadrao = "";
		String substring;
		if (nome != null){
			nome = nome.trim();
			nome = nome.toLowerCase();
			String[] nomePartido = nome.split(" ");
			char c;
			char C;
			String concatenar;
			for (int i = 0; i < nomePartido.length; i++){
				c = nomePartido[i].charAt(0);
				C = Character.toUpperCase(c);
				substring = nomePartido[i].substring(1);
				concatenar = C + "";
				concatenar = concatenar.concat(substring);
				nomePartido[i] = concatenar;
			}
			for (int j = 0; j < nomePartido.length; j++){
				nomePadrao = nomePadrao + (nomePartido[j].concat(" "));
			}

			nomePadrao = nomePadrao.trim();
		}
		return nomePadrao;
	}			

	public static boolean senhaNosConformes(String senha){
		boolean senhaOK = false;
		boolean senhaMaiusculaOK = false;
		boolean senhaCaractereEspecialOK = false;
		if (!senha.equals("")){
			if (senha.length() >= N_MINIMO_CARACTERES_SENHA && senha.length() <= N_MAXIMO_CARACTERES_SENHA){
				for (int i = 0; i < senha.length(); i++){
					if ((senha.charAt(i) >= 32 && senha.charAt(i) <= 64)
							|| (senha.charAt(i) >= 91 && senha.charAt(i) <= 96) 
							|| (senha.charAt(i) >= 123 && senha.charAt(i) <= 127)){
						senhaCaractereEspecialOK = true;
					}
					if (senha.charAt(i) >= 65 && senha.charAt(i) <= 90){
						senhaMaiusculaOK = true;
					}

					if (senhaMaiusculaOK && senhaCaractereEspecialOK){
						senhaOK = true;
						break;
					}
				}
			}
		}
		return senhaOK;
	}

	public static boolean nomeUsuarioNosConformes(String nomeUsuario){
		boolean nomeUsuarioOK = false;
		if (!nomeUsuario.equals("")){
			if (nomeUsuario.length() >= N_MINIMO_CARACTERES_NOME_USUARIO && nomeUsuario.length() <= N_MAXIMO_CARACTERES_NOME_USUARIO){
				nomeUsuarioOK = true;
		}
		}
		return nomeUsuarioOK;
	}
	
	public static boolean nomeNosConformes(String nome) {
		boolean nomeOK = false;
		if (!nome.isEmpty()) //força o usuario a informar seu nome
			nomeOK = true;
		
		return nomeOK;
	}

}
