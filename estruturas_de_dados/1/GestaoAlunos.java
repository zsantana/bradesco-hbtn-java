import java.util.ArrayList;
import java.util.List;

public class GestaoAlunos {
    private List<Aluno> alunos;

    public GestaoAlunos() {
        this.alunos = new ArrayList<>();
    }

    public void adicionarAluno(String nome, int idade) {
        Aluno aluno = new Aluno(nome, idade);
        alunos.add(aluno);
        System.out.println("Aluno adicionado: " + aluno);
    }

    public void excluirAluno(String nome) {
        Aluno alunoParaRemover = null;
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                alunoParaRemover = aluno;
                break;
            }
        }
        if (alunoParaRemover != null) {
            alunos.remove(alunoParaRemover);
            System.out.println("Aluno removido: " + alunoParaRemover);
        } else {
            System.out.println("Aluno não encontrado: " + nome);
        }
    }

    public void buscarAluno(String nome) {
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Aluno encontrado: " + aluno);
                return;
            }
        }
        System.out.println("Aluno não encontrado: " + nome);
    }

    public void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            System.out.println("Lista de alunos:");
            for (Aluno aluno : alunos) {
                System.out.println(aluno);
            }
        }
    }

    public static void main(String[] args) {
        GestaoAlunos gestaoAlunos = new GestaoAlunos();

        // Adicionando alunos
        gestaoAlunos.adicionarAluno("João", 20);
        gestaoAlunos.adicionarAluno("Maria", 22);
        gestaoAlunos.adicionarAluno("Pedro", 19);

        // Listando alunos
        gestaoAlunos.listarAlunos();

        // Buscando um aluno
        gestaoAlunos.buscarAluno("Maria");

        // Excluindo um aluno
        gestaoAlunos.excluirAluno("João");

        // Tentando excluir um aluno inexistente
        gestaoAlunos.excluirAluno("Carlos");

        // Buscando um aluno inexistente
        gestaoAlunos.buscarAluno("Ana");

        // Listando alunos novamente
        gestaoAlunos.listarAlunos();
    }
}