package aplicacao;

import javax.naming.PartialResultException;
import javax.swing.JOptionPane;

import cinema.*;
import cinema.vetores.*;
import cliente.*;
import cliente.leidameiaentrada.*;
import cliente.vetor.*;

public class Cinema { // Classe de aplicação.

    private static final int QUANTIDADE_DE_FILMES = 6; // Define a quantidade máxima de filmes.
    private static final int QUANTIDADE_DE_SALAS = 6; // Define a quantidade máxima de salas.
    private static final int QUANTIDADE_DE_SESSOES = 6; // Define a quantidade máxima de sessões.

    private static final double PRECO_DA_MEIA = 10.00; // Define o preço da meia-entrada.
    private static final double PRECO_DA_INTEIRA = 20.00; // Define o preço da inteira.

    private static final int IDADE_MINIMA = 14; // Idade mínima necessária para efetuar o cadastramento.

    private Sala sala01;
    private Sala sala02;
    private Sala sala03;
    private Sala sala04;
    private Sala sala05;
    private Sala sala06;

    private Filme ednaldosAdventure;
    private Filme oRetornoDoRei;
    private Filme osVingadores;
    private Filme panteraNegra;
    private Filme parasita;
    private Filme vingadoresUltimato;

    private Sessao sessao01;
    private Sessao sessao02;
    private Sessao sessao03;
    private Sessao sessao04;
    private Sessao sessao05;
    private Sessao sessao06;

    private VetorDeClientes vetorDeClientes;
    private VetorDeFilmes vetorDeFilmes;
    private VetorDeIngressos vetorDeIngressos;
    private VetorDeSalas vetorDeSalas;
    private VetorDeSessoes vetorDeSessoes;

    public Cinema() { // Construtor da classe Cinema.
        ednaldosAdventure = new Filme("Ednaldo's Adventure", "Eu sou Ednaldo Pereira e irei derrotar, ao lado de Estive e Bill, o grande Bandidão e seu companheiro boi Bufa.", "Quem espera, na maioria das vezes, sempre alcança.", "Ednaldo Pereira, Estive, Bill, Bandidão e boi Bufa.", "Ednaldo Pereira", "L", 10);
        oRetornoDoRei = new Filme("O Senhor dos Anéis: O Retorno do Rei", "O confronto final entre as forças do bem e do mal que lutam pelo controle do futuro da Terra Média se aproxima. Sauron planeja um grande ataque a Minas Tirith, capital de Gondor, o que faz com que Gandalf e Pippin partam para o local na intenção de ajudar a resistência. Um exército é reunido por Theoden em Rohan, em mais uma tentativa de deter as forças de Sauron. Enquanto isso, Frodo, Sam e Gollum seguem sua viagem rumo à Montanha da Perdição para destruir o anel.", "4h 11m", "Elijah Wood, Viggo Mortensen, Ian McKellen...", "Peter Jackson", "14", 8.9);
        osVingadores = new Filme("Os Vingadores", "Loki, o irmão de Thor, ganha acesso ao poder ilimitado do cubo cósmico ao roubá-lo de dentro das instalações da S.H.I.E.L.D. Nick Fury, o diretor desta agência internacional que mantém a paz, logo reúne os únicos super-heróis que serão capazes de defender a Terra de ameaças sem precedentes. Homem de Ferro, Capitão América, Hulk, Thor, Viúva Negra e Gavião Arqueiro formam o time dos sonhos de Fury, mas eles precisam aprender a colocar os egos de lado e agir como um grupo em prol da humanidade.", "2h 24m", "Robert Downey Jr., Chris Evans, Scarlett Johansson, Mark Ruffalo, Chris Hemsworth, Jeremy Renner, Samuel L. Jackson e Tom Hiddleston...", "Joss Whedon", "12", 8.0);
        panteraNegra = new Filme("Pantera Negra", "Conheça a história de T'Challa, príncipe do reino de Wakanda, que perde o seu pai e viaja para os Estados Unidos, onde tem contato com os Vingadores. Entre as suas habilidades estão a velocidade, inteligência e os sentidos apurados.", "2h 15m", "Chadwick Boseman, Michael B. Jordan, Lupita Nyong'o...", "Ryan Coogler", "12", 7.3);
        parasita = new Filme("Parasita", "Toda a família de Ki-taek está desempregada, vivendo em um porão sujo e apertado, mas uma obra do acaso faz com que ele comece a dar aulas de inglês a uma garota de família rica. Fascinados com a vida luxuosa destas pessoas, pai, mãe e filhos bolam um plano para se infiltrarem também na família burguesa, um a um. No entanto, os segredos e mentiras necessários à ascensão social custam caro a todos.", "2h 12m", "Kang-ho Song, Sun-kyun Lee, Yeo-jeong Jo", "Bong Joon Ho", "16", 8.6);
        vingadoresUltimato = new Filme("Vingadores: Ultimato", "Após Thanos eliminar metade das criaturas vivas, os Vingadores têm de lidar com a perda de amigos e entes queridos. Com Tony Stark vagando perdido no espaço sem água e comida, Steve Rogers e Natasha Romanov lideram a resistência contra o titã louco.", "3h 2m", "Robert Downey Jr., Chris Evans, Scarlett Johansson, Mark Ruffalo, Chris Hemsworth, Jeremy Renner, Paul Rudd, Benedict Cumberbatch, Chadwick Boseman, Brie Larson, Tom Holland, Zoe Saldana, Evangeline Lilly, Karen Gillan, Tessa Thompson, Danai Guirra, Dave Bautista, Elizabeth Olsen...", "Anthony Russo e Joe Russo", "12", 8.5);
        sala01 = new Sala(1, 225);
        sala02 = new Sala(2, 225);
        sala03 = new Sala(3, 225);
        sala04 = new Sala(4, 400);
        sala05 = new Sala(5, 225);
        sala06 = new Sala(6, 400);
        sessao01 = new Sessao(sala01, parasita, "28/10", "21:15");
        sessao02 = new Sessao(sala02, osVingadores, "28/10", "15:00");
        sessao03 = new Sessao(sala04, oRetornoDoRei, "02/11", "23:59");
        sessao04 = new Sessao(sala05, panteraNegra, "10/11", "16:30");
        sessao05 = new Sessao(sala06, vingadoresUltimato, "25/04", "23:59");
        sessao06 = new Sessao(sala06, ednaldosAdventure, "25/12", "20:00");
        vetorDeClientes = new VetorDeClientes(100);
        vetorDeFilmes = new VetorDeFilmes(QUANTIDADE_DE_FILMES);
        vetorDeSalas = new VetorDeSalas(QUANTIDADE_DE_SALAS);
        vetorDeSessoes = new VetorDeSessoes(QUANTIDADE_DE_SESSOES);
    }

    public void gerenciadorDeTarefas() { // Esse método gerencia a aplicação.
        inicializarCinema();
        menuPrincipal();
    }

    private int opcoesDoMenu() { // Opções do menu principal.
        int opcao;
        opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha uma opção do menu abaixo: \n" +
                "1 - Fazer cadastro \n" +
                "2 - Ver filmes em cartaz \n" +
                "3 - Comprar ingressos \n" +
                "0 - Cancelar \n"));
        while (opcao < 0 || opcao > 3) {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Você escolheu uma opção inválida. Por favor, tente novamente: \n" +
                    "1 - Fazer cadastro \n" +
                    "2 - Ver filmes em cartaz \n" +
                    "3 - Comprar ingressos \n" +
                    "0 - Cancelar \n"));
        }
        return opcao;
    }

    private void menuPrincipal() { // Menu principal do programa.
        int opcao;
        do {
            opcao = opcoesDoMenu();
            switch (opcao) {
                case 1 -> fazerCadastro();
                case 2 -> verFilmesEmCartaz();
                case 3 -> comprarIngressos();
                case 0 -> JOptionPane.showMessageDialog(null, "Obrigado e volte sempre! =)");
            }
        } while (opcao != 0);
    }

    private void fazerCadastro() { // Inicia o cadastro de um cliente.
        String identificacao, nome;
        int idade, tipoDoCliente, tamanho, contador, escolha;
        boolean flag = false;
        identificacao = JOptionPane.showInputDialog("Digite, no campo abaixo, o seu CPF:");
        while (identificacao.length() != 11) { // Caso 1.1: o CPF digitado tem um tamanho diferente de 11.
            identificacao = JOptionPane.showInputDialog("O seu CPF precisa ter 11 dígitos. Por favor, digite novamente:");
        }
        tamanho = identificacao.length();
        do { // Caso 1.2: o tamanho do CPF é válido.
            for (contador = 0; contador < tamanho; contador = contador + 1) {
                if (Character.toLowerCase(identificacao.charAt(contador)) >= '1' && Character.toLowerCase(identificacao.charAt(contador)) <= '9') { // Caso 1.2.1: o caractere é válido.
                    flag = false;
                } else { // Caso 1.2.2: o caractere é inválido.
                    identificacao = JOptionPane.showInputDialog("O CPF deve conter apenas números. Por favor, digite novamente:");
                    while (identificacao.length() != 11) { // Caso 1.2.2.1: tamanho diferente de 11.
                        identificacao = JOptionPane.showInputDialog("O seu CPF precisa ter 11 dígitos. Por favor, digite novamente:");
                        flag = true;
                    }
                }
            }
        } while (flag);
        nome = JOptionPane.showInputDialog("Informe o seu nome: ");
        while (nome.length() < 3) { // Caso 2.1: o tamanho do nome não é válido.
            nome = JOptionPane.showInputDialog("Informe o seu nome: \n" +
                    "(Precisa conter pelo menos três caracteres)");
        }
        tamanho = nome.length();
        do {
            for (contador = 0; contador < tamanho; contador = contador + 1) { // Caso 2.2: o tamanho do nome é válido.
                if (Character.toLowerCase(nome.charAt(contador)) >= '1' && Character.toLowerCase(nome.charAt(contador)) <= '9') { // Caso 2.2.1: o caractere é inválido.
                    flag = true;
                    nome = JOptionPane.showInputDialog("Informe o seu nome: \n" +
                            "(Não pode conter números)");
                    while (nome.length() < 3) { // Caso 2.2.1.1: o tamanho do nome não é válido.
                        nome = JOptionPane.showInputDialog("Informe o seu nome: \n" +
                                "(Precisa conter pelo menos três caracteres)");
                    }
                } else { // Caso 2.2.2: o caractere é válido.
                    flag = false;
                }
            }
        } while (flag);
        idade = Integer.parseInt(JOptionPane.showInputDialog("Informe a sua idade: "));
        do {
            if (idade < IDADE_MINIMA) { // Caso 3.1: idade não abaixo da idade mínima.
                escolha = Integer.parseInt(JOptionPane.showInputDialog("Você digitou uma idade abaixo da idade permitida! \n" +
                        "1 - Foi um erro, deixe-me digitar novamente! \n" +
                        "0 - Voltar ao menu \n"));
                if (escolha == 1) { // Caso 3.1.1: digitar novamente.
                    idade = Integer.parseInt(JOptionPane.showInputDialog("Informe a sua idade: "));
                } else { // Caso 3.1.3: voltar ao menu.
                    menuPrincipal();
                }
            }
        } while (idade < 14);
        tipoDoCliente = Integer.parseInt(JOptionPane.showInputDialog("Você se identifica com alguma das situações abaixo? \n" +
                "1 - Sou estudante \n" +
                "2 - Possuo algum tipo de deficiencia \n" +
                "3 - Sou uma pessoa de baixa renda \n" +
                "0 - Não me identifico com nenhuma das opções acima \n"));
        do {
            switch (tipoDoCliente) {
                case 1 -> { // Caso 4.1: o cliente é um estudante.
                    Cliente cliente01 = new Estudante(identificacao, nome, idade);
                    vetorDeClientes.cadastrarClientes(cliente01);
                    JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso! \n" +
                            "Agora você pode aproveitar promoções especiais e descontos! =)");
                }
                case 2 -> { // Caso 4.2: o cliente possui alguma deficiencia.
                    Cliente cliente02 = new ClienteComNessecidadesEspeciais(identificacao, nome, idade);
                    vetorDeClientes.cadastrarClientes(cliente02);
                    JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso! \n" +
                            "Agora você pode aproveitar promoções especiais e descontos! =)");
                }
                case 3 -> { // Caso 4.3: o cliente é uma pessoa de baixa renda.
                    Cliente cliente03 = new PessoaDeBaixaRenda(identificacao, nome, idade);
                    vetorDeClientes.cadastrarClientes(cliente03);
                    JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso! \n" +
                            "Agora você pode aproveitar promoções especiais e descontos! =)");
                }
                case 0 -> { // Caso 4.4: o cliente não se identificou com nenhuma das opções.
                    Cliente cliente04 = new Cliente(identificacao, nome, idade);
                    vetorDeClientes.cadastrarClientes(cliente04);
                    JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso! \n" +
                            "Agora você pode aproveitar promoções especiais e descontos! =)");
                }
                default -> { // Caso 4.5: valor inválido.
                    tipoDoCliente = Integer.parseInt(JOptionPane.showInputDialog("Você se identifica com alguma das situações abaixo? \n" +
                            "1 - Sou estudante \n" +
                            "2 - Possuo algum tipo de deficiencia \n" +
                            "3 - Sou uma pessoa de baixa renda \n" +
                            "0 - Não me identifico com nenhuma das opções acima \n"));
                }
            }
        } while (tipoDoCliente < 0 || tipoDoCliente > 3);
    }

    private void verFilmesEmCartaz() { // Exibe os filmes que estão em cartaz no momento.
        String exibirFilme;
        int continuar, contador;
        contador = 0;
        do {
            exibirFilme = this.vetorDeFilmes.exibirSemDetalhes(contador);
            JOptionPane.showMessageDialog(null, exibirFilme);
            continuar = Integer.parseInt(String.valueOf(JOptionPane.showInternalConfirmDialog(null, "Quer ver o próximo filme?")));
            contador = contador + 1;
            if (contador == this.vetorDeFilmes.getContador()) { // Caso 1.1: chegou ao último filme.
                if (continuar < 1) { // Caso 1.2: usuário tentar ver o próximo filme.
                    JOptionPane.showMessageDialog(null, "Você já viu todos os filmes que estão em cartaz no momento!");
                }
                continuar = 1;
            }
        } while (continuar < 1);
    }

    private void comprarIngressos() { // Inicia o processo de compra de ingressos.
        Ingresso ingresso;
        int opcao, sessao, qtdMeia, qtdInteira, contador = 0, linha, coluna;
        double meia, inteira;
        opcao = Integer.parseInt(JOptionPane.showInputDialog(this.vetorDeFilmes.painelDeExibicao() + "0 - Voltar ao menu"));
        while (opcao < 0 || opcao > 6) {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(this.vetorDeFilmes.painelDeExibicao() + "0 - Voltar ao menu"));
        }
        sessao = Integer.parseInt(JOptionPane.showInputDialog(this.vetorDeSessoes.exibirSessoes(this.vetorDeFilmes.retornarFilme(opcao - 1))));
        qtdMeia = Integer.parseInt(JOptionPane.showInputDialog("Quantos ingressos meia-entrada você gostaria de comprar?"));
        while (qtdMeia < 0) {
            qtdMeia = Integer.parseInt(JOptionPane.showInputDialog("Quantos ingressos meia-entrada você gostaria de comprar?"));
        }
        while (contador != qtdMeia) {
            ingresso = new Ingresso(false);
            contador++;
        }
        qtdInteira = Integer.parseInt(JOptionPane.showInputDialog("Quantos ingressos do tipo inteira você gostaria de comprar?"));
        while (qtdInteira < 0) {
            qtdInteira = Integer.parseInt(JOptionPane.showInputDialog("Quantos ingressos do tipo inteira você gostaria de comprar?"));
        }
        while (qtdInteira != contador) {
            ingresso = new Ingresso(true);
            contador++;
        }
        contador = 0;
        while (contador != qtdInteira + qtdMeia) {
            linha = Integer.parseInt(JOptionPane.showInputDialog("Escolha a linha do lugar desejado: \n" + this.vetorDeSalas.matriz(opcao - 1)));
            while (linha < 0) {
                linha = Integer.parseInt(JOptionPane.showInputDialog("Escolha a linha do lugar desejado: \n" + this.vetorDeSalas.matriz(opcao - 1)));
            }
            coluna = Integer.parseInt(JOptionPane.showInputDialog("Escolha a linha do lugar desejado: \n" + this.vetorDeSalas.matriz(opcao - 1)));
            while (coluna < 0) {
                coluna = Integer.parseInt(JOptionPane.showInputDialog("Escolha a linha do lugar desejado: \n" + this.vetorDeSalas.matriz(opcao - 1)));
            }
            this.vetorDeSalas.ocuparMatriz(opcao - 1, linha, coluna);
            contador = contador + 1;
        }
        meia = qtdMeia * PRECO_DA_MEIA;
        inteira = qtdInteira * PRECO_DA_INTEIRA;
        JOptionPane.showMessageDialog(null, "VALOR TOTAL: \n" + "R$ " + meia + inteira);
    }

    private void inicializarCinema() { // Esse método inicializa toda a estrutura do cinema.
        // Cadastrar filmes:
        this.vetorDeFilmes.inserirFilmeNoVetor(this.ednaldosAdventure);
        this.vetorDeFilmes.inserirFilmeNoVetor(this.oRetornoDoRei);
        this.vetorDeFilmes.inserirFilmeNoVetor(this.osVingadores);
        this.vetorDeFilmes.inserirFilmeNoVetor(this.panteraNegra);
        this.vetorDeFilmes.inserirFilmeNoVetor(this.parasita);
        this.vetorDeFilmes.inserirFilmeNoVetor(this.vingadoresUltimato);
        // Cadastrar salas:
        this.sala01.preencherMatriz();
        this.vetorDeSalas.inserirSalaNoVetor(this.sala01);
        this.sala02.preencherMatriz();
        this.vetorDeSalas.inserirSalaNoVetor(this.sala02);
        this.sala03.preencherMatriz();
        this.vetorDeSalas.inserirSalaNoVetor(this.sala03);
        this.sala04.preencherMatriz();
        this.vetorDeSalas.inserirSalaNoVetor(this.sala04);
        this.sala05.preencherMatriz();
        this.vetorDeSalas.inserirSalaNoVetor(this.sala05);
        this.sala06.preencherMatriz();
        this.vetorDeSalas.inserirSalaNoVetor(this.sala06);
        // Cadastrando sessões:
        this.vetorDeSessoes.inserirSessaoNoVetor(this.sessao01);
        this.vetorDeSessoes.inserirSessaoNoVetor(this.sessao02);
        this.vetorDeSessoes.inserirSessaoNoVetor(this.sessao03);
        this.vetorDeSessoes.inserirSessaoNoVetor(this.sessao04);
        this.vetorDeSessoes.inserirSessaoNoVetor(this.sessao05);
        this.vetorDeSessoes.inserirSessaoNoVetor(this.sessao06);
    }

}
