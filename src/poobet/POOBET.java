
package poobet;

public class POOBET {
    static Jogador jogador;
    public static void main(String[] args) {
        iniciarCadastro();
        System.out.println(jogador);
    }
    public static void iniciarCadastro(){
        jogador = new Jogador(InOut.leString("Insira seu nome:"), InOut.leString("Insira seu sobrenome:"), InOut.leString("Insira seu apelido:"),
        InOut.leString("Insira seu cpf:"), "Brasileiro", (long) InOut.leInt("Insira sua data de nascimento:"));
        
        jogador.openMenu();
    }
}
