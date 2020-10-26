package cliente;

public class Cliente {

    private static final int IDADE_MINIMA = 14; // Idade mínima necessária para efetuar o cadastramento.

    private String identificacao; // O tipo de identificação usada será o CPF do cliente.
    private String nome; // Nome do cliente.
    private int idade; // Idade do cliente.

    public Cliente(String identificacao, String nome, int idade) {
        if (identificacao.length() != 11) { // Caso 1.1: CPF inválido. Observação: para um CPF ser válido ele precisa ter um total de 11 caracteres.
            this.identificacao = "00000000011";
        } else { // Caso 1.2: CPF válido.
            this.identificacao = identificacao;
        }
        if (nome.length() <= 0) { // Caso 2.1: nome inválido.
            this.nome = "NOME INDISPONÍVEL";
        } else { // Caso 2.2: o nome é válido.
            this.nome = nome;
        }
        if (idade < IDADE_MINIMA) { // Caso 3.1: abaixo da idade mínima.
            this.idade = 0;
        } else { // Caso 3.2: idade válida.
            this.idade = idade;
        }
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

}
