public class Cliente {
    private int id;
    private String nome;
    private boolean premium;

    public Cliente(int id, String nome, boolean premium) {
        this.id = id;
        this.nome = nome;
        this.premium = premium;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public boolean isPremium() {
        return premium;
    }
}