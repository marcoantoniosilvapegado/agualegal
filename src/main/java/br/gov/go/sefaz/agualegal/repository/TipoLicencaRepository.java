package br.gov.go.sefaz.agualegal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.go.sefaz.agualegal.modelo.TipoLicenca;

@Repository
public interface TipoLicencaRepository extends JpaRepository<TipoLicenca, Integer> {
}