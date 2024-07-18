package br.gov.go.sefaz.agualegal;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.gov.go.sefaz.agualegal.modelo.Credenciamento;
import br.gov.go.sefaz.agualegal.repository.CredenciamentoRepository;

@SpringBootApplication
public class AgualegalApplication implements CommandLineRunner{

	@Autowired
	CredenciamentoRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(AgualegalApplication.class, args);				
	}

	@Override
	public void run(String... args) throws Exception {
		Credenciamento c = new Credenciamento();
		c.setCnpj("22502602000180");
		c.setDataInicio(new Date());
		c.setDataSolicitacao(new Date());
		c.setInscricaoEstadual(1281777L);
		c.setRazaoSocial("Empresa teste persistencia");
		c.setStatus(1);
		
		this.repository.save(c);
		System.out.println(c.toString());
		
		
	}
	
	

}
