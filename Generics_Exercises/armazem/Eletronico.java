public class Eletronico {
    private String descricao;
    private double valor;

    public Eletronico(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    @Override
    public String toString() {
        // [<descricao>] R$ <valor>.
        return String.format("[%s] R$ %.6f", descricao, valor);
    }

    // Getters and setters, if needed (not required for this task)
}