package br.com.rudar.enumerated;

public enum TipoCondicaoPagamento {
	A("� Vista"), B("� Prazo"), C("Pendente de Faturamento"), D("Devolu��o"), E("Simples Remessa"),
	F("Diferen�a de ICMS"), G("Cr�dito ICMS Ativo Imobilizado"), H("Garantia"), I("Demonstra��o"),
	J("Amostra"), K("Prazo Negociado");
	
	private String label;

	TipoCondicaoPagamento(String label) {
		this.label = label;
	}
	
	public String getLabel(){
		return label;
	}
}
