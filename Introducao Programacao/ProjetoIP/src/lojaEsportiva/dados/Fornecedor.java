package lojaEsportiva.dados;

public class Fornecedor  extends PessoaAbstrata{
   //CLASSE BASE
    private String tipoProduto;
    public Fornecedor(String nome,String endereco,String contato,String tipoProduto, String id) {
        super (nome,endereco,contato);
    	this.tipoProduto = tipoProduto;
        this.id = id;
    }
    public String getTipoProduto() {
        return tipoProduto;
    }
    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }
   
   
	@Override
	public String getId() {
		return this.id;
	}
	@Override
	public void setId(String id) {
		this.id = id;
	}


}
