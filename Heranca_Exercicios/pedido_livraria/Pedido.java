import produtos.Produto;
import produtos.Livro;
import produtos.Dvd;


public class Pedido {

    private double percentualDesconto;
    private ItemPedido[] itens;

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }
    

    public double calcularTotal() {
        double total = 0.0;

        for (ItemPedido item : itens) {
            total += item.getProduto().obterPrecoLiquido() * item.getQuantidade();
        }

        return total * (1 - percentualDesconto / 100);
    }


    public void apresentarResumoPedido() {
        System.out.println("-------- RESUMO PEDIDO -------");
        
        double totalProdutos = 0;
        
        // Exibir cada item do pedido
        for (ItemPedido item : itens) {
            if (item != null) {
                Produto produto = item.getProduto();
                double precoLiquido = produto.obterPrecoLiquido();
                double totalItem = item.getQuantidade() * precoLiquido;
                totalProdutos += totalItem;
                
                String tipo = (produto instanceof Livro) ? "Livro" : "Dvd";
                
                System.out.printf("Tipo: %s  Título: %s  Preço: %.2f  Quant: %d  Total: %.2f%n",
                                tipo, produto.getTitulo(), precoLiquido, item.getQuantidade(), totalItem);
            }
        }
        
        System.out.println("---------------------------");
        
        // Calcular desconto em valor
        double valorDesconto = totalProdutos * (percentualDesconto / 100);
        double totalFinal = totalProdutos - valorDesconto;
        
        System.out.printf("DESCONTO: %.2f%n", valorDesconto);
        System.out.printf("TOTAL PRODUTOS: %.2f%n", totalProdutos);
        System.out.println("---------------------------");
        System.out.printf("TOTAL PEDIDO: %.2f%n", totalFinal);
        System.out.println("---------------------------");
    }
}