package br.gov.go.sefaz.agualegal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.gov.go.sefaz.agualegal.repository.CampoFormularioRepository;

@SpringBootApplication
public class AgualegalApplication implements CommandLineRunner 
{

	@Autowired
	public CampoFormularioRepository formularioRepository;

	public static void main(String[] args) {
		SpringApplication.run(AgualegalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	//	this.formularioRepository.findAll().forEach(item -> System.out.println(item.toString()));		
	}
	
	
	
	//@Override
	/*public void run(String... args) throws Exception {

		
		Optional<DadosPedido> dados = dadosPedidoRepository.findById(2);
		System.out.println(dados.get().getJsonProdutos());
		dados.get().getJsonProdutos();

		Type listType = new TypeToken<List<ProdutoDTO>>() {
		}.getType();
		Gson gson = new Gson();
		List<ProdutoDTO> produtoDTOList = gson.fromJson(dados.get().getJsonProdutos(), listType);

		produtoDTOList.forEach(item -> 
			{
				try {
					UtilsAguaLegal.saveFile(item.getImagemRotulo(), "C:\\Users\\marco.pegado\\Desktop\\arqs\\recup", item.getDescricaoMarca());
				} catch (IOException e) {					
					e.printStackTrace();
				}
			}
		);

	}*/

	

}
