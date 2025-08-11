import java.util.*;

public class Biblioteca<T extends Midia> {
    private List<T> listaMidias = new ArrayList<>();

    public void adicionarMidia(T midia) {
        listaMidias.add(midia);
    }

    public List<T> obterListaMidias() {
        return listaMidias;
    }
}