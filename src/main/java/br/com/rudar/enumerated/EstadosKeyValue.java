package br.com.rudar.enumerated;

public enum EstadosKeyValue {
	AC("Acre"), AL("Alagoas"), AM("Amazonas"), AP("Amapá"), BA("Bahia"),
	CE("Ceará"), DF("Distrito Federal"), ES("Espirito Santo"), GO("Goias"),
	MA("Maranhão"), MG("Minas Gerais"), MS("Mato Grosso Sul"), TO("Tocantins"),
	MT(	"Mato Grosso"), PA("Pará"), PB("Paraiba"), PE("Pernanbuco"),
	PI("Piaui"), PR("Parana"), RJ("Rio de Janeiro"),SP("São Paulo"),
	RN("Rio Grande do Norte"), RO("Rondônia"), RR("Roraima"),
	RS("Rio Grande do Sul"), SC("Santa Catarina"), SE("Sergipe");
	
	
	private String label;

	EstadosKeyValue(String label) {
		this.label = label;
	}
	
	public String getLabel(){
		return label;
	}
}
