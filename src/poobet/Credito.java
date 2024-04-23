
package poobet;


public class Credito {
    double saldo;
    String validade;
    String moeda;
    boolean bloqueado;
    public Credito(double saldo, String validade, String moeda, boolean bloqueado){
        this.saldo = saldo;
        this.validade = validade;
        this.moeda = moeda;
        this.bloqueado = bloqueado;
    }
    public void addCredito (double valor) {saldo+=valor;}
    public void remCredito (double valor) {saldo-=valor;}
    public double conferirCredito(){
        return saldo;
    }
}
