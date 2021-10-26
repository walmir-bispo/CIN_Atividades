package lojaEsportiva.dados;

import lojaEsportiva.exceptions.ClienteJaCadastradoException;
import lojaEsportiva.exceptions.ClienteNaoEncontradoException;

public class RepositorioListaCliente implements InterfaceCliente {
	private Cliente consumidor;
	private RepositorioListaCliente proximo;
	public RepositorioListaCliente() {
		this.consumidor=null;
		this.proximo=null;
	}
	@Override
	public void inserir(Cliente consumidor) throws ClienteJaCadastradoException {
		if(this.proximo==null) {
			this.consumidor=consumidor;
			this.proximo=new RepositorioListaCliente();
		}else {
			this.proximo.inserir(consumidor);
		}
	}
	@Override
	public void remover(String Id) throws ClienteNaoEncontradoException {
		if(this.consumidor.getId().equals(Id)) {
			this.consumidor=this.proximo.consumidor;
			this.proximo=this.proximo.proximo;
		}else {
			this.proximo.remover(Id);
		}
	}
	@Override
	public void atualizar(Cliente consumidor) throws ClienteNaoEncontradoException {
		if(this.consumidor.getId().equals(consumidor.getId())){
			this.consumidor=consumidor;
		}else {
			this.proximo.atualizar(consumidor);
		}
		
	}
	@Override
	public Cliente procurar(String Id) throws ClienteNaoEncontradoException {
		if(this.consumidor.getId().equals(Id)) {
			return this.consumidor;
		}else {
			return this.proximo.procurar(Id);
		}
	}
	@Override
	public boolean existe(String Id) {
		if(this.proximo==null) {
			return false;
		}else if(this.consumidor.getId().equals(Id)) {
			return true;
					
		}else {
			return this.proximo.existe(Id);
		}
	}
}