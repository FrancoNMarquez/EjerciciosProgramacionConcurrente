package ParqueParcial;

public class Persona implements Runnable{
    Parque unParque = new Parque();
    public Persona(Parque elParque){
        this.unParque=elParque;
    }
    public void run(){
        try {
            unParque.entrarParque();
            Thread.sleep(5000);
            System.out.println("Caminando por el parque"+Thread.currentThread().getName());
            unParque.salirParque();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
