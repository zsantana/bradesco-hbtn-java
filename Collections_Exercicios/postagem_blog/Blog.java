import java.util.*;

public class Blog {
    private Set<Post> posts;

    public Blog() {
        this.posts = new HashSet<>();
    }

    public void adicionarPostagem(Post post) {
        if (posts.contains(post)) {
            throw new IllegalArgumentException("Postagem jah existente");
        }
        posts.add(post);
    }

    public Set<Autor> obterTodosAutores() {
        return new TreeSet<>(
            posts.stream().map(Post::getAutor).toList()
        );
    }

    public Map<Categorias, Integer> obterContagemPorCategoria() {
        EnumMap<Categorias, Integer> contagem = new EnumMap<>(Categorias.class);
        for (Post p : posts) {
            contagem.put(p.getCategoria(), contagem.getOrDefault(p.getCategoria(), 0) + 1);
        }
        return contagem;
    }

    public Set<Post> obterPostsPorAutor(Autor autor) {
        Set<Post> result = new TreeSet<>();
        for (Post p : posts) {
            if (p.getAutor().equals(autor)) result.add(p);
        }
        return result;
    }

    public Set<Post> obterPostsPorCategoria(Categorias categoria) {
        Set<Post> result = new TreeSet<>();
        for (Post p : posts) {
            if (p.getCategoria() == categoria) result.add(p);
        }
        return result;
    }

    public Map<Categorias, Set<Post>> obterTodosPostsPorCategorias() {
        EnumMap<Categorias, Set<Post>> map = new EnumMap<>(Categorias.class);
        for (Categorias cat : Categorias.values())
            map.put(cat, new TreeSet<>());

        for (Post p : posts) {
            map.get(p.getCategoria()).add(p);
        }
        return map;
    }

    public Map<Autor, Set<Post>> obterTodosPostsPorAutor() {
        TreeMap<Autor, Set<Post>> map = new TreeMap<>();
        for (Post p : posts) {
            map.computeIfAbsent(p.getAutor(), k -> new TreeSet<>()).add(p);
        }
        return map;
    }
}