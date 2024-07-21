package br.gov.go.sefaz.agualegal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.go.sefaz.agualegal.modelo.CampoFormulario;

public interface CampoFormularioRepository extends JpaRepository<CampoFormulario, Long>{
	
	@Query(value = "SELECT  c FROM CampoFormulario c where c.disponibilizarCampo = 'S' "
			+ "AND ( :tipoAgua <> '1'  or (:tipoAgua = '1' and c.tipoAnalise.id <>3))")
	Optional<List<CampoFormulario>> findCamposFormulario(String tipoAgua);
}
