package lojaEsportiva.dados;

import lojaEsportiva.exceptions.FuncionarioJaCadastradoException;
import lojaEsportiva.exceptions.FuncionarioNaoExistenteException;

public interface RepositorioFuncionarios {


	public void inserir(Funcionarios funcionario) throws FuncionarioJaCadastradoException;
	public void remover(String idFuncionario) throws FuncionarioNaoExistenteException;
	public Funcionarios procurar(String idFuncionario) throws FuncionarioNaoExistenteException;
	public Funcionarios atualizar(Funcionarios funcionario) throws FuncionarioNaoExistenteException;
	public boolean existe(String idFuncionario);

}