
package poobet;

public class Bet {
    int idAposta;
    double valorAposta;
    boolean pagou;
    public Bet(int idAposta, double valorAposta){
        this.idAposta = idAposta;
        this.valorAposta = valorAposta;
        if(idAposta == 2){
            pagou = true;
        }else{
            pagou = false;
        }
    }
    public boolean getResult(){
        return pagou;
    }
}
