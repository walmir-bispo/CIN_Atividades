package lojaEsportiva.exceptions;

public class FornecedorNaoEncontradoException  extends Exception{
    public FornecedorNaoEncontradoException(){
        super("O fornecedor n�o � ligado a esta loja,por favor verifique o cnpj e tente novamente.");
    }
}
