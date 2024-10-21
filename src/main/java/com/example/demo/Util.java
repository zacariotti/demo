package com.example.demo;

public class Util {

	// Método que valida o CPF
	public static boolean isValidCPF(String cpf) {
		// Remove possíveis caracteres de formatação
		cpf = cpf.replaceAll("\\D", "");

		// Verifica se o CPF tem 11 dígitos
		if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
			return false;
		}

		// Calcula os dois dígitos verificadores
		try {
			int sum1 = 0, sum2 = 0;
			for (int i = 0; i < 9; i++) {
				int digit = cpf.charAt(i) - '0';
				sum1 += digit * (10 - i);
				sum2 += digit * (11 - i);
			}
			int checkDigit1 = (sum1 * 10) % 11;
			checkDigit1 = (checkDigit1 == 10) ? 0 : checkDigit1;
			sum2 += checkDigit1 * 2;
			int checkDigit2 = (sum2 * 10) % 11;
			checkDigit2 = (checkDigit2 == 10) ? 0 : checkDigit2;

			return checkDigit1 == (cpf.charAt(9) - '0') && checkDigit2 == (cpf.charAt(10) - '0');
		} catch (Exception e) {
			return false;
		}
	}

}
