package br.gov.go.sefaz.agualegal.domain;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;

public class RespostaPreAnalise implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String statusPedido;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer codigoPedido;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String motivoIndeferimento;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private boolean preAnaliseDeferida;

	public RespostaPreAnalise(String motivoIndeferimento) {
		super();
		this.motivoIndeferimento = motivoIndeferimento;
	}

	public RespostaPreAnalise() {
		// TODO Auto-generated constructor stub
	}

	public RespostaPreAnalise(String statusPedido, Integer codigoPedido) {
		super();
		this.statusPedido = statusPedido;
		this.codigoPedido = codigoPedido;
		this.preAnaliseDeferida = true;
	}

	public RespostaPreAnalise(String status, String motivo) {
		super();
		this.statusPedido = status;
		this.motivoIndeferimento = motivo;
		this.preAnaliseDeferida = false;
	}

	public String getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(String statusPedido) {
		this.statusPedido = statusPedido;
	}

	public Integer getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(Integer codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public String getMotivoIndeferimento() {
		return motivoIndeferimento;
	}

	public void setMotivoIndeferimento(String motivoIndeferimento) {
		this.motivoIndeferimento = motivoIndeferimento;
	}

	public boolean isPreAnaliseDeferida() {
		return preAnaliseDeferida;
	}

	public void setPreAnaliseDeferida(boolean preAnaliseDeferida) {
		this.preAnaliseDeferida = preAnaliseDeferida;
	}

	@Override
	public String toString() {
		return "RespostaPreAnalise [statusPedido=" + statusPedido + ", codigoPedido=" + codigoPedido
				+ ", motivoIndeferimento=" + motivoIndeferimento + ", preAnaliseDeferida=" + preAnaliseDeferida + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoPedido, motivoIndeferimento, preAnaliseDeferida, statusPedido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RespostaPreAnalise other = (RespostaPreAnalise) obj;
		return Objects.equals(codigoPedido, other.codigoPedido)
				&& Objects.equals(motivoIndeferimento, other.motivoIndeferimento)
				&& preAnaliseDeferida == other.preAnaliseDeferida && Objects.equals(statusPedido, other.statusPedido);
	}

}
