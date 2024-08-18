package br.gov.go.sefaz.agualegal.dto.solicitacao;

import java.io.Serializable;
import java.util.Objects;

public class EnderecoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String enderecoEnvasador;

	private String coordenadasEnvasador;

	private String enderecoEnvase;

	private String coordenadasEnvase;

	public String getEnderecoEnvasador() {
		return enderecoEnvasador;
	}

	public void setEnderecoEnvasador(String enderecoEnvasador) {
		this.enderecoEnvasador = enderecoEnvasador;
	}

	public String getCoordenadasEnvasador() {
		return coordenadasEnvasador;
	}

	public void setCoordenadasEnvasador(String coordenadasEnvasador) {
		this.coordenadasEnvasador = coordenadasEnvasador;
	}

	public String getEnderecoEnvase() {
		return enderecoEnvase;
	}

	public void setEnderecoEnvase(String enderecoEnvase) {
		this.enderecoEnvase = enderecoEnvase;
	}

	public String getCoordenadasEnvase() {
		return coordenadasEnvase;
	}

	public void setCoordenadasEnvase(String coordenadasEnvase) {
		this.coordenadasEnvase = coordenadasEnvase;
	}

	@Override
	public String toString() {
		return "EnderecoDTO [enderecoEnvasador=" + enderecoEnvasador + ", coordenadasEnvasador=" + coordenadasEnvasador
				+ ", enderecoEnvase=" + enderecoEnvase + ", coordenadasEnvase=" + coordenadasEnvase + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(coordenadasEnvasador, coordenadasEnvase, enderecoEnvasador, enderecoEnvase);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnderecoDTO other = (EnderecoDTO) obj;
		return Objects.equals(coordenadasEnvasador, other.coordenadasEnvasador)
				&& Objects.equals(coordenadasEnvase, other.coordenadasEnvase)
				&& Objects.equals(enderecoEnvasador, other.enderecoEnvasador)
				&& Objects.equals(enderecoEnvase, other.enderecoEnvase);
	}

}
