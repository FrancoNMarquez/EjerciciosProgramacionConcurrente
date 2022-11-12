package PlantaEmbotelladora;

public class PlantaEmbotelladora {
    public static void main(String[] args) {
        //Objetos Pasivos
        Almacen unAlmacen = new Almacen();
        MesaDeCajas laMesa = new MesaDeCajas();

        //Objetos Activos
        Camion unCamion = new Camion(unAlmacen);
        Empaquetador empaquetador = new Empaquetador(laMesa,unAlmacen);
        int cantEmbotelladores = 4;
        Embotellador[] arrEmbotelladores = new Embotellador[cantEmbotelladores];

        //Hilos
        Thread[] arrHilos = new Thread[cantEmbotelladores];
        Thread hiloEmpaquetador = new Thread(empaquetador);
        Thread hiloCamion = new Thread(unCamion);
        for (int i = 0; i < cantEmbotelladores; i++) {
            if(i%2!=0){
                arrEmbotelladores[i] = new Embotellador(laMesa,(short)1);
            }else{
                arrEmbotelladores[i] = new Embotellador(laMesa,(short)0);
            }

            arrHilos[i] = new Thread(arrEmbotelladores[i]);
            arrHilos[i].start();
        }
        hiloEmpaquetador.start();
        hiloCamion.start();
    }
}
