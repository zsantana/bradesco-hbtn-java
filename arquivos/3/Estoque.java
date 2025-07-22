
import java.io.*;
import java.util.*;

public class Estoque {
    private List<Produto> produtos;
    private String arquivo;

    public Estoque(String arquivo) {
        this.arquivo = arquivo;
        this.produtos = new ArrayList<>();
        carregarProdutos();
    }

    private void carregarProdutos() {
        produtos.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(",");
                if (campos.length == 4) {
                    try {
                        int id = Integer.parseInt(campos[0]);
                        String nome = campos[1];
                        int quantidade = Integer.parseInt(campos[2]);
                        double preco = Double.parseDouble(campos[3]);
                        produtos.add(new Produto(id, nome, quantidade, preco));
                    } catch (NumberFormatException e) {
                        // Ignora linhas inválidas
                    }
                }
            }
        } catch (FileNotFoundException e) {
            // Arquivo não existe ainda, tudo bem
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    private void salvarProdutos() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            for (Produto p : produtos) {
                bw.write(p.toCsv());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

    private int gerarNovoId() {
        // Encontra o menor ID disponível
        Set<Integer> idsUsados = new HashSet<>();
        for (Produto p : produtos) {
            idsUsados.add(p.getId());
        }
        
        // Procura o menor ID disponível começando de 1
        int id = 1;
        while (idsUsados.contains(id)) {
            id++;
        }
        return id;
    }

    public void adicionarProduto(String nome, int quantidade, double preco) {
        if (quantidade < 0 || preco < 0) {
            System.out.println("Quantidade e preço devem ser positivos.");
            return;
        }
        int id = gerarNovoId();
        Produto novo = new Produto(id, nome, quantidade, preco);
        produtos.add(novo);
        salvarProdutos();
        // System.out.println("Produto adicionado com ID: " + id);
    }

    public void excluirProduto(int id) {
        boolean removido = false;
        Iterator<Produto> it = produtos.iterator();
        while (it.hasNext()) {
            Produto p = it.next();
            if (p.getId() == id) {
                it.remove();
                removido = true;
                break;
            }
        }
        if (removido) {
            salvarProdutos();
            // System.out.println("Produto removido.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void exibirEstoque() {
        if (produtos.isEmpty()) {
            System.out.println("Estoque vazio.");
        } else {
            for (Produto p : produtos) {
                System.out.println(p);
            }
        }
    }

    public void atualizarQuantidade(int id, int novaQuantidade) {
        if (novaQuantidade < 0) {
            System.out.println("Quantidade deve ser positiva.");
            return;
        }
        boolean encontrado = false;
        for (Produto p : produtos) {
            if (p.getId() == id) {
                p.setQuantidade(novaQuantidade);
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            salvarProdutos();
            // System.out.println("Quantidade atualizada.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }
}