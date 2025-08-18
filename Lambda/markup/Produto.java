import java.util.function.Supplier;
import java.util.function.Consumer;

public class Produto {
    private String nome;
    private double preco;
    private double percentualMarkup = 10; // valor inicial de 10%

    public Produto(double preco, String nome) {
        this.preco = preco;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    // Supplier para calcular o preço acrescido do markup
    public Supplier<Double> precoComMarkup = () -> {
        return preco * (1 + percentualMarkup / 100.0);
    };

    // Consumer para atualizar o percentual de markup
    public Consumer<Double> atualizarMarkup = novoMarkup -> {
        percentualMarkup = novoMarkup;
    };
}