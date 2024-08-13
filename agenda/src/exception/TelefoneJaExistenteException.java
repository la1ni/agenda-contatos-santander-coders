package exception;

public class TelefoneJaExistenteException extends Exception{

    public TelefoneJaExistenteException(){
        super("Este telefone já está registrado na agenda.");
    }
}
