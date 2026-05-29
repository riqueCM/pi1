public class Personagem {

    public String nome;
    public int conhecimento = 0;
    public int motivacao = 5;
    public int energia = 5;
    public int vida = 5;
    public int nivel = 1;
    public boolean vivo = true;

    public Personagem(String nome) {
        this.nome = nome;
    }

    public void alterarStatus(int valorConhecimento, int valorMotivacao, int valorEnergia, int valorVida) {
        conhecimento += valorConhecimento;
        motivacao    += valorMotivacao;
        energia      += valorEnergia;
        vida         += valorVida;

        if (energia == 0) {
            vida -= 1;
            System.out.println("\nSua energia acabou e sua vida foi reduzida.");
        }

        limitarAtributos();
        atualizarNivel();
    }

    public void verificarSituacao() {
        if (vida <= 0 || motivacao <= 0) {
            vivo = false;
            System.out.println("\nGAME OVER: seu personagem chegou ao limite da jornada.");
        }
    }

    public void atualizarNivel() {
        if (conhecimento >= 9)      nivel = 4;
        else if (conhecimento >= 6) nivel = 3;
        else if (conhecimento >= 3) nivel = 2;
        else                        nivel = 1;
    }

    public void limitarAtributos() {
        if (conhecimento < 0)  conhecimento = 0;
        if (motivacao    < 0)  motivacao    = 0;
        if (energia      < 0)  energia      = 0;
        if (vida         < 0)  vida         = 0;

        if (conhecimento > 10) conhecimento = 10;
        if (motivacao    > 10) motivacao    = 10;
        if (energia      > 10) energia      = 10;
        if (vida         > 10) vida         = 10;
    }

    public void reiniciar() {
        conhecimento = 0;
        motivacao    = 5;
        energia      = 5;
        vida         = 5;
        nivel        = 1;
        vivo         = true;
    }

    public void exibirStatus() {
        System.out.println("\n------ STATUS ATUAL ------");
        System.out.println("Nome        : " + nome);
        System.out.println("Conhecimento: " + barraProgresso(conhecimento) + " " + conhecimento + "/10");
        System.out.println("Motivação   : " + barraProgresso(motivacao)    + " " + motivacao    + "/10");
        System.out.println("Energia     : " + barraProgresso(energia)      + " " + energia      + "/10");
        System.out.println("Vida        : " + barraProgresso(vida)         + " " + vida         + "/10");
        System.out.println("Nível       : " + nivel);
        System.out.println("--------------------------");
    }

    private String barraProgresso(int valor) {
        StringBuilder barra = new StringBuilder("[");
        for (int i = 1; i <= 10; i++) {
            barra.append(i <= valor ? "█" : "░");
        }
        barra.append("]");
        return barra.toString();
    }
}
