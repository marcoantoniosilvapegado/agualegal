package br.gov.go.sefaz.agualegal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.go.sefaz.agualegal.modelo.StatusCredenciamento;

@Repository
public interface StatusCredenciamentoRepository extends JpaRepository<StatusCredenciamento, Integer> {
}