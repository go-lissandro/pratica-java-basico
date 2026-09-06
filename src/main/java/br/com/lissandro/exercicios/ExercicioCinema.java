package br.com.lissandro.exercicios;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExercicioCinema {

    static abstract class Ingresso {
        protected double valor;
        protected String nomeFilme;
        protected boolean dublado;

        Ingresso(double valor, String nomeFilme, boolean dublado) {
            this.valor = valor;
            this.nomeFilme = nomeFilme;
            this.dublado = dublado;
        }

        public abstract double valorReal();

        String getNomeFilme() {
            return nomeFilme;
        }

        boolean isDublado() {
            return dublado;
        }

        String descricaoRapida() {
            return nomeFilme + " (" + (dublado ? "Dublado" : "Legendado") + ")";
        }
    }

    static class MeiaEntrada extends Ingresso {
        MeiaEntrada(double valor, String nomeFilme, boolean dublado) {
            super(valor, nomeFilme, dublado);
        }

        @Override
        public double valorReal() {
            return valor / 2.0;
        }
    }

    static class IngressoFamilia extends Ingresso {
        private int numeroPessoas;

        IngressoFamilia(double valor, String nomeFilme, boolean dublado, int numeroPessoas) {
            super(valor, nomeFilme, dublado);
            this.numeroPessoas = numeroPessoas;
        }

        @Override
        public double valorReal() {
            double total = valor * numeroPessoas;
            if (numeroPessoas > 3) {
                total *= 0.95;
            }
            return total;
        }
    }

    private static final List<Ingresso> ingressos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== CINEMA - TIPOS DE INGRESSO =====");
            System.out.println("1. Criar ingresso normal");
            System.out.println("2. Criar meia-entrada");
            System.out.println("3. Criar ingresso família");
            System.out.println("4. Listar ingressos criados");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 0) break;

            switch (opcao) {
                case 1: criarIngresso(sc, "normal"); break;
                case 2: criarIngresso(sc, "meia"); break;
                case 3: criarIngresso(sc, "familia"); break;
                case 4: listar(); break;
                default: System.out.println("Opção inválida.");
            }
        }
        sc.close();
        System.out.println("Programa encerrado.");
    }

    private static void criarIngresso(Scanner sc, String tipo) {
        System.out.print("Valor do ingresso (R$): ");
        double valor = sc.nextDouble();
        sc.nextLine();
        System.out.print("Nome do filme: ");
        String filme = sc.nextLine();
        System.out.print("Dublado ou Legendado? (d/l): ");
        String opcao = sc.nextLine();
        boolean dublado = opcao.equalsIgnoreCase("d");

        Ingresso ingresso;
        switch (tipo) {
            case "meia":
                ingresso = new MeiaEntrada(valor, filme, dublado);
                break;
            case "familia":
                System.out.print("Quantas pessoas? ");
                int pessoas = sc.nextInt();
                sc.nextLine();
                ingresso = new IngressoFamilia(valor, filme, dublado, pessoas);
                break;
            default:
                ingresso = new Ingresso(valor, filme, dublado) {
                    @Override
                    public double valorReal() {
                        return valor;
                    }
                };
        }
        ingressos.add(ingresso);
        System.out.println("Ingresso criado: " + ingresso.descricaoRapida() + " - Valor real: R$ " + String.format("%.2f", ingresso.valorReal()));
    }

    private static void listar() {
        if (ingressos.isEmpty()) {
            System.out.println("Nenhum ingresso criado ainda.");
            return;
        }
        System.out.println("===== INGRESSOS CRIADOS =====");
        for (int i = 0; i < ingressos.size(); i++) {
            Ingresso ing = ingressos.get(i);
            System.out.println((i + 1) + ". " + ing.descricaoRapida() + " - Valor real: R$ " + String.format("%.2f", ing.valorReal()));
        }
    }
}