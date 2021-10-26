package lojaEsportiva.negocio;

import lojaEsportiva.dados.Cliente;
import lojaEsportiva.dados.InterfaceCliente;
import lojaEsportiva.exceptions.ClienteJaCadastradoException;
import lojaEsportiva.exceptions.ClienteNaoEncontradoException;

public class CadastroCliente {
	private InterfaceCliente cliente;
	public CadastroCliente(InterfaceCliente rep) {
		this.cliente=rep;
	}
	public void cadastrar(Cliente consumidor) throws ClienteJaCadastradoException{
		if(this.cliente.existe(consumidor.getId())){
			throw new ClienteJaCadastradoException();
		}else {
			this.cliente.inserir(consumidor);
		}
	}
	public void remover(String Id) throws ClienteNaoEncontradoException{
		if(this.cliente.existe(Id)){
			this.cliente.remover(Id);
		}else {
			throw new ClienteNaoEncontradoException();
			
		}
	}
	public void atualizar(Cliente consumidor)throws ClienteNaoEncontradoException{
		if(this.cliente.existe(consumidor.getId())){
			this.cliente.atualizar(consumidor);
		}else {
			throw new ClienteNaoEncontradoException();
			
		}
	}
	public Cliente procurar (String Id)throws ClienteNaoEncontradoException{
		if(this.cliente.existe(Id)){
			return this.cliente.procurar(Id);
		}else {
			throw new ClienteNaoEncontradoException();
			
		}
	}
}