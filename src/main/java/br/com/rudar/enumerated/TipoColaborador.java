package br.com.rudar.enumerated;

public enum TipoColaborador{
	F("Fornecedor"), C("Cliente"),
	M("Cart�o Cr�dito "), T("Transportador"),
	R("Representante");
	
	private String label;

	TipoColaborador(String label) {
		this.label = label;
	}
	
	public String getLabel(){
		return this.label;
	}
}
