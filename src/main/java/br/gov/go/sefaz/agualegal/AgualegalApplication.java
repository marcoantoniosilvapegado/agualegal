package br.gov.go.sefaz.agualegal;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.gov.go.sefaz.agualegal.dto.solicitacao.ProdutoDTO;
import br.gov.go.sefaz.agualegal.modelo.Cadastro;
import br.gov.go.sefaz.agualegal.modelo.CadastroCnae;
import br.gov.go.sefaz.agualegal.modelo.DadosPedido;
import br.gov.go.sefaz.agualegal.repository.CadastroCnaeRepository;
import br.gov.go.sefaz.agualegal.repository.CadastroRepository;
import br.gov.go.sefaz.agualegal.repository.CampoFormularioRepository;
import br.gov.go.sefaz.agualegal.repository.DadosPedidoRepository;
import br.gov.go.sefaz.agualegal.utils.UtilsAguaLegal;

@SpringBootApplication
public class AgualegalApplication// implements CommandLineRunner 
{

	@Autowired
	public CampoFormularioRepository formularioRepository;
	
	@Autowired 
	public DadosPedidoRepository dadosPedidoRepository;
	
	@Autowired
	public CadastroRepository cadastroRepository;
	
	@Autowired
	public CadastroCnaeRepository cadastroCnaeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AgualegalApplication.class, args);
	}

	//@Override
	public void run(String... args) throws Exception {
		Cadastro cadastro = new Cadastro();
		cadastro.setCnpj("55377488000162");
		cadastro.setIe(122437111L);
		cadastro.setRazaoSocial("ASB BEBIDAS E ALIMENTOS LTDA");
		cadastro.setSituacaoFiscal(1);
		
		Cadastro cadastroSalvo = this.cadastroRepository.save(cadastro);
		
		CadastroCnae cadastroCnae = new CadastroCnae();
		cadastroCnae.setCadastro(cadastroSalvo);
		cadastroCnae.setStatus(1);
		cadastroCnae.setCnae(1121600L);
		
		this.cadastroCnaeRepository.save(cadastroCnae);
		
	}
	
	
	
	

}
