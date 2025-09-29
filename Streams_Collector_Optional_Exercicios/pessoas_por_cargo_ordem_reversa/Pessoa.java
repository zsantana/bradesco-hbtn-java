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
        int cmp = Integer.compare(this.idade, outra.idade); // menor idade primeiro
        if(cmp == 0) {
            cmp = Double.compare(outra.salario, this.salario); // maior salário primeiro
        }
        if(cmp == 0) {
            cmp = Integer.compare(this.codigo, outra.codigo); // menor código primeiro
        }
        return cmp;
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