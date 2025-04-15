package ttre;

import java.util.ArrayList;
import java.util.Scanner;

public class Controle {
    public static ArrayList<Estoque> estoques = new ArrayList<>();
    public static float valorTotal = 0;

    public static void submenuControleMateriais() {
        int answ = -1;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("-----Menu Controle de Materiais-----\n1 - Adicionar material\n2 - Remover material\n3 - Listar estoque\n0 - Voltar\nO que deseja fazer?: ");
            answ = sc.nextInt();
            switch (answ) {
                case 1: adicionarEstoque(); break;
                case 2: removerEstoque(); break;
                case 3: listarEstoque(); break;
            }
        } while (answ != 0);
    }

    public static void adicionarEstoque() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o código do material: ");
        int codigo = sc.nextInt();

        System.out.println("Digite a quantidade: ");
        int quantidade = sc.nextInt();
        
        String tipo = null;
        for (int i = 0; i < Main.produtos.size(); i++) {
            if (Main.produtos.get(i).codigo == codigo) {
                tipo = Main.produtos.get(i).tipo;
                valorTotal += quantidade * Main.produtos.get(i).valor;
            }
        }

        if (tipo != null) {
            estoques.add(new Estoque(tipo, codigo, quantidade));
            System.out.println("Item adicionado ao estoque!");
        } else {
            System.out.println("Item não encontrado! Faça o registro de lançamento ou insira o código corretamente.");
        }


    }

    public static void removerEstoque() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o código do material a ser removido: ");
        int codigo = sc.nextInt();

        System.out.println("Digite a quantidade a ser removida: ");
        int quantidade = sc.nextInt();

        Estoque estoqueRemovido = null;
        for (int i = 0; i < estoques.size(); i++) {
            if (estoques.get(i).getCodigo() == codigo) {
                estoqueRemovido = estoques.get(i);
            }
        }

        if (estoqueRemovido != null) {
            if (estoqueRemovido.getQuantidade() > quantidade) {
                estoqueRemovido.setQuantidade(estoqueRemovido.getQuantidade() - quantidade);
                System.out.println("Quantidade removida com sucesso!");
            } else {
                estoques.remove(estoqueRemovido);
                System.out.println("Item removido completamente do estoque!");
            }
        } else {
            System.out.println("Item não encontrado no estoque.");
        }
    }

    public static void listarEstoque() {
        if (estoques.isEmpty()) {
            System.out.println("O estoque está vazio.");
        } else {
            System.out.println("Lista de Estoque:");
            for (int i = 0; i < estoques.size(); i++) {
                estoques.get(i).exibirEstoque();
            }
        }
    }
}
