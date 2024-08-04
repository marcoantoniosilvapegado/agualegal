package br.gov.go.sefaz.agualegal.repositorynew;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.go.sefaz.agualegal.modelonew.Grafica;

@Repository
public interface GraficaRepository extends JpaRepository<Grafica, Integer> {
	
	Optional<Grafica> findByCnpj(String cnpj);
}