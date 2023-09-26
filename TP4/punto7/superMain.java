package TP4.punto7;

public class superMain {

    public static void main(String[] args) {
        GestorCruce elCruce = new GestorCruce();
        Auto[] autos = new Auto[10];
        HiloControl unControl = new HiloControl(elCruce);

        for (int i = 0; i < autos.length; i++) {
            if (i % 2 == 0) {
                autos[i] = new Auto(elCruce, 'n');
            } else {
                autos[i] = new Auto(elCruce, 'o');
            }
        }

        Thread[] hilosAutos = new Thread[10];

        for (int j = 0; j < autos.length; j++) {
            hilosAutos[j] = new Thread(autos[j]);
        }

        for (int k = 0; k < hilosAutos.length; k++) {
            hilosAutos[k].start();
        }

        Thread hiloControl = new Thread(unControl);
        hiloControl.start();
    }
}
