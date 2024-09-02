package util;

import java.util.Scanner;

public class Util {

    public static void escrever(String mensagem) {
        System.out.println(mensagem);
    }

    public static void erro(String mensagem) {
        System.err.println(mensagem);
    }

    public static String ler(Scanner entrada, String questao) {
        System.out.println(questao);
        return entrada.nextLine();
    }

    public static String validarString(Scanner scanner, String pergunta) {
        StringBuilder substr = new StringBuilder();
        while (true) {
            System.out.println(pergunta);
            String resposta = scanner.nextLine();
            for (int i = 0; i < resposta.length(); i++) {
                char letra = resposta.charAt(i);
                if (letra >= 'A' && letra <= 'Z' || letra >= 'a' && letra <= 'z') {
                    substr.append(letra);
                    if (substr.length() == resposta.length()) {
                        return resposta;
                    }
                } else {
                    System.err.println("Digite um dado textual válido");
                    break;
                }
            }
        }
    }

    public static String validarNumero(Scanner scanner, String pergunta) {
        while (true) {
            System.out.println(pergunta);
            String resposta = scanner.nextLine();
            try {
                Integer.parseInt(resposta);
                return resposta;
            } catch (NumberFormatException e) {
                System.err.println("Digite um número válido");
            }
        }
    }

    public static String validarEmail(Scanner scanner, String pergunta) {
        while (true) {
            System.out.println(pergunta);
            String resposta = scanner.nextLine();
            if (resposta.contains("@")) {
                return resposta;
            } else {
                System.err.println("Digite um email válido");
            }
        }
    }
}
