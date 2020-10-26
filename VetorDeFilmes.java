package cinema.vetores;

import javax.swing.JOptionPane;

import cinema.Filme;

public class VetorDeFilmes implements InterfaceDosVetores { // Implementa a interface InterfaceDosVetores.

    private static int contador; // Conta quantos filmes foram cadastrados no vetor.
    private Filme[] vetorDeFilmes; // Armazena todos os filmes cadastrados.

    public VetorDeFilmes(int quantidadeDeFilmes) {
        if (quantidadeDeFilmes <= 0) { // Caso 1.1: quantidade de filmes menor ou igual a zero.
            this.vetorDeFilmes = new Filme[0];
        } else { // Caso 1.2: quantidade maior do que zero.
            this.vetorDeFilmes = new Filme[quantidadeDeFilmes];
        }
        contador = 0; // Inicializa o contador com o valor igual a zero.
    }

    private boolean buscarFilme(Filme filme) { // Realiza uma busca para encontrar um determinado filme no vetor.
        int i;
        for (i = 0; i < contador; i = i + 1) {
            if (this.vetorDeFilmes[i].getTitulo().compareTo(filme.getTitulo()) == 0) { // Caso 1.1: títulos iguais.
                return true;
            }
        }
        return false; // Caso 1.2: títulos diferentes.
    }

    public Filme retornarFilme(int aux) {
        return this.vetorDeFilmes[aux];
    }

    public void inserirFilmeNoVetor(Filme filme) { // Insere um filme no vetor de filmes.
        int posicao;
        posicao = contador;
        if (buscarFilme(filme)) { // Caso 1.1: filme encontrado através do método de busca.
            JOptionPane.showMessageDialog(null, "O filme " + filme.getTitulo() + " já foi cadastrado.");
        } else { // Caso 1.2: filme não encontrado no vetor.
            this.vetorDeFilmes[posicao] = filme;
            contador = contador + 1;
        }
    }

    public StringBuilder painelDeExibicao() { // Auxilia na exibição dos filmes para o cliente.
        StringBuilder confirmacao;
        String auxiliar;
        int filme;
        confirmacao = new StringBuilder("Selecione um dos filmes em cartaz: \n");
        for (filme = 0; filme < contador; filme = filme + 1) {
            auxiliar = (filme + 1) + " - " + this.exibirSemDetalhes(filme) + " \n";
            confirmacao.append(auxiliar);
        }
        return confirmacao;
    }

    @Override
    public String exibirSemDetalhes(int auxiliar) { // Exibe apenas o título de um filme.
        String tituloDoFilme;
        tituloDoFilme = this.vetorDeFilmes[auxiliar].getTitulo();
        return tituloDoFilme;
    }

    @Override
    public Filme exibirComDetalhes(int auxiliar) { // Exibe todos os detalhes de um filme.
        return this.vetorDeFilmes[auxiliar];
    }

    @Override
    public Filme exibirTodos() { // Exibe todos os itens do vetor.
        Filme exibicao;
        int i;
        for (i = 0; i < this.vetorDeFilmes.length; i = i + 1) {
            exibicao = this.vetorDeFilmes[i];
            return exibicao;
        }
        return null;
    }

    public Filme[] getVetorDeFilmes() {
        return vetorDeFilmes;
    }

    public void setVetorDeFilmes(Filme[] vetorDeFilmes) {
        this.vetorDeFilmes = vetorDeFilmes;
    }

    public int getContador() {
        return contador;
    }

}
