package br.gov.go.sefaz.agualegal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.go.sefaz.agualegal.modelo.Grafica;

@Repository
public interface GraficaRepository extends JpaRepository<Grafica, Integer> {
	
	Optional<Grafica> findByCnpj(String cnpj);
}