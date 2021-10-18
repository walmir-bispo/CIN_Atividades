package lojaEsportiva.dados;

import lojaEsportiva.exceptions.ProdutoJaCadastradoException;
import lojaEsportiva.exceptions.ProdutoNaoEncontradoException;

public class RepositorioProdutoArray implements repositorioprodutos {
	private Produto[] produtos;
	private int index=0;
	
	public RepositorioProdutoArray() {
		produtos=new Produto[100];
		index=0;
	}
	
	public void inserir(Produto produto) throws ProdutoJaCadastradoException {
		produtos[index]=produto;
		index+=1;
	}

	
	public Produto procurar(String identificador) throws ProdutoNaoEncontradoException {
		Produto	retorna =null;
		int i=this.getIndex(identificador);
		if(i==this.index){
			throw new ProdutoNaoEncontradoException();
		}else {
			retorna= this.produtos[i];
		}
		return retorna;
		
	}

	@Override
	public void remover(String identificador) throws ProdutoNaoEncontradoException {
		int i=this.getIndex(identificador);
		if(i==this.index){
			throw new ProdutoNaoEncontradoException();
		}else {
			this.index=this.index-1;
			this.produtos[i]=this.produtos[this.index];
			this.produtos[this.index]=null;
		}	
	}

	@Override
	public void atualizar(Produto produtonovo) throws ProdutoNaoEncontradoException {
		int i=this.getIndex(produtonovo.getIdentificador());
		if(i==this.index){
			throw new ProdutoNaoEncontradoException();
		}else {
			this.produtos[i]=produtonovo;
		}
		
	}
	private int getIndex(String identificador) {
		boolean achou=false;
		String n;
		int i=0;
		while((!achou)&&(i<this.index)) {
			n= produtos[i].getIdentificador();
			if (n.equals(identificador)) {
				achou=true;
			}else {
				i+=1;
			}
		}
		return i;
	}
	public boolean existe(String identificador) {
		boolean achou=false;
		String n;
		int i =0;
		while((!achou)&&(i<this.index)) {
			n= produtos[i].getIdentificador();
			if (n.equals(identificador)) {
				achou=true;
			}else {
				i++;
			}
		}
		return achou;
	}
}

