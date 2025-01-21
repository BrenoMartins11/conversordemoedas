import java.util.Scanner;

// Classe principal
public class ConversorMoedas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Exibe as opções para o usuário
        System.out.println("Bem-vindo ao Conversor de Moedas!");
        System.out.println("Escolha a moeda de origem:");
        System.out.println("1. Real (BRL)");
        System.out.println("2. Dólar (USD)");
        System.out.println("3. Euro (EUR)");
        int opcaoOrigem = scanner.nextInt();

        System.out.println("Escolha a moeda de destino:");
        System.out.println("1. Real (BRL)");
        System.out.println("2. Dólar (USD)");
        System.out.println("3. Euro (EUR)");
        int opcaoDestino = scanner.nextInt();

        System.out.print("Digite o valor a ser convertido: ");
        double valor = scanner.nextDouble();

        // Cria uma instância do conversor
        MoedaConversor conversor = new MoedaConversor();
        double resultado = conversor.converter(opcaoOrigem, opcaoDestino, valor);

        if (resultado != -1) {
            System.out.printf("Valor convertido: %.2f\n", resultado);
        } else {
            System.out.println("Opção inválida! Verifique as moedas escolhidas.");
        }

        scanner.close();
    }
}

// Classe para conversão de moedas
class MoedaConversor {
    // Método para realizar a conversão
    public double converter(int moedaOrigem, int moedaDestino, double valor) {
        // Taxas de câmbio (valores fictícios para demonstração)
        double[][] taxasCambio = {
                {1.0, 0.20, 0.18}, // BRL para BRL, USD, EUR
                {5.0, 1.0, 0.90},  // USD para BRL, USD, EUR
                {5.5, 1.1, 1.0}    // EUR para BRL, USD, EUR
        };

        // Verifica se as opções são válidas
        if (moedaOrigem < 1 || moedaOrigem > 3 || moedaDestino < 1 || moedaDestino > 3) {
            return -1; // Retorna -1 em caso de erro
        }

        // Ajusta os índices para o array (0-based)
        int origemIndex = moedaOrigem - 1;
        int destinoIndex = moedaDestino - 1;

        // Realiza a conversão
        return valor * taxasCambio[origemIndex][destinoIndex];
    }
}
