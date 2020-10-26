package aplicacao;

public class VacCINE { // Classe principal.

    public static void main(String[] arguments) {
        iniciarAplicacao();
    }

    public static void iniciarAplicacao() { // Inicia a aplicação.
        Cinema aplicacao = new Cinema();
        aplicacao.gerenciadorDeTarefas();
    }

}
