package lojaEsportiva.exceptions;

public class FornecedorJaCadastradoException extends  Exception {
    public FornecedorJaCadastradoException(){
        super ("Este fornecedor j� consta no banco de dados.");
    }
}
