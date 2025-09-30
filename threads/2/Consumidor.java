public class Consumidor extends Thread {
    private final Fila fila;

    public Consumidor(Fila fila) {
        this.fila = fila;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int item = fila.retirar();
                // Simula processamento do item
                System.out.println("Consumindo: " + item);
                Thread.sleep(500); // 0.5s para consumir/processar
            }
        } catch (InterruptedException e) {
            System.out.println("Consumidor encerrado.");
        }
    }
}