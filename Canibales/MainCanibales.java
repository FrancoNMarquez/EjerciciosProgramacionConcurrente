package Canibales;

public class MainCanibales {

    public static void main(String[] args) {
         final int CANT_CANIBALES = 30;
        Olla unaOlla  = new Olla();
        Canibal[] canibales = new Canibal[CANT_CANIBALES];
        Thread[] hilosCanibales = new Thread[CANT_CANIBALES];
        Cocinero unCocinero = new Cocinero(unaOlla);
        Thread hiloCocinero = new Thread(unCocinero);
        for (int i = 0; i <CANT_CANIBALES ; i++) {
            canibales[i]=new Canibal(unaOlla);
            hilosCanibales[i] = new Thread(canibales[i]);
            hilosCanibales[i].start();
        }
        hiloCocinero.start();
    }
}
