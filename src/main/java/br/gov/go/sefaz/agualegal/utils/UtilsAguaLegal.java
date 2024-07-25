package br.gov.go.sefaz.agualegal.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;

import org.apache.tika.Tika;

import br.gov.go.sefaz.agualegal.dto.solicitacao.ArquivoDTO;
import br.gov.go.sefaz.agualegal.dto.solicitacao.CampoDTO;
import br.gov.go.sefaz.agualegal.dto.solicitacao.ProdutoDTO;
import br.gov.go.sefaz.agualegal.dto.solicitacao.SolicitacaoCredenciamentoDTO;

public class UtilsAguaLegal {

	public static String extracaoDadosListaCampos(String campo, SolicitacaoCredenciamentoDTO dto) {
		List<CampoDTO> listAux = dto.getListaCampos().stream().filter(item -> item.getNomeCampo().equals(campo))
				.collect(Collectors.toList());
		if (!listAux.isEmpty()) {
			return listAux.get(0).getConteudoCampo();
		}
		return "";
	}

	public static boolean isEmpty(String s) {
		return s == null || s.trim().length() == 0;
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


}
