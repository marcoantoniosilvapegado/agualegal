package br.gov.go.sefaz.agualegal.repository;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.gov.go.sefaz.agualegal.dto.CampoResponseDTO;
import br.gov.go.sefaz.agualegal.dto.ListaCamposResponseDTO;
import br.gov.go.sefaz.agualegal.mapper.CampoAnaliseMapper;

@Repository
public class ComunicacaoGraficasRepository {

	private JdbcTemplate jdbcTemplate;

	public ComunicacaoGraficasRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@SuppressWarnings("deprecation")
	public Boolean verificaEnvasadoraListaExcecao(String inscricao) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT COUNT(*) FROM IE_EXCECAO IEX where IEX.IE = ?");

		Integer count = jdbcTemplate.queryForObject(sql.toString(), new Object[] { inscricao }, Integer.class);
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
		
		StringBuilder sql = new StringBuilder();
		
		sql.append(" SELECT ");
		sql.append(" C.NOMECAMPO ,  ");
		sql.append(" C.DESCRICAOCAMPO , ");
		sql.append(" C.MIDIARESPOSTA ,  ");
		sql.append(" T.NOMETIPOANALISE  ");
		sql.append(" ,C.DADOOBRIGATORIO  ");
		sql.append(" FROM CAMPOS C, TIPOANALISE T ");
		sql.append(" WHERE C.DATAFIM  IS NULL  ");
		sql.append(" AND C.IDTIPOANALISE  = T.ID  ");
		
		if(tipoAgua.equals("1")) {
			sql.append(" AND C.IDTIPOANALISE <> 3");
		}		

		 return jdbcTemplate.query(sql.toString(), new CampoAnaliseMapper());
	}

}
