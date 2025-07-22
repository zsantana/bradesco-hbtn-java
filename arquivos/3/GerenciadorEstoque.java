
import java.util.Scanner;

public class GerenciadorEstoque {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estoque estoque = new Estoque("estoque.csv");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Excluir Produto");
            System.out.println("3. Exibir Estoque");
            System.out.println("4. Atualizar Quantidade de Produto");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao;
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida!");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();
                    int quantidade;
                    double preco;
                    try {
                        System.out.print("Digite a quantidade: ");
                        quantidade = Integer.parseInt(scanner.nextLine());
                        System.out.print("Digite o preço: ");
                        preco = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Quantidade e preço devem ser números válidos.");
                        break;
                    }
                    estoque.adicionarProduto(nome, quantidade, preco);
                    break;
                case 2:
                    System.out.print("Digite o ID do produto a ser excluído: ");
                    int idExcluir;
                    try {
                        idExcluir = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("ID inválido.");
                        break;
                    }
                    estoque.excluirProduto(idExcluir);
                    break;
                case 3:
                    System.out.println("Estoque:");
                    estoque.exibirEstoque();
                    break;
                case 4:
                    System.out.print("Digite o ID do produto: ");
                    int idAtualizar;
                    int novaQuantidade;
                    try {
                        idAtualizar = Integer.parseInt(scanner.nextLine());
                        System.out.print("Digite a nova quantidade: ");
                        novaQuantidade = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("ID e quantidade devem ser números válidos.");
                        break;
                    }
                    estoque.atualizarQuantidade(idAtualizar, novaQuantidade);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}