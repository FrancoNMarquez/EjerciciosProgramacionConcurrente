package Trenes;

import java.util.concurrent.Semaphore;

public class Tren {
    //Recurso compartido
    //Con semaforos genericos
    private final int cantAsientos;
    private Semaphore mutexCompra; // Exclusion mutua compra de Tickets
    private Semaphore semComprarTicket; // Rendevous Pasajero - Vendedor
    private Semaphore semEntregaTicket; // Rendevous Vendedor - Pasajero

    private Semaphore semAsientos; // Asientos del Tren
    private Semaphore semViajar; // Tren viaja cuando ya se lleno
    private Semaphore semBajar; // Finaliza el viaje

    public Tren(int cantAsientos) {
        this.cantAsientos = cantAsientos;
        this.mutexCompra = new Semaphore(1);
        this.semComprarTicket = new Semaphore(0);
        this.semAsientos = new Semaphore(cantAsientos);
        this.semEntregaTicket = new Semaphore(0);
        this.semViajar = new Semaphore(0);
        this.semBajar = new Semaphore(0);
    }


}
