package TP4.punto7;

import java.util.concurrent.Semaphore;

public class HiloControl implements Runnable {

    GestorCruce elGestor;
    Semaphore cambiar = new Semaphore(1);

    public HiloControl(GestorCruce elGestor) {
        this.elGestor = elGestor;
    }

    public void cambioSemaforo() {
        // Cambia los boolean del gestor

        boolean oesteLibre;
        boolean norteLibre;

        try {
            cambiar.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        oesteLibre = elGestor.oesteLibre();
        norteLibre = elGestor.norteLibre();

        elGestor.setSemaforoEO(!oesteLibre);
        elGestor.setSemaforoNS(!norteLibre);
        if (!oesteLibre) {
            try {
                elGestor.sensorEntradaOeste.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            elGestor.sensorEntradaNorte.release();
            System.out.println("El semáforo Norte esta en verde");
        } else {
            try {
                elGestor.sensorEntradaNorte.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            elGestor.sensorEntradaOeste.release();
            System.out.println("El semaforo Oeste esta en verde");
        }
        cambiar.release();
    }

    public void run() {
        int i = 0;
        while (i < 10) {
            cambioSemaforo();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("bruh");
            }
            i++;
        }
    }
}

