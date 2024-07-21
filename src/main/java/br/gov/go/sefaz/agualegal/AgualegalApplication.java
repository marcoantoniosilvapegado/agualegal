package br.gov.go.sefaz.agualegal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.gov.go.sefaz.agualegal.modelo.CampoFormulario;
import br.gov.go.sefaz.agualegal.modelo.Credenciamento;
import br.gov.go.sefaz.agualegal.modelo.PedidoCampoForm;
import br.gov.go.sefaz.agualegal.modelo.PedidoCredenciamento;
import br.gov.go.sefaz.agualegal.modelo.PedidoProduto;
import br.gov.go.sefaz.agualegal.modelo.TipoAnalise;
import br.gov.go.sefaz.agualegal.modelo.TipoResposta;
import br.gov.go.sefaz.agualegal.repository.CampoFormularioRepository;
import br.gov.go.sefaz.agualegal.repository.CredenciamentoRepository;
import br.gov.go.sefaz.agualegal.repository.IeExcecaoRepository;
import br.gov.go.sefaz.agualegal.repository.TipoAnaliseRepository;
import br.gov.go.sefaz.agualegal.repository.TipoRespostaRepository;

@SpringBootApplication
public class AgualegalApplication implements CommandLineRunner
{

	@Autowired
	CredenciamentoRepository repository;
	     
	@Autowired
	IeExcecaoRepository ieExcecaoRepository;
	
	@Autowired
	TipoRespostaRepository tipoRespostaRepository;
	
	@Autowired
	TipoAnaliseRepository tipoAnaliseRepository;
	
	@Autowired
	CampoFormularioRepository campoFormularioRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AgualegalApplication.class, args);				
	}
	
    @Transactional
	public void run(String... args) throws Exception {
		
		Credenciamento cred = this.repository.findById(36L).get();
		System.out.println(cred.toString());
		PedidoCredenciamento pedido = cred.getPedidos().get(0);
		System.out.println(pedido.toString());
		PedidoCampoForm pedidoCampoForm = pedido.getListaPedidoCampos().get(0);
		System.out.println(pedidoCampoForm.toString());
		PedidoProduto prod = pedido.getListaProdutos().get(0);
		System.out.println(prod.toString());
		
		
		
		
	}
	
	public void run5(String... args) throws Exception {
		
		Credenciamento credenciamento = new Credenciamento();
		credenciamento.setCnpj("22502602000180");		
		credenciamento.setDataSolicitacao(new Date());
		credenciamento.setInscricaoEstadual(1281777L);
		credenciamento.setRazaoSocial("Envasadora Águas de Bacabal");
		credenciamento.setStatus(1);
		
		PedidoCredenciamento pedido = new PedidoCredenciamento();
		pedido.setCredenciamento(credenciamento);
		pedido.setNumeroPedido(123456L);
		pedido.setDataPedido(new Date());
		pedido.setDataVencimento(this.addDaysToDate(10));
		pedido.setStatus(1);
		pedido.setTipoPedido(1);
		pedido.setCnpjGrafica("24964915000185");
		pedido.setNomeGrafica("Gráfica Bacabal");

		credenciamento.getPedidos().add(pedido);  
		pedido.setCredenciamento(credenciamento);
		
		PedidoCampoForm pedidoCampoForm = new PedidoCampoForm();
		pedidoCampoForm.setValorCampo("Marco Antonio");
		pedidoCampoForm.setPedidoCredenciamento(pedido);
		pedidoCampoForm.setDataVencimento(this.addDaysToDate(10));
		pedidoCampoForm.setCampoFormulario(this.campoFormularioRepository.findById(3L).get());
		pedido.getListaPedidoCampos().add(pedidoCampoForm);		
		
		PedidoProduto produto = new PedidoProduto();
		produto.setDescricaoMarca("Marca águas de lindoia");
		produto.setVolume(20);
		produto.setTipoProduto("Água mineral");
		produto.setTipoEmbalagem("Galão");
		produto.setPedidoCredenciamento(pedido);
		produto.setImagemRecipiente(carregaBytes("C:\\Users\\marco.pegado\\Desktop\\arqs\\galao20.jpg"));
		produto.setImagemRotulo(carregaBytes("C:\\Users\\marco.pegado\\Desktop\\arqs\\rotulo20.jpg"));
		produto.setPedidoCredenciamento(pedido);
		pedido.getListaProdutos().add(produto);
		
		this.repository.save(credenciamento);
	}


	
	public void run3(String... args) throws Exception {
		Integer teste1 = this.ieExcecaoRepository.findExceptionByIE(991836618L);
		Integer teste2 = this.ieExcecaoRepository.findExceptionByIE(991836617L);		
		System.out.println(teste1);
		System.out.println(teste2);
		Optional<TipoAnalise> tipoAnaliseFiltro = this.tipoAnaliseRepository.findById(0L);
		Optional<TipoResposta> tipoRespostaFiltro = this.tipoRespostaRepository.findById(3L);
		
		CampoFormulario campoPersist = new CampoFormulario();
		campoPersist.setCampoObrigatorio("S");
		campoPersist.setDataVencimento(this.addDaysToDate(10));
		campoPersist.setDescricaoCriterio("Data de fundação da empresa envasadora");
		campoPersist.setDisponibilizarCampo("S");
		campoPersist.setNomeCriterio("Data Fundação");
		campoPersist.setStatus("A");
		campoPersist.setTemDataVencimento("S");
		campoPersist.setTipoAnalise(tipoAnaliseFiltro.get());
		campoPersist.setTipoResposta(tipoRespostaFiltro.get());
		
	//	this.campoFormularioRepository.save(campoPersist);
		
		List<CampoFormulario> list1 = this.campoFormularioRepository.findAll();
		List<TipoAnalise> list2 = this.tipoAnaliseRepository.findAll();
		List<TipoResposta> list3 = this.tipoRespostaRepository.findAll();
		
		
		System.out.println(list1.toString());
		System.out.println(list2.toString());
		System.out.println(list3.toString());				
		
	}
	
	//@Override
	public void run2(String... args) throws Exception {
				
		Credenciamento credenciamento = new Credenciamento();
		credenciamento.setCnpj("22502602000180");
		//credenciamento.setDataInicio(new Date());
		credenciamento.setDataSolicitacao(new Date());
		credenciamento.setInscricaoEstadual(1281777L);
		credenciamento.setRazaoSocial("Envasadora Águas de Bacabal");
		credenciamento.setStatus(1);

		PedidoCredenciamento pedido = new PedidoCredenciamento();
		pedido.setCredenciamento(credenciamento);
		pedido.setNumeroPedido(123456L);
		pedido.setDataPedido(new Date());
		pedido.setDataVencimento(this.addDaysToDate(10));
		pedido.setStatus(1);
		pedido.setTipoPedido(1);
		pedido.setCnpjGrafica("24964915000185");
		pedido.setNomeGrafica("Gráfica Bacabal");

	//	pedido.get.addAll(this.retornaListaPedidosTeste(pedido));
		//pedido.getProdutos().addAll(this.retornaListaProdutosTeste(pedido));

	//	credenciamento.getPedidos().add(pedido);

		this.repository.save(credenciamento);
		
		
	}
	/*
	private List<Produto> retornaListaProdutosTeste(PedidoCredenciamento pedido){
		
		Produto prod = new Produto();
		prod.setTipoEmbalagem("Galão de água");
		prod.setDescricaoMarca("Água Estrela");
		prod.setVolume(20);
		prod.setTipoProduto("Mineral");
		prod.setImagemRecipiente(carregaBytes("C:\\Users\\marco.pegado\\Desktop\\arqs\\galao20.jpg"));
		prod.setImagemRotulo(carregaBytes("C:\\Users\\marco.pegado\\Desktop\\arqs\\rotulo20.jpg"));
		prod.setPedidoCredenciamento(pedido);
		
		Produto prod2 = new Produto();
		prod2.setTipoEmbalagem("Galão de água");
		prod2.setDescricaoMarca("Águas Cristalinas");
		prod2.setVolume(40);
		prod2.setTipoProduto("Gaseificada");
		prod2.setImagemRecipiente(carregaBytes("C:\\Users\\marco.pegado\\Desktop\\arqs\\galao40.jpg"));
		prod2.setImagemRotulo(carregaBytes("C:\\Users\\marco.pegado\\Desktop\\arqs\\rotulo40.jpg"));
		prod2.setPedidoCredenciamento(pedido);	
		
		Produto prod3 = new Produto();
		prod3.setTipoEmbalagem("Galão de água - 10");
		prod3.setDescricaoMarca("Liquiágua");
		prod3.setVolume(10);
		prod3.setTipoProduto("Saborizada");
		prod3.setImagemRecipiente(carregaBytes("C:\\Users\\marco.pegado\\Desktop\\arqs\\galao10.jpg"));
		prod3.setImagemRotulo(carregaBytes("C:\\Users\\marco.pegado\\Desktop\\arqs\\rotulo10.jpg"));
		prod3.setPedidoCredenciamento(pedido);	
		
		return Arrays.asList(prod, prod2, prod3);
	}
	
/*	private List<PedidoListaCampos> retornaListaPedidosTeste(PedidoCredenciamento pedido){
		
		PedidoListaCampos pedidoListaCampo1 = new PedidoListaCampos();
		pedidoListaCampo1.setNomeCampo("CPF");
		pedidoListaCampo1.setDescricaoCampo("CPF do responsável pela envasadora");
		pedidoListaCampo1.setValorCampo("04102178325");
		pedidoListaCampo1.setTipoCampo("TEXTO");
		pedidoListaCampo1.setPedidoCredenciamento(pedido);
	
		PedidoListaCampos pedidoListaCampo2 = new PedidoListaCampos();
		pedidoListaCampo2.setNomeCampo("LICENCA SANITARIA");
		pedidoListaCampo2.setDescricaoCampo("PDF da licença sanitária emitida");
		pedidoListaCampo2.setConteudoArquivo(carregaBytes("C:\\Users\\marco.pegado\\Desktop\\arqs\\teste.pdf"));
		pedidoListaCampo2.setTipoCampo("PDF");
		pedidoListaCampo2.setPedidoCredenciamento(pedido);

		PedidoListaCampos pedidoListaCampo3 = new PedidoListaCampos();
		pedidoListaCampo3.setNomeCampo("EMISSOR DA LICENÇA");
		pedidoListaCampo3.setDescricaoCampo("Órgão responsável pela emissão da licença sanitária");
		pedidoListaCampo3.setValorCampo("ANVISA");
		pedidoListaCampo3.setTipoCampo("TEXTO"); 
		pedidoListaCampo3.setPedidoCredenciamento(pedido);
				
		PedidoListaCampos pedidoListaCampo4 = new PedidoListaCampos();
		pedidoListaCampo4.setNomeCampo("Endereço Envasadora");
		pedidoListaCampo4.setDescricaoCampo("Endereço da empresa envasadora");
		pedidoListaCampo4.setValorCampo("Rua da Alegria, Centro - Bacabal");
		pedidoListaCampo4.setTipoCampo("TEXTO");
		pedidoListaCampo4.setPedidoCredenciamento(pedido);
		
		PedidoListaCampos pedidoListaCampo5 = new PedidoListaCampos();
		pedidoListaCampo5.setNomeCampo("RG");
		pedidoListaCampo5.setDescricaoCampo("RG do responsável pela anvasadora");
		pedidoListaCampo5.setValorCampo("0321529920064");
		pedidoListaCampo5.setTipoCampo("TEXTO");
		pedidoListaCampo5.setPedidoCredenciamento(pedido);
		
		PedidoListaCampos pedidoListaCampo6 = new PedidoListaCampos();
		pedidoListaCampo6.setNomeCampo("NOME");
		pedidoListaCampo6.setDescricaoCampo("NOME do responsável pela anvasadora");
		pedidoListaCampo6.setValorCampo("Marco Antonio");
		pedidoListaCampo6.setTipoCampo("TEXTO");
		pedidoListaCampo6.setPedidoCredenciamento(pedido);
		
		PedidoListaCampos pedidoListaCampo7 = new PedidoListaCampos();
		pedidoListaCampo7.setNomeCampo("Nome Fantasia");
		pedidoListaCampo7.setDescricaoCampo("Nome Fantasia da Envasadora");
		pedidoListaCampo7.setValorCampo("Envasadora Águas de Bacabal");
		pedidoListaCampo7.setTipoCampo("TEXTO");
		pedidoListaCampo7.setPedidoCredenciamento(pedido);
		
		PedidoListaCampos pedidoListaCampo8 = new PedidoListaCampos();
		pedidoListaCampo8.setNomeCampo("IMAGEM LACRE");
		pedidoListaCampo8.setDescricaoCampo("Imagem do lacre usado no envasamento");
		pedidoListaCampo8.setConteudoArquivo(carregaBytes("C:\\Users\\marco.pegado\\Desktop\\arqs\\lacre.jpg"));
		pedidoListaCampo8.setTipoCampo("IMAGEM");
		pedidoListaCampo8.setPedidoCredenciamento(pedido);
		
		return Arrays.asList(pedidoListaCampo1, pedidoListaCampo2, pedidoListaCampo3, pedidoListaCampo4,
				pedidoListaCampo5, pedidoListaCampo6,pedidoListaCampo7,pedidoListaCampo8);

	}*/
	
	public static byte[] carregaBytes(String caminho) {
        Path path = Paths.get(caminho);//("C:\\Users\\marco.pegado\\Desktop\\arqs\\teste.pdf");
        try {
            return Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
	
	public Date addDaysToDate(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, days);
        return calendar.getTime();
    }


	
	

}
