package lojaEsportiva.dados;

import lojaEsportiva.exceptions.VendaJaCadastradaException;
import lojaEsportiva.exceptions.VendaNaoEncontradaException;

public class RepositorioVendasLista implements RepositorioVendas {
	private Venda venda;
	private RepositorioVendasLista proximo;
	
	public RepositorioVendasLista() {
		this.venda = null;
		this.proximo = null;
	}

	@Override
	public void inserir(Venda venda) throws VendaJaCadastradaException {
		if(this.venda == null) {
			this.venda = venda;
			this.proximo = new RepositorioVendasLista();
		} else {
			this.proximo.inserir(venda);
		}
	}

	@Override
	public Venda procurar(String id) throws VendaNaoEncontradaException {
		if(this.venda.getId().equals(id)) {
			return this.venda;
		} else {
			return this.proximo.procurar(id);
		}
	}

	
	@Override
	public void remover(String id) throws VendaNaoEncontradaException {
		if(this.venda.getId().equals(id)) {
			this.venda = this.proximo.venda;
			this.proximo = this.proximo.proximo;
		} else {
			this.proximo.remover(id);
		}
	}

	@Override
	public void atualizar(Venda venda) throws VendaNaoEncontradaException{
		if(this.venda.getId().equals(venda.getId())) {
			this.venda = venda;
		} else {
			this.proximo.atualizar(venda);
		}
	}

	@Override
	public boolean existe(String id) {
		if(this.venda == null) {
			return false;
		} else if(this.venda.getId().equals(id)) {
			return true;
		} else {
			return this.proximo.existe(id);
		}
	}
}