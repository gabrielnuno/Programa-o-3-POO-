package cinema;

import java.util.Random;

public class Ingresso {

    private static final double PRECO_DA_MEIA = 10.00; // Define o preço da meia-entrada.
    private static final double PRECO_DA_INTEIRA = 20.00; // Define o preço da inteira.
    private static final double DESCONTO_PROMOCIONAL = 0.2; // Define o valor do desconto, caso haja algum. Se o valor for igual a um isso significa que não há descontos disponíveis.

    private double preco; // Define o preço do ingresso a ser comprado.
    private int codigo; // Código de identificação do ingresso.
    private boolean tipoDoIngresso; // Define se o ingresso comprado é uma meia-entrada (false) ou inteira (true).
    private boolean flag; // Sinaliza se o ingresso já está com um preço promocional (true) ou não (false).

    public Ingresso(boolean tipoDoIngresso) {
        Random gerador = new Random();
        this.codigo = gerador.nextInt(999999999); // Gera um código para o ingresso.
        this.tipoDoIngresso = tipoDoIngresso;
        if (!this.tipoDoIngresso) { // Caso 1.1: meia-entrada.
            this.preco = PRECO_DA_MEIA;
        } else { // Caso 1.2: inteira.
            this.preco = PRECO_DA_INTEIRA;
        }
        this.flag = false;
    }

    public String aplicarPromocao(Ingresso ingresso) { // Aplica um desconto no valor, caso esteja disponível.
        String confirmacao;
        if (this.tipoDoIngresso) { // Caso 1.1: há uma promoção aplicada no valor.
            confirmacao = "O valor do ingresso já está com um desconto promocional. \n";
        } else { // Caso 1.2: não há uma promoção aplicada no valor.
            this.preco = (this.preco * DESCONTO_PROMOCIONAL);
            this.flag = true;
            confirmacao = "O desconto promocional foi aplicado! \n";
        }
        return confirmacao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public boolean isTipoDoIngresso() {
        return tipoDoIngresso;
    }

    public void setTipoDoIngresso(boolean tipoDoIngresso) {
        this.tipoDoIngresso = tipoDoIngresso;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        String ingresso;
        if (this.tipoDoIngresso) { // Caso 1.1: o ingresso é uma inteira.
            ingresso = "inteira";
        } else { // Caso 1.2: O ingresso é uma meia-entrada.
            ingresso = "meia-entrada";
        }
        return "Tipo do ingresso: " + ingresso + " \n" +
                "Valor: " + this.preco + " \n";
    }

}
