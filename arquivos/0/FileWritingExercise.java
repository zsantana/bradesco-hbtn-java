import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWritingExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita o nome do arquivo
        System.out.print("Digite o nome do arquivo (com extensão .txt): ");
        String fileName = scanner.nextLine();

        // implemente o codigo aqui
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            while (true) {
                System.out.print("Digite uma linha de texto (ou 'sair' para finalizar): ");
                String line = scanner.nextLine();
                if (line.equals("sair")) {
                    break;
                }
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Arquivo '" + fileName + "' criado e salvo com sucesso!");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao escrever no arquivo: " + e.getMessage());
        }

        scanner.close();
    }
}