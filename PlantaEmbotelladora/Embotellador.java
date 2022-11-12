package PlantaEmbotelladora;

import java.util.Random;

public class Embotellador implements Runnable{
    private short tipo;
    private MesaDeCajas laMesa;
    public Embotellador(MesaDeCajas unaMesa,short tipo){
       this.tipo=tipo;
        this.laMesa=unaMesa;
    }
    public void run(){
        int i=0;
        while(true){
            try {

                laMesa.ponerBotella(this.tipo);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            i++;
        }
    }
}
