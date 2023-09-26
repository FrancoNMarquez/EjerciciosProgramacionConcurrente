package TP4.Punto1;

public class SynchronizedObjectCounter {
    private int c = 0;
    public void increment(){
        synchronized ((Integer)c) {c++;} // Este elemento debe ser casteado a Integer
    }
    public void decrement() {

        synchronized (this) {c--;} // el this sincroniza el lock de la clase SynchronizedObjectCounter, pero no de c
    }
    public int value() {return c;}

}
