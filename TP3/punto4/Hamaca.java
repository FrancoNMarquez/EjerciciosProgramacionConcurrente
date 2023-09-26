package TP3.punto4;

public class Hamaca {

    public synchronized void dormir(){
        System.out.println("esta mimiendo");
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            System.out.println("Se toma una monster");
        }
    }
}
