public class Fases {

    public static void fase1PrimeiraAula(Personagem p) {
        Utilitarios.limparTela();
        System.out.println("══════════════════════════════════════");
        System.out.println("  FASE 1 - PRIMEIRA AULA");
        System.out.println("══════════════════════════════════════");
        System.out.println("O professor explica que Algoritmos será a base do curso.");
        System.out.println("O que você faz?");
        System.out.println("1 - Levo a disciplina a sério desde o começo");
        System.out.println("2 - Vou empurrar com a barriga e estudar depois");
        System.out.println("3 - Tento prestar atenção, mas sem exagero");
        int opcao = Utilitarios.lerOpcao(1, 3);

        if (opcao == 1) {
            p.alterarStatus(2, 2, -1, 0);
            System.out.println("Boa escolha! Você começou o semestre com foco.");
        } else if (opcao == 2) {
            p.alterarStatus(-1, -1, 0, 0);
            System.out.println("Você subestimou a disciplina e perdeu ritmo.");
        } else {
            p.alterarStatus(1, 1, 0, 0);
            System.out.println("Você manteve uma postura equilibrada.");
        }

        p.exibirStatus();
        p.verificarSituacao();
        Utilitarios.pausar();
    }

    public static void fase2ListaExercicios(Personagem p) {
        Utilitarios.limparTela();
        System.out.println("══════════════════════════════════════");
        System.out.println("  FASE 2 - LISTA DE EXERCÍCIOS");
        System.out.println("══════════════════════════════════════");
        System.out.println("Chegou a primeira lista com problemas de lógica.");
        System.out.println("1 - Resolver sozinho com calma");
        System.out.println("2 - Copiar de um colega");
        System.out.println("3 - Pedir ajuda e tentar entender");
        int opcao = Utilitarios.lerOpcao(1, 3);

        switch (opcao) {
            case 1:
                p.alterarStatus(3, 1, -2, 0);
                System.out.println("Você aprendeu bastante praticando.");
                break;
            case 2:
                p.alterarStatus(-1, -2, 0, -1);
                System.out.println("Você entregou, mas não aprendeu de verdade.");
                break;
            case 3:
                p.alterarStatus(2, 2, -1, 0);
                System.out.println("Ótimo! Você aprendeu com apoio sem depender dos outros.");
                break;
            default:
                System.out.println("Opção inesperada.");
                break;
        }

        p.exibirStatus();
        p.verificarSituacao();
        Utilitarios.pausar();
    }

    public static void fase3Prova(Personagem p) {
        Utilitarios.limparTela();
        System.out.println("══════════════════════════════════════");
        System.out.println("  FASE 3 - PROVA INTERMEDIÁRIA");
        System.out.println("══════════════════════════════════════");
        System.out.println("A prova chegou. Como você reage?");
        System.out.println("1 - Revisar conteúdo e confiar no que estudou");
        System.out.println("2 - Tentar colar");
        System.out.println("3 - Ir sem estudar e torcer");
        int opcao = Utilitarios.lerOpcao(1, 3);

        if (opcao == 1) {
            if (p.conhecimento >= 4) {
                p.alterarStatus(2, 2, -1, 0);
                System.out.println("Você foi muito bem na prova!");
            } else {
                p.alterarStatus(0, 1, -1, 0);
                System.out.println("Você se esforçou, mas percebeu que precisa praticar mais.");
            }
        } else if (opcao == 2) {
            p.alterarStatus(-2, -3, -1, -2);
            System.out.println("Você foi pego tentando colar e sofreu uma grande penalidade.");
        } else {
            p.alterarStatus(0, -2, -1, -1);
            System.out.println("A prova foi difícil e a falta de estudo pesou.");
        }

        p.exibirStatus();
        p.verificarSituacao();
        Utilitarios.pausar();
    }

    public static void fase4ProjetoGrupo(Personagem p) {
        Utilitarios.limparTela();
        System.out.println("══════════════════════════════════════");
        System.out.println("  FASE 4 - PROJETO EM GRUPO");
        System.out.println("══════════════════════════════════════");
        System.out.println("Seu grupo precisa entregar um trabalho prático.");
        System.out.println("1 - Assumir a parte do código e ajudar o grupo");
        System.out.println("2 - Fazer só o mínimo e deixar os outros resolverem");
        System.out.println("3 - Organizar tarefas e colaborar com todos");
        int opcao = Utilitarios.lerOpcao(1, 3);

        switch (opcao) {
            case 1:
                p.alterarStatus(2, 1, -2, 0);
                System.out.println("Você evoluiu tecnicamente com o desafio.");
                break;
            case 2:
                p.alterarStatus(-1, -2, 0, -1);
                System.out.println("Seu grupo percebeu sua falta de compromisso.");
                break;
            case 3:
                p.alterarStatus(2, 2, -1, 0);
                System.out.println("Boa liderança e boa colaboração renderam bons resultados.");
                break;
            default:
                System.out.println("Opção inesperada.");
                break;
        }

        p.exibirStatus();
        p.verificarSituacao();
        Utilitarios.pausar();
    }

    public static void fase5FinalSemestre(Personagem p) {
        Utilitarios.limparTela();
        System.out.println("══════════════════════════════════════");
        System.out.println("  FASE 5 - RETA FINAL");
        System.out.println("══════════════════════════════════════");
        System.out.println("Chegou a última semana. O que você faz?");
        System.out.println("1 - Monta um plano de revisão completo");
        System.out.println("2 - Decora respostas sem entender");
        System.out.println("3 - Desiste porque acha que não dá mais tempo");
        int opcao = Utilitarios.lerOpcao(1, 3);

        if (opcao == 1) {
            p.alterarStatus(3, 2, -1, 0);
            System.out.println("Seu esforço final consolidou o aprendizado.");
        } else if (opcao == 2) {
            p.alterarStatus(1, -1, -1, 0);
            System.out.println("Você até tenta recuperar, mas sem base sólida.");
        } else {
            p.alterarStatus(-1, -3, -1, -2);
            System.out.println("Você perdeu a chance de reagir na reta final.");
        }

        p.exibirStatus();
        p.verificarSituacao();
        Utilitarios.pausar();
    }
}
