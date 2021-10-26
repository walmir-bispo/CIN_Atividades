package lojaEsportiva.negocio;

import lojaEsportiva.dados.Funcionarios;
import lojaEsportiva.dados.RepositorioFuncionarios;
import lojaEsportiva.exceptions.FuncionarioJaCadastradoException;
import lojaEsportiva.exceptions.FuncionarioNaoExistenteException;

public class CadastroFuncionarios {

	private RepositorioFuncionarios funcionarios;

	public CadastroFuncionarios(RepositorioFuncionarios rep) {
		funcionarios = rep;
	}

	public void cadastrar(Funcionarios funcionario) throws FuncionarioJaCadastradoException {

		if (funcionarios.existe(funcionario.getIdFuncionario()) == false && funcionarios.existe(funcionario.getId()) == false) {
			funcionarios.inserir(funcionario);
		} else {
			throw new FuncionarioJaCadastradoException();
		}

	}

	public void remover(String idFuncionario) throws FuncionarioNaoExistenteException {

		if (funcionarios.existe(idFuncionario) == false) {
			throw new FuncionarioNaoExistenteException();
		} else {
			funcionarios.remover(idFuncionario);
		}
	}

	public Funcionarios procurar(String idFuncionario) throws FuncionarioNaoExistenteException {

		if (funcionarios.existe(idFuncionario) == false) {
			throw new FuncionarioNaoExistenteException();
		} else {
			return funcionarios.procurar(idFuncionario);
		}

	}

	public Funcionarios atualizar(Funcionarios funcionario) throws FuncionarioNaoExistenteException {

		if (funcionarios.existe(funcionario.getIdFuncionario()) == false) {
			throw new FuncionarioNaoExistenteException();
		} else {
			return funcionarios.atualizar(funcionario);
		}

	}

}
