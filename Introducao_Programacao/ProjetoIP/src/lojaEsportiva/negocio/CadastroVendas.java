package lojaEsportiva.negocio;

import lojaEsportiva.dados.RepositorioVendas;
import lojaEsportiva.dados.Venda;
import lojaEsportiva.exceptions.VendaJaCadastradaException;
import lojaEsportiva.exceptions.VendaNaoEncontradaException;

public class CadastroVendas {
	private RepositorioVendas vendas;

	public CadastroVendas(RepositorioVendas vendas) {
		this.vendas = vendas;
	}
	
	public void cadastrar(Venda venda) throws VendaJaCadastradaException {
		if(!vendas.existe(venda.getId())) {
			this.vendas.inserir(venda);
		} else {
			throw new VendaJaCadastradaException();
		}
	}
	
	public Venda procurar(String id) throws VendaNaoEncontradaException{
		if(vendas.existe(id)) {
			return this.vendas.procurar(id);
		} else {
			throw new VendaNaoEncontradaException();
		}
	}
	
	public void remover(String id) throws VendaNaoEncontradaException {
		if(vendas.existe(id)) {
			this.vendas.remover(id);
		} else {
			throw new VendaNaoEncontradaException();
		}
	}
	
	public void atualizar(Venda venda) throws VendaNaoEncontradaException {
		if(vendas.existe(venda.getId())) {
			this.vendas.atualizar(venda);
		} else {
			throw new VendaNaoEncontradaException();
		}
	}
}