package lojaEsportiva.dados;

import lojaEsportiva.exceptions.FuncionarioJaCadastradoException;
import lojaEsportiva.exceptions.FuncionarioNaoExistenteException;

public class RepositorioFuncionariosArray implements RepositorioFuncionarios {

	private Funcionarios[] funcionario;
	private int indice;

	public RepositorioFuncionariosArray() {
		this.funcionario = new Funcionarios[100];
		this.indice = 0;
	}

	@Override
	public void inserir(Funcionarios funcionario) throws FuncionarioJaCadastradoException {

		this.funcionario[indice] = funcionario;
		this.indice++;

	}

	@Override
	public void remover(String idFuncionario) throws FuncionarioNaoExistenteException {

		int i = this.getIndice(idFuncionario);

		this.indice = this.indice - 1;
		this.funcionario[i] = this.funcionario[this.indice];
		this.funcionario[this.indice] = null;


	}

	@Override
	public Funcionarios procurar(String idFuncionario) throws FuncionarioNaoExistenteException {

		int i = this.getIndice(idFuncionario);
		return this.funcionario[i];

		}

	@Override
	public Funcionarios atualizar(Funcionarios funcionario) throws FuncionarioNaoExistenteException {

		int i = this.getIndice(funcionario.getIdFuncionario());

		this.funcionario[i] = funcionario;
		return this.funcionario[i];


	}

	private int getIndice(String idFuncionario) {


		boolean controle = false;
		int i = 0;

		while ((controle==false) && (i < this.indice)) {		
			if (funcionario[i].getIdFuncionario().equals(idFuncionario)) {
				controle = true;
			} else {
				i += 1;
			}
		}
		return i;
	}

	@Override
	public boolean existe(String idFuncionario) {

		boolean controle = false;
		int i = 0;

		while ((controle==false) && (i < this.indice)) {

			if (funcionario[i].getIdFuncionario().equals(idFuncionario)) {
				controle = true;
			} else {
				i += 1;
			}
		}
		return controle;
	}


}