package view;

import service.agenda_contatos.AgendaContatosService;
import exception.ContatoNaoEncontradoException;
import exception.NaoExistemContatosException;
import model.Contato;
import util.Util;
import exception.TelefoneJaExistenteException;

import java.util.Scanner;


// classe de interação com o usuário
public class Agenda {

    private final Scanner scanner = new Scanner(System.in);
    private final AgendaContatosService agendaService = new AgendaContatosService();
    public void criarContato() throws Exception {
        try {

            String nome = Util.validarString(scanner, "Digite o nome do contato: ");
            String sobrenome = Util.validarString(scanner, "Digite o sobrenome do contato: ");
            String telefone = Util.validarNumero(scanner, "Digite o telefone do contato: ");
            String email = Util.validarEmail(scanner, "Digite o email do contato: ");

            Contato contato = new Contato(nome, sobrenome, telefone, email);
            agendaService.criarContato(contato);
        } catch (Exception e) {
            Util.erro(e.getMessage());
        }
    }

    public void detalharContato() throws Exception {
        String telefone = Util.validarNumero(scanner, "Digite o telefone do contato que deseja detalhar: ");
        Contato contato = agendaService.detalharContato(telefone);
        if (contato != null) {
            Util.escrever(contato.toString());
        } else {
            Util.erro("Contato não encontrado.");
        }
    }

    public void editarContato() throws Exception {
        try {
            String telefone = Util.validarNumero(scanner, "Digite o telefone do contato: ");
            Contato contato = agendaService.detalharContato(telefone);

            if (contato == null) {
                throw new ContatoNaoEncontradoException();
            }

            String nome = Util.validarString(scanner, "Digite o nome do contato: ");
            contato.setNome(nome);

            String sobrenome = Util.validarString(scanner, "Digite o sobrenome do contato: ");
            contato.setsobrenome(sobrenome);

            String telefoneEditado = Util.validarNumero(scanner, "Digite o telefone do contato: ");

            if (telefone.equals(telefoneEditado)) {
                contato.setTelefone(telefoneEditado);
            } else {
                try {
                    agendaService.consultarNumeroExistente(telefoneEditado);
                    contato.setTelefone(telefoneEditado);
                } catch (TelefoneJaExistenteException e) {
                    Util.erro("Número de telefone já está em uso. Escolha outra opção.");
                    return;
                }
            }

            String email = Util.validarEmail(scanner, "Digite o email do contato: ");
            contato.setEmail(email);

            System.out.println("<< Contato editado >>");
        } catch (Exception e) {
            Util.erro(e.getMessage());
        }
    }

    public void removerContato() throws Exception {
        try {
            String telefone = Util.ler(scanner, "Digite o telefone do contato: ");
            agendaService.removerContato(telefone);
            Util.escrever("Contato removido com sucesso.");
        } catch (Exception e) {
            Util.erro("Erro ao remvoer o contato: " + e.getMessage());
        }
    }

    public void exibeListaDeContatos() throws ContatoNaoEncontradoException, NaoExistemContatosException {
        if (agendaService.getContatos() != null) {
            String titulo = "LISTA DE CONTATOS";
            int larguraMaxima = titulo.length();

            // Determinar o comprimento máximo dos dados de contato para ajustar o layout
            for (Contato contato : agendaService.getContatos()) {
                String dadosContato = contato.getNome() + " " + contato.getSobrenome() + " | " + contato.getTelefone() + " | " + contato.getEmail();
                if (dadosContato.length() > larguraMaxima) {
                    larguraMaxima = dadosContato.length();
                }
            }

            int largura = larguraMaxima + 10;
            String linhaSuperior = "╔" + "═".repeat(largura) + "╗";
            String linhaIntermediaria = "╠" + "═".repeat(largura) + "╣";
            String linhaInferior = "╚" + "═".repeat(largura) + "╝";

            String linhaTitulo = "║" + " ".repeat((largura - titulo.length()) / 2) + titulo + " ".repeat(((largura - titulo.length()) / 2) + 1) + "║";
            StringBuilder listaDeContatos = new StringBuilder();
            listaDeContatos.append(linhaSuperior).append("\n").append(linhaTitulo).append("\n").append(linhaIntermediaria).append("\n");

            for (int i = 0; i < agendaService.getContatos().length; i++) {
                String dadosContato = agendaService.getContatos()[i].getNome() + " " + agendaService.getContatos()[i].getSobrenome() + " | " + agendaService.getContatos()[i].getTelefone() + " | " + agendaService.getContatos()[i].getEmail();
                String linhaContato = "║  " + (i + 1) + ". " + dadosContato + " ".repeat(largura - dadosContato.length() - 5) + "║";
                listaDeContatos.append(linhaContato).append("\n");
            }

            listaDeContatos.append(linhaInferior);
            System.out.println(listaDeContatos.toString());
        } else throw new NaoExistemContatosException();
    }
}
