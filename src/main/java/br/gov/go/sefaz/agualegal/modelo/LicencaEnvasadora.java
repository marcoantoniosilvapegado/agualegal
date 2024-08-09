package br.gov.go.sefaz.agualegal.modelo;

import java.util.Date;
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
@Table(schema = "APL_AGUALEGAL", name = "TAB_LICENCA_ENVASADORA")
public class LicencaEnvasadora {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_licenca_envasadora")
	@SequenceGenerator(name = "seq_licenca_envasadora", sequenceName = "seq_tab_licenca_envasadora", allocationSize = 1)
	@Column(name = "id_licenca_envasadora")
	private Integer idLicencaEnvasadora;

	@Column(name = "numero_licenca", nullable = false, length = 20)
	private String numeroLicenca;

	@Lob
	@Column(name = "imagem", nullable = false)
	private String imagem;

	@Column(name = "data_vencimento")
	private Date dataVencimento;

	@Column(name = "vigente", length = 1, columnDefinition = "CHAR(1) DEFAULT 'S'")
	private Character vigente;

	@ManyToOne
	@JoinColumn(name = "id_envasadora", nullable = false)
	private Envasadora envasadora;

	@ManyToOne
	@JoinColumn(name = "id_tipo_licenca", nullable = false)
	private TipoLicenca tipoLicenca;

	@ManyToOne
	@JoinColumn(name = "id_emissor_licenca", nullable = false)
	private EmissorLicenca emissorLicenca;

	public LicencaEnvasadora() {
	
	}

	public Integer getIdLicencaEnvasadora() {
		return idLicencaEnvasadora;
	}

	public void setIdLicencaEnvasadora(Integer idLicencaEnvasadora) {
		this.idLicencaEnvasadora = idLicencaEnvasadora;
	}

	public String getNumeroLicenca() {
		return numeroLicenca;
	}

	public void setNumeroLicenca(String numeroLicenca) {
		this.numeroLicenca = numeroLicenca;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Character getVigente() {
		return vigente;
	}

	public void setVigente(Character vigente) {
		this.vigente = vigente;
	}

	public Envasadora getEnvasadora() {
		return envasadora;
	}

	public void setEnvasadora(Envasadora envasadora) {
		this.envasadora = envasadora;
	}

	public TipoLicenca getTipoLicenca() {
		return tipoLicenca;
	}

	public void setTipoLicenca(TipoLicenca tipoLicenca) {
		this.tipoLicenca = tipoLicenca;
	}

	public EmissorLicenca getEmissorLicenca() {
		return emissorLicenca;
	}

	public void setEmissorLicenca(EmissorLicenca emissorLicenca) {
		this.emissorLicenca = emissorLicenca;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataVencimento, emissorLicenca, envasadora, idLicencaEnvasadora, imagem, numeroLicenca,
				tipoLicenca, vigente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LicencaEnvasadora other = (LicencaEnvasadora) obj;
		return Objects.equals(dataVencimento, other.dataVencimento)
				&& Objects.equals(emissorLicenca, other.emissorLicenca) && Objects.equals(envasadora, other.envasadora)
				&& Objects.equals(idLicencaEnvasadora, other.idLicencaEnvasadora)
				&& Objects.equals(imagem, other.imagem) && Objects.equals(numeroLicenca, other.numeroLicenca)
				&& Objects.equals(tipoLicenca, other.tipoLicenca) && Objects.equals(vigente, other.vigente);
	}

	@Override
	public String toString() {
		return "LicencaEnvasadora [idLicencaEnvasadora=" + idLicencaEnvasadora + ", numeroLicenca=" + numeroLicenca
				+ ", imagem=" + imagem + ", dataVencimento=" + dataVencimento + ", vigente=" + vigente + ", envasadora="
				+ envasadora + ", tipoLicenca=" + tipoLicenca + ", emissorLicenca=" + emissorLicenca + "]";
	}

}