package br.gov.go.sefaz.agualegal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


//@Repository
public interface CredenciamentoRepository
//extends JpaRepository<Credenciamento, Long>

{
	/*@Query(value = "select count(0) from tab_credenciamento tc, tab_pedido_credenciamento tpc\r\n"
			+ "where tc.cnpj= :cnpj and tc.id_credenciamento = tpc.id_credenciamento and tpc.tipo_pedido=1\r\n"
			+ "and tpc.id_status_pedido=1", nativeQuery = true)
	public Integer verificaSolicitacaoVigente(String cnpj);
	*/
}	
