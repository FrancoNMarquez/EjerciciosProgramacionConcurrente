package TP4.Punto4;

public class Usuario implements Runnable {

    private char tipo;
    private CentroDeImpresion centro;

    public Usuario(char tipo, CentroDeImpresion c) {
        this.tipo = tipo;
        this.centro = c;
    }

    public void run() {
        tipo = java.lang.Character.toLowerCase(tipo);
        switch (tipo) {
            case 'a':
                imprimirA();
                break;
            case 'b':
                imprimirB();
                break;
            case 'x':
                imprimirX();
                break;
            default:
                System.out.println("elegi bien, kpo");
                break;

        }
    }

    private void imprimirA() {
        centro.imprimirA();
    }

    private void imprimirB() {
        centro.imprimirB();
    }

    private void imprimirX() {
        centro.imprimirX();
    }
}
