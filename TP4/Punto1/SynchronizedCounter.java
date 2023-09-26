package TP4.Punto1;

public class SynchronizedCounter {
    private int c = 0;
    public synchronized void increment() {c++;}
    public void decrement() {c--;} // El decrementar tiene que ser sincronizado.
    public synchronized int value() {return c;}

}
