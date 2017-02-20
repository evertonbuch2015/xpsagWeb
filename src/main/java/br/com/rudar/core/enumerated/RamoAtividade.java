package br.com.rudar.core.enumerated;

public enum RamoAtividade {
	INDUSTRIA("Indústria"), TRANSPORTE("Transporte"),
	COMERCIO("Comércio"), GOVERNO("Governo"),
	TURISMO("Turismo"), HOSPITAL("Hospital"),
	ESCOLA("Escola"), LAVANDERIA("Lavanderia"); 
	
	
	private String label;

	RamoAtividade(String label) {
		this.label = label;
	}
	
	public String getLabel(){
		return label;
	}
	
}
