package br.gov.go.sefaz.agualegal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.go.sefaz.agualegal.modelo.IeExcecao;

public interface IeExcecaoRepository {
//extends JpaRepository<IeExcecao, Long>{

	/*@Query(value = "select count(*) from IeExcecao e where e.ie = :ie and e.dataFim is null")
	public Integer findExceptionByIE(Long ie);
	*/
}
