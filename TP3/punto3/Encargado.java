package TP3.punto3;

import java.util.Scanner;

public class Encargado extends Thread{
    private Sala salita;

    public Encargado(Sala unaSala){
        this.salita=unaSala;
    }
    public void run(){
        System.out.println("Ingrese la butaca del 0 al 9:");
        Scanner sc = new Scanner(System.in);
        int butaca = sc.nextInt();
        this.salita.reservar(butaca);
    }
}
