package br.gov.go.sefaz.agualegal.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import br.gov.go.sefaz.agualegal.dto.solicitacao.DadosSolicitacaoDTO;
import br.gov.go.sefaz.agualegal.dto.solicitacao.LicencaDTO;
import br.gov.go.sefaz.agualegal.dto.solicitacao.ProdutoDTO;

public class MockTestes {

	public static byte[] carregaBytes(String caminho) {
		Path path = Paths.get(caminho);
		try {
			return Files.readAllBytes(path);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static DadosSolicitacaoDTO mockSucessoParametrosDesativados() {

		DadosSolicitacaoDTO dto = new DadosSolicitacaoDTO();

		dto.getCadastro().setCnpj("68289928000171");
		dto.getCadastro().setRazaoSocial("OX EXPLORACAO E PESQUISA DE MINERAIS");
		dto.getCadastro().setNomeFantasia("OX ÁGUAS");
		dto.getCadastro().setInscricaoEstadual("121247805");
		dto.setTokenGrafica("5KmX9HRr6FI_KX5rEJGhsAqEpifZ62uN3nMEd_8h1C0");
		dto.setTipoAgua("3");

		dto.setCnpjGrafica("35113067000117");

		dto.setObservacao(
				"Solicitação de credenciamento de empresa envasadora para fins de atuação no Leste do maranhão");

		List<ProdutoDTO> listaProdutos = new ArrayList<>();
		ProdutoDTO produtoDTO = new ProdutoDTO();
		produtoDTO.setVolume(20);
		produtoDTO.setTipoProduto(1);
		produtoDTO.setTipoEmbalagem(1);
		produtoDTO.setDescricaoMarca("Água Biônicas");
		produtoDTO.setImagemRecipiente(carregaBytes("C:\\Users\\marco.pegado\\Desktop\\arqs\\galao20.jpg"));
		produtoDTO.setImagemRotulo(carregaBytes("C:\\Users\\marco.pegado\\Desktop\\arqs\\rotulo20.jpg"));

		ProdutoDTO produtoDTO2 = new ProdutoDTO();
		produtoDTO2.setVolume(40);
		produtoDTO2.setTipoProduto(2);
		produtoDTO2.setTipoEmbalagem(2);
		produtoDTO2.setDescricaoMarca("Água do poder");
		produtoDTO2.setImagemRecipiente(carregaBytes("C:\\Users\\marco.pegado\\Desktop\\arqs\\galao40.jpg"));
		produtoDTO2.setImagemRotulo(carregaBytes("C:\\Users\\marco.pegado\\Desktop\\arqs\\rotulo40.jpg"));

		ProdutoDTO produtoDTO3 = new ProdutoDTO();
		produtoDTO3.setVolume(10);
		produtoDTO3.setTipoProduto(2);
		produtoDTO3.setTipoEmbalagem(1);
		produtoDTO3.setDescricaoMarca("Água mata-sedes");
		produtoDTO3.setImagemRecipiente(carregaBytes("C:\\Users\\marco.pegado\\Desktop\\arqs\\galao10.jpg"));
		produtoDTO3.setImagemRotulo(carregaBytes("C:\\Users\\marco.pegado\\Desktop\\arqs\\rotulo10.jpg"));

		listaProdutos.add(produtoDTO);
		listaProdutos.add(produtoDTO2);
		listaProdutos.add(produtoDTO3);

		dto.setListaProdutos(listaProdutos);

		dto.getResponsavel().setCpfResponsavel("27345589048");
		dto.getResponsavel().setRgResponsavel("032152992006");
		dto.getResponsavel().setTelefoneResponsavel("98988566805");
		dto.getResponsavel().setNomeResponsavel("Marco Antonio Silva");
		dto.getResponsavel().setEmailResponsavel("marcoantoniosilvapegado@gmail.com");

		LicencaDTO licencaSanitaria = new LicencaDTO();
		licencaSanitaria.setEmissorLicenca(1);
		licencaSanitaria.setNumero("12345");
		licencaSanitaria.setImagem(carregaBytes("C:\\Users\\marco.pegado\\Desktop\\arqs\\teste.pdf"));

		LicencaDTO licencaAmbiental = new LicencaDTO();
		licencaAmbiental.setNumero("23456");
		licencaAmbiental.setImagem(carregaBytes("C:\\Users\\marco.pegado\\Desktop\\arqs\\teste.pdf"));

		dto.setLicencaVigilancia(licencaSanitaria);
		dto.setLicencaMineracao(licencaAmbiental);

		dto.getEnderecoDTO().setEnderecoEnvasador("Rua da Alegria, 737, Centro - São Luis - MA");
		dto.getEnderecoDTO().setCoordenadasEnvasador("-2.5920175196049184, -44.18432958161534");
		dto.getEnderecoDTO().setEnderecoEnvase("Rua Agostinho Torres, SN, João Paulo - São Luis - MA");
		dto.getEnderecoDTO().setCoordenadasEnvase("-2.5920175196049183, -44.18432958161533");

		return dto;

	}

}
