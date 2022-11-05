package domain.model;

public class Vaga {
	private String cargo;
	private String linkVaga;
	private String empresa;
	private String nivelVaga;
	private String quantidadeVaga;
	private String detalheVaga;
	private String localidade;
	private String dataPublicacao;
	private String salario;
	
	public Vaga(String cargo, String linkVaga, String empresa, String nivelVaga, String quantidadeVaga, String detalheVaga,
			String localidade, String dataPublicacao, String salario) {
		this.cargo = cargo;
		this.linkVaga = linkVaga;
		this.empresa = empresa;
		this.nivelVaga = nivelVaga;
		this.quantidadeVaga = quantidadeVaga;
		this.detalheVaga = detalheVaga;
		this.localidade = localidade;
		this.dataPublicacao = dataPublicacao;
		this.salario = definirSalario(salario);
	}
	
	public String definirSalario(String salario) {
		if (salario.length()==0) {
			return "A combinar";
		} else {
			return salario;
		}
	}

	public String getCargo() {
		return cargo;
	}
	
	public String getLinkVaga() {
		return linkVaga;
	}

	public String getEmpresa() {
		return empresa;
	}

	public String getNivelVaga() {
		return nivelVaga;
	}

	public String getQuantidadeVaga() {
		return quantidadeVaga;
	}

	public String getDetalheVaga() {
		return detalheVaga;
	}

	public String getLocalidade() {
		return localidade;
	}

	public String getDataPublicacao() {
		return dataPublicacao;
	}

	public String getSalario() {
		return salario;
	}
}
