package exception;

public class ContatoNaoEncontradoException extends Exception {

    public ContatoNaoEncontradoException() {
        super("O contato não existe na agenda");
    }

}
