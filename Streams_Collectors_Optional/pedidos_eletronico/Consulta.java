import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

public class Consulta {
    
     public static List<Produto> obterProdutosPorPrecoMinimo(List<Produto> produtos, double precoMinimo) {
        return produtos.stream()
                .filter(produto -> produto.getPreco() >= precoMinimo)
                .collect(Collectors.toList());
    }
   
    public static Produto obterProdutoMaiorPreco(List<Produto> produtos) {
        return produtos.stream()
                .max(Comparator.comparing(Produto::getPreco))
                .orElse(null);
    }

    public static List<Pedido> obterPedidosComEletronicos(List<Pedido> pedidos) {
        return pedidos.stream()
            .filter(pedido -> 
                pedido.getProdutos().stream()
                    .anyMatch(produto -> produto.getCategoria() == CategoriaProduto.ELETRONICO)
            )
            .collect(Collectors.toList());
    }
}