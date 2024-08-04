package br.gov.go.sefaz.agualegal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.go.sefaz.agualegal.modelo.TipoAnalise;

@Repository
public interface TipoAnaliseRepository extends JpaRepository<TipoAnalise, Integer> {
	
}
