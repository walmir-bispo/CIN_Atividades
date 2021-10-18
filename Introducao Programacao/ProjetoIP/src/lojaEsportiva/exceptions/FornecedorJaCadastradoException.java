package lojaEsportiva.exceptions;

public class FornecedorJaCadastradoException extends  Exception {
    public FornecedorJaCadastradoException(){
        super ("Este fornecedor já consta no banco de dados.");
    }
}
