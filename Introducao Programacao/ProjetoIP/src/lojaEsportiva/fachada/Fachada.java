package lojaEsportiva.fachada;

import lojaEsportiva.dados.Cliente;
import lojaEsportiva.dados.Fornecedor;
import lojaEsportiva.dados.Funcionarios;
import lojaEsportiva.dados.Produto;
import lojaEsportiva.dados.Venda;
import lojaEsportiva.exceptions.ClienteJaCadastradoException;
import lojaEsportiva.exceptions.ClienteNaoEncontradoException;
import lojaEsportiva.exceptions.FornecedorJaCadastradoException;
import lojaEsportiva.exceptions.FornecedorNaoEncontradoException;
import lojaEsportiva.exceptions.FuncionarioJaCadastradoException;
import lojaEsportiva.exceptions.FuncionarioNaoExistenteException;
import lojaEsportiva.exceptions.ProdutoJaCadastradoException;
import lojaEsportiva.exceptions.ProdutoNaoEncontradoException;
import lojaEsportiva.exceptions.VendaJaCadastradaException;
import lojaEsportiva.exceptions.VendaNaoEncontradaException;
import lojaEsportiva.negocio.CadastroCliente;
import lojaEsportiva.negocio.CadastroFornecedor;
import lojaEsportiva.negocio.CadastroFuncionarios;
import lojaEsportiva.negocio.CadastroVendas;
import lojaEsportiva.negocio.Cadastroprodutos;

public class Fachada {
	private CadastroVendas vendas;
	private Cadastroprodutos produto;
	private CadastroFornecedor fornecedor;
	private CadastroFuncionarios funcionarios;
	private CadastroCliente cliente;
	public Fachada(CadastroVendas vendas, Cadastroprodutos produto, CadastroFornecedor fornecedor, CadastroFuncionarios funcionarios, CadastroCliente cliente) {
		this.vendas = vendas;
		this.produto = produto;
		this.fornecedor = fornecedor;
		this.funcionarios = funcionarios;
		this.cliente=cliente;
	}
	public void cadastrarVenda(Venda venda) throws VendaJaCadastradaException {
		this.vendas.cadastrar(venda);
	}
	
	public Venda procurarVenda(String id) throws VendaNaoEncontradaException {
		return this.vendas.procurar(id);
	}
	
	public void removerVenda(String id) throws VendaNaoEncontradaException {
		this.vendas.remover(id);
	}
	
	public void atualizarVenda(Venda venda) throws VendaNaoEncontradaException {
		this.vendas.atualizar(venda);
	}
	
	public void cadastrarProduto(Produto produto) throws ProdutoJaCadastradoException{
		this.produto.cadastrar(produto);
	}

	public Produto procurarProduto(String identificador) throws ProdutoNaoEncontradoException{
		return this.produto.procurar(identificador);
	}

	public void removerProduto(String identificador)throws ProdutoNaoEncontradoException{
		this.produto.remover(identificador);
	}

	public void atualizarProduto(Produto produtonovo) throws ProdutoNaoEncontradoException{
		this.produto.atualizar(produtonovo);
	}
	
	public void cadastrarFornecedor (Fornecedor fornecedor) throws FornecedorJaCadastradoException{
		this.fornecedor.cadastrar(fornecedor);
	}
	
	public void removerFornecedor (String cnpj) throws FornecedorNaoEncontradoException{
		this.fornecedor.remover(cnpj);
	}
	
	public Fornecedor procurarFornecedor (String cnpj) throws FornecedorNaoEncontradoException{
		return this.fornecedor.procurar(cnpj);
	}
	
	public void atualizarFornecedor (Fornecedor fornecedor) throws FornecedorNaoEncontradoException{
		this.fornecedor.atualizar(fornecedor);
	}	
 
	public void cadastrarFuncionario(Funcionarios funcionario) throws FuncionarioJaCadastradoException {			
		this.funcionarios.cadastrar(funcionario);			
	}

	public void removerFuncionario(String idFuncionario) throws FuncionarioNaoExistenteException {
		this.funcionarios.remover(idFuncionario);			
	}

	public Funcionarios procurarFuncionario(String idFuncionario) throws FuncionarioNaoExistenteException {
		return this.funcionarios.procurar(idFuncionario);		
	}

	public Funcionarios atualizarFuncionario(Funcionarios funcionario) throws FuncionarioNaoExistenteException {
		return funcionarios.atualizar(funcionario);
	}
	
	public void cadastrarCliente(Cliente consumidor) throws ClienteJaCadastradoException{
		this.cliente.cadastrar(consumidor);		
	}

	public void removerCliente(String Id) throws ClienteNaoEncontradoException{
		this.cliente.remover(Id);
	}

	public void atualizarCliente(Cliente consumidor)throws ClienteNaoEncontradoException{
		this.cliente.atualizar(consumidor);
	}
	
	public Cliente procurarCliente (String Id)throws ClienteNaoEncontradoException{
		return this.cliente.procurar(Id);
	}

}