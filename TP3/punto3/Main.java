package TP3.punto3;

public class Main {
    public static void main(String[] args) {
        Sala unaSala = new Sala();

        Encargado encargado1 = new Encargado(unaSala);
        Encargado encargado2 = new Encargado(unaSala);

        encargado1.start();
        encargado2.start();

    }
}
