package PlantaEmbotelladora;

public class Camion implements Runnable{
    private Almacen unAlmacen;

    public Camion(Almacen almacen){
        this.unAlmacen = almacen;
    }

    public void run(){
        while(true){
            try {
                unAlmacen.sacarCaja();
                Thread.sleep(1000);
                System.out.println("--EL CAMION SE LLEVO LAS CAJAS--");
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
