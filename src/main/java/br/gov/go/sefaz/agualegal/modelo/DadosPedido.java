package br.gov.go.sefaz.agualegal.modelo;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(schema = "APL_AGUALEGAL", name = "TAB_DADOS_PEDIDO")
public class DadosPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_dados_pedido")
	@SequenceGenerator(name = "seq_dados_pedido", sequenceName = "APL_AGUALEGAL.seq_tab_dados_pedido", allocationSize = 1)
	@Column(name = "id_dados_pedido")
	private Integer idDadosPedido;

	@ManyToOne
	@JoinColumn(name = "id_pedido_credenciamento", nullable = false)
	private PedidoCredenciamento pedidoCredenciamento;

	@Lob
	@Column(name = "json_envasadora")
	private String jsonEnvasadora;

	@Lob
	@Column(name = "json_responsavel")
	private String jsonResponsavel;

	@Lob
	@Column(name = "json_licencas")
	private String jsonLicencas;

	@Lob
	@Column(name = "json_produtos")
	private String jsonProdutos;

	@Lob
	@Column(name = "json_campos_ativos")
	private String jsonCampos;

	@ManyToOne
	@JoinColumn(name = "ID_SITUACAOCAD_SEFAZ", nullable = true)
	private SituacaoCadSefaz situacaoCadSefaz;

	public DadosPedido() {

	}

	public Integer getIdDadosPedido() {
		return idDadosPedido;
	}

	public void setIdDadosPedido(Integer idDadosPedido) {
		this.idDadosPedido = idDadosPedido;
	}

	public PedidoCredenciamento getPedidoCredenciamento() {
		return pedidoCredenciamento;
	}

	public void setPedidoCredenciamento(PedidoCredenciamento pedidoCredenciamento) {
		this.pedidoCredenciamento = pedidoCredenciamento;
	}

	public String getJsonEnvasadora() {
		return jsonEnvasadora;
	}

	public void setJsonEnvasadora(String jsonEnvasadora) {
		this.jsonEnvasadora = jsonEnvasadora;
	}

	public String getJsonResponsavel() {
		return jsonResponsavel;
	}

	public void setJsonResponsavel(String jsonResponsavel) {
		this.jsonResponsavel = jsonResponsavel;
	}

	public String getJsonLicencas() {
		return jsonLicencas;
	}

	public void setJsonLicencas(String jsonLicencas) {
		this.jsonLicencas = jsonLicencas;
	}

	public String getJsonProdutos() {
		return jsonProdutos;
	}

	public void setJsonProdutos(String jsonProdutos) {
		this.jsonProdutos = jsonProdutos;
	}

	public String getJsonCampos() {
		return jsonCampos;
	}

	public void setJsonCampos(String jsonCampos) {
		this.jsonCampos = jsonCampos;
	}

	public SituacaoCadSefaz getSituacaoCadSefaz() {
		return situacaoCadSefaz;
	}

	public void setSituacaoCadSefaz(SituacaoCadSefaz situacaoCadSefaz) {
		this.situacaoCadSefaz = situacaoCadSefaz;
	}

	@Override
	public String toString() {
		return "DadosPedido [idDadosPedido=" + idDadosPedido + ", pedidoCredenciamento=" + pedidoCredenciamento
				+ ", jsonEnvasadora=" + jsonEnvasadora + ", jsonResponsavel=" + jsonResponsavel + ", jsonLicencas="
				+ jsonLicencas + ", jsonProdutos=" + jsonProdutos + ", jsonCampos=" + jsonCampos + ", situacaoCadSefaz="
				+ situacaoCadSefaz + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idDadosPedido, jsonCampos, jsonEnvasadora, jsonLicencas, jsonProdutos, jsonResponsavel,
				pedidoCredenciamento, situacaoCadSefaz);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DadosPedido other = (DadosPedido) obj;
		return Objects.equals(idDadosPedido, other.idDadosPedido) && Objects.equals(jsonCampos, other.jsonCampos)
				&& Objects.equals(jsonEnvasadora, other.jsonEnvasadora)
				&& Objects.equals(jsonLicencas, other.jsonLicencas) && Objects.equals(jsonProdutos, other.jsonProdutos)
				&& Objects.equals(jsonResponsavel, other.jsonResponsavel)
				&& Objects.equals(pedidoCredenciamento, other.pedidoCredenciamento)
				&& Objects.equals(situacaoCadSefaz, other.situacaoCadSefaz);
	}

}
