package lojaEsportiva.dados;

public class Cliente extends PessoaAbstrata  {
	
	
	public Cliente (String nome,String endereco,String contato,String id) {
			super(nome,endereco,contato);
			this.id=id;
		}
		public String getId() {
			return this.id;
		}
		public void setId(String id) {
			this.id=id;
		}
	}