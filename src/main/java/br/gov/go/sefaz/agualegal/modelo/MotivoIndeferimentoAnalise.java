package br.gov.go.sefaz.agualegal.modelo;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(schema = "APL_AGUALEGAL", name = "TAB_MOTIVO_INDEFERIMENTO_ANALISE")
public class MotivoIndeferimentoAnalise {

	@Id
	@Column(name = "ID_MOTIVO_INDEFERIMENTO_ANALISE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MOTIVO_INDEFERIMENTO_ANALISE")
	@SequenceGenerator(name = "SEQ_MOTIVO_INDEFERIMENTO_ANALISE", sequenceName = "APL_AGUALEGAL.SEQ_TAB_MOTIVO_INDEFERIMENTO_ANALISE", allocationSize = 1)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "ID_ANALISE_PEDIDO")
	private AnalisePedido analiseSolicitacao;

	@ManyToOne
	@JoinColumn(name = "ID_MOTIVO_INDEFERIMENTO")
	private MotivoIndeferimento motivo;

	public MotivoIndeferimentoAnalise(Long id, AnalisePedido analiseSolicitacao, MotivoIndeferimento motivo) {
		super();
		this.id = id;
		this.analiseSolicitacao = analiseSolicitacao;
		this.motivo = motivo;
	}

	public MotivoIndeferimentoAnalise() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AnalisePedido getAnaliseSolicitacao() {
		return analiseSolicitacao;
	}

	public void setAnaliseSolicitacao(AnalisePedido analiseSolicitacao) {
		this.analiseSolicitacao = analiseSolicitacao;
	}

	public MotivoIndeferimento getMotivo() {
		return motivo;
	}

	public void setMotivo(MotivoIndeferimento motivo) {
		this.motivo = motivo;
	}

	@Override
	public String toString() {
		return "MotivoIndeferimentoAnalise [id=" + id + ", analiseSolicitacao=" + analiseSolicitacao + ", motivo="
				+ motivo + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(analiseSolicitacao, id, motivo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MotivoIndeferimentoAnalise other = (MotivoIndeferimentoAnalise) obj;
		return Objects.equals(analiseSolicitacao, other.analiseSolicitacao) && Objects.equals(id, other.id)
				&& Objects.equals(motivo, other.motivo);
	}

}
