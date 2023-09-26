package TP4.punto7;
import java.util.concurrent.Semaphore;
public class GestorCruce {

    Semaphore sensorEntradaOeste;
    Semaphore sensorEntradaNorte;
    Semaphore sensorSalidaOeste;
    Semaphore sensorSalidaNorte;
    private boolean semaforoNS;
    private boolean semaforoEO;

    public GestorCruce(){
        sensorEntradaOeste = new Semaphore(1,true);
        sensorEntradaNorte = new Semaphore(1,true);
        semaforoEO=true;
        semaforoNS=false;
    }

    public boolean norteLibre(){
        return semaforoNS;
    }
    public boolean oesteLibre(){
        return semaforoEO;
    }

    public void setSemaforoNS(boolean semaforoNS) {
        this.semaforoNS = semaforoNS;
    }

    public void setSemaforoEO(boolean semaforoEO) {
        this.semaforoEO = semaforoEO;
    }
    public void adquirirSemaforoOeste(){
        try {
            sensorEntradaOeste.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void adquirirSemaforoNorte(){
        try{
            sensorEntradaNorte.acquire();
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
    public void saleNorte(){
        sensorEntradaNorte.release();
    }
    public void saleOeste(){
        sensorEntradaOeste.release();
    }
}
