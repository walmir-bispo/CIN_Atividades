package lojaEsportiva.exceptions;

public class VendaJaCadastradaException extends Exception {
	
	public VendaJaCadastradaException() {
		super("O ID passado já consta em nosso Banco de Dados!");
	}
}
