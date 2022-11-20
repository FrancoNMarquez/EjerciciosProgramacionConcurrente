package CentroDeHemoterapia;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Centro {

    private int camillasDisp;

    Lock lock = new ReentrantLock(true);
    Condition hayCamillas = lock.newCondition();
    int revistas = 9;
    int sillas = 12;


    public void ingresarCentro(){

    }
    public void salirCentro(){

    }
    public void agarrarRevista(){

    }
    public void dejarRevista(){

    }
    public void sentarse(){

    }
    public void pararse(){

    }
    public void verTele(){

    }

}
