package br.com.rudar.enumerated;

public enum OrigemMercadoria {
	INDUSTRIA("Ind�stria"), TRANSPORTE("Transporte"),
	COMERCIO("Com�rcio"), GOVERNO("Governo"),
	TURISMO("Turismo"), HOSPITAL("Hospital"),
	ESCOLA("Escola"), LAVANDERIA("Lavanderia"); 
	
	
	private String label;

	OrigemMercadoria(String label) {
		this.label = label;
	}
	
	public String getLabel(){
		return label;
	}
	
}
