package br.gov.go.sefaz.agualegal.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.gov.go.sefaz.agualegal.domain.dto.CampoDTO;

public class CamposDTORowMapper implements RowMapper<CampoDTO>{

	@Override
	public CampoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		 return new CampoDTO(
	                rs.getString("campo"),
	                rs.getString("analise"),
	                rs.getString("obrigatorio")
	        );
	}

}
