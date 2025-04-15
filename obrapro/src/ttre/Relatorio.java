package ttre;

import java.util.List;
import java.util.Scanner;

public class Relatorio {

    public static void submenuRelatorio(Empreitada empreitada, List<Produto> materiais) {
        Scanner sc = new Scanner(System.in);
        int answ;

        do {
            System.out.println("----- Menu Relatório -----");
            System.out.println("1 - Gerar relatório da última empreitada");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");
            answ = sc.nextInt();

            switch (answ) {
                case 1:
                    String relatorio = gerarRelatorio(empreitada, materiais);
                    System.out.println(relatorio);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (answ != 0);
    }

    public static String gerarRelatorio(Empreitada empreitada, List<Produto> materiais) {

        String materiaisUsados = "";

        for (int i = 0; i < Controle.estoques.size(); i++) {
            materiaisUsados += Controle.estoques.get(i).tipo + "\n";
        }

        float totalValor = Controle.valorTotal;
        String relatorio = "Descrição da Empreitada: " + empreitada.descricao + "\n" +
                           "Status: " + empreitada.status + "\n" +
                           "Materiais Utilizados:" + materiaisUsados + "\n";

        for (Produto produto : materiais) {
            relatorio += "- " + produto.tipo + " (R$ " + produto.valor + ")\n";
        }

        relatorio += "Total gasto em materiais: R$ " + totalValor + "\n";
        return relatorio;
    }
}
