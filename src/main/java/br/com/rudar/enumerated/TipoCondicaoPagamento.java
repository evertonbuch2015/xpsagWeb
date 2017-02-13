package br.com.rudar.enumerated;

public enum TipoCondicaoPagamento {
	A("À Vista"), B("À Prazo"), C("Pendente de Faturamento"), D("Devolução"), E("Simples Remessa"),
	F("Diferença de ICMS"), G("Crédito ICMS Ativo Imobilizado"), H("Garantia"), I("Demonstração"),
	J("Amostra"), K("Prazo Negociado");
	
	private String label;

	TipoCondicaoPagamento(String label) {
		this.label = label;
	}
	
	public String getLabel(){
		return label;
	}
}
