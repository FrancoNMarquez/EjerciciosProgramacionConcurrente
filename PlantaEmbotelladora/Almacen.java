package PlantaEmbotelladora;
import java.security.PublicKey;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class Almacen {
    private Caja[] arregloDeCajas= new Caja[10];
    private final int MAX_CAJAS = 10;
    private int cantCajas = 0;
    Lock lock = new ReentrantLock(true);
    Condition camionEspera = lock.newCondition();
    Condition empEspera = lock.newCondition();
    boolean espacioLibre = true;
    boolean retirandoCajas = false;


    public Almacen(){

    }
    public boolean estaLleno(){
        return cantCajas==MAX_CAJAS;
    }
    public void ponerCaja(Caja laCaja) throws InterruptedException {
        lock.lock();

        while(retirandoCajas){
            empEspera.await();
        }

        if(this.estaLleno()){
            camionEspera.signal();
        }
        while(this.estaLleno()){
            empEspera.await();
        }
        this.agregarCaja(laCaja);

        lock.unlock();
    }
    public void agregarCaja(Caja laCaja){
        //agregar la caja adentro del array de cajas
        int i = 0;
        boolean espacioEncontrado = false;
        while(i<MAX_CAJAS || !espacioEncontrado){
            if(arregloDeCajas[i]==null){
                arregloDeCajas[i]=laCaja;
                espacioEncontrado = true;
            }
            i++;
        }
    }
    public void sacarCaja() throws InterruptedException {
        lock.lock();

        while(!this.estaLleno()){
            camionEspera.await();
        }
        this.vaciarCajas();
        empEspera.signal();
        lock.unlock();


        lock.unlock();
    }
    public void vaciarCajas(){
        for (int i = 0; i <MAX_CAJAS ; i++) {
            arregloDeCajas[i]=null;
        }
    }
}
