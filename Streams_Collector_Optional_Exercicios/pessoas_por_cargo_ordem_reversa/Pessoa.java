import java.util.*;

public class Pessoa implements Comparable<Pessoa> {
    private int codigo;
    private String nome;
    private String cargo;
    private int idade;
    private double salario;

    public Pessoa(int codigo, String nome, String cargo, int idade, double salario) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargo = cargo;
        this.idade = idade;
        this.salario = salario;
    }

    @Override
    public int compareTo(Pessoa outra) {
        int comp = Double.compare(outra.salario, this.salario); // decrescente
        if (comp == 0)
            comp = Integer.compare(this.codigo, outra.codigo); // crescente
        return comp;
    }

    @Override
    public String toString() {
        String s = String.format("[%d] %s %s %d R$ %.6f", codigo, nome, cargo, idade, salario);
        return s.replace(".", ",");
    }

    public String getCargo() {
        return cargo;
    }
}