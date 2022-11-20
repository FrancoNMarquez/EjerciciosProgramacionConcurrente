package ParqueParcial;

public class Vecino implements Runnable{
    Parque unParque = new Parque();
    public Vecino(Parque elParque){
        this.unParque=elParque;
    }
    public void run(){
        try {
            unParque.entrarParqueVecino();
            Thread.sleep(1000);
            System.out.println("Vecino visitando el parque"+Thread.currentThread().getName());
            unParque.salirParque();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
