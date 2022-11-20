package ParqueParcial;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Parque {
    private final int MAX_USUARIOS = 10;
    private int usuariosAdentro;
    private int vecinosEsperando;
    Lock lock = new ReentrantLock(true);
    Condition esperaVecino = lock.newCondition();
    Condition esperaNormal= lock.newCondition();

    public void entrarParque() throws InterruptedException {
        lock.lock();
        while(lleno()&&vecinosEsperando!=0){
            esperaNormal.await();
        }
        usuariosAdentro++;
        lock.unlock();
    }
    public void entrarParqueVecino() throws InterruptedException {
        lock.lock();
        vecinosEsperando++;
        while(lleno()){
            esperaVecino.await();
        }
        vecinosEsperando--;
        usuariosAdentro++;

        lock.unlock();
    }
    private boolean lleno(){
        return usuariosAdentro==MAX_USUARIOS;
    }
    public void salirParque(){
        lock.lock();
        usuariosAdentro--;
        esperaVecino.signalAll();
        esperaNormal.signalAll();
        System.out.println("Sali del parque:"+ Thread.currentThread().getName());
        lock.unlock();
    }
}
