package view;

import controller.Controlador;
import model.Contato;
import util.Util;

import java.util.Arrays;
import java.util.Scanner;

public class Menu {
    private final Controlador controlador = new Controlador();
    private final Agenda agenda = new Agenda();
    private final Scanner entrada;

    public Menu() {
        this.entrada = new Scanner(System.in);
    }

    public void iniciar() throws Exception {

        int opcao = 0;

        do {
            StringBuilder lista = new StringBuilder("");

            if (controlador.getContatos() != null) {
                lista.append("""
                 >>>> Registros <<<<
                Id | Nome                  | Telefone  | Email
                """);
                for (Contato contato : controlador.getContatos()) {
                    String linha = String.format("%d  | %s       | %s | %s\n", controlador.indiceDeContatosPorTelefone(contato.getTelefone()) + 1, STR."\{contato.getNome()} \{contato.getsobrenome()}", contato.getTelefone(), contato.getEmail());
                    lista.append(linha);
                }
            }

            String opcoes = STR."""

                ##############################
                ##### AGENDA DE CONTATOS #####
                ##############################
                \{lista.toString()}
                >>>> Menu <<<<
                1 - Adicionar Contato
                2 - Detalhar Contato
                3 - Editar Contato
                4 - Remover Contato
                5 - Sair
                """;

            Util.escrever(opcoes);
            opcao = Integer.parseInt(Util.ler(entrada, "Digite a opção desejada: "));

            switch (opcao) {
                case 1:
                    try {
                        this.agenda.criarContato();
                    } catch (Exception e) {
                        Util.erro(e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        this.agenda.detalharContato();
                    } catch (Exception e) {
                        Util.erro(e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        this.agenda.editarContato();
                    } catch (Exception e) {
                        Util.erro(e.getMessage());
                    }
                    break;

                case 4:
                    break;

                case 5:
                    Util.erro("Saindo do programa...");
                    break;

                default:
                    Util.erro("Opção inválida!");
                    break;
            }

        }
        while (opcao != 5);
    }
}
