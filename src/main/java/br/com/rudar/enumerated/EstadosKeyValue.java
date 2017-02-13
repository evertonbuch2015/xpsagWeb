package br.com.rudar.enumerated;

public enum EstadosKeyValue {
	AC("Acre"), AL("Alagoas"), AM("Amazonas"), AP("Amap�"), BA("Bahia"),
	CE("Cear�"), DF("Distrito Federal"), ES("Espirito Santo"), GO("Goias"),
	MA("Maranh�o"), MG("Minas Gerais"), MS("Mato Grosso Sul"), TO("Tocantins"),
	MT(	"Mato Grosso"), PA("Par�"), PB("Paraiba"), PE("Pernanbuco"),
	PI("Piaui"), PR("Parana"), RJ("Rio de Janeiro"),SP("S�o Paulo"),
	RN("Rio Grande do Norte"), RO("Rond�nia"), RR("Roraima"),
	RS("Rio Grande do Sul"), SC("Santa Catarina"), SE("Sergipe");
	
	
	private String label;

	EstadosKeyValue(String label) {
		this.label = label;
	}
	
	public String getLabel(){
		return label;
	}
}
