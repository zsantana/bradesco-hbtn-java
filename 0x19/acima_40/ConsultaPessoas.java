import java.util.*;
import java.util.stream.*;

public class ConsultaPessoas {
    public static Map<String, List<Pessoa>> obterPessoasPorCargoAcimaDe40anos(List<Pessoa> pessoas) {
        return pessoas.stream()
            .collect(Collectors.groupingBy(
                Pessoa::getCargo,
                Collectors.filtering(p -> p.getIdade() > 40, Collectors.toList())
            ));
    }
}