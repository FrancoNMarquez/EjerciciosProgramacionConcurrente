package TP3.punto5;

public class Surtidor {
    private int combustibleDisponible;
    public Surtidor(int nafta){
        this.combustibleDisponible=nafta;
    }

    public synchronized int cargar(){
        int naftaCargada=0;
        if(combustibleDisponible!=0){
            combustibleDisponible=combustibleDisponible-10; //Usar random para cargar
            naftaCargada=10;
            System.out.println("Se cargo nafta");
        }
        return naftaCargada;
    }
}
