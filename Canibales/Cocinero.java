package Canibales;

public class Cocinero implements Runnable{
    Olla unaOlla = new Olla();

    public Cocinero(Olla unaOlla) {
        this.unaOlla = unaOlla;
    }

    public void run(){
        try {
           int i=3;
            while (i!=0) {
                unaOlla.cocinar();
                Thread.sleep(1000);
                i--;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
