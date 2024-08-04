package br.gov.go.sefaz.agualegal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.gov.go.sefaz.agualegal.modelo.Credenciamento;

@Repository
public interface CredenciamentoRepository extends JpaRepository<Credenciamento, Integer> {
	
	@Query(value = "select \r\n"
			+ "count(0)\r\n"
			+ "from apl_agualegal.tab_envasadora te, apl_agualegal.tab_credenciamento tc,\r\n"
			+ "apl_agualegal.tab_pedido_credenciamento pc\r\n"
			+ "where te.cnpj= :cnpjEnvasadora\r\n"
			+ "and te.id_envasadora = tc.id_envasadora\r\n"
			+ "and tc.id_credenciamento = pc.id_credenciamento\r\n"
			+ "and pc.id_tipo_pedido=1\r\n"
			+ "and pc.id_status_pedido = 1", nativeQuery = true)
	public Integer verificaSolicitacaoCredenciamentoVigente(String cnpjEnvasadora);
	
	@Query(value = "select \r\n"
			+ "count(0)\r\n"
			+ "from apl_agualegal.tab_envasadora te, \r\n"
			+ "apl_agualegal.tab_credenciamento tc\r\n"
			+ "where te.cnpj= :cnpjEnvasadora\r\n"
			+ "and te.id_envasadora = tc.id_envasadora\r\n"
			+ "and tc.id_status_credenciamento=1\r\n"
			+ "and (tc.data_fim is null or trunc(tc.data_fim)>trunc(sysdate))", nativeQuery = true)
	public Integer verificaCredeciamentoAtivo(String cnpjEnvasadora);
}