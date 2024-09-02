package controller;


import util.Util;
import view.Agenda;

import java.util.List;


public class MenuContatos extends Menu {

    private final Agenda agenda = new Agenda();

    @Override
    public void selecionaOpcao() {

        String menu = Menu.geraMenuComOpcoes("Agenda Contatos", List.of("Adicionar Contato", "Detalhar Contato", "Editar Contato", "Excluir Contato", "Exibir lista completa", "Sair"));
        int opcaoSelecionada;

        do {
            System.out.println(menu);
            opcaoSelecionada = Integer.parseInt(Util.validarNumero(entrada, "Digite a opção desejada: "));

            switch (opcaoSelecionada) {
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
                    try {
                        this.agenda.removerContato();
                    } catch (Exception e) {
                        Util.erro(e.getMessage());
                    }
                    break;

                case 5:
                    try {
                        this.agenda.exibeListaDeContatos();
                    } catch (Exception e) {
                        Util.erro(e.getMessage());
                    }
                    break;

                case 6:
                    Util.erro("Saindo da agenda...");
                    break;

                default:
                    Util.erro("Opção inválida!");
                    break;
            }

        } while (opcaoSelecionada != 6);
    }
}
