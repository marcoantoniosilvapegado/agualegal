package br.gov.go.sefaz.agualegal.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.gov.go.sefaz.agualegal.dto.solicitacao.ArquivoDTO;
import br.gov.go.sefaz.agualegal.dto.solicitacao.CampoDTO;
import br.gov.go.sefaz.agualegal.dto.solicitacao.ProdutoDTO;
import br.gov.go.sefaz.agualegal.dto.solicitacao.SolicitacaoCredenciamentoDTO;
import br.gov.go.sefaz.agualegal.modelo.PedidoProduto;

public class UtilsAguaLegal {
	
	public static String extracaoDadosListaCampos(String campo, SolicitacaoCredenciamentoDTO dto){
		List<CampoDTO> listAux = 
				dto.getListaCampos().stream().filter(item -> item.getNomeCampo().equals(campo)).collect(Collectors.toList());
		if(!listAux.isEmpty()) {
			return listAux.get(0).getConteudoCampo();
		}
		return "";
	}
	
	public static byte[] carregaBytes(String caminho) {
        Path path = Paths.get(caminho);//("C:\\Users\\marco.pegado\\Desktop\\arqs\\teste.pdf");
        try {
            return Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
	
	public static SolicitacaoCredenciamentoDTO mockTemporarioSolicitacaoDTO() {
		
		SolicitacaoCredenciamentoDTO dto = new SolicitacaoCredenciamentoDTO();
		dto.setCnpjGrafica("35113067000117");
		dto.setNomeGrafica("GRAFICA E EDITORA SAO LUIS LTDA");
		dto.setInscricaoEstadual("199279103");
		dto.setTipoAgua("2");
		dto.setTokenGrafica("Bearer 4567");
		
		List<CampoDTO> listaCampos = new ArrayList<>();
		listaCampos.add(new CampoDTO("CNPJ", "CNPJ", "38545378000143"));
		listaCampos.add(new CampoDTO("Nome Fantasia", "Nome Fantasia", "AGUA 5 ESTRELAS"));
		listaCampos.add(new CampoDTO("Razão Social", "Razão Social", "AGUA 5 ESTRELAS"));
		listaCampos.add(new CampoDTO("Inscrição Estadual", "Inscrição Estadual", "199279103"));
		listaCampos.add(new CampoDTO("Endereço do Envasador", "Endereço do Envasador", "Rua das águas, N. 33, bairro águas de lindoia"));
		listaCampos.add(new CampoDTO("Endereço do local do envase", "Endereço do local do envase", "Rua do Envasamento, número 44, bairro Águas claras"));	
		listaCampos.add(new CampoDTO("RG do responsável pelo Envasador", "RG do responsável pelo Envasador", "0321529920064"));
		listaCampos.add(new CampoDTO("CPF do responsável pelo Envasador", "CPF do responsável pelo Envasador", "04102178325"));
		listaCampos.add(new CampoDTO("E-mail do responsável pelo Envasador", "E-mail do responsável pelo Envasador", "marcoantonio@gmail.com"));
		
		dto.setListaCampos(listaCampos);
		
		List<ArquivoDTO> listaArquivo = new ArrayList<>();		
		listaArquivo.add(new ArquivoDTO("Imagem da licença sanitária", "Imagem da licença sanitária", 
				carregaBytes("C:\\Users\\marco.pegado\\Desktop\\arqs\\licenca.jpg")));
		dto.setListaArquivos(listaArquivo);
		
		List<ProdutoDTO> listaProdutos = new ArrayList<>();
		ProdutoDTO produtoDTO = new ProdutoDTO();
		produtoDTO.setVolume("20");
		produtoDTO.setTipo("Água mineral");
		produtoDTO.setTipoEmbalagem("Galão");
		produtoDTO.setDescricaoMarca("Marca águas de lindoia");
		produtoDTO.setFotoRecipienteBase(carregaBytes("C:\\Users\\marco.pegado\\Desktop\\arqs\\galao20.jpg"));
		produtoDTO.setImagemRotuloBase(carregaBytes("C:\\Users\\marco.pegado\\Desktop\\arqs\\rotulo20.jpg"));
		
		ProdutoDTO produtoDTO2 = new ProdutoDTO();
		produtoDTO2.setVolume("40");
		produtoDTO2.setTipo("Água de sais minerais");
		produtoDTO2.setTipoEmbalagem("Garrafa");
		produtoDTO2.setDescricaoMarca("Marca águas de sal");
		produtoDTO2.setFotoRecipienteBase(carregaBytes("C:\\Users\\marco.pegado\\Desktop\\arqs\\galao40.jpg"));
		produtoDTO2.setImagemRotuloBase(carregaBytes("C:\\Users\\marco.pegado\\Desktop\\arqs\\rotulo40.jpg"));
		
		listaProdutos.add(produtoDTO2);
		listaProdutos.add(produtoDTO);		
		
		dto.setListaProdutos(listaProdutos);
		
		return dto;
		
	}
}
