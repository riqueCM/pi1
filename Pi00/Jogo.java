public class Jogo {

    private Personagem personagem;
    private boolean jogoAtivo = true;

    public void iniciar() {
        while (jogoAtivo) {
            personagem = criarPersonagem();

            menuStatus();

            if (personagem.vivo) Fases.fase1PrimeiraAula(personagem);
            if (personagem.vivo) Fases.fase2ListaExercicios(personagem);
            if (personagem.vivo) Fases.fase3Prova(personagem);
            if (personagem.vivo) Fases.fase4ProjetoGrupo(personagem);
            if (personagem.vivo) Fases.fase5FinalSemestre(personagem);

            encerrarJogo();
        }

        Utilitarios.getScanner().close();
    }

    private Personagem criarPersonagem() {
        Utilitarios.limparTela();
        System.out.println("==============================================");
        System.out.println("   A JORNADA DO CALOURO EM ALGORITMOS");
        System.out.println("==============================================");
        System.out.println("Você é um novo aluno de ADS e precisa sobreviver");
        System.out.println("ao semestre na disciplina de Algoritmos.");
        System.out.println("Cuidado: energia, motivação e vida podem mudar seu destino.");
        System.out.print("Digite o nome do personagem: ");
        String nome = Utilitarios.getScanner().nextLine();

        Personagem p = new Personagem(nome);
        System.out.println("\nBem-vindo, " + nome + "!");
        Utilitarios.pausar();
        return p;
    }

    private void menuStatus() {
        personagem.atualizarNivel();
        Utilitarios.limparTela();
        System.out.println("============== STATUS DO PERSONAGEM ==============");
        personagem.exibirStatus();
        System.out.println("==================================================");
        Utilitarios.pausar();
    }

    private void encerrarJogo() {
        Utilitarios.limparTela();
        personagem.atualizarNivel();

        System.out.println("============== RESULTADO FINAL ==============");
        personagem.exibirStatus();
        System.out.println("=============================================");

        if (!personagem.vivo) {
            System.out.println("FINAL: Game Over.");
            System.out.println("Seu personagem chegou ao limite e não conseguiu concluir o semestre.");
        } else if (personagem.conhecimento >= 9 && personagem.motivacao >= 6 && personagem.energia >= 3) {
            System.out.println("FINAL: Aprovado com excelente desempenho em Algoritmos!");
            System.out.println("Você dominou os fundamentos e encerrou o semestre em destaque.");
        } else if (personagem.conhecimento >= 6 && personagem.motivacao >= 3) {
            System.out.println("FINAL: Aprovado!");
            System.out.println("Você conseguiu vencer os desafios e concluir a disciplina.");
        } else if (personagem.conhecimento >= 3) {
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
        } else {
            jogoAtivo = false;
            System.out.println("Obrigado por jogar!");
        }
    }
}
