package PlantaEmbotelladora;

public class Empaquetador implements Runnable{
    MesaDeCajas laMesa;
    Caja laCaja = null;
    Almacen unAlmacen ;
    public Empaquetador(MesaDeCajas unaMesa, Almacen elAlmacen){
        this.laMesa = unaMesa;
        this.unAlmacen = elAlmacen;
    }

    public void run(){
        //Si son dos cosas distinas, pero con la misma excepcion
        //uso 2 tryCatch o todoo en uno solo?
        Caja nuevaCaja ;
        while(true){
            try {
                laCaja=laMesa.sacarCaja();
                nuevaCaja = new Caja(laCaja.getTipo());

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //llevar al almacen
            try {
                unAlmacen.ponerCaja(laCaja);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            laMesa.ponerCaja(nuevaCaja);

        }

    }
}
