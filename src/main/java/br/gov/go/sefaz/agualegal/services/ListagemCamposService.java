package br.gov.go.sefaz.agualegal.services;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import br.gov.go.sefaz.agualegal.domain.dto.CampoDTO;
import br.gov.go.sefaz.agualegal.domain.dto.ListaDTO;
import br.gov.go.sefaz.agualegal.domain.dto.SolicitacaoGraficaDTO;
import br.gov.go.sefaz.agualegal.exception.TokenGraficaInvalidoException;
import br.gov.go.sefaz.agualegal.mapper.CamposDTORowMapper;

@Service
public class ListagemCamposService {

	private JdbcTemplate jdbcTemplate;
	private ValidaTokenGraficaService validaTokenGraficaService;

	public ListagemCamposService(JdbcTemplate jdbcTemplate, ValidaTokenGraficaService validaTokenGraficaService) {
		this.jdbcTemplate = jdbcTemplate;
		this.validaTokenGraficaService = validaTokenGraficaService;
	}

	public ListaDTO retornaListagemCampos(SolicitacaoGraficaDTO dto) {

		Boolean tokenValido = validaTokenGraficaService.validaTokenGrafica(dto.getCnpjGrafica(), dto.getToken());
		if (!tokenValido) {
			throw new TokenGraficaInvalidoException("Token ou CNPJ da gráfica inválidos!");
		}

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append("C.NOME_CRITERIO AS CAMPO, ");
		sql.append("AN.TIPO_ANALISE AS ANALISE, ");
		sql.append("DECODE(C.CAMPO_OBRIGATORIO, 'S', 'SIM', 'NÃO') AS OBRIGATORIO ");
		sql.append("FROM TAB_TIPO_ANALISE AN, ");
		sql.append(
				"(SELECT *FROM TAB_CAMPOS_FORMULARIO T WHERE T.CODIGO_CRITERIO IN ('RAZAOSOCIALENVASADORA', 'CNPJENVASADORA') ");
		sql.append(" UNION ");
		sql.append("SELECT *FROM TAB_CAMPOS_FORMULARIO T WHERE ");
		sql.append("(T.CODIGO_CRITERIO NOT IN ('RAZAOSOCIALENVASADORA', 'CNPJENVASADORA') AND T.STATUS=1) ");
		sql.append(" )C ");
		sql.append(" WHERE  AN.ID_TIPO_ANALISE = C.ID_TIPO_ANALISE ");
		sql.append("AND AN.ID_STATUS=1");

		List<CampoDTO> lista = jdbcTemplate.query(sql.toString(), new CamposDTORowMapper());
		return new ListaDTO(lista);
	};

}
