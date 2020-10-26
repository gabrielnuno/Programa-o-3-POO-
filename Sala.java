package cinema;

public class Sala implements Comparable<Sala> {

    private static final int TAMANHO_MEDIO = 225; // Define o tamanho da sala menor.
    private static final int TAMANHO_GRANDE = 400; // Define o tamanho da sala maior.

    private char[][] matrizDaSala; // A matriz define as dimensões da sala.
    private int numero; // Número de identificação da sala.
    private int lugares; // Quantidade de lugares que a sala possui. Usaremos dois tamanhos, sendo o menor com 225 lugares e o maior com 400.

    public Sala(int numero, int lugares) {
        if (numero <= 0) { // Caso 1.1: número menor ou igual a zero.
            this.numero = 0;
        } else { // Caso 1.2: número maior do que zero.
            this.numero = numero;
        }
        if (lugares != TAMANHO_MEDIO && lugares != TAMANHO_GRANDE) { // Caso 2.1: o tamanho da sala é incompatível.
            this.lugares = 0;
        } else { // Caso 2.2: tamanho correto.
            this.lugares = lugares;
            if (this.lugares == TAMANHO_MEDIO) { // Caso 2.2.1: inicia a matriz para uma sala com 225 lugares.
                this.matrizDaSala = new char[15][15];
            } else { // Caso 2.2.2: inicia a matriz para uma sala com 400 lugares.
                this.matrizDaSala = new char[20][20];
            }
        }
    }

    public void preencherMatriz() { // Preenche a matriz apenas com o caractere '○', para facilitar a visualização por parte do cliente.
        int l, c;
        for (l = 0; l < this.matrizDaSala.length; l = l + 1) {
            for (c = 0; c < this.matrizDaSala[l].length; c = c + 1) {
                this.matrizDaSala[l][c] = '○';
            }
        }
    }

    public String ocuparLugar(int linha, int coluna) { // Ocupa um lugar na sala.
        String confirmacao;
        int contador;
        if (this.matrizDaSala[linha][coluna] == 'X') { // Caso 1.1: lugar ocupado.
            confirmacao = "Este lugar já foi ocupado!";
        } else if (this.matrizDaSala[linha][coluna] == 'Ø') { // Caso 1.2: lugar interditado.
            confirmacao = "Este lugar não pode ser ocupado devido às novas regras de isolamento social.";
        } else { // Caso 1.3: lugar disponível.
            for (contador = 0; contador < 3; contador = contador + 1) {
                if (this.matrizDaSala[linha][coluna + contador] == 'Ø') {
                    confirmacao = "Este lugar não pode ser ocupado, pois não se encontra à uma distância segura de outras pessoas.";
                    return confirmacao;
                }
                if (this.matrizDaSala[linha + contador][coluna] == 'Ø') {
                    confirmacao = "Este lugar não pode ser ocupado, pois não se encontra à uma distância segura de outras pessoas.";
                    return confirmacao;
                }
            }
            confirmacao = "O lugar é seu! =)";
        }
        return confirmacao;
    }

    public StringBuilder exibirMatriz() { // Exibe a matriz da sala.
        StringBuilder auxiliar;
        StringBuilder matriz;
        int l, c;
        matriz = new StringBuilder("\n");
        for (l = 0; l < this.matrizDaSala.length; l = l + 1) {
            for (c = 0; c < this.matrizDaSala[l].length; c = c + 1) {
                matriz.append(this.matrizDaSala[l][c]).append(" ");
            }
            matriz.append(" \n");
        }
        return matriz;
    }

    public char[][] getMatrizDaSala() {
        return matrizDaSala;
    }

    public void setMatrizDaSala(char[][] matrizDaSala) {
        this.matrizDaSala = matrizDaSala;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getLugares() {
        return lugares;
    }

    public void setLugares(int lugares) {
        this.lugares = lugares;
    }

    @Override
    public int compareTo(Sala sala) {
        return Integer.compare(this.numero, sala.numero);
    }

    @Override
    public String toString() {
        return "Número da sala: " + this.numero + " \n" +
                "Capacidade total: " + this.lugares + " \n";
    }

}
