package br.com.lissandro.exercicios;
import java.util.Scanner;

public class ExercicioUsuarios {

    static abstract class Usuario {
        protected String nome;
        protected String email;
        protected String senha;
        protected boolean administrador;

        Usuario(String nome, String email, String senha) {
            this.nome = nome;
            this.email = email;
            this.senha = senha;
        }

        String getNome() {
            return nome;
        }

        String getEmail() {
            return email;
        }

        void setNome(String nome) {
            this.nome = nome;
        }

        void setEmail(String email) {
            this.email = email;
        }

        boolean isAdministrador() {
            return administrador;
        }

        boolean realizarLogin(String email, String senha) {
            if (this.email.equals(email) && this.senha.equals(senha)) {
                System.out.println("Login realizado com sucesso.");
                return true;
            }
            System.out.println("Falha no login: email ou senha incorretos.");
            return false;
        }

        void realizarLogoff() {
            System.out.println("Logoff realizado.");
        }

        void alterarDados(String nome, String email) {
            this.nome = nome;
            this.email = email;
            System.out.println("Dados alterados com sucesso.");
        }

        void alterarSenha(String novaSenha) {
            this.senha = novaSenha;
            System.out.println("Senha alterada com sucesso.");
        }
    }

    static class Gerente extends Usuario {
        Gerente(String nome, String email, String senha) {
            super(nome, email, senha);
            this.administrador = true;
        }

        void gerarRelatorioFinanceiro() {
            System.out.println("Relatório financeiro gerado.");
        }

        void consultarVendas() {
            System.out.println("Consulta de vendas em andamento...");
        }
    }

    static class Vendedor extends Usuario {
        private int quantidadeVendas;

        Vendedor(String nome, String email, String senha) {
            super(nome, email, senha);
            this.administrador = false;
            this.quantidadeVendas = 0;
        }

        int getQuantidadeVendas() {
            return quantidadeVendas;
        }

        void realizarVenda() {
            quantidadeVendas++;
            System.out.println("Venda realizada! Total de vendas: " + quantidadeVendas);
        }

        void consultarVendas() {
            System.out.println("Quantidade de vendas: " + quantidadeVendas);
        }
    }

    static class Atendente extends Usuario {
        private double valorEmCaixa;

        Atendente(String nome, String email, String senha) {
            super(nome, email, senha);
            this.administrador = false;
            this.valorEmCaixa = 0;
        }

        double getValorEmCaixa() {
            return valorEmCaixa;
        }

        void receberPagamento(double valor) {
            valorEmCaixa += valor;
            System.out.println("Pagamento recebido. Valor em caixa: R$ " + String.format("%.2f", valorEmCaixa));
        }

        void fecharCaixa() {
            System.out.println("Caixa fechado. Total: R$ " + String.format("%.2f", valorEmCaixa));
            valorEmCaixa = 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Gerente gerente = new Gerente("Gerente", "gerente@empresa.com", "1234");
        Vendedor vendedor = new Vendedor("Vendedor", "vendedor@empresa.com", "1234");
        Atendente atendente = new Atendente("Atendente", "atendente@empresa.com", "1234");

        while (true) {
            System.out.println("\n===== SISTEMA DE USUÁRIOS =====");
            System.out.println("1. Operações do Gerente");
            System.out.println("2. Operações do Vendedor");
            System.out.println("3. Operações do Atendente");
            System.out.println("4. Exibir dados dos usuários");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 0) break;

            switch (opcao) {
                case 1: menuGerente(sc, gerente, vendedor); break;
                case 2: menuVendedor(sc, vendedor); break;
                case 3: menuAtendente(sc, atendente); break;
                case 4: exibirUsuarios(gerente, vendedor, atendente); break;
                default: System.out.println("Opção inválida.");
            }
        }
        sc.close();
        System.out.println("Programa encerrado.");
    }

    private static void exibirUsuarios(Gerente g, Vendedor v, Atendente a) {
        System.out.println("--- Gerente ---");
        System.out.println("Nome: " + g.getNome() + " | Email: " + g.getEmail() + " | Admin: " + g.isAdministrador());
        System.out.println("--- Vendedor ---");
        System.out.println("Nome: " + v.getNome() + " | Email: " + v.getEmail() + " | Admin: " + v.isAdministrador() + " | Vendas: " + v.getQuantidadeVendas());
        System.out.println("--- Atendente ---");
        System.out.println("Nome: " + a.getNome() + " | Email: " + a.getEmail() + " | Admin: " + a.isAdministrador() + " | Caixa: R$ " + String.format("%.2f", a.getValorEmCaixa()));
    }

    private static void menuGerente(Scanner sc, Gerente gerente, Vendedor vendedor) {
        System.out.println("--- Menu Gerente ---");
        System.out.println("1. Gerar relatório financeiro");
        System.out.println("2. Consultar vendas");
        System.out.println("3. Realizar login");
        System.out.println("4. Realizar logoff");
        System.out.println("5. Alterar dados");
        System.out.println("6. Alterar senha");
        System.out.println("7. Voltar");
        System.out.print("Opção: ");
        int op = sc.nextInt();
        sc.nextLine();
        switch (op) {
            case 1: gerente.gerarRelatorioFinanceiro(); break;
            case 2: gerente.consultarVendas(); break;
            case 3:
                System.out.print("Email: "); String email = sc.nextLine();
                System.out.print("Senha: "); String senha = sc.nextLine();
                gerente.realizarLogin(email, senha);
                break;
            case 4: gerente.realizarLogoff(); break;
            case 5:
                System.out.print("Novo nome: "); String nome = sc.nextLine();
                System.out.print("Novo email: "); String novoEmail = sc.nextLine();
                gerente.alterarDados(nome, novoEmail);
                break;
            case 6:
                System.out.print("Nova senha: "); String novaSenha = sc.nextLine();
                gerente.alterarSenha(novaSenha);
                break;
            case 7: break;
            default: System.out.println("Opção inválida.");
        }
    }

    private static void menuVendedor(Scanner sc, Vendedor vendedor) {
        System.out.println("--- Menu Vendedor ---");
        System.out.println("1. Realizar venda");
        System.out.println("2. Consultar vendas");
        System.out.println("3. Realizar login");
        System.out.println("4. Realizar logoff");
        System.out.println("5. Alterar dados");
        System.out.println("6. Alterar senha");
        System.out.println("7. Voltar");
        System.out.print("Opção: ");
        int op = sc.nextInt();
        sc.nextLine();
        switch (op) {
            case 1: vendedor.realizarVenda(); break;
            case 2: vendedor.consultarVendas(); break;
            case 3:
                System.out.print("Email: "); String email = sc.nextLine();
                System.out.print("Senha: "); String senha = sc.nextLine();
                vendedor.realizarLogin(email, senha);
                break;
            case 4: vendedor.realizarLogoff(); break;
            case 5:
                System.out.print("Novo nome: "); String nome = sc.nextLine();
                System.out.print("Novo email: "); String novoEmail = sc.nextLine();
                vendedor.alterarDados(nome, novoEmail);
                break;
            case 6:
                System.out.print("Nova senha: "); String novaSenha = sc.nextLine();
                vendedor.alterarSenha(novaSenha);
                break;
            case 7: break;
            default: System.out.println("Opção inválida.");
        }
    }

    private static void menuAtendente(Scanner sc, Atendente atendente) {
        System.out.println("--- Menu Atendente ---");
        System.out.println("1. Receber pagamento");
        System.out.println("2. Fechar caixa");
        System.out.println("3. Realizar login");
        System.out.println("4. Realizar logoff");
        System.out.println("5. Alterar dados");
        System.out.println("6. Alterar senha");
        System.out.println("7. Voltar");
        System.out.print("Opção: ");
        int op = sc.nextInt();
        sc.nextLine();
        switch (op) {
            case 1:
                System.out.print("Valor do pagamento (R$): ");
                double valor = sc.nextDouble();
                sc.nextLine();
                atendente.receberPagamento(valor);
                break;
            case 2: atendente.fecharCaixa(); break;
            case 3:
                System.out.print("Email: "); String email = sc.nextLine();
                System.out.print("Senha: "); String senha = sc.nextLine();
                atendente.realizarLogin(email, senha);
                break;
            case 4: atendente.realizarLogoff(); break;
            case 5:
                System.out.print("Novo nome: "); String nome = sc.nextLine();
                System.out.print("Novo email: "); String novoEmail = sc.nextLine();
                atendente.alterarDados(nome, novoEmail);
                break;
            case 6:
                System.out.print("Nova senha: "); String novaSenha = sc.nextLine();
                atendente.alterarSenha(novaSenha);
                break;
            case 7: break;
            default: System.out.println("Opção inválida.");
        }
    }
}