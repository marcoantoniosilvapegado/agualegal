package br.gov.go.sefaz.agualegal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.go.sefaz.agualegal.modelo.Cadastro;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Integer> {

	public Optional<Cadastro> findByCnpj(String cnpj);

	public Optional<Cadastro> findByCnpjAndSituacaoFiscal(String cnpj, Integer situacaoFiscal);

}
