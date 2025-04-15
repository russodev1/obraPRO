package ttre;

public class Empreitada {
    int id;
    String descricao;
    String status;

    public Empreitada(int id, String descricao, String status) {
        this.id = id;
        this.descricao = descricao;
        this.status = status;
    }

    public void exibirempreitada() {
        System.out.println(toString());
    }

    public String toString() {
        return "----------Sobre a Empreitada------\nID: " + id + "\nDescrição: " + descricao + "\nStatus: " + status;
    }
}
