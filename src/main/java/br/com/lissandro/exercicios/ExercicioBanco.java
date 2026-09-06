package br.com.lissandro.exercicios;
import java.util.Scanner;

public class ExercicioBanco {
    static class Conta {
        double saldo;
        double limiteEspecial;
        boolean usandoEspecial;
        Conta(double depositoInicial) {
            this.saldo = depositoInicial;
            if (depositoInicial <= 500) {
                this.limiteEspecial = 50;
            } else {
                this.limiteEspecial = depositoInicial * 0.5;
            }
            this.usandoEspecial = false;
        }
        double consultarSaldo() {
            return saldo + (usandoEspecial ? limiteEspecial : 0);
        }
        double consultarChequeEspecial() {
            return limiteEspecial;
        }
        void depositar(double valor) {
            saldo += valor;
        }
        boolean sacar(double valor) {
            double disponivel = consultarSaldo();
            if (valor <= disponivel) {
                if (valor <= saldo) {
                    saldo -= valor;
                } else {
                    double resto = valor - saldo;
                    saldo = 0;
                    usandoEspecial = true;
                    limiteEspecial -= resto;
                }
                return true;
            }
            return false;
        }
        boolean pagarBoleto(double valor) {
            return sacar(valor);
        }
        boolean verificaUsoEspecial() {
            return usandoEspecial;
        }
        void aplicarTaxaEspecial() {
            if (usandoEspecial) {
                double taxa = (limiteEspecial * 0.2);
                limiteEspecial -= taxa;
                if (limiteEspecial < 0) limiteEspecial = 0;
                usandoEspecial = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Valor inicial para abrir a conta: ");
        double inicial = sc.nextDouble();
        Conta conta = new Conta(inicial);
        while (true) {
            System.out.println("--- Banco ---");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Consultar cheque especial");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Pagar boleto");
            System.out.println("6. Verificar uso de cheque especial");
            System.out.println("7. Aplicar taxa de cheque especial (se usado)");
            System.out.println("0. Sair");
            int op = sc.nextInt();
            if (op == 0) break;
            switch (op) {
                case 1:
                    System.out.println("Saldo total: " + conta.consultarSaldo());
                    break;
                case 2:
                    System.out.println("Limite de cheque especial: " + conta.consultarChequeEspecial());
                    break;
                case 3:
                    System.out.print("Valor a depositar: ");
                    double dep = sc.nextDouble();
                    conta.depositar(dep);
                    System.out.println("Depositado.");
                    break;
                case 4:
                    System.out.print("Valor a sacar: ");
                    double sac = sc.nextDouble();
                    if (conta.sacar(sac)) System.out.println("Saque realizado."); else System.out.println("Saldo insuficiente.");
                    break;
                case 5:
                    System.out.print("Valor do boleto: ");
                    double boleto = sc.nextDouble();
                    if (conta.pagarBoleto(boleto)) System.out.println("Boleto pago."); else System.out.println("Saldo insuficiente.");
                    break;
                case 6:
                    System.out.println("Usando cheque especial? " + conta.verificaUsoEspecial());
                    break;
                case 7:
                    conta.aplicarTaxaEspecial();
                    System.out.println("Taxa aplicada se necessário.");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
        sc.close();
    }
}
