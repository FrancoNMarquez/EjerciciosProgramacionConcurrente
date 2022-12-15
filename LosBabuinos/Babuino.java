package LosBabuinos;

public class Babuino implements Runnable{
    Cuerda laCuerda = new Cuerda();
    char direccion ; //Ingresar N o S.
    public Babuino(char direccion,Cuerda unaCuerda){
        laCuerda=unaCuerda;
        this.direccion=direccion;
    }
    public void run(){

            try {
                if(direccion=='d') {
                    laCuerda.cruzarDerecha();
                    System.out.println("Estoy cruzando por la der...");
                    Thread.sleep(1000);
                    laCuerda.termineCruzarDerecha();

                }else{
                    laCuerda.cruzarIzquierda();
                    System.out.println("Estoy cruzando por la izq...");
                    Thread.sleep(1000);
                    laCuerda.termineCruzarIzquierda();

                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

    }
}
