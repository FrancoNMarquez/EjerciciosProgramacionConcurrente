package PlantaEmbotelladora;

public class PlantaEmbotelladora {
    public static void main(String[] args) {
        MesaDeCajas laMesa = new MesaDeCajas();
        Empaquetador empaquetador = new Empaquetador(laMesa);
        int cantEmbotelladores = 4;
        Embotellador[] arrEmbotelladores = new Embotellador[cantEmbotelladores];
        Thread[] arrHilos = new Thread[cantEmbotelladores];
        Thread hiloEmpaquetador = new Thread(empaquetador);

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


    }
}
