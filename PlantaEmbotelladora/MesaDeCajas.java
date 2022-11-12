package PlantaEmbotelladora;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class MesaDeCajas {
    //implements Sync para que sirve?
    private final Caja[] arregloCajas = new Caja[2];
    private boolean hayCajaVino = true;
    private boolean hayCajaAgua = true;
    Lock lock = new ReentrantLock(true);
    Condition estaLaCajaDeVino = lock.newCondition();
    Condition estaLaCajaDeAgua = lock.newCondition();
    boolean cajaEstaLLena = false;
    Condition cajaLlena = lock.newCondition();
    public MesaDeCajas() {
        for (int i = 0; i <2 ; i++) {
            arregloCajas[i]= new Caja((short)i);

        }
    }

    public void ponerCaja(@NotNull Caja unaCaja){
        //el empaquetador pone una caja, si es que no hay ninguna.
        lock.lock();

        if(unaCaja.getTipo()==0){
            System.out.println("Estoy poniendo una caja de Vino...");
            arregloCajas[0]=unaCaja;
            hayCajaVino=true;
            estaLaCajaDeVino.signalAll();
        }else{
            System.out.println("Estoy poniendo una caja de Agua...");
            arregloCajas[1]=unaCaja;
            hayCajaAgua=true;
            estaLaCajaDeAgua.signalAll();
        }

        lock.unlock();
    }
    public Caja sacarCaja() throws InterruptedException {
        //pide lock, saca la instancia actual de caja, pone otra caja, unlock
        //sin whiles, solo accede el empaquetador?
        lock.lock();
        Caja devolverCaja = null;
        int lenArregloCajas = arregloCajas.length;

        while (!arregloCajas[0].estaLlena() && !arregloCajas[1].estaLlena()){
            System.out.println("Esperando para sacar caja");
            cajaLlena.await();
        }
        //Saber que tipo de caja hay que sacar y poner esa pos del arreglo en null
        for (int i = 0; i <lenArregloCajas  ; i++) {
            if(arregloCajas[i].estaLlena()){
                if(i==0){
                    hayCajaVino=false;
                }else{
                    hayCajaAgua=false;
                }
                devolverCaja = arregloCajas[i];
                System.out.println("Saque caja de tipo " +i);
            }
        }
        System.out.println("llegue aca");
        lock.unlock();

        return devolverCaja;
    }
    public void ponerBotella(short tipo) throws InterruptedException {
        //Si tipo=0 es embotellador de cajas de vino
        //Si es 1, es caja de agua

        //El embotellador pide el lock para poder ir a la caja, y mientras no haya caja, espera
        lock.lock();
        if(tipo==0){
            while (!hayCajaVino) {
                System.out.println("NO HAY CAJA DE VINO");
                estaLaCajaDeVino.await();
            }

            if(arregloCajas[0].estaLlena()){
                System.out.println("Despierto al empaquetador");
                cajaEstaLLena = true;
                cajaLlena.signal();}
            while(arregloCajas[0].estaLlena()){
                estaLaCajaDeVino.await();
            }
            arregloCajas[0].agregarBotella();
            System.out.println("---AGREGUE BOTELLA DE VINO---");
        }else{
            while(!hayCajaAgua){
                System.out.println("NO HAY CAJA DE AGUA");
                estaLaCajaDeAgua.await();
            }
            if(arregloCajas[1].estaLlena()){
                cajaLlena.signal();
            }
            while(arregloCajas[1].estaLlena()){
                estaLaCajaDeAgua.await();
            }
            arregloCajas[1].agregarBotella();

            System.out.println("---AGREGUE BOTELLA DE AGUA---");

            //aca le tiene que avisar el empaquetador de que ya hay una caja nueva
        }
        lock.unlock();
    }

}
