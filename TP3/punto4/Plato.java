package TP3.punto4;

public class Plato {
    public Plato(){

    }
    public synchronized void comer() {
        System.out.println("ñom ñom");
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println("ñom ñom'nt");
        }

    }
}
