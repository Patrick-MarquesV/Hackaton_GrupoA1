package domain.model;

import java.util.Date;

public class Vaga {
	String cargo;
	String empresa;
	String nivelVaga;
	Integer quantidadeVaga;
	String detalheVaga;
	String localidade;
	Date dataPublicacao;
	String salario;
	
	public Vaga(String cargo, String empresa, String nivelVaga, Integer quantidadeVaga, String detalheVaga,
			String localidade, Date dataPublicacao, String salario) {
		super();
		this.cargo = cargo;
		this.empresa = empresa;
		this.nivelVaga = nivelVaga;
		this.quantidadeVaga = quantidadeVaga;
		this.detalheVaga = detalheVaga;
		this.localidade = localidade;
		this.dataPublicacao = dataPublicacao;
		this.salario = definirSalario(salario);
	}
	
	public String definirSalario(String salario) {
		if (salario==null) {
			return "A combinar";
		} else {
			return salario;
		}
	}

	public String getCargo() {
		return cargo;
	}

	public String getEmpresa() {
		return empresa;
	}

	public String getNivelVaga() {
		return nivelVaga;
	}

	public Integer getQuantidadeVaga() {
		return quantidadeVaga;
	}

	public String getDetalheVaga() {
		return detalheVaga;
	}

	public String getLocalidade() {
		return localidade;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public String getSalario() {
		return salario;
	}
}