package ttre;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static float fluxo = 0;
    public static ArrayList<Produto> produtos = new ArrayList<>();
    public static Gestao gestao = new Gestao();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answ = -1;
        System.out.println("-----Bem vindo ao sistema de controle de obras ObraPRO!-----");

        do {
            System.out.println("-----Menu Principal-----\n1 - Contabilidade\n2 - Controle de materiais\n3 - Gestão de Empreitada\n4 - Relatório e Análise\n0 - Sair\nO que deseja fazer?: ");
            answ = sc.nextInt();
            switch (answ) {
                case 1:
                    Contabilidade.submenuContabilidade(produtos);
                    break;
                case 2:
                    Controle.submenuControleMateriais();
                    break;
                case 3:
                    gestao.submenuGestaoEmpreitada();
                    break;
                case 4:
                    if (gestao.temEmpreitada()) {
                        Relatorio.submenuRelatorio(gestao.getUltimaEmpreitada(), produtos);
                    } else {
                        System.out.println("Nenhuma empreitada foi cadastrada ainda.");
                    }
                    break;
            }

        } while (answ != 0);
        sc.close();
    }
}
