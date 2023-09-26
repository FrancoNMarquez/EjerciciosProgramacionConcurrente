package TP4.punto7;

public class Auto implements  Runnable{
    char sentido ;
    GestorCruce elCruce;
    public Auto(GestorCruce elCruce,char sentido){
        this.sentido=sentido;
        this.elCruce=elCruce;
    }

    public void run(){
        if(sentido=='n'){
            llegoNorte();
        }else{
            llegoOeste();
        }
    }
     public void llegoOeste(){
        //acquire
        elCruce.adquirirSemaforoOeste();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + "Cruzando oeste");
        elCruce.saleOeste();
    }
    public void llegoNorte(){
        //acquire
        elCruce.adquirirSemaforoNorte();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + "Cruzando norte");
        elCruce.saleNorte();
    }

}
