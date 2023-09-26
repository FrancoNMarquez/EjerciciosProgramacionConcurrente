package TP3.punto3;
//recurso compartido
public class Sala {
    private boolean[] asientos= new boolean[10];

   public synchronized void reservar(int butaca){
       if(!asientos[butaca]){
           asientos[butaca]=true;
           System.out.println("Se ha reservado con exito");
       }else{
           System.out.println("Esa butaca ya esta reservada por otra persona");
       }
   }
}

