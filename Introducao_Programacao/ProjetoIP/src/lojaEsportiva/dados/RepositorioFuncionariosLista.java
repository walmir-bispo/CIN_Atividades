package lojaEsportiva.dados;

import lojaEsportiva.exceptions.FuncionarioJaCadastradoException;
import lojaEsportiva.exceptions.FuncionarioNaoExistenteException;

public class RepositorioFuncionariosLista implements RepositorioFuncionarios {

	private Funcionarios funcionario;
	private RepositorioFuncionariosLista proximo;

	public RepositorioFuncionariosLista() {

		this.funcionario = null;
		this.proximo = null;

	}

	@Override
	public void inserir(Funcionarios funcionario) throws FuncionarioJaCadastradoException {

		if (this.funcionario == null) {
			this.funcionario = funcionario;
			this.proximo = new RepositorioFuncionariosLista();
		} else {
			this.proximo.inserir(funcionario);

		}

	}

	@Override
	public void remover(String idFuncionario) throws FuncionarioNaoExistenteException {

		if (this.funcionario.getIdFuncionario().equals(idFuncionario)) {
			this.funcionario = this.proximo.funcionario;
			this.proximo = this.proximo.proximo;
		} else {
			this.proximo.remover(idFuncionario);
		}

	}

	@Override
	public Funcionarios procurar(String idFuncionario) throws FuncionarioNaoExistenteException {

		if (this.funcionario.getIdFuncionario().equals(idFuncionario)) {
			return funcionario;
		} else {
			return this.proximo.procurar(idFuncionario);
		}

	}

	@Override
	public Funcionarios atualizar(Funcionarios funcionario) throws FuncionarioNaoExistenteException {

		if (this.funcionario.getIdFuncionario().equals(funcionario.getIdFuncionario())) {
			this.funcionario = funcionario;
			return this.funcionario;
		} else {
			return this.proximo.atualizar(funcionario);
		}

	}

	@Override
	public boolean existe(String idFuncionario) {

		if (this.funcionario == null) {
			return false;

		} else if (this.funcionario.getIdFuncionario().equals(idFuncionario)) {
			return true;

		} else {
			return this.proximo.existe(idFuncionario);
		}
	}

} 