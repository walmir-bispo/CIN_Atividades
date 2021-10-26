package lojaEsportiva.dados;

public class Funcionarios extends Cliente {

	private String rg;
	private String numeroConta;
	private String idFuncionario;

	public Funcionarios(String rg, String numeroConta, String idFuncionario, String nome, String endereco, String contato, String id) {
		super(nome,endereco,contato,id);

		this.rg = rg;
		this.numeroConta = numeroConta;
		this.idFuncionario = idFuncionario;		
	}

	public String getRg() {
		return rg;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(String idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

}
