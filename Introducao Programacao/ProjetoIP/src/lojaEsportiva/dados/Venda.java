package lojaEsportiva.dados;

public class Venda {
	private Produto produto;
	private Cliente cliente;
	private Funcionarios funcionario;
	private String id;
	
	public Venda(Produto produto, Cliente cliente, Funcionarios funcionario, String id) {
		this.produto = produto;
		this.cliente = cliente;
		this.funcionario = funcionario;
		this.id = id;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionarios getFuncionario() {
		return this.funcionario;
	}

	public void setFuncionario(Funcionarios funcionario) {
		this.funcionario = funcionario;
	}
	
	public String getId() {
		return this.id;
	}

}