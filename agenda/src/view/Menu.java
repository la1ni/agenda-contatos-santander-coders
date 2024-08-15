package view;

import controller.Controlador;
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

        int opcao;

        do {

            String lista="";

            String opcoes = STR."""

                    ##################
                    ##### AGENDA #####
                    ##################

                    >>>> Contatos <<<<
                    \{lista}

                    >>>> Menu <<<<
                    1 - Adicionar Contato
                    2 - Detalhar Contato
                    3 - Editar Contato
                    4 - Remover Contato
                    5 - Sair

                    """;

            Util.escrever(opcoes);
            opcao =  Integer.parseInt(Util.ler(entrada, "Digite a opcao:"));

            switch (opcao){
                case 1:
                    try {
                        this.agenda.criarContato();
                        System.out.println(Arrays.toString(controlador.getContatos()));
                    } catch (Exception e){

                    }

                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    break;

                default:
                    Util.erro("Opcao invalida");
                    break;
            }

        } while(opcao <= 4);

    }

}
