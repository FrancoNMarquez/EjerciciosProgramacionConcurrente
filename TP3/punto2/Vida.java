package TP3.punto2;
public class Vida {
    private int hp;

    public Vida(){
        this.hp=10;
    }
    public synchronized void modificarVida(int cantHp){
        this.hp+=cantHp;
    }
    public int getHp(){
        return this.hp;
    }
}
