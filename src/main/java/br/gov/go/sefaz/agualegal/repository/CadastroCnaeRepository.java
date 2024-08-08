package br.gov.go.sefaz.agualegal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.gov.go.sefaz.agualegal.modelo.CadastroCnae;

@Repository
public interface CadastroCnaeRepository extends JpaRepository<CadastroCnae, Integer>{
	
	@Query(value = "select c from CadastroCnae c where c.status = 1 and c.cnae = :cnae and c.cadastro.cnpj = :cnpj")
	public CadastroCnae findByCnae(String cnpj, Long cnae);
}
