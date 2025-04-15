package ttre;

import java.util.ArrayList;

public class Produto {
    public int codigo;
    public String tipo;
    public float valor;

    Produto() {}

    Produto(String tipo, float valor, int codigo) {
        this.tipo = tipo;
        this.valor = valor;
        this.codigo = codigo;
    }

    public static void show(ArrayList<Produto> x) {
        for (int i = 0; i < x.size(); i++) {
            System.out.println("Tipo: " + x.get(i).tipo + " | Valor unitário: " + x.get(i).valor + " | Código: " + x.get(i).codigo);
        }
    }
}
