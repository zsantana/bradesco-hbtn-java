public class Produto {
    private int id;
    private String nome;
    private CategoriaProduto categoria;
    private double preco;

    public Produto(int id, String nome, CategoriaProduto categoria, double preco) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public CategoriaProduto getCategoria() {
        return categoria;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s %s R$ %.2f", id, nome, categoria.name(), preco).replace('.', ',');
    }
}