package Toboganes;

import java.util.concurrent.Semaphore;

public class Mirador {
    Semaphore[] toboganes = new Semaphore[2];
   // Semaphore tobogan1, tobogan2; // clase tobogan con 1 semaforo, tirarse y eso en el tobogan
    Semaphore semEscalera ;
    Semaphore mutexBase;
    Semaphore encargado;
    boolean tob1ocupado, tob2ocupado;

    public Mirador(){
        for (int i = 0; i < 2; i++) {
            toboganes[i]=new Semaphore(1);
        }
        mutexBase = new Semaphore(1);
        semEscalera = new Semaphore(10,true);
        encargado = new Semaphore(0);
        tob1ocupado = false;
        tob2ocupado = false;
    }

    public void subirEscalera() throws InterruptedException {
        semEscalera.acquire();
    }
    public void bajarEscalera(){
        semEscalera.release();
    }
    public int subirBase() throws InterruptedException {
        int posicion = 0;
        mutexBase.acquire();
        semEscalera.release();
        //aca despierto al encargado
        encargado.release(); // va un semaforo aca o ttodo lo resuelvo aca?
        this.verificarToboganes();
        //retornar la posicion en la que se tira
        return posicion;
    }
    public void tirarse(int numTobogan) throws InterruptedException {
        //paso por parametro la posicion en la que me tiro
        toboganes[numTobogan].acquire();
        mutexBase.release();
    }
    public void irse(int numTobogan){
        toboganes[numTobogan].release();
    }

    public void verificarToboganes(){
        //aca el encargado tiene que decidir, por cual tobogan se tira el proximo tipo

    }
    public void usandoTob1(){
        tob1ocupado=true;
    }
    public void tob1Libre(){
        tob1ocupado=false;
    }
    public void usandoTob2(){
        tob1ocupado=true;
    }
    public void tob2Libre(){
        tob1ocupado=false;
    }





}
