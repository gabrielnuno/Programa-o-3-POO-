package cinema.vetores;

import java.util.Random;

import cinema.Ingresso;

public class VetorDeIngressos implements InterfaceDosVetores {

    private Ingresso[] vetorDeIngressos; // Armazena os ingressos que serão comprados.
    private int quantidade; // Conta quantos ingressos foram armazenados no vetor.

    public VetorDeIngressos(int quantidadeDeIngressos) {
        if (quantidadeDeIngressos <= 0) { // Caso 1.1: quantidade de ingressos menor ou igual a zero.
            this.vetorDeIngressos = new Ingresso[0];
        } else { // Caso 1.2: a quantidade de ingressos é maior do que zero.
            this.vetorDeIngressos = new Ingresso[quantidadeDeIngressos];
        }
        this.quantidade = 0;
    }

    private boolean buscarIngresso(Ingresso ingresso) { // Realiza uma busca para encontrar um código repetido no vetor.
        int i;
        for (i = 0; i < this.quantidade; i = i + 1) {
            if (this.vetorDeIngressos[i].getCodigo() == ingresso.getCodigo()) { // Caso 1.1: códigos iguais iguais.
                return true;
            }
        }
        return false; // Caso 1.2: códigos diferentes.
    }

    public void inserirIngressoNoVetor(Ingresso ingresso) { // Insere um ingresso no vetor de filmes.
        int posicao;
        posicao = this.quantidade;
        if (buscarIngresso(ingresso)) { // Caso 1.1: ingresso com código repetido.
            Random gerador = new Random();
            do {
                ingresso.setCodigo(gerador.nextInt(999999999));
            } while (!buscarIngresso(ingresso));
        } else { // Caso 1.2: ingresso não encontrado no vetor.
            this.vetorDeIngressos[posicao] = ingresso;
            this.quantidade = this.quantidade + 1;
        }
    }

    @Override
    public Double exibirSemDetalhes(int auxiliar) { // Esse método retorna apenas o preçço do ingresso.
        return this.vetorDeIngressos[auxiliar].getPreco();
    }

    @Override
    public Ingresso exibirComDetalhes(int auxiliar) { // Exibe um ingresso com todas as informações.
        return this.vetorDeIngressos[auxiliar];
    }

    @Override
    public Ingresso exibirTodos() { // Exibe todos os itens do vetor.
        Ingresso exibicao;
        int contador;
        for (contador = 0; contador < this.vetorDeIngressos.length; contador = contador + 1) {
            exibicao = this.vetorDeIngressos[contador];
            return exibicao;
        }
        return null;
    }

    public Ingresso[] getVetorDeIngressos() {
        return vetorDeIngressos;
    }

    public void setVetorDeIngressos(Ingresso[] vetorDeIngressos) {
        this.vetorDeIngressos = vetorDeIngressos;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
