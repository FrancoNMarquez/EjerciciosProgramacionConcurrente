package TP2;

public class MiHiloThread extends Thread{
    public void run(){
        System.out.println("Comenzando "+getName());
        try {
            for (int contar=0; contar<10; contar++){
                Thread.sleep(400);
                System.out.println("En "+getName()+", el recuento "+contar);
            }
        }catch (InterruptedException exc){
            System.out.println(getName()+ "Interrumpido.");
        }
        System.out.println("Terminando "+getName());
    }
}
//Hay que cambiar el nombreHIlo declarado en un runnable, con el getName que ya viene en Thread