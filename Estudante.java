package cliente.leidameiaentrada;

import cinema.Ingresso;
import cliente.Cliente;

public class Estudante extends Cliente { // Herda os atributos da classe Cliente.

    public Estudante(String identificacao, String nome, int idade) {
        super(identificacao, nome, idade);
    }

    public String setMeiaEntrada(Ingresso ingresso) { // Atualiza o tipo do ingresso para meia-entrada.
        String confirmacao;
        if (!ingresso.isTipoDoIngresso()) { // Caso 1.1: já é meia-entrada.
            confirmacao = "O ingresso já está definido como meia-entrada. \n";
        } else { // Caso 1.2: é inteira.
            ingresso.setTipoDoIngresso(false);
            confirmacao = "O tipo do igresso foi definido como meia-entrada. \n";
        }
        return confirmacao;
    }

    public String descontoPromocional(Ingresso ingresso) { // Aplica um desconto promocional, caso esteja disponível.
        String confirmacao;
        if (ingresso.isFlag()) { // Caso 1.1: há uma promoção aplicada no valor.
            confirmacao = "O ingresso já está com um valor promocional. \n";
        } else { // Caso 1.2: não há promoções aplicadas no valor do ingresso.
            ingresso.setPreco(ingresso.getPreco() * 0.2);
            ingresso.setFlag(true);
            confirmacao = "O desconto promocional foi aplicado! \n";
        }
        return confirmacao;
    }

}
