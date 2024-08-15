package view;

import controller.Controlador;
import model.Contato;
import util.Util;
import java.util.Scanner;

public class Agenda {

    private final Scanner scanner = new Scanner(System.in);
    private final Controlador controlador = new Controlador();

    public void criarContato() throws Exception {
        try {
            String nome = Util.ler(scanner, "Digite o nome do contato: ");
            String sobrenome = Util.ler(scanner, "Digite o sobrenome do contato: ");
            String telefone = Util.ler(scanner, "Digite o telefone do contato: ");
            String email = Util.ler(scanner, "Digite o email do contato: ");

            Contato contato = new Contato(nome, sobrenome, telefone, email);
            controlador.criarContato(contato);
        } catch (Exception e){
            Util.erro(e.getMessage());
        }
    }

    public void detalharContato() throws Exception {
        String telefone = Util.ler(scanner, "Digite o telefone do contato que deseja detalhar: ");
        Contato contato = controlador.detalharContato(telefone);
        if (contato != null) {
            Util.escrever(contato.toString());
        } else {
            Util.erro("Contato não encontrado.");
        }
    }

}
