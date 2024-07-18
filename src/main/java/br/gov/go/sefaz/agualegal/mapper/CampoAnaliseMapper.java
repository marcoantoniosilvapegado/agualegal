package br.gov.go.sefaz.agualegal.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.gov.go.sefaz.agualegal.dto.CampoResponseDTO;

public class CampoAnaliseMapper implements RowMapper<CampoResponseDTO>{

	@Override
	public CampoResponseDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		CampoResponseDTO dto = new CampoResponseDTO();
		
		dto.setNomeCampo(rs.getString("NOME_CAMPO"));
		dto.setDescricaoCampo(rs.getString("DESCRICAO_CAMPO"));
		dto.setTipoAnalise(rs.getString("NOME_TIPO_ANALISE"));
		dto.setTipoFormato(rs.getString("MIDIA_RESPOSTA"));
		dto.setDadoObrigatorio(rs.getInt("DADO_OBRIGATORIO")==1);
		
		return dto;
	}
	

}
