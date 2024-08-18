package br.gov.go.sefaz.agualegal.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.gov.go.sefaz.agualegal.domain.DadosReponsavelPersistencia;
import br.gov.go.sefaz.agualegal.domain.EnvasadoraPersistencia;
import br.gov.go.sefaz.agualegal.domain.PreAnaliseResultado;
import br.gov.go.sefaz.agualegal.domain.RespostaPreAnalise;
import br.gov.go.sefaz.agualegal.dto.solicitacao.CampoPersistDTO;
import br.gov.go.sefaz.agualegal.dto.solicitacao.DadosSolicitacaoDTO;
import br.gov.go.sefaz.agualegal.exception.SolicitacaoCredenciamentoException;
import br.gov.go.sefaz.agualegal.modelo.AnalisePedido;
import br.gov.go.sefaz.agualegal.modelo.CampoFormulario;
import br.gov.go.sefaz.agualegal.modelo.Credenciamento;
import br.gov.go.sefaz.agualegal.modelo.DadosPedido;
import br.gov.go.sefaz.agualegal.modelo.Envasadora;
import br.gov.go.sefaz.agualegal.modelo.Grafica;
import br.gov.go.sefaz.agualegal.modelo.MotivoIndeferimento;
import br.gov.go.sefaz.agualegal.modelo.MotivoIndeferimentoAnalise;
import br.gov.go.sefaz.agualegal.modelo.PedidoCredenciamento;
import br.gov.go.sefaz.agualegal.modelo.SituacaoCadSefaz;
import br.gov.go.sefaz.agualegal.modelo.StatusAnalise;
import br.gov.go.sefaz.agualegal.modelo.StatusCredenciamento;
import br.gov.go.sefaz.agualegal.modelo.TipoAgua;
import br.gov.go.sefaz.agualegal.modelo.TipoAnalise;
import br.gov.go.sefaz.agualegal.repository.AnalisePedidoRepository;
import br.gov.go.sefaz.agualegal.repository.CampoFormularioRepository;
import br.gov.go.sefaz.agualegal.repository.CredenciamentoRepository;
import br.gov.go.sefaz.agualegal.repository.DadosPedidoRepository;
import br.gov.go.sefaz.agualegal.repository.EnvasadoraRepository;
import br.gov.go.sefaz.agualegal.repository.GraficaRepository;
import br.gov.go.sefaz.agualegal.repository.MotivoIndeferimentoAnaliseRepository;
import br.gov.go.sefaz.agualegal.repository.MotivoIndeferimentoRepository;
import br.gov.go.sefaz.agualegal.repository.PedidoCredenciamentoRepository;
import br.gov.go.sefaz.agualegal.repository.SituacaoCadSefazRepository;
import br.gov.go.sefaz.agualegal.repository.StatusAnaliseRepository;
import br.gov.go.sefaz.agualegal.repository.StatusCredenciamentoRepository;
import br.gov.go.sefaz.agualegal.repository.TipoAguaRepository;
import br.gov.go.sefaz.agualegal.repository.TipoAnaliseRepository;
import br.gov.go.sefaz.agualegal.repository.TipoPedidoRepository;
import br.gov.go.sefaz.agualegal.utils.ByteArrayToBase64TypeAdapter;
import br.gov.go.sefaz.agualegal.utils.UtilsAguaLegal;

@Service
public class CredenciamentoEnvasadoraService {

	private EnvasadoraRepository envasadoraRepository;
	private TipoAguaRepository tipoAguaRepository;
	private StatusCredenciamentoRepository statusCredenciamentoRepository;
	private CredenciamentoRepository credenciamentoRepository;
	private GraficaRepository graficaRepository;
	private StatusAnaliseRepository statusAnaliseRepository;
	private TipoPedidoRepository tipoPedidoRepository;
	private PedidoCredenciamentoRepository pedidoCredenciamentoRepository;
	private DadosPedidoRepository dadosPedidoRepository;
	private ValidacaoSolicitacaoCredenciamento validacaoSolicitacaoCredenciamento;
	private PreAnaliseService preAnaliseService;
	private AnalisePedidoRepository analisePedidoRepository;
	private TipoAnaliseRepository tipoAnaliseRepository;
	private MotivoIndeferimentoAnaliseRepository motivoIndeferimentoAnaliseRepository;
	private MotivoIndeferimentoRepository motivoIndeferimentoRepository;
	private CampoFormularioRepository campoFormularioRepository;
	private SituacaoCadSefazRepository situacaoCadSefazRepository;

	public CredenciamentoEnvasadoraService(EnvasadoraRepository envasadoraRepository,
			TipoAguaRepository tipoAguaRepository, StatusCredenciamentoRepository statusCredenciamentoRepository,
			CredenciamentoRepository credenciamentoRepository, GraficaRepository graficaRepository,
			StatusAnaliseRepository statusAnaliseRepository, TipoPedidoRepository tipoPedidoRepository,
			PedidoCredenciamentoRepository pedidoCredenciamentoRepository, DadosPedidoRepository dadosPedidoRepository,
			ValidacaoSolicitacaoCredenciamento validacaoSolicitacaoCredenciamento, PreAnaliseService preAnaliseService,
			AnalisePedidoRepository analisePedidoRepository, TipoAnaliseRepository tipoAnaliseRepository,
			MotivoIndeferimentoRepository motivoIndeferimentoRepository, 
			MotivoIndeferimentoAnaliseRepository motivoIndeferimentoAnaliseRepository,
			CampoFormularioRepository campoFormularioRepository,
			SituacaoCadSefazRepository situacaoCadSefazRepository
			) {
		super();
		this.envasadoraRepository = envasadoraRepository;
		this.tipoAguaRepository = tipoAguaRepository;
		this.statusCredenciamentoRepository = statusCredenciamentoRepository;
		this.credenciamentoRepository = credenciamentoRepository;
		this.graficaRepository = graficaRepository;
		this.statusAnaliseRepository = statusAnaliseRepository;
		this.tipoPedidoRepository = tipoPedidoRepository;
		this.pedidoCredenciamentoRepository = pedidoCredenciamentoRepository;
		this.dadosPedidoRepository = dadosPedidoRepository;
		this.validacaoSolicitacaoCredenciamento = validacaoSolicitacaoCredenciamento;
		this.preAnaliseService = preAnaliseService;
		this.tipoAnaliseRepository = tipoAnaliseRepository;
		this.motivoIndeferimentoRepository = motivoIndeferimentoRepository;
		this.analisePedidoRepository = analisePedidoRepository;
		this.motivoIndeferimentoAnaliseRepository = motivoIndeferimentoAnaliseRepository;
		this.campoFormularioRepository = campoFormularioRepository;
		this.situacaoCadSefazRepository = situacaoCadSefazRepository;
	}

	@Transactional
	public ResponseEntity<RespostaPreAnalise> solicitaCredenciamentoEnvasadora(DadosSolicitacaoDTO dto) {
		/* Pré análise */
		PreAnaliseResultado preAnalise = this.preAnaliseService.preAnaliseEnvasadora(dto);

		/* Validação dos dados recebidos na solicitação de credenciamento */
		this.validacaoSolicitacaoCredenciamento.validacaoDadosSolicitacaoCredenciamento(dto);

		/* Valida se o tipoAgua enviado é válido()1,2,ou3 */
		TipoAgua tipoAgua = tipoAguaRepository.findById(Integer.parseInt(dto.getTipoAgua())).orElseThrow(
				() -> new SolicitacaoCredenciamentoException("Tipo de água não encontrado: " + dto.getTipoAgua(), 1));

		/* Verificação de solicitação de credenciamento vigente */
		Integer qtdSolicitacaoVigente = this.credenciamentoRepository
				.verificaSolicitacaoCredenciamentoVigente(dto.getCadastro().getCnpj());

		if (qtdSolicitacaoVigente > 0) {
			return new ResponseEntity<RespostaPreAnalise>(
					new RespostaPreAnalise("Não Efetuada",
							"Já existe uma solicitação de credenciamento para o cnpj " + dto.getCadastro().getCnpj()),
					HttpStatus.BAD_REQUEST);
		}

		/* Verificação de credenciamento ativo */
		Integer qtdCredenciamentoAtivo = this.credenciamentoRepository
				.verificaCredeciamentoAtivo(dto.getCadastro().getCnpj());

		if (qtdCredenciamentoAtivo > 0) {
			return new ResponseEntity<RespostaPreAnalise>(
					new RespostaPreAnalise("Não Efetuada",
							"Já existe um credenciamento ativo para o cnpj " + dto.getCadastro().getCnpj()),
					HttpStatus.BAD_REQUEST);
		}

		Envasadora envasadora = this.persistenciaEnvasadora(dto, tipoAgua);
		Credenciamento credenciamento = persistenciaCredenciamento(dto, envasadora, preAnalise);
		PedidoCredenciamento pedido = persistenciaPedidoCredenciamento(dto, credenciamento, preAnalise);
		AnalisePedido analise = persistenciaPedidoPreAnalise(pedido, preAnalise);	
		MotivoIndeferimentoAnalise motivo = persistenciaMotivoIndeferimentoAnalise(analise, preAnalise);
		
		persistenciaDadosPedido(dto, pedido, envasadora, preAnalise);

		if (!preAnalise.isDeferido()) {
			return new ResponseEntity<RespostaPreAnalise>(
					new RespostaPreAnalise(analise.getStatusAnalise().getDescricaoStatus(),
							motivo.getMotivo().getDescricaoMotivo()),
					HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<RespostaPreAnalise>(
				new RespostaPreAnalise(analise.getStatusAnalise().getDescricaoStatus(),
						pedido.getIdPedidoCredenciamento()),
				HttpStatus.OK);
	}

	private MotivoIndeferimentoAnalise persistenciaMotivoIndeferimentoAnalise(AnalisePedido analise,
			PreAnaliseResultado preAnalise) {
		Optional<MotivoIndeferimento> motivoIndeferimento = null;
		MotivoIndeferimentoAnalise motivoIndeferimentoAnalise = new MotivoIndeferimentoAnalise();
		if(!preAnalise.isDeferido()){
			
			motivoIndeferimento = this.motivoIndeferimentoRepository.findById(preAnalise.getIdMotivoIndeferimento());
				if (motivoIndeferimento.isEmpty()) {
					throw new SolicitacaoCredenciamentoException(
							"A tabela de motivos de indeferimento não está configurada corretamente");
				}				
				motivoIndeferimentoAnalise.setMotivo(motivoIndeferimento.get());
				motivoIndeferimentoAnalise.setAnaliseSolicitacao(analise);
				return this.motivoIndeferimentoAnaliseRepository.save(motivoIndeferimentoAnalise);			
		}		
		return null;
	}

	private AnalisePedido persistenciaPedidoPreAnalise(PedidoCredenciamento pedido,
			PreAnaliseResultado preAnaliseResultado) {

		AnalisePedido analisePedido = new AnalisePedido();
		analisePedido.setPedidoCredenciamento(pedido);
		analisePedido.setDataAnalise(new Date());

		Optional<TipoAnalise> tipoPreAnalise = this.tipoAnaliseRepository.findById(4);
		if (tipoPreAnalise.isEmpty()) {
			throw new SolicitacaoCredenciamentoException(
					"A tabela de parametrização dos tipos de análise não está configurada corretamente");
		}

		Optional<StatusAnalise> statusAnalise = this.statusAnaliseRepository
				.findById(preAnaliseResultado.isDeferido() ? 2 : 3);
		if (statusAnalise.isEmpty()) {
			throw new SolicitacaoCredenciamentoException(
					"A tabela de status analise não está configurada corretamente");
		}
		
		analisePedido.setStatusAnalise(statusAnalise.get());
		analisePedido.setTipoAnalise(tipoPreAnalise.get());
		return this.analisePedidoRepository.save(analisePedido);

	}

	private DadosPedido persistenciaDadosPedido(DadosSolicitacaoDTO dto, PedidoCredenciamento pedido,
			Envasadora envasadora, PreAnaliseResultado preAnaliseResultado) {
		DadosPedido dadosPedido = new DadosPedido();
		DadosReponsavelPersistencia dadosReponsavelPersistencia;
		dadosPedido.setPedidoCredenciamento(pedido);

		if (dto.getResponsavel() != null) {
			dadosReponsavelPersistencia = new DadosReponsavelPersistencia(dto.getResponsavel(),
					envasadora.getIdEnvasadora().toString());
			dadosPedido.setJsonResponsavel(UtilsAguaLegal.toJson(dadosReponsavelPersistencia));
		}

		dadosPedido.setJsonEnvasadora(UtilsAguaLegal.toJson(new EnvasadoraPersistencia(dto.getCadastro(),
				dto.getEnderecoDTO(), dto.getTipoAgua(), envasadora.getIdEnvasadora().toString())));

		Gson gson = new GsonBuilder().registerTypeAdapter(byte[].class, new ByteArrayToBase64TypeAdapter()).create();

		dadosPedido.setJsonProdutos(gson.toJson(dto.getListaProdutos()));

		dadosPedido.setJsonLicencas(gson.toJson(dto.getListaLicencas()));
		
		List<CampoFormulario> listaCamposAtivos = 
				this.campoFormularioRepository.findCamposAtivosFormulario().get();
		List<CampoPersistDTO> listaCamposPersist = 
				listaCamposAtivos.stream().map(item -> new CampoPersistDTO(item)).collect(Collectors.toList());
		dadosPedido.setJsonCampos(   
				UtilsAguaLegal.toJson(listaCamposPersist)
				);		
		/*Se possuir a situação fiscal vinda da sefaz, persistir*/
		if(preAnaliseResultado.getSituacaoFiscalSefaz()!= null) {
			Optional<SituacaoCadSefaz> situacaoSefaz = 
					this.situacaoCadSefazRepository.findById(preAnaliseResultado.getSituacaoFiscalSefaz());
			if(situacaoSefaz.isPresent()) {
				dadosPedido.setSituacaoCadSefaz(situacaoSefaz.get());
			}
		}
		return this.dadosPedidoRepository.save(dadosPedido);

	}

	private PedidoCredenciamento persistenciaPedidoCredenciamento(DadosSolicitacaoDTO dto,
			Credenciamento credenciamento, PreAnaliseResultado preAnalise) {

		Optional<Grafica> grafica = this.graficaRepository.findByCnpj(dto.getCnpjGrafica());

		PedidoCredenciamento pedidoCredenciamento = new PedidoCredenciamento();

		pedidoCredenciamento.setCredenciamento(credenciamento);
		Date dataAtual = new Date();
		pedidoCredenciamento.setDataPedido(dataAtual);
		pedidoCredenciamento.setNumeroPedido(UtilsAguaLegal.generateSixDigitNumber());

		pedidoCredenciamento.setObservacao(UtilsAguaLegal.isEmpty(dto.getObservacao()) ? "" : dto.getObservacao());
		if (grafica.isPresent()) {
			pedidoCredenciamento.setGrafica(grafica.get());
		}

		/*
		 * Se a pré análise foi indeferida, será salvo registro do pedido, já nascido
		 * indeferido
		 */
		if (preAnalise.isDeferido()) {
			pedidoCredenciamento.setStatusPedido(this.statusAnaliseRepository.findById(1).get());
		} else {
			pedidoCredenciamento.setStatusPedido(this.statusAnaliseRepository.findById(3).get());
			pedidoCredenciamento.setDataAnalise(dataAtual);
		}

		pedidoCredenciamento.setTipoPedido(this.tipoPedidoRepository.findById(1).get());

		return this.pedidoCredenciamentoRepository.save(pedidoCredenciamento);

	}

	private Credenciamento persistenciaCredenciamento(DadosSolicitacaoDTO dto, Envasadora envasadora,
			PreAnaliseResultado preAnalise) {

		/*
		 * Registro de credenciamento nasce inativo. Ficará ativo se for deferido pelos
		 * fiscais. Se ja existe registro na tab_credenciamento para aquele cnpj, ele é
		 * devolvido.
		 */

		Credenciamento credAtivo = this.credenciamentoRepository
				.buscaRegistroCredenciamentoAtivo(dto.getCadastro().getCnpj());
		if (credAtivo != null) {
			return credAtivo;
		}
		Optional<StatusCredenciamento> statusInativo = this.statusCredenciamentoRepository.findById(2);

		Credenciamento credenciamento = new Credenciamento();
		credenciamento.setEnvasadora(envasadora);
		credenciamento.setStatusCredenciamento(statusInativo.get());

		return this.credenciamentoRepository.save(credenciamento);

	}

	private Envasadora persistenciaEnvasadora(DadosSolicitacaoDTO dto, TipoAgua tipoAgua) {
		/* Será verificado se a envasadora já existe na base */
		Optional<Envasadora> envasadora = envasadoraRepository.findByCnpj(dto.getCadastro().getCnpj());
		if (envasadora.isPresent()) {
			return envasadora.get();
		}
		/* Caso não, será criado registro na tabela TAB_ENVASADORA */
		Envasadora envasadoraPersist = new Envasadora(dto.getCadastro(), tipoAgua);
		return this.envasadoraRepository.save(envasadoraPersist);
	}

}
