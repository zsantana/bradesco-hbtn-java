package exceptions;

public class OperacaoInvalidaException extends Exception {
    public OperacaoInvalidaException(String mensagem) {
        super(mensagem);
    }
}