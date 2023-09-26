package TP3.punto6;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        ClaseAparte[] arrHilos;

        int cantHilos;
        int arreglo[] = new int[50000];
        Random random = new Random();
        int sumarVerificar = 0;
        for (int i = 0; i < arreglo.length ; i++) {
            arreglo[i]= random.nextInt((10-1)+1)+1;
            sumarVerificar+=arreglo[i];
        }
        Total total = new Total();
        cantHilos=-1;
        while(!(cantHilos >=0 && cantHilos<50000)){
            System.out.println("Ingrese cantidad de Hilos: ");
            Scanner sc = new Scanner(System.in);
            cantHilos = sc.nextInt();
        }

        arrHilos= new ClaseAparte[cantHilos];
        int cantPosArr = 0;
        try{
            cantPosArr = arreglo.length / cantHilos ;
        }catch (ArithmeticException e){
            System.out.println("Si pones 0 hilos tira error. Reintenta mas tarde.");
        }
        int inicio=0;
        int fin=0;
        for (int i = 0; i < cantHilos ; i++) {
            inicio=i*cantPosArr;
            if(i==cantHilos-1){
                fin=arreglo.length;
            }else{
                fin=(i+1)*cantPosArr;
            }
            arrHilos[i]= new ClaseAparte(inicio,fin,arreglo,total);
        }
        for (int i = 0; i <cantHilos ; i++) {
            arrHilos[i].start();
        }
        System.out.println("Suma verificar= "+sumarVerificar);
        System.out.println("Total ="+total.getTotal());
    }
}
