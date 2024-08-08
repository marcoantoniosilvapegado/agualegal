package br.gov.go.sefaz.agualegal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.gov.go.sefaz.agualegal.modelo.IeExcecao;

@Repository
public interface IeExcecaoRepository extends JpaRepository<IeExcecao, Integer>{
	
	@Query(value = "select e from IeExcecao e where e.dataFim is null and e.inscricaoEstadual = :ie")
	public Optional<IeExcecao> findIEExcecaoAtivo(String ie);

}
