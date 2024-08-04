package br.gov.go.sefaz.agualegal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.gov.go.sefaz.agualegal.modelo.CampoFormulario;

@Repository
public interface CampoFormularioRepository extends JpaRepository<CampoFormulario, Long>{
	
	@Query(value = "select  c from CampoFormulario c where c.status = 'A'")
	Optional<List<CampoFormulario>> findCamposAtivosFormulario();
	
	
}
