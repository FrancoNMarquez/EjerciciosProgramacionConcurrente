package LosBabuinos;

import java.util.concurrent.Semaphore;

public class Cuerda {
    Semaphore espaciosCuerda = new Semaphore(5,true);
    Semaphore semEsperaDerecha = new Semaphore(1);
    Semaphore semEsperaIzquierda = new Semaphore(1);
    Semaphore mutexIzq = new Semaphore(1);
    Semaphore mutexDer = new Semaphore(1);
    int cantEsperaDerecha=0, cantEsperaIzquierda =0, cantEnCuerda=0;


    public void cruzarDerecha() throws InterruptedException {
        mutexDer.acquire();
        cantEsperaDerecha++;
        mutexDer.release();
        semEsperaDerecha.acquire();
        espaciosCuerda.acquire();
        mutexDer.acquire();
        cantEnCuerda++;
        mutexDer.release();
        //semEsperaDerecha.release();
        //tengo que descontar aca el cantEspera?
    }
    public void cruzarIzquierda() throws InterruptedException {

        mutexIzq.acquire(); //dos mutex distintos
        cantEsperaIzquierda++;
        mutexIzq.release();
        semEsperaIzquierda.acquire();
        espaciosCuerda.acquire();
        //incremento contador
        mutexIzq.acquire(); // ver si puedo agarrarlo al principio y liberarlo al final, pq son mutex distintos.
        cantEsperaIzquierda--;
        cantEnCuerda++;
        mutexIzq.release();
        semEsperaIzquierda.release();
    }

    public void termineCruzarDerecha() throws InterruptedException {
        mutexDer.acquire();
        espaciosCuerda.release();
        cantEnCuerda--;
        if(cantEsperaDerecha==0 && cantEnCuerda==0){
            semEsperaIzquierda.release();
            System.out.println("Libere a la izquierda");

        }
        System.out.println("Ya cruce por der...");
        mutexDer.release();
    }
    public void termineCruzarIzquierda() throws InterruptedException {
        mutexIzq.acquire();
        espaciosCuerda.release();
        cantEnCuerda--;
        if(cantEsperaIzquierda==0 && cantEnCuerda==0){ //agregar contador monosENCuerda
            semEsperaDerecha.release();
            System.out.println("Libere a la derecha");
            // semEsperaDerecha.release();
        }
        System.out.println("Ya cruce por izq...");
        mutexIzq.release();
    }


}
