package cinema.vetores;

import javax.swing.JOptionPane;

import cinema.Sala;

public class VetorDeSalas implements InterfaceDosVetores { // Implementa a interface InterfaceDosVetores.

    private Sala[] vetorDeSalas; // Armazena todas as salas cadastradas.
    private int contador; // Conta quantas salas foram cadastradas no vetor.

    public VetorDeSalas(int quantidadeDeSalas) {
        if (quantidadeDeSalas <= 0) { // Caso 1.1: quantidade de salas menor ou igual a zero.
            this.vetorDeSalas = new Sala[0];
        } else { // Caso 1.2: quantidade de salas maior do que zero.
            this.vetorDeSalas = new Sala[quantidadeDeSalas];
        }
        this.contador = 0; // Inicializa o contador com o valor igual a zero.
    }

    private boolean buscarSala(Sala sala) { // Realiza uma busca para encontrar uma determinada sala no vetor.
        int i;
        for (i = 0; i < this.contador; i = i + 1) {
            if (this.vetorDeSalas[i].getNumero() == sala.getNumero()) { // Caso 1.1: números iguais.
                return true;
            }
        }
        return false; // Caso 1.2: não encontrou números iguais.
    }

    public void inserirSalaNoVetor(Sala sala) { // Insere uma sala no vetor de salas.
        int posicao;
        posicao = this.contador;
        if (buscarSala(sala)) { // Caso 1.1: sala encontrada através do método de busca.
            JOptionPane.showMessageDialog(null, "A sala " + sala.getNumero() + " já foi cadastrada.");
        } else { // Caso 1.2: sala não encontrada no vetor.
            this.vetorDeSalas[posicao] = sala;
            this.contador = this.contador + 1;
        }
    }

    public void ocuparMatriz(int i, int l, int c) {
        this.vetorDeSalas[i].ocuparLugar(l, c);
    }

    public StringBuilder matriz(int i) {
        return this.vetorDeSalas[i].exibirMatriz();
    }

    @Override
    public String exibirSemDetalhes(int auxiliar) { // Exibe apenas as informações básicas de uma sala.
        return "Número: " + this.vetorDeSalas[auxiliar].getNumero() + " ";
    }

    @Override
    public Sala exibirComDetalhes(int auxiliar) { // Exibe todos os detalhes da uma sala.
        return this.vetorDeSalas[auxiliar];
    }

    @Override
    public Sala exibirTodos() { // Exibe todos os itens do vetor.
        Sala exibicao;
        int i;
        for (i = 0; i < this.vetorDeSalas.length; i = i + 1) {
            exibicao = this.vetorDeSalas[i];
            return exibicao;
        }
        return null;
    }

    public Sala[] getVetorDeSalas() {
        return vetorDeSalas;
    }

    public void setVetorDeSalas(Sala[] vetorDeSalas) {
        this.vetorDeSalas = vetorDeSalas;
    }

    public int getContador() {
        return contador;
    }

}
