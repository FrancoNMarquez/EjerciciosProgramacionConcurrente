package TP3.punto6;

public class ClaseAparte extends Thread{
    private int inicio;
    private int fin;
    private int[] arreglo;
    private Total total;
    public ClaseAparte (int inicio, int fin, int[] arr,Total total){
        this.inicio=inicio;
        this.fin=fin;
        this.arreglo=arr;
        this.total=total;
    }

    public void run(){
        int acumulador=0;
        for (int i = inicio; i < fin; i++) {
            acumulador+= arreglo[i];
        }
        total.incrementar(acumulador);
    }
}
