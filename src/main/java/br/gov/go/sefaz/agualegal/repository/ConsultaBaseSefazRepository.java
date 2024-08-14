package br.gov.go.sefaz.agualegal.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ConsultaBaseSefazRepository {

	private JdbcTemplate jdbcTemplate;

	public ConsultaBaseSefazRepository(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	private final String pathDBLINK = "@DESENV.SEFAZ.MA.GOV.BR";// versionar por ambiente posteriormente

	public Boolean verificaEnvasadoraExiste(String ie) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT COUNT(0) FROM TAXMAOC.RUC_GENERAL");
		sql.append(pathDBLINK);
		sql.append(" RG ");
		sql.append("WHERE RG.RGE_RUC = ").append(ie);
		Integer queryForObject = jdbcTemplate.queryForObject(sql.toString(), Integer.class);
		return queryForObject > 0;
	}

	public Boolean verificaSituacaoFiscalAtiva(String ie) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT COUNT(0) FROM TAXMAOC.RUC_GENERAL");
		sql.append(pathDBLINK);
		sql.append(" RG ");
		sql.append("WHERE RG.RGE_RUC = ").append(ie);
		sql.append(" AND RG.RGE_TSC_SIT_CADASTRAL = 1");
		Integer queryForObject = jdbcTemplate.queryForObject(sql.toString(), Integer.class);
		return queryForObject > 0;
	};

	public Boolean verificaPossuiCnaeEnvase(String ie, String cnae) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT COUNT(0) FROM TAXMAOC.RUC_CNAE_FISCAL");
		sql.append(pathDBLINK);
		sql.append(" CNAE ");
		sql.append("WHERE CNAE.RCF_TCF_CODIGO_CNAE = ").append(cnae);
		sql.append(" AND CNAE.RCF_RGE_RUC = ").append(ie);
		Integer queryForObject = jdbcTemplate.queryForObject(sql.toString(), Integer.class);
		return queryForObject > 0;
	}
}
