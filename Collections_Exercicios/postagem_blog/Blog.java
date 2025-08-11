import java.util.*;

public class Blog {
    private Set<Post> posts;

    public Blog() {
        this.posts = new HashSet<>();
    }

    public void adicionarPostagem(Post post) {
        if (!posts.add(post)) {
            throw new IllegalArgumentException("Postagem jah existente");
        }
    }

    public Set<Autor> obterTodosAutores() {
        Set<Autor> autores = new TreeSet<>();
        for (Post post : posts) {
            autores.add(post.getAutor());
        }
        return autores;
    }

    public Map<Categorias, Integer> obterContagemPorCategoria() {
        Map<Categorias, Integer> contagem = new HashMap<>();
        for (Post post : posts) {
            contagem.put(post.getCategoria(),
                contagem.getOrDefault(post.getCategoria(), 0) + 1);
        }
        return contagem;
    }

    public Set<Post> obterPostsPorAutor(Autor autor) {
        Set<Post> resultado = new TreeSet<>();
        for (Post post : posts) {
            if (post.getAutor().equals(autor)) {
                resultado.add(post);
            }
        }
        return resultado;
    }

    public Set<Post> obterPostsPorCategoria(Categorias categoria) {
        Set<Post> resultado = new TreeSet<>();
        for (Post post : posts) {
            if (post.getCategoria() == categoria) {
                resultado.add(post);
            }
        }
        return resultado;
    }

    public Map<Categorias, Set<Post>> obterTodosPostsPorCategorias() {
        Map<Categorias, Set<Post>> map = new HashMap<>();
        for (Post post : posts) {
            map.computeIfAbsent(post.getCategoria(), k -> new TreeSet<>()).add(post);
        }
        return map;
    }

    public Map<Autor, Set<Post>> obterTodosPostsPorAutor() {
        Map<Autor, Set<Post>> map = new HashMap<>();
        for (Post post : posts) {
            map.computeIfAbsent(post.getAutor(), k -> new TreeSet<>()).add(post);
        }
        return map;
    }
}