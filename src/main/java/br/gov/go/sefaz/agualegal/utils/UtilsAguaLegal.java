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

}
