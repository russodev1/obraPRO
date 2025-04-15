package ttre;

public class Contrato {
    int n;
    Empreitada empreitadas;

    public Contrato(int n, Empreitada empreitadas) {
        this.n = n;
        this.empreitadas = empreitadas;
    }

    public void exibircontrato() {
        System.out.println(toString());
    }

    public String toString() {
        return "-----Sobre o Contrato-----\nNúmero: " + n + "\n" + empreitadas.toString();
    }
}
