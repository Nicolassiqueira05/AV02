/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poobet;

/**
 *
 * @author alunolab02
 */
public class Jogador {
    
    int idJogador;
    String nome;
    String sobreNome;
    String apelido;
    String cpf;
    String nacionalidade;
    Long dataNascimento;

    double valorAposta;
    Bet[] bet = new Bet[99];
    int betIndex = 0;

    Credito credito = new Credito(0.0, "2025", "real", false);
    
    public Jogador(String nome, String sobreNome, String apelido, String cpf, String nacionalidade, Long dataNascimento){
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.apelido = apelido;
        this.cpf = cpf;
        this.nacionalidade = nacionalidade;
        this.dataNascimento = dataNascimento;
    }
    
    public void menu(int i){
        switch(i){
            case 1:
                InOut.MsgDeInformacao("Saldo", credito.conferirCredito() + "");
                openMenu();
                break;
            case 2:
                credito.addCredito(InOut.leDouble("Quanto você quer depositar?"));
                openMenu();
                break;
            case 3:
                valorAposta = (InOut.leDouble("Quanto você quer apostar?"));
                InOut.MsgDeInformacao("","O id da sua aposta é " + betIndex);
                createBet(valorAposta);
                openMenu();
                break;
            case 4:
                if(checkBet(InOut.leInt("Quanto o id da sua aposta?"))){
                    InOut.MsgDeInformacao("Bet", "Você venceu e dobrou sua aposta");
                }else{
                    InOut.MsgDeInformacao("Bet", "Você Perdeu e é um fracasso");
                }
                openMenu();
                break;
        }
    }
    public void openMenu(){
        menu(InOut.leInt(
                "Oque você quer fazer: " +
                        " digite 1 para conferir seu saldo " +
                        " digite 2 para depositar credito " +
                        " digite 3 para fazer uma aposta " +
                        " digite 4 para conferir uma aposta "
        ));
    }

    public void createBet(double valor){
        bet[betIndex] = new Bet(betIndex, valor);
        credito.remCredito(valor);
        betIndex++;
    }

    public boolean checkBet(int id){
        if(bet[id].getResult()) {
            credito.addCredito(bet[id].valorAposta * 2);
        }
        return bet[id].getResult();
    }

}
