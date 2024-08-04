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
        Path path = Paths.get(caminho);//("C:\\Users\\marco.pegado\\Desktop\\arqs\\teste.pdf");
        try {
            return Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
	
	public static DadosSolicitacaoDTO mock1() {
		
		DadosSolicitacaoDTO dto = new DadosSolicitacaoDTO();
		
		dto.getCadastro().setCnpj("56698998000102");
		dto.getCadastro().setRazaoSocial("NATURAGUA AGUAS MINERAIS INDUSTRIA E COMERCIO SA");
		dto.getCadastro().setNomeFantasia("AGUAS NATURAGUA");
		dto.getCadastro().setInscricaoEstadual("122437110");
		
		dto.setTipoAgua("3");
		
		dto.setCnpjGrafica("06989552000150");
		
		dto.setObservacao("Solicitação de credenciamento de empresa envasadora para fins de atuação no SUL do maranhão");
		
		List<ProdutoDTO> listaProdutos = new ArrayList<>();
		ProdutoDTO produtoDTO = new ProdutoDTO();
		produtoDTO.setVolume(20);
		produtoDTO.setTipoProduto(1);
		produtoDTO.setTipoEmbalagem(1);
		produtoDTO.setDescricaoMarca("Água mineral estrela");
		produtoDTO.setImagemRecipiente(carregaBytes("C:\\Users\\marco.pegado\\Desktop\\arqs\\galao20.jpg"));
		produtoDTO.setImagemRotulo(carregaBytes("C:\\Users\\marco.pegado\\Desktop\\arqs\\rotulo20.jpg"));

		ProdutoDTO produtoDTO2 = new ProdutoDTO();
		produtoDTO2.setVolume(40);
		produtoDTO2.setTipoProduto(2);
		produtoDTO2.setTipoEmbalagem(2);
		produtoDTO2.setDescricaoMarca("Água de sais minerais estrela");
		produtoDTO2.setImagemRecipiente(carregaBytes("C:\\Users\\marco.pegado\\Desktop\\arqs\\galao40.jpg"));
		produtoDTO2.setImagemRotulo(carregaBytes("C:\\Users\\marco.pegado\\Desktop\\arqs\\rotulo40.jpg"));

		ProdutoDTO produtoDTO3 = new ProdutoDTO();
		produtoDTO3.setVolume(10);
		produtoDTO3.setTipoProduto(1);
		produtoDTO3.setTipoEmbalagem(1);
		produtoDTO3.setDescricaoMarca("Águas Gaseificada estrela");
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
		licencaSanitaria.setImagem(carregaBytes("C:\\Users\\marco.pegado\\Desktop\\arqs\\licencavigilancia.jpg"));
		
		LicencaDTO licencaAmbiental = new LicencaDTO();		
		licencaAmbiental.setNumero("23456");
		licencaAmbiental.setImagem(carregaBytes("C:\\Users\\marco.pegado\\Desktop\\arqs\\licencamineral.jpg"));
		
		dto.setLicencaVigilancia(licencaSanitaria);
		dto.setLicencaMineracao(licencaAmbiental);
		
		return dto;
		
	}
	
}
