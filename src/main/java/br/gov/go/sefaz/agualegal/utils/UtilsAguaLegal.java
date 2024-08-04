package br.gov.go.sefaz.agualegal.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.validator.routines.EmailValidator;
import javax.imageio.ImageIO;

import org.apache.tika.Tika;

import com.google.gson.Gson;

public class UtilsAguaLegal {

	private static final Gson gson = new Gson();

	public static boolean isEmpty(String s) {
		return s == null || s.trim().length() == 0;
	}

	public static String toJson(Object obj) {
		return gson.toJson(obj);
	}

	public static byte[] carregaBytes(String caminho) {
		Path path = Paths.get(caminho);// ("C:\\Users\\marco.pegado\\Desktop\\arqs\\teste.pdf");
		try {
			return Files.readAllBytes(path);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean isImage(byte[] data) {
		if (data == null || data.length == 0) {
			return false;
		}

		try (ByteArrayInputStream bis = new ByteArrayInputStream(data)) {
			BufferedImage image = ImageIO.read(bis);
			return image != null;
		} catch (IOException e) {
			return false;
		}
	}

	public static boolean verificaTamanhoImagemValido(byte[] data, boolean campo) {
		if (data == null) {
			return false;
		}

		return campo ? data.length <= 4 * 1024 * 1024 : data.length <= 2 * 1024 * 1024;
	}

	public static boolean verificaTamanhoImagemValido(byte[] data) {
		if (data == null) {
			return false;
		}

		return data.length <= 2 * 1024 * 1024;
	}

	public static List<String> filtrarItensLista(List<String> lista1, List<String> lista2) {
		return lista1.stream().filter(elemento -> !lista2.contains(elemento)).collect(Collectors.toList());
	}

	public static String detectarExtensaoConteudo(byte[] dados) {

		Tika tika = new Tika();
		String tipoMime;

		tipoMime = tika.detect(dados);

		if (tipoMime.startsWith("image/")) {
			return "IMAGEM";
		} else if ("application/pdf".equals(tipoMime)) {
			return "PDF";
		} else {
			return "OUTROS";
		}
	}

	public static boolean isNotEmpty(byte[] dados) {
		return dados != null && dados.length > 0;
	}

	public static void saveFile(byte[] fileBytes, String directory, String fileName) throws IOException {

		Path path = Paths.get(directory);
		if (!Files.exists(path)) {
			Files.createDirectories(path);
		}

		File file = new File(path.toFile(), fileName);

		try (FileOutputStream fos = new FileOutputStream(file)) {
			fos.write(fileBytes);
		}
	}

	public static boolean verificaEmailValido(String email) {
		if (email == null || email.isEmpty()) {
			return false;
		}

		EmailValidator validator = EmailValidator.getInstance();
		return validator.isValid(email);
	}

	public static boolean verificaCpfValido(String cpf) {
		if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d{11}")) {
			return false;
		}

		// Verifica se todos os dígitos são iguais
		if (cpf.matches("(\\d)\\1{10}")) {
			return false;
		}

		// Calcula o primeiro dígito verificador
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			sum += (cpf.charAt(i) - '0') * (10 - i);
		}
		int firstCheckDigit = 11 - (sum % 11);
		if (firstCheckDigit >= 10) {
			firstCheckDigit = 0;
		}

		// Calcula o segundo dígito verificador
		sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += (cpf.charAt(i) - '0') * (11 - i);
		}
		int secondCheckDigit = 11 - (sum % 11);
		if (secondCheckDigit >= 10) {
			secondCheckDigit = 0;
		}

		// Verifica os dígitos calculados com os dígitos informados
		return cpf.charAt(9) - '0' == firstCheckDigit && cpf.charAt(10) - '0' == secondCheckDigit;
	}

	public static boolean verificaCnpjValido(String cnpj) {
		if (cnpj == null || cnpj.length() != 14 || !cnpj.matches("\\d{14}")) {
			return false;
		}

		// Verifica se todos os dígitos são iguais
		if (cnpj.matches("(\\d)\\1{13}")) {
			return false;
		}

		// Cálculo do primeiro dígito verificador
		int[] weights1 = { 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
		int sum = 0;
		for (int i = 0; i < 12; i++) {
			sum += (cnpj.charAt(i) - '0') * weights1[i];
		}
		int firstCheckDigit = sum % 11 < 2 ? 0 : 11 - (sum % 11);

		// Cálculo do segundo dígito verificador
		int[] weights2 = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
		sum = 0;
		for (int i = 0; i < 13; i++) {
			sum += (cnpj.charAt(i) - '0') * weights2[i];
		}
		int secondCheckDigit = sum % 11 < 2 ? 0 : 11 - (sum % 11);

		// Verifica os dígitos calculados com os dígitos informados
		return cnpj.charAt(12) - '0' == firstCheckDigit && cnpj.charAt(13) - '0' == secondCheckDigit;
	}

}
