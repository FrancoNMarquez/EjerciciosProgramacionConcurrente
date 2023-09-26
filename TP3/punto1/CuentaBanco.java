package TP3;

public class CuentaBanco {
    private int balance = 50;

    public CuentaBanco() {
        this.balance = balance;
    }

    public int getBalance(){
        return balance;
    }
    public void retiroBancario(int retiro){
        balance = balance - retiro;
    }

}
