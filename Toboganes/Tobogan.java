package Toboganes;

import java.util.concurrent.Semaphore;

public class Tobogan {
    Semaphore mutex = new Semaphore(1);

    public void usarTobogan() throws InterruptedException {
        mutex.acquire();
    }
    public void dejarTobogan(){
        mutex.release();
    }

}
