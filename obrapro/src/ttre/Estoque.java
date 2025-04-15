package ttre;

public class Estoque {
    public int codigo;
    public int quantidade;
    String tipo;

    public Estoque(String tipo, int codigo, int quantidade) {
        this.tipo = tipo;
        this.codigo = codigo;
        this.quantidade = quantidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void exibirEstoque() {
        System.out.println("Tipo: " + tipo + ", Código: " + codigo + ", Quantidade: " + quantidade);
    }
}
