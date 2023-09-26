package TP2;

public class RunnableEjemplo implements Runnable{
    private String name;
    public RunnableEjemplo(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void run() {
        for (int i = 0; i < 10 ; i++)
            System.out.println(i + " " + getName());
        System.out.println("Termina thread " + getName());
    }
    public static void main (String [] args) {
    //Hay que crear los hilos que implementan el runnable
        System.out.println("Termina thread main");
        Thread t; //Creo una variable de tipo hilo
    }
}
