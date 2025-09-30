import java.util.LinkedList;
import java.util.List;

public class Fila {
    private final List<Integer> fila = new LinkedList<>();
    private final int capacidade;

    public Fila(int capacidade) {
        this.capacidade = capacidade;
    }

    // Adiciona item na fila, bloqueia produtor se fila cheia
    public synchronized void adicionar(int item) throws InterruptedException {
        while (fila.size() >= capacidade) {
            wait();
        }
        fila.add(item);
        System.out.println("Adicionado: " + item + " | Fila: " + fila.size());
        notifyAll();
    }

    // Retira item da fila, bloqueia consumidor se fila vazia
    public synchronized int retirar() throws InterruptedException {
        while (fila.isEmpty()) {
            wait();
        }
        int item = fila.remove(0);
        System.out.println("Removido: " + item + " | Fila: " + fila.size());
        notifyAll();
        return item;
    }
}