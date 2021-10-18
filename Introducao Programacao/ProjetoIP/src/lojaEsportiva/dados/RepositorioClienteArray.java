package lojaEsportiva.dados;

import lojaEsportiva.exceptions.ClienteJaCadastradoException;
import lojaEsportiva.exceptions.ClienteNaoEncontradoException;

public class RepositorioClienteArray implements InterfaceCliente {
	private Cliente[] consumidor;
	private int indice;
	public RepositorioClienteArray() {
		this.consumidor=new Cliente[100];
		this.indice=0;
	}
	public int getIndice(String Id){
		int retorno=0;
		boolean achou=false;
		while((!achou)&&retorno<this.indice) {
			if(this.consumidor[retorno].getId().equals(Id)) {
				achou=true;
			}else {
				retorno=retorno+1;
			}
		}return retorno;
	}
	@Override
	public void inserir(Cliente consumidor) throws ClienteJaCadastradoException {
		this.consumidor[this.indice]=consumidor;
		indice=indice+1;
		
	}

	@Override
	public void remover(String Id) throws ClienteNaoEncontradoException {
		// TODO Auto-generated method stub
		int i=this.getIndice(Id);
		this.indice=this.indice-1;
		this.consumidor[i]=this.consumidor[this.indice];
		this.consumidor[indice]=null;
	}

	@Override
	public void atualizar(Cliente consumidor) throws ClienteNaoEncontradoException {
		int i=this.getIndice(consumidor.getId());
		this.consumidor[i]=consumidor;
		
	}

	@Override
	public Cliente procurar(String Id) throws ClienteNaoEncontradoException {
	Cliente consumidor=null;
	int i=getIndice(Id);
	consumidor=this.consumidor[i];
		return consumidor;
	}

	@Override
	public boolean existe(String Id) {
		int retorno=0;
		boolean achou=false;
		while((!achou)&&retorno<this.indice) {
			if(this.consumidor[retorno].getId().equals(Id)) {
				achou=true;
			}else {
				retorno=retorno+1;
			}
		}
		return achou;
	}
	
}