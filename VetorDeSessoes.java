package cinema.vetores;

import javax.swing.JOptionPane;

import cinema.Sessao;
import cinema.Filme;

public class VetorDeSessoes {

    private Sessao[] vetorDeSessoes; // Armazena todas a sessões cadastradas.
    private int contador; // Conta quantas sessões foram cadastradas no vetor.

    public VetorDeSessoes(int quantidadeDeSessoes) {
        if (quantidadeDeSessoes <= 0) { // Caso 1.1: quantidade de sessões menor ou igual a zero.
            this.vetorDeSessoes = new Sessao[0];
        } else { // Caso 1.2: quantidade de sessões maior do que zero.
            this.vetorDeSessoes = new Sessao[quantidadeDeSessoes];
        }
        this.contador = 0; // Inicializa o contador com o valor igual a zero.
    }

    private boolean buscarSessao(Sessao sessao) { // Realiza uma busca para encontrar uma determinada sala no vetor.
        int i;
        for (i = 0; i < this.contador; i = i + 1) {
            if (this.vetorDeSessoes[i].getSala().getNumero() == sessao.getSala().getNumero() && this.vetorDeSessoes[i].getData().compareTo(sessao.getData()) == 0 && this.vetorDeSessoes[i].getHorario().compareTo(sessao.getHorario()) == 0) { // Caso 1.1: números iguais.
                return true;
            }
        }
        return false; // Caso 1.2: não encontrou números iguais.
    }

    public int buscarPosicao(Filme filme) { // Busca uma sessão de um determinado filme.
        int auxiliar;
        for (auxiliar = 0; auxiliar < this.contador; auxiliar = auxiliar = 1) {
            if (this.vetorDeSessoes[auxiliar].getFilme().getTitulo().compareTo(filme.getTitulo()) == 0) {
                return auxiliar;
            }
        }
        return -1;
    }

    public void inserirSessaoNoVetor(Sessao sessao) { // Insere uma sessão no vetor.
        int posicao;
        posicao = this.contador;
        if (buscarSessao(sessao)) { // Caso 1.1: sessão encontrada através do método de busca.
            JOptionPane.showMessageDialog(null, "A sessão já foi cadastrada.");
        } else { // Caso 1.2: sessão não encontrada no vetor.
            this.vetorDeSessoes[posicao] = sessao;
            this.contador = this.contador + 1;
        }
    }

    public Sessao exibirComDetalhes(int auxiliar) { // Exibe todos os detalhes da uma sessão.
        return this.vetorDeSessoes[auxiliar];
    }

    public StringBuilder exibirSessoes(Filme filme) { // Exibe todas as sessões com um determinado filme.
        StringBuilder confirmacao;
        String complemento;
        int auxiliar;
        confirmacao = new StringBuilder("Escolha uma sessão na lista abaixo: \n");
        for (auxiliar = 0; auxiliar < this.contador; auxiliar = auxiliar + 1) {
            if (this.vetorDeSessoes[auxiliar].getFilme().getTitulo().compareTo(filme.getTitulo()) == 0) {
                complemento = "1 - " + this.vetorDeSessoes[auxiliar].toString();
                confirmacao.append(complemento);
            }
        }
        return confirmacao;
    }

    public Sessao[] getVetorDeSessoes() {
        return vetorDeSessoes;
    }

    public void setVetorDeSessoes(Sessao[] vetorDeSessoes) {
        this.vetorDeSessoes = vetorDeSessoes;
    }

    public int getContador() {
        return contador;
    }

}
