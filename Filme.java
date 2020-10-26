package cinema;

public class Filme implements Comparable<Filme> {

    private String titulo; // Título do filme.
    private String sinopse; // Sinopse do filme.
    private String tempoDeDuracao; // Tempo de duração do filme.
    private String elenco; // Atores e atrizes que participaram do filme.
    private String direcao; // Refere-se à quem dirigiu o filme.
    private String classificacao; // Classificação indicativa do filme no Brasil.
    private double avaliacao; // Nota, de 0 à 10, de acordo com a crítica.

    public Filme(String titulo, String sinopse, String tempoDeDuracao, String elenco, String direcao, String classificacao, double avaliacao) {
        if (titulo.length() <= 0) { // Caso 1.1: título inválido.
            this.titulo = "TÍTULO INDISPONÍVEL";
        } else { // Caso 1.2: o título é válido.
            this.titulo = titulo;
        }
        if (sinopse.length() <= 0) { // Caso 2.1: sinopse inválida.
            this.sinopse = "SINOPSE INDISPONÍVEL";
        } else { // Caso 2.2: a sinopse é válida.
            this.sinopse = sinopse;
        }
        if (tempoDeDuracao.length() < 4) { // Caso 3.1: tempo de duração inválido.
            this.tempoDeDuracao = "TEMPO DE DURAÇÃO INDISPONÍVEL";
        } else { // Caso 3.2: o tempo de duração é válido.
            this.tempoDeDuracao = tempoDeDuracao;
        }
        if (elenco.length() <= 0) { // Caso 4.1: String "elenco" inválida.
            this.elenco = "ELENCO INDISPONÍVEL";
        } else { // Caso 4.2: a String "elenco" é válida.
            this.elenco = elenco;
        }
        if (direcao.length() <= 0) { // Caso 5.1: String "direcao" inválida.
            this.direcao = "DIREÇÃO INDISPONÍVEL";
        } else { // Caso 5.2: a String "direcao" é válida.
            this.direcao = direcao;
        }
        if (classificacao.length() <= 0) { // Caso 6.1: classificação indicativa inválida.
            this.classificacao = "SINOPSE INDISPONÍVEL";
        } else { // Caso 6.2: a classificação indicativa é válida..
            this.classificacao = classificacao;
        }
        if (avaliacao < 0 || avaliacao > 10) { // Caso 7.1: avaliação inválida.
            this.avaliacao = 012345678.9;
        } else { // Caso 7.2: a avaliação é válida.
            this.avaliacao = avaliacao;
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getTempoDeDuracao() {
        return tempoDeDuracao;
    }

    public void setTempoDeDuracao(String tempoDeDuracao) {
        this.tempoDeDuracao = tempoDeDuracao;
    }

    public String getElenco() {
        return elenco;
    }

    public void setElenco(String elenco) {
        this.elenco = elenco;
    }

    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    @Override
    public int compareTo(Filme filme) {
        return Integer.compare(this.titulo.compareTo(filme.getTitulo()), 0);
    }

    @Override
    public String toString() {
        return "Título: " + this.titulo + " \n" +
                "Sinopse: " + this.sinopse + " \n" +
                "Duração: " + this.tempoDeDuracao + " \n" +
                "Elenco: " + this.elenco + " \n" +
                "Direção: " + this.direcao + " \n" +
                "Classificação indicativa: " + this.classificacao + " \n" +
                "Avaliação dos críticos: " + this.avaliacao + " \n";
    }

}
