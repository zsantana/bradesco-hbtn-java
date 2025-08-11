public class Comida {
    private String nome;
    private int calorias;
    private double preco;

    public Comida(String nome, int calorias, double preco) {
        this.nome = nome;
        this.calorias = calorias;
        this.preco = preco;
    }

    @Override
    public String toString() {
        // [<nome>] <calorias> R$ <preco>.
        return String.format("[%s] %d,000000 R$ %.6f", nome, calorias, preco);
    }

    // Getters and setters, if needed (not required for this task)
}