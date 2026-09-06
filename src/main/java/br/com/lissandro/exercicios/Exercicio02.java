package br.com.lissandro.exercicios;
import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== EXERCÍCIOS - ESTRUTURAS DE CONTROLE =====");
            System.out.println("1. Tabuada");
            System.out.println("2. Cálculo de IMC");
            System.out.println("3. Números pares ou ímpares em um intervalo");
            System.out.println("4. Sequência de divisão (resto diferente de 0)");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt();

            if (opcao == 0) {
                System.out.println("Encerrando o programa...");
                break;
            }

            switch (opcao) {
                case 1:
                    tabuada(sc);
                    break;
                case 2:
                    imc(sc);
                    break;
                case 3:
                    parImpar(sc);
                    break;
                case 4:
                    sequenciaDivisao(sc);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        sc.close();
    }

    private static void tabuada(Scanner sc) {
        System.out.print("Digite um número para ver a tabuada de 1 a 10: ");
        int numero = sc.nextInt();
        System.out.println("===== TABUADA DO " + numero + " =====");
        for (int i = 1; i <= 10; i++) {
            System.out.println(numero + " x " + i + " = " + (numero * i));
        }
    }

    private static void imc(Scanner sc) {
        System.out.print("Digite sua altura (em metros, ex: 1.75): ");
        double altura = sc.nextDouble();
        System.out.print("Digite seu peso (em kg, ex: 70.5): ");
        double peso = sc.nextDouble();
        double imc = peso / (altura * altura);
        String classificacao;
        if (imc <= 18.5) {
            classificacao = "Abaixo do peso";
        } else if (imc <= 24.9) {
            classificacao = "Peso ideal";
        } else if (imc <= 29.9) {
            classificacao = "Levemente acima do peso";
        } else if (imc <= 34.9) {
            classificacao = "Obesidade Grau I";
        } else if (imc <= 39.9) {
            classificacao = "Obesidade Grau II (Severa)";
        } else {
            classificacao = "Obesidade III (Mórbida)";
        }
        System.out.printf("Seu IMC é: %.2f%n", imc);
        System.out.println("Classificação: " + classificacao);
    }

    private static void parImpar(Scanner sc) {
        System.out.print("Digite o primeiro número: ");
        int primeiro = sc.nextInt();
        System.out.print("Digite o segundo número (maior que o primeiro): ");
        int segundo = sc.nextInt();
        if (segundo <= primeiro) {
            System.out.println("O segundo número deve ser maior que o primeiro.");
            return;
        }
        System.out.print("Escolha 'par' ou 'impar': ");
        String escolha = sc.next();
        boolean querPar = escolha.equalsIgnoreCase("par");
        System.out.println("===== NÚMEROS " + (querPar ? "PARES" : "ÍMPARES") + " DE " + primeiro + " ATÉ " + segundo + " (DECRESCENTE) =====");
        for (int i = segundo; i >= primeiro; i--) {
            if ((i % 2 == 0) == querPar) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    private static void sequenciaDivisao(Scanner sc) {
        System.out.print("Digite um número inicial: ");
        int primeiro = sc.nextInt();
        System.out.println("Agora informe outros números. O programa só para quando a divisão pelo número inicial tiver resto diferente de 0.");
        while (true) {
            System.out.print("Informe um número: ");
            int numero = sc.nextInt();
            if (numero < primeiro) {
                System.out.println("Número menor que o inicial (" + primeiro + "). Ignorado.");
                continue;
            }
            if (numero % primeiro != 0) {
                System.out.println("Número " + numero + " dividido por " + primeiro + " tem resto diferente de 0. Encerrando.");
                break;
            }
            System.out.println("Número " + numero + " é divisível por " + primeiro + ". Continuando...");
        }
    }
}