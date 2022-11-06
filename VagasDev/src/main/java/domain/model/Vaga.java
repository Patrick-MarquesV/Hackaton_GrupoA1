package domain.model;

public class Vaga {
	private String cargo;
	private String linkVaga;
	private String empresa;
	private String nivelVaga;
	private String detalheVaga;
	private String localidade;
	private String dataPublicacao;
	
	public Vaga(String cargo, String linkVaga, String empresa, String nivelVaga, String detalheVaga,
			String localidade, String dataPublicacao) {
		this.cargo = cargo;
		this.linkVaga = linkVaga;
		this.empresa = empresa;
		this.nivelVaga = nivelVaga;
		this.detalheVaga = detalheVaga;
		this.localidade = localidade;
		this.dataPublicacao = dataPublicacao;
	}


	@Override
	public String toString() {
		return "Vaga{" +
				"cargo='" + cargo + '\'' +
				", linkVaga='" + linkVaga + '\'' +
				", empresa='" + empresa + '\'' +
				", nivelVaga='" + nivelVaga + '\'' +
				", detalheVaga='" + detalheVaga + '\'' +
				", localidade='" + localidade + '\'' +
				", dataPublicacao='" + dataPublicacao + '\'' +
				'}';
	}
}
