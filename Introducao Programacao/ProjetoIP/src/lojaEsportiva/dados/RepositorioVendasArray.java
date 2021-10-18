package lojaEsportiva.dados;

import lojaEsportiva.exceptions.VendaJaCadastradaException;
import lojaEsportiva.exceptions.VendaNaoEncontradaException;

public class RepositorioVendasArray implements RepositorioVendas {
	private Venda[] vendas;
	private int index = 0; 

    public RepositorioVendasArray() {
		this.vendas = new Venda[100];
	}
	
	@Override
	public void inserir(Venda venda) throws VendaJaCadastradaException {
		this.vendas[this.index] = venda;
		this.index++;
	}

	@Override
	public Venda procurar(String id) throws VendaNaoEncontradaException {
		Venda venda = null;
		int i = this.getIndice(id);
		venda = this.vendas[i];
		return venda;
	}

	@Override
	public void remover(String id) throws VendaNaoEncontradaException {
		int i = this.getIndice(id);
		this.index--;
		this.vendas[i] = this.vendas[this.index];
		this.vendas[this.index] = null;
	}
	
	@Override
	public void atualizar(Venda registroVenda) throws VendaNaoEncontradaException {
		int i = this.getIndice(registroVenda.getId());
		this.vendas[i] = registroVenda;
	}
	
	public int getIndice(String id) {
		boolean isCadastrado = false;
		int i = 0;
		while(i < this.index && !isCadastrado) {
			if(this.vendas[i].getId().equals(id)) {
				isCadastrado = true;
			} else {
				i++;
			}
		}
		return i;
	}

	@Override
	public boolean existe(String id) {
		boolean isCadastrado = false;
		int i = 0;
		while(i < this.index && !isCadastrado) {
			if(this.vendas[i].getId().equals(id)) {
				isCadastrado = true;
			} else {
				i++;
			}
		}
		return isCadastrado;
	}
}
