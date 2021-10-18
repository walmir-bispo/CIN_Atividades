package lojaEsportiva.dados;

import lojaEsportiva.exceptions.ProdutoJaCadastradoException;
import lojaEsportiva.exceptions.ProdutoNaoEncontradoException;

public class RepositorioProdutosLista implements repositorioprodutos  {
	private Produto produto;
	private RepositorioProdutosLista proximo;
	public RepositorioProdutosLista() {
		this.produto=null;
		this.proximo=null;
	}
	
	public void inserir(Produto produto)throws ProdutoJaCadastradoException {
		if(this.proximo==null) {
			this.produto=produto;
			this.proximo=new RepositorioProdutosLista();
		}else if(this.produto.getIdentificador().equals(produto.getIdentificador())){
			throw new ProdutoJaCadastradoException();
		}else {
			this.proximo.inserir(produto);
		}
	}

	

	public void remover(String identificador)throws ProdutoNaoEncontradoException {
		if(this.proximo==null) {
			throw new ProdutoNaoEncontradoException();
		}else if(this.produto.getIdentificador().equals(produto.getIdentificador())) {
			this.produto=this.proximo.produto;
			this.proximo=this.proximo.proximo;
		}else {
			this.proximo.remover(identificador);
		}
		
	}
	
	public void atualizar(Produto produtonovo) throws ProdutoNaoEncontradoException{
		if(this.proximo==null) {
			throw new ProdutoNaoEncontradoException();
		}else if(this.produto.getIdentificador().equals(produto.getIdentificador())) {
			this.produto=produtonovo;
		}else {
			this.proximo.atualizar(produtonovo);
		}
		
	}

	
	public Produto procurar(String identificador) throws ProdutoNaoEncontradoException {
		Produto retorna=null;
		if(this.proximo==null){
			throw new ProdutoNaoEncontradoException();
		}else if(this.produto.getIdentificador().equals(identificador)) {
			retorna= this.produto;
		}else {
			this.proximo.procurar(identificador);
		}
		return retorna;
	}
	public boolean existe(String identificador) {
		boolean resposta= false;
		if(this.proximo==null){
			resposta=false;
		}else if(this.produto.getIdentificador().equals(produto.getIdentificador())) {
			resposta= true;
		}else {
			this.proximo.existe(identificador);
		}
		return resposta;
	}
}
