package br.gov.go.sefaz.agualegal.enums;

public enum MENSAGENSPADRAO {

	GRAFICAENCONTRADA(1, "Encontrou Gráfica"), GRAFICANAOENCONTRADA(2, "Não encontrou Gráfica"),
	GRAFICANAOAUTORIZADA(3, "A Gráfica não está autorizada a usar o sistema Água Legal"),
	ENVASADORANAOENCONTRADA(4, "Envasadora não encontrada"),
	ENVASADORANAOAUTORIZADA(5, "A Envasadora não está autorizada a usar o sistema Água Legal"),
	ENVASADORAAUTORIZADA(6, "A Envasadora não autorizada a usar o sistema Água Legal");

	private int cod;
	private String desc;

	private MENSAGENSPADRAO(int cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}

	public int getCod() {
		return cod;
	}

	public String getDesc() {
		return desc;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}