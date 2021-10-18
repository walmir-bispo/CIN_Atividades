package lojaEsportiva.dados;

import lojaEsportiva.exceptions.ClienteJaCadastradoException;
import lojaEsportiva.exceptions.ClienteNaoEncontradoException;

public interface InterfaceCliente {
	 
	public void inserir(Cliente consumidor) throws ClienteJaCadastradoException;
	public void remover(String Id) throws ClienteNaoEncontradoException;
	public void atualizar(Cliente consumidor)throws ClienteNaoEncontradoException;
	public Cliente procurar (String Id)throws ClienteNaoEncontradoException;
	public boolean existe(String Id);

}