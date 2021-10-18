package lojaEsportiva.exceptions;

public class ClienteNaoEncontradoException extends Exception {
	public ClienteNaoEncontradoException() {
		super("Erro, cliente nao encontrado");
		
	}
}