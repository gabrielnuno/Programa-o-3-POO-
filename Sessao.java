package cinema;

public class Sessao implements Comparable<Sessao> {

    private Sala sala; // Define a sala em que ocorrerá essa sessão.
    private Filme filme; // Filme exibido na sessão.
    private String data; // Data da sessão.
    private String horario; // Horário da sessão.

    public Sessao(Sala sala, Filme filme, String data, String horario) {
        this.sala = sala;
        this.filme = filme;
        if (data.length() < 5) { // Caso 1.1: data inválida.
            this.data = "DATA INDISPONÍVEL";
        } else { // Caso 1.2: a data é válida.
            this.data = data;
        }
        if (horario.length() <= 4) { // Caso 2.1: horário inválido.
            this.horario = "HORÁRIO INDISPONÍVEL";
        } else { // Caso 2.2: o horário é válido.
            this.horario = horario;
        }
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;

    }

    @Override
    public int compareTo(Sessao sessao) {
        return Integer.compare(this.sala.getNumero(), sessao.sala.getNumero());
    }

    @Override
    public String toString() {
        return "Sala: " + this.sala.getNumero() + " \n" +
                "Filme: " + this.filme.getTitulo() + " \n" +
                "Data: " + this.data + " \n" +
                "Horário: " + this.horario + " \n";
    }

}
