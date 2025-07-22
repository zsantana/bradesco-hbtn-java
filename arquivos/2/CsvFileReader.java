import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvFileReader {
    public static void main(String[] args) {
        String arquivo = "funcionarios.csv";
        BufferedReader br = null;
        String linha;

        try {
            br = new BufferedReader(new FileReader(arquivo));
            boolean primeiraLinha = true;
            while ((linha = br.readLine()) != null) {
                // Ignora linhas em branco
                if (linha.trim().isEmpty()) {
                    continue;
                }
                String[] dados = linha.split(",");
                if (primeiraLinha) {
                    System.out.println("Funcionário: " + dados[0]);
                    System.out.println("Idade: " + dados[1]);
                    System.out.println("Departamento: " + dados[2]);
                    System.out.println("Salarial: " + dados[3]);
                    System.out.println("------------------------");
                    primeiraLinha = false;
                } else {
                    System.out.println("Funcionário: " + dados[0]);
                    System.out.println("Idade: " + dados[1]);
                    System.out.println("Departamento: " + dados[2]);
                    System.out.println("Salarial: " + dados[3]);
                    System.out.println("------------------------");
                }
            }
            System.out.println("Leitura do arquivo concluída.");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo.");
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                System.out.println("Erro ao fechar o arquivo.");
            }
        }
    }
}