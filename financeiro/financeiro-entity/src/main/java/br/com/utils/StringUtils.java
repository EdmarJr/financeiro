package br.com.utils;

public class StringUtils {

	public static String primeiraLetraMaiuscula(String texto) {
		String primeiraLetra = texto.substring(0, 1).toUpperCase();
		String restanteTexto = texto.substring(1, texto.length());
		StringBuilder sb = new StringBuilder();
		sb.append(primeiraLetra);
		sb.append(restanteTexto);
		return sb.toString();

	}

}
