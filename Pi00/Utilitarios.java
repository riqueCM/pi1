import java.util.Scanner;

public class Utilitarios {

    private static final Scanner scanner = new Scanner(System.in);

    public static Scanner getScanner() {
        return scanner;
    }

    public static int lerOpcao(int minimo, int maximo) {
        int valor;
        while (true) {
            System.out.print("Escolha uma opção: ");
            if (scanner.hasNextInt()) {
                valor = scanner.nextInt();
                scanner.nextLine();
                if (valor >= minimo && valor <= maximo) {
                    return valor;
                }
            } else {
                scanner.nextLine();
            }
            System.out.println("Opção inválida. Tente novamente.");
        }
    }

    public static void pausar() {
        System.out.println("\nPressione ENTER para continuar...");
        scanner.nextLine();
    }

    public static void limparTela() {
        for (int i = 0; i < 25; i++) {
            System.out.println();
        }
    }
}
