package br.com.rudar.core.enumerated;

public enum TipoFrete {
	C("CIF - Por Conta do Cliente"), F("FOB - Por Conta do Remetente"),
	T("Por Conta de Terceiros"), S("Sem Frete");
	
	
	private String label;

	TipoFrete(String label) {
		this.label = label;
	}
	
	public String getLabel(){
		return label;
	}
}
