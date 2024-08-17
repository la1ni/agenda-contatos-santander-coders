package view;

import controller.Controlador;
import model.Contato;
import util.Util;
import exception.TelefoneJaExistenteException;
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

    public void editarContato() throws Exception {
        try {
            String telefone = Util.ler(scanner, "Digite o telefone do contato: ");
            Contato contato = controlador.detalharContato(telefone);

            if (contato == null) {
                Util.erro("Contato não encontrado.");
                return;
            }

            String nome = Util.ler(scanner, "Digite o nome do contato: ");
            contato.setNome(nome);

            String sobrenome = Util.ler(scanner, "Digite o sobrenome do contato: ");
            contato.setsobrenome(sobrenome);

            String telefoneEditado = Util.ler(scanner, "Digite o telefone do contato: ");

            try {
                controlador.consultarNumeroExistente(telefoneEditado);
                contato.setTelefone(telefoneEditado);
            } catch (TelefoneJaExistenteException e) {
                Util.erro("Número de telefone já está em uso. Escolha outro número.");
                return;
            }

            String email = Util.ler(scanner, "Digite o email do contato: ");
            contato.setEmail(email);

            System.out.println("<< Contato editado >>");
        } catch (Exception e) {
            Util.erro(e.getMessage());
        }
    }

    public void removerContato() throws Exception {
        try {
            String telefone = Util.ler(scanner, "Digite o telefone do contato: ");
            controlador.removerContato(telefone);
            Util.escrever("Contato removido com sucesso.");
        } catch (Exception e) {
            Util.erro("Erro ao remvoer o contato: " + e.getMessage());
        }
    }
}
