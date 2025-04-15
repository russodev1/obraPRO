package ttre;

import java.util.Scanner;

public class Gestao {
    Empreitada[] empreitadas;
    Contrato[] contratos;
    int nempreitadas = 0;
    int ncontratos = 0;
    int proxid = 1;
    int proxicon = 100;

    public Gestao() {
        this.empreitadas = new Empreitada[10];
        this.contratos = new Contrato[10];
    }

    public boolean temEmpreitada() {
        return nempreitadas > 0;
    }

    public Empreitada getUltimaEmpreitada() {
        if (nempreitadas > 0) {
            return empreitadas[nempreitadas - 1];
        }
        return null;
    }

    public void criandocontrato(String descricao) {
        if (nempreitadas >= empreitadas.length) {
            System.out.println("Não foi possível efetuar o contrato! Máximo de obras atingido!");
            return;
        }
        Empreitada novaemprei = new Empreitada(proxid, descricao, "Em andamento");
        Contrato novocontrato = new Contrato(proxicon, novaemprei);
        empreitadas[nempreitadas] = novaemprei;
        contratos[ncontratos] = novocontrato;

        System.out.println("Contrato criado com sucesso!");
        novocontrato.exibircontrato();

        nempreitadas++;
        ncontratos++;
        proxid++;
        proxicon++;
    }

    public void atualizarStatus(int id, String novoStatus) {
        boolean encontrado = false;
        for (int i = 0; i < nempreitadas; i++) {
            if (empreitadas[i].id == id) {
                empreitadas[i].status = novoStatus;
                System.out.println("Empreitada atualizada com sucesso!");
                empreitadas[i].exibirempreitada();
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Empreitada não encontrado!");
        }
    }

    public void verempreitada() {
        if (nempreitadas == 0) {
            System.out.println("Nenhuma empreitada encontrada!");
        } else {
            for (int i = 0; i < nempreitadas; i++) {
                empreitadas[i].exibirempreitada();
            }
        }
    }

    public void submenuGestaoEmpreitada() {
        Scanner sc = new Scanner(System.in);
        int answ = -1;
        do {
            System.out.println("-----Menu Gestão de Empreitada-----\n1 - Criar contrato\n2 - Atualizar status de empreitada\n3 - Ver empreitadas\n0 - Voltar\nO que deseja fazer?: ");
            answ = sc.nextInt();
            sc.nextLine();

            switch (answ) {
                case 1:
                    System.out.println("Digite a descrição da empreitada: ");
                    String desc = sc.nextLine();
                    criandocontrato(desc);
                    break;
                case 2:
                    System.out.println("Digite o ID da empreitada: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite o novo status: ");
                    String status = sc.nextLine();
                    atualizarStatus(id, status);
                    break;
                case 3:
                    verempreitada();
                    break;
            }
        } while (answ != 0);
    }
}
