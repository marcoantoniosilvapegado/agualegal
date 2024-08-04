package br.gov.go.sefaz.agualegal.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.gov.go.sefaz.agualegal.dto.CampoResponseDTO;
import br.gov.go.sefaz.agualegal.dto.ListaCamposResponseDTO;
import br.gov.go.sefaz.agualegal.mapper.CampoAnaliseMapper;
import br.gov.go.sefaz.agualegal.modelo.CampoFormulario;

//@Repository
public class ComunicacaoGraficasRepository {

/*	private JdbcTemplate jdbcTemplate;

	@Autowired
	IeExcecaoRepository ieExcecaoRepository;
	
	@Autowired
	CampoFormularioRepository campoFormularioRepository;

	public ComunicacaoGraficasRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Boolean verificaEnvasadoraListaExcecao(String inscricao) {
		this.ieExcecaoRepository.findExceptionByIE(Long.parseLong(inscricao));

		Integer count = this.ieExcecaoRepository.findExceptionByIE(Long.parseLong(inscricao));//jdbcTemplate.queryForObject(sql.toString(), new Object[] { inscricao }, Integer.class);
		return count != null && count > 0;		
	}
	
	@SuppressWarnings("deprecation")
	public Boolean verificaEnvasadoraExisteCadastro(String IE) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT COUNT(*) FROM CADASTRO C ");
		sql.append("WHERE C.INSCRICAOESTADUAL  = ? ");

		Integer count = jdbcTemplate.queryForObject(sql.toString(), new Object[] { IE }, Integer.class);
		return count != null && count > 0;

	}

	@SuppressWarnings("deprecation")
	public Boolean verificaEnvasadoraSituacaoAtiva(String IE) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT COUNT(0) FROM ");
		sql.append("CADASTRO C, ");
		sql.append("SITUACAOCADASTRAL S ");
		sql.append("WHERE C.INSCRICAOESTADUAL  = :INSCRICAOESTADUAL ");
		sql.append("AND C.IDCADASTRO = S.IDCADASTRO  ");
		sql.append("AND S.SITUACAO = 1 ");
		sql.append("AND S.DATAFINAL  IS NULL ");

		Integer count = jdbcTemplate.queryForObject(sql.toString(), new Object[] { IE }, Integer.class);
		return count != null && count > 0;

	}

	public Boolean verificaEnvasadoraPossuiCnae(String IE) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT COUNT(*) FROM CADASTRO C, ");
		sql.append("CADASTRO_CNAE CC, ");
		sql.append("ATIVIDADE A ");
		sql.append("WHERE C.INSCRICAOESTADUAL = :IE ");
		sql.append("AND C.IDCADASTRO = CC.IDCADASTRO ");
		sql.append("AND CC.DATAFIM  IS NULL ");
		sql.append("AND CC.IDATIVIDADE  = A.IDATIVIDADE ");
		sql.append("AND A.CNAE  = 1121600 ");

		Integer count = jdbcTemplate.queryForObject(sql.toString(), new Object[] { IE }, Integer.class);
		return count != null && count > 0;
	}

	public List<CampoResponseDTO> listaCamposEnvasadora(String tipoAgua) {
		
		List<CampoFormulario> listaCampos 
				= this.campoFormularioRepository.findCamposFormulario(tipoAgua)
				.get();
		
		return listaCampos.stream().map(item -> new CampoResponseDTO(item))
		.collect(Collectors.toList());

	}*/

}
