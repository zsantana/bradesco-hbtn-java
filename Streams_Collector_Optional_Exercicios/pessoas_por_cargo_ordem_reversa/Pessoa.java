
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

    public String getCargo() {
        return cargo;
    }

    @Override
    public int compareTo(Pessoa outra) {
        // ordem: maior idade, maior salário, menor código
        int cmp = Integer.compare(outra.idade, this.idade); // DECRESCENTE
        if(cmp == 0) {
            cmp = Double.compare(outra.salario, this.salario); // DECRESCENTE
        }
        if(cmp == 0) {
            cmp = Integer.compare(this.codigo, outra.codigo); // CRESCENTE
        }
        return cmp;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s %s %d R$ %.6f", codigo, nome, cargo, idade, salario).replace(".", ",");
    }
}

