import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;

public class ConsultaProdutos {
    public static List<Produto> filtrar(List<Produto> produtos, Predicate<Produto> predicado) {
        List<Produto> listaFiltrada = new ArrayList<>();
        for (Produto p : produtos) {
            if (predicado.test(p)) {
                listaFiltrada.add(p);
            }
        }
        return listaFiltrada;
    }
}