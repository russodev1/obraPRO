package ttre;

import java.util.ArrayList;
import java.util.Scanner;

public class Contabilidade {

    public static void submenuContabilidade(ArrayList<Produto> produtos) {
        int answ = -1;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("-----Menu Contabilidade-----\n1 - Registrar lançamentos\n2 - Consultar fluxo\n3- Remover lançamento\n4- Gerar relatório financeiro\n0 - Voltar\nO que deseja fazer?: ");
            answ = sc.nextInt();
            switch (answ) {
                case 1: registrar(produtos); break;
                case 2: System.out.println("Fluxo do caixa: " + Main.fluxo); break;
                case 3: remover(produtos); break;
                case 4: relatorio(produtos); break;
                default: System.out.println("Opção inválida."); break;
            }
        } while (answ != 0);
    }

    public static void registrar(ArrayList<Produto> produtos) {
        Scanner sc = new Scanner(System.in);
        int codigo;

        do {
            System.out.println("Digite o codigo do produto (ou 0 para voltar): ");
            codigo = sc.nextInt();
            sc.nextLine();

            if (codigo != 0) {
                System.out.println("Digite o valor unitário do produto: ");
                float valor = sc.nextFloat();
                sc.nextLine();

                System.out.println("Digite o tipo do produto: ");
                String tipo = sc.nextLine();

                produtos.add(new Produto(tipo, valor, codigo));
                Main.fluxo += valor;
                System.out.println("Produto adicionado!");
            }

        } while (codigo != 0);
    }

    public static void remover(ArrayList<Produto> produtos) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o código do produto a ser removido: ");
        int codigo = sc.nextInt();

        Produto produtoRemovido = null;
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).codigo == codigo) {
                produtoRemovido = produtos.get(i);
            }
        }

        if (produtoRemovido != null) {
            produtos.remove(produtoRemovido);
            Main.fluxo -= produtoRemovido.valor;
            System.out.println("Produto removido!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public static void relatorio(ArrayList<Produto> produtos) {
        System.out.println("Relatório de Produtos:");
        System.out.println("Fluxo financeiro: " + Main.fluxo);
        Produto.show(produtos);
    }

}
