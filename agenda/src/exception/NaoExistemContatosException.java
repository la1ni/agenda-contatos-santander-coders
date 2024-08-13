package exception;

public class NaoExistemContatosException extends Exception {

    public NaoExistemContatosException(){
        super("Não existem contatos registrados.");
    }
}
