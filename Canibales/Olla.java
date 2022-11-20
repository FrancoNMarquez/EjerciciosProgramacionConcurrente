package Canibales;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Olla {

    //Cerrojos
    int raciones = 10;
    Lock lock = new ReentrantLock(true);
    Condition debeCocinar = lock.newCondition();
    Condition esperaComida = lock.newCondition();

    public void servirseComida() throws InterruptedException {
        lock.lock();

        if(!hayComida()){
            debeCocinar.signal();
            while (!hayComida()){

                esperaComida.await();
            }
        }
        System.out.println(Thread.currentThread().getName()+" racion numero:"+raciones);
        raciones--;
        lock.unlock();

    }
    public void cocinar() throws InterruptedException {
        lock.lock();
        while(hayComida()){
            debeCocinar.await();
        }
        System.out.println("Cocinando...");
        raciones=10;
        esperaComida.signalAll();
        lock.unlock();
    }
    private boolean hayComida(){
        return raciones!=0;
    }
}
