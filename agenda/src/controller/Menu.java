package controller;

import java.util.List;
import java.util.Scanner;

public abstract class Menu {

    protected final Scanner entrada;

    public Menu() {
        this.entrada = new Scanner(System.in);
    }

    public static String geraMenuComOpcoes(String tituloMenu, List<String> opcoes) {

        int contador = 1;
        StringBuilder opcoesConcatenadas = new StringBuilder();

        int largura = tituloMenu.length() + 19;

        String bordaTopo = "╔" + "═".repeat(largura) + "╗";
        String linhaCentral = "╠" + "═".repeat(largura) + "╣";
        String bordaFim = "╚" + "═".repeat(largura) + "╝";
        String linhaTitulo = "║" + " ".repeat((largura - tituloMenu.length() ) / 2 ) + "" + tituloMenu + "" + " ".repeat(((largura - tituloMenu.length()) / 2) + 1) + "║";

        for (String opcao : opcoes) {
            opcoesConcatenadas.append("* " + contador + ". " + opcao + " ".repeat(largura - opcao.length() - 4) + "║" + "\n");
            contador++;
        }

        StringBuilder menuTemplate = new StringBuilder(bordaTopo + "\n" + linhaTitulo + "\n" + linhaCentral + "\n" + opcoesConcatenadas +  bordaFim);

        return menuTemplate.toString();
    }

    public abstract void selecionaOpcao();
}



