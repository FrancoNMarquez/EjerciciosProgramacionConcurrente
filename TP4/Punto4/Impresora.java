package TP4.Punto4;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/*public class Impresora {
    private char tipo;
    private Semaphore semImprimir;

    public Impresora(char tipo){
        semImprimir = new Semaphore(1);
        this.tipo=tipo;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
}*/
public class Impresora {

    private char tipo;
    private Semaphore semDisponible;
    private Semaphore semImprimiendo;

    public Impresora(char tipo) {
        this.tipo = tipo;
        this.semDisponible = new Semaphore(1, true);
        this.semImprimiendo = new Semaphore(0);
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public void usar(){
        try {
            semDisponible.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Impresora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void terminar(){
        semDisponible.release();
    }

    public boolean intentarImprimir(){
        return this.semDisponible.tryAcquire();
    }
}
