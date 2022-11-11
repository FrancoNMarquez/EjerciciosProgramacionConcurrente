package PlantaEmbotelladora;

public class Empaquetador implements Runnable{
    MesaDeCajas laMesa;
    Caja laCaja = null;

    public Empaquetador(MesaDeCajas unaMesa){
        this.laMesa = unaMesa;
    }

    public void run(){
        Caja nuevaCaja ;
        while(true){
            try {
                laCaja=laMesa.sacarCaja();
                nuevaCaja = new Caja(laCaja.getTipo());

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //llevar al almacen
            laMesa.ponerCaja(nuevaCaja);
        }

    }
}
