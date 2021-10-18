package lojaEsportiva.dados;

import lojaEsportiva.exceptions.FornecedorJaCadastradoException;
import lojaEsportiva.exceptions.FornecedorNaoEncontradoException;

public class RepositorioLista implements Repositorio{
    private Fornecedor fornecedor;
    private RepositorioLista proximo;
    public RepositorioLista(){
        this.fornecedor = null;
        this.proximo = null;
    }

    @Override
    public void remover(String cnpj) throws FornecedorNaoEncontradoException {
        if (this.fornecedor.getId().equals(cnpj)){
            this.fornecedor = this.proximo.fornecedor;
            this.proximo = this.proximo.proximo;
        } else if (this.proximo != null){
            this.proximo.remover(cnpj);
        } else {
            throw  new FornecedorNaoEncontradoException();
        }
    }

    @Override
    public Fornecedor procurar(String cnpj) throws FornecedorNaoEncontradoException {
        if (this.proximo == null){
           throw new FornecedorNaoEncontradoException();
        } else if (this.fornecedor.getId().equals(cnpj)){
           return this.fornecedor;
        } else {
         return   this.proximo.procurar(cnpj);
        }


    }

    @Override
    public boolean existe(String cnpj) {
    	if(this.fornecedor != null)	{
    		if(this.fornecedor.getId().equals(cnpj)) {
    			return true;
    		} else {
    		return	this.proximo.existe(cnpj);
    		}
    	} else {
    		return false;
    	}
    	
       
    }

    @Override
    public void cadastrar(Fornecedor fornecedor) throws FornecedorJaCadastradoException{
        if (this.fornecedor == null){
            this.fornecedor = fornecedor;
            this.proximo = new RepositorioLista();
        }
        else if (this.fornecedor.getId().equals(fornecedor.getId())){
            throw new FornecedorJaCadastradoException();
        }

        else{
            this.proximo.cadastrar(fornecedor);
        }
    }

    @Override
    public void atualizar(Fornecedor fornecedor) throws FornecedorNaoEncontradoException {
        if (this.proximo == null){
           throw new FornecedorNaoEncontradoException();
        } else if (this.fornecedor.getId().equals(fornecedor.getId())){
             this.fornecedor.setTipoProduto(fornecedor.getTipoProduto());
        } else {
           this.proximo.atualizar(fornecedor);
           }

    }
}
