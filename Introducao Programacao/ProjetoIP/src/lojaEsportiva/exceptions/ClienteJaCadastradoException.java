package lojaEsportiva.exceptions;

public class ClienteJaCadastradoException extends Exception {
	public ClienteJaCadastradoException() {
		super("Erro, cliente ja cadastrado");
	}
}