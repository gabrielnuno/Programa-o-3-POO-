package cliente.vetor;

import javax.swing.JOptionPane;

import cliente.Cliente;

public class VetorDeClientes {

    private Cliente[] vetorDeClientes; // Armazena os clientes cadastrados.
    private int contador; // Conta quantos clientes foram adicionados.

    public VetorDeClientes(int quantidadeDeClientes) {
        vetorDeClientes = new Cliente[quantidadeDeClientes];
        this.contador = 0;
    }

    private boolean buscarCliente(Cliente cliente) { // Realiza uma busca para encontrar um determinado cliente no vetor.
        int i;
        for (i = 0; i < this.contador; i = i + 1) {
            if (this.vetorDeClientes[i].getIdentificacao().compareTo(cliente.getIdentificacao()) == 0) { // Caso 1.1: CPF iguais.
                return true;
            }
        }
        return false; // Caso 1.2: CPF diferentes.
    }

    public void cadastrarClientes(Cliente cliente) { // Cadastra um novo cliente no vetor.
        int posicao;
        posicao = this.contador;
        if (buscarCliente(cliente)) { // Caso 1.1: cliente encontrado através do método de busca.
            JOptionPane.showMessageDialog(null, "Esse cliente já está cadastrado.");
        } else { // Caso 1.2: cliente não encontrado no vetor.
            this.vetorDeClientes[posicao] = cliente;
            this.contador = this.contador + 1;
        }
    }

    public Cliente[] getVetorDeClientes() {
        return vetorDeClientes;
    }

    public void setVetorDeClientes(Cliente[] vetorDeClientes) {
        this.vetorDeClientes = vetorDeClientes;
    }

    public int getContador() {
        return contador;
    }

}
