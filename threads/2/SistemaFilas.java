
public class SistemaFilas {
    public static void main(String[] args) {
        Fila fila = new Fila(10); // capacidade de 10 elementos

        // cria 2 produtores e 2 consumidores
        Produtor p1 = new Produtor(fila);
        Produtor p2 = new Produtor(fila);
        Consumidor c1 = new Consumidor(fila);
        Consumidor c2 = new Consumidor(fila);

        p1.start();
        p2.start();
        c1.start();
        c2.start();

        // deixa o sistema rodar por 20 segundos
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Encerrando o sistema...");
        System.exit(0);
    }
}