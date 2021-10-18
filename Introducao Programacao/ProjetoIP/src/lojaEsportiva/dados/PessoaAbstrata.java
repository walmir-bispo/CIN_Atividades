package lojaEsportiva.dados;

public abstract class PessoaAbstrata {
	private String nome;
	private String endereco;
	private String contato;
	protected String id;
	public PessoaAbstrata(String nome,String endereco,String contato){
		this.nome=nome;
		this.endereco=endereco;
		this.contato=contato;
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public abstract String getId();
	public abstract void setId(String id);

}