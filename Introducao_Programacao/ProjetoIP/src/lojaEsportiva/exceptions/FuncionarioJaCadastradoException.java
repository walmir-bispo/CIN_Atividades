package lojaEsportiva.exceptions;

public class FuncionarioJaCadastradoException extends Exception {

	public FuncionarioJaCadastradoException() {
		super("Funcion�rio j� est� cadastrado.");
	}

}