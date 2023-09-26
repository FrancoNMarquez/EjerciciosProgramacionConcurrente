package TP3.punto5;

import java.util.Scanner;

public class theMain {
    public static void main(String[] args) {
        Surtidor elSurtidor = new Surtidor(100);
        Auto arrayAutos[] = new Auto[5];
        Thread arrayHilos[] = new Thread[5];
        Scanner sc = new Scanner(System.in);
        String patentes[] = {"abc123", "abc321","asd342","bbb333","aaa111"};
        String modelo[] = {"2000","2001","2003","2004","2018"};
        String marca[] = {"Honda","Honda","Honda","Honda","Honda"};
        int km =10;
        int combustible = 15;

        for (int i = 0; i < 5; i++) {
            arrayAutos[i]= new Auto(patentes[i],modelo[i],marca[i],km,combustible,elSurtidor);
        }
        for (int i = 0; i <5 ; i++) {
            arrayHilos[i] = new Thread(arrayAutos[i]);
        }
        for (int i = 0; i <5 ; i++) {
            arrayHilos[i].start();
        }
    }
}
