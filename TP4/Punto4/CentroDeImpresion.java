package TP4.Punto4;

import java.util.Random;

public class CentroDeImpresion {

    private Impresora[] impresoraA;
    private Impresora[] impresoraB;

    public CentroDeImpresion(Impresora[] impresoraA, Impresora[] impresoraB) {
        this.impresoraA = impresoraA;
        this.impresoraB = impresoraB;
    }

    public void imprimirA() {
        int cant = impresoraA.length;
        int i = 0;
        boolean noSePudo = true;
        do {
            if (impresoraA[i].intentarImprimir()) {
                noSePudo = false;
                imprimiendo(i, 'A');
            } else {
                i++;
            }
        } while (!noSePudo && cant < i);

        Random random = new Random();
        int pos = random.nextInt((cant - 0 + 1) + 0);
        imprimiendo(pos, 'A');
    }

    public void imprimirB() {
        int cant = impresoraB.length;
        int i = 0;
        boolean noSePudo = true;
        do {
            if (impresoraB[i].intentarImprimir()) {
                noSePudo = false;
                imprimiendo(i, 'B');
            } else {
                i++;
            }
        } while (!noSePudo && cant < i);

        Random random = new Random();
        int pos = random.nextInt((cant - 0 + 1) + 0);
        imprimiendo(pos, 'B');
    }

    private void imprimiendo(int p, char tipo) {
        impresoraB[p].usar();
        System.out.println("Imprimiendo " + tipo);
        impresoraB[p].terminar();
    }

    public void imprimirX() {
        int cant = impresoraA.length;
        int i = 0;
        boolean noSePudo = true;
        do {
            if (impresoraA[i].intentarImprimir()) {
                noSePudo = false;
                imprimiendo(i, 'X');
            } else {
                i++;
            }
        } while (!noSePudo && cant < i);

        if (!noSePudo) {
            cant = impresoraB.length;
            i = 0;
            do {
                if (impresoraB[i].intentarImprimir()) {
                    noSePudo = false;
                    imprimiendo(i, 'X');
                } else {
                    i++;
                }
            } while (!noSePudo && cant < i);
            Random random = new Random();
            int pos = random.nextInt((cant - 0 + 1) + 0);
            imprimiendo(pos, 'X');
        }
    }
}
