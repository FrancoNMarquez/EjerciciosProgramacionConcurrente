package TP3.punto4;

public class Rueda {

    public synchronized void correr(){
        System.out.println("Corre epicamente");
        try{
            Thread.sleep(1500);
        }catch (InterruptedException e){
            System.out.println("Se queda quieto epicamente");
        }
    }
}
