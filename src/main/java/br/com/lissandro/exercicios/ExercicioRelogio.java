package br.com.lissandro.exercicios;
import java.util.Scanner;

public class ExercicioRelogio {

    static abstract class Relogio {
        protected int hora;
        protected int minuto;
        protected int segundo;

        Relogio() {
            this.hora = 0;
            this.minuto = 0;
            this.segundo = 0;
        }

        public int getHora() {
            return hora;
        }

        public void setHora(int hora) {
            if (hora >= 0 && hora < 24) {
                this.hora = hora;
            } else {
                System.out.println("Hora inválida (0-23).");
            }
        }

        public int getMinuto() {
            return minuto;
        }

        public void setMinuto(int minuto) {
            if (minuto >= 0 && minuto < 60) {
                this.minuto = minuto;
            } else {
                System.out.println("Minuto inválido (0-59).");
            }
        }

        public int getSegundo() {
            return segundo;
        }

        public void setSegundo(int segundo) {
            if (segundo >= 0 && segundo < 60) {
                this.segundo = segundo;
            } else {
                System.out.println("Segundo inválido (0-59).");
            }
        }

        public String formatar() {
            return String.format("%02d:%02d:%02d", hora, minuto, segundo);
        }

        public abstract void sincronizar(Relogio outro);
    }

    static class RelogioBrasileiro extends Relogio {
        @Override
        public void sincronizar(Relogio outro) {
            this.hora = outro.hora;
            this.minuto = outro.minuto;
            this.segundo = outro.segundo;
            System.out.println("Relógio brasileiro sincronizado: " + formatar());
        }
    }

    static class RelogioAmericano extends Relogio {
        @Override
        public void setHora(int hora) {
            if (hora >= 0 && hora <= 12) {
                this.hora = hora;
            } else {
                System.out.println("Hora inválida para relógio americano (0-12).");
            }
        }

        @Override
        public void sincronizar(Relogio outro) {
            int horaOrig = outro.hora % 12;
            if (horaOrig == 0) horaOrig = 12;
            this.hora = horaOrig;
            this.minuto = outro.minuto;
            this.segundo = outro.segundo;
            System.out.println("Relógio americano sincronizado: " + formatar());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RelogioBrasileiro br = new RelogioBrasileiro();
        RelogioAmericano us = new RelogioAmericano();

        while (true) {
            System.out.println("\n===== RELÓGIOS DO MUNDO =====");
            System.out.println("1. Configurar relógio brasileiro");
            System.out.println("2. Configurar relógio americano");
            System.out.println("3. Ver horas (brasileiro)");
            System.out.println("4. Ver horas (americano)");
            System.out.println("5. Sincronizar relógio brasileiro a partir de outro");
            System.out.println("6. Sincronizar relógio americano a partir de outro");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 0) break;

            switch (opcao) {
                case 1: configurar(sc, br, "brasileiro"); break;
                case 2: configurar(sc, us, "americano"); break;
                case 3: System.out.println("Brasileiro: " + br.formatar()); break;
                case 4: System.out.println("Americano: " + us.formatar()); break;
                case 5: br.sincronizar(us); break;
                case 6: us.sincronizar(br); break;
                default: System.out.println("Opção inválida.");
            }
        }
        sc.close();
        System.out.println("Programa encerrado.");
    }

    private static void configurar(Scanner sc, Relogio relogio, String nome) {
        System.out.print("Hora [" + nome + "]: ");
        int hora = sc.nextInt();
        System.out.print("Minuto: ");
        int minuto = sc.nextInt();
        System.out.print("Segundo: ");
        int segundo = sc.nextInt();
        sc.nextLine();

        relogio.setHora(hora);
        relogio.setMinuto(minuto);
        relogio.setSegundo(segundo);
        System.out.println("Relógio " + nome + " configurado: " + relogio.formatar());
    }
}