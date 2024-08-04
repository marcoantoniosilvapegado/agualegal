package br.gov.go.sefaz.agualegal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.go.sefaz.agualegal.modelo.Envasadora;

@Repository
public interface EnvasadoraRepository extends JpaRepository<Envasadora, Integer> {
	
	 Optional<Envasadora> findByCnpj(String cnpj);
}