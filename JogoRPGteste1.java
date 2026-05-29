import java.util.Scanner;

public class JogoRPG {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do seu personagem: ");
        String nome = scanner.nextLine();
        Player player = new Player(nome);

        int cenaAtual = 1;
        boolean jogando = true;

        while (jogando) {
            switch (cenaAtual) {
                case 1:
                    cenaAtual = cenaIntroducao(scanner, player);
                    break;
                case 2:
                    cenaAtual = cenaListaExercicios(scanner, player);
                    break;
                case 3:
                    cenaAtual = cenaProva(scanner, player);
                    break;
                case 99:
                    mostrarFinal(player);
                    jogando = false;
                    break;
                default:
                    System.out.println("Erro: cena inválida.");
                    jogando = false;
            }
        }

        scanner.close();
    }

    private static int cenaIntroducao(Scanner scanner, Player player) {
        System.out.println("\n=== INÍCIO DO SEMESTRE ===");
        System.out.println("Você acabou de entrar na faculdade e terá a disciplina de Algoritmos.");
        System.out.println("1) Vou levar a disciplina muito a sério desde o começo.");
        System.out.println("2) Vou assistir às aulas, mas estudar só perto da prova.");
        System.out.println("3) Vou focar em outras coisas, Algoritmos eu vejo depois.");

        System.out.print("Escolha uma opção: ");
        String escolha = scanner.nextLine();

        switch (escolha) {
            case "1":
                player.aumentarConhecimento(2);
                player.aumentarMotivacao(1);
                return 2;
            case "2":
                player.aumentarMotivacao(1);
                return 2;
            case "3":
                player.diminuirConhecimento(1);
                player.diminuirMotivacao(1);
                return 2;
            default:
                System.out.println("Opção inválida, tente novamente.");
                return 1;
        }
    }

    private static int cenaListaExercicios(Scanner scanner, Player player) {
        System.out.println("\n=== PRIMEIRA LISTA DE EXERCÍCIOS ===");
        return 3;
    }

    private static int cenaProva(Scanner scanner, Player player) {
        System.out.println("\n=== PROVA INTERMEDIÁRIA ===");
        return 99;
    }

    private static void mostrarFinal(Player player) {
        System.out.println("\n=== FINAL DO JOGO ===");
        if (player.getConhecimento() >= 5) {
            System.out.println("Você foi aprovado com uma ótima nota em Algoritmos!");
        } else {
            System.out.println("Você não alcançou a nota necessária. Precisa refazer a disciplina.");
        }
    }
}
