package Canibales;

public class Canibal implements Runnable{
    Olla unaOlla = new Olla();
    boolean comio = false;
    public Canibal(Olla unaOlla) {
        this.unaOlla = unaOlla;
    }

    public void run(){
        int i=1;
        while (i!=0) {
            try {
                unaOlla.servirseComida();
                System.out.println("Sirviendome comida..");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            i--;
        }
    }
}
