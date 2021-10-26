package lojaEsportiva.exceptions;

public class VendaNaoEncontradaException extends Exception {
	
	public VendaNaoEncontradaException() {
		super("Registro não encontrado! Por favor, verifique o ID e tente novemente!");		
	}
}
