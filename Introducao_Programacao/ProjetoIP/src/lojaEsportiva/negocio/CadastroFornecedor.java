package lojaEsportiva.negocio;

import lojaEsportiva.dados.Fornecedor;
import lojaEsportiva.dados.Repositorio;
import lojaEsportiva.exceptions.FornecedorJaCadastradoException;
import lojaEsportiva.exceptions.FornecedorNaoEncontradoException;

public class CadastroFornecedor{
   private Repositorio fornecedor;
   public CadastroFornecedor (Repositorio rep) {
	   fornecedor = rep;
   }
   public void cadastrar (Fornecedor fornecedor) throws FornecedorJaCadastradoException{
	  this.fornecedor.cadastrar(fornecedor);
   }
   public void remover (String cnpj) throws FornecedorNaoEncontradoException{
	   this.fornecedor.remover(cnpj);
   }
   public Fornecedor procurar (String cnpj) throws FornecedorNaoEncontradoException{
	   return this.fornecedor.procurar(cnpj);
   }
   public void atualizar (Fornecedor fornecedor) throws FornecedorNaoEncontradoException{
	   this.fornecedor.atualizar(fornecedor);
   }
}
