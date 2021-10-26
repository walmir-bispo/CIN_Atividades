package lojaEsportiva.dados;

import lojaEsportiva.exceptions.ProdutoJaCadastradoException;
import lojaEsportiva.exceptions.ProdutoNaoEncontradoException;

public interface repositorioprodutos {

	public void inserir(Produto produto) throws ProdutoJaCadastradoException;

	public Produto procurar(String identificador) throws ProdutoNaoEncontradoException;

	public void remover(String identificador)throws ProdutoNaoEncontradoException;

	public void atualizar(Produto produtonovo) throws ProdutoNaoEncontradoException;
	
	public boolean existe(String identificador);
}

