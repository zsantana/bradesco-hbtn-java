import java.util.*;
import java.util.stream.*;

public class ConsultaPessoas {
    public static Map<String, TreeSet<String>> obterHobbiesPorCargo(List<Pessoa> pessoas) {
        return pessoas.stream().collect(
                Collectors.groupingBy(
                        Pessoa::getCargo,
                        Collectors.flatMapping(
                                pessoa -> pessoa.getHobbies().stream(),
                                Collectors.toCollection(TreeSet::new)
                        )
                )
        );
    }
}