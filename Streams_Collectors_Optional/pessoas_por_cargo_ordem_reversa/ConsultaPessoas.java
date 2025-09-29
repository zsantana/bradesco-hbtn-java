import java.util.*;
import java.util.stream.*;

public class ConsultaPessoas {
    public static TreeMap<String, LinkedHashSet<Pessoa>> obterPessoasAgrupadasPorCargoEmOrdemReversa(List<Pessoa> pessoas) {
        return pessoas.stream()
            .collect(Collectors.groupingBy(
                Pessoa::getCargo,
                () -> new TreeMap<>(Comparator.reverseOrder()),
                Collectors.toCollection(LinkedHashSet::new)
            ));
    }
}