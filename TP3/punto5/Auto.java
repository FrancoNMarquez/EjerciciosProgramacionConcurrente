package TP3.punto5;

public class Auto extends Vehiculo implements Runnable{
    private final int MAXIMO_NAFTA = 15;
    private Surtidor surtidor;

//Si implementa runnable, tengo que hacer el run
    public Auto(String patente, String modelo, String marca, int km, int combustible,Surtidor surtidor) {
        super(patente, modelo, marca, km, combustible);
        this.surtidor=surtidor;
    }
    public void run(){
        do{
            recorrerKm();
            if(cantCombustible<=5){
                cantCombustible += surtidor.cargar();
                if(cantCombustible>10){
                    System.out.println("Cargo nafta");
                }
            }
        }while(cantCombustible!=0);
    }
    public void recorrerKm(){
        cantCombustible--; //random
    }
}
