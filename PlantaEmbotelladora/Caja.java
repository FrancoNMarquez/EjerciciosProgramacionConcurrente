package PlantaEmbotelladora;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
public class Caja {
    short botellas;
    final short MAX_BOTELLAS = 10;
    private short tipo;

    public Caja(short tipo) {
        this.tipo = tipo;
        this.botellas=0;
    }
    public synchronized short getTipo(){
        return this.tipo;
    }
    //Necesito un Lock con Conditions? no
    // Usar synchronized normalito
    public synchronized void agregarBotella(){
        this.botellas++;
    }
    public synchronized boolean estaLlena(){
        return this.botellas==MAX_BOTELLAS;
    }

}
