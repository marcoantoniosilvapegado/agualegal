package br.gov.go.sefaz.agualegal.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.gov.go.sefaz.agualegal.dto.CampoResponseDTO;

public class CampoAnaliseMapper implements RowMapper<CampoResponseDTO>{

	@Override
	public CampoResponseDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		CampoResponseDTO dto = new CampoResponseDTO();
		
		dto.setNomeCampo(rs.getString("NOMECAMPO"));
		dto.setDescricaoCampo(rs.getString("DESCRICAOCAMPO"));
		dto.setTipoAnalise(rs.getString("NOMETIPOANALISE"));
		dto.setTipoFormato(rs.getString("MIDIARESPOSTA"));
		dto.setDadoObrigatorio(rs.getInt("DADOOBRIGATORIO")==1);
		
		return dto;
	}
	

}
