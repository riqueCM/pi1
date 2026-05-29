public class Jogo {

    public static void iniciar() {
        boolean jogoAtivo = true;

        while (jogoAtivo) {
            criarPersonagem();
            menuStatus();

            if (Personagem.vivo) Fases.fase1PrimeiraAula();
            if (Personagem.vivo) Fases.fase2ListaExercicios();
            if (Personagem.vivo) Fases.fase3Prova();
            if (Personagem.vivo) Fases.fase4ProjetoGrupo();
            if (Personagem.vivo) Fases.fase5FinalSemestre();

            jogoAtivo = encerrarJogo();
        }

        Utilitarios.getScanner().close();
    }

    private static void criarPersonagem() {
        Utilitarios.limparTela();
        System.out.println("==============================================");
        System.out.println("   A JORNADA DO CALOURO EM ALGORITMOS");
        System.out.println("==============================================");
        System.out.println("Você é um novo aluno de ADS e precisa sobreviver");
        System.out.println("ao semestre na disciplina de Algoritmos.");
        System.out.println("Cuidado: energia, motivação e vida podem mudar seu destino.");
        System.out.print("Digite o nome do personagem: ");
        String nome = Utilitarios.getScanner().nextLine();

        Personagem.inicializar(nome);
        System.out.println("\nBem-vindo, " + nome + "!");
        Utilitarios.pausar();
    }

    private static void menuStatus() {
        Personagem.atualizarNivel();
        Utilitarios.limparTela();
        System.out.println("============== STATUS DO PERSONAGEM ==============");
        Personagem.exibirStatus();
        System.out.println("==================================================");
        Utilitarios.pausar();
    }

    private static boolean encerrarJogo() {
        Utilitarios.limparTela();
        Personagem.atualizarNivel();

        System.out.println("============== RESULTADO FINAL ==============");
        Personagem.exibirStatus();
        System.out.println("=============================================");

        if (!Personagem.vivo) {
            System.out.println("FINAL: Game Over.");
            System.out.println("Seu personagem chegou ao limite e não conseguiu concluir o semestre.");
        } else if (Personagem.conhecimento >= 9 && Personagem.motivacao >= 6 && Personagem.energia >= 3) {
            System.out.println("FINAL: Aprovado com excelente desempenho em Algoritmos!");
            System.out.println("Você dominou os fundamentos e encerrou o semestre em destaque.");
        } else if (Personagem.conhecimento >= 6 && Personagem.motivacao >= 3) {
            System.out.println("FINAL: Aprovado!");
            System.out.println("Você conseguiu vencer os desafios e concluir a disciplina.");
        } else if (Personagem.conhecimento >= 3) {
            System.out.println("FINAL: Exame final.");
            System.out.println("Você ainda tem uma chance, mas precisa estudar mais.");
        } else {
            System.out.println("FINAL: Reprovado.");
            System.out.println("As decisões tomadas ao longo do semestre dificultaram sua jornada.");
        }

        System.out.println("\nDeseja jogar novamente?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        int opcao = Utilitarios.lerOpcao(1, 2);

        if (opcao == 1) {
            System.out.println("\nReiniciando aventura...");
            Utilitarios.pausar();
            return true;
        } else {
            System.out.println("Obrigado por jogar!");
            return false;
        }
    }
}
