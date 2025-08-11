public class Tarefa {
    private String descricao;
    private boolean estahFeita;
    private int identificador;

    public Tarefa(String descricao, int identificador) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descricao de tarefa invalida");
        }
        this.descricao = descricao;
        this.identificador = identificador;
        this.estahFeita = false;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean estahFeita() {
        return estahFeita;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void modificarDescricao(String novaDescricao) {
        if (novaDescricao == null || novaDescricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descricao de tarefa invalida");
        }
        this.descricao = novaDescricao;
    }

    public void marcarFeita() {
        this.estahFeita = true;
    }

    public void desfazer() {
        this.estahFeita = false;
    }
}