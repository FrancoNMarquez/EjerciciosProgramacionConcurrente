package PlantaEmbotelladora;

import java.util.Random;

public class Embotellador implements Runnable{
    private short tipo;
    private MesaDeCajas laMesa;
    public Embotellador(MesaDeCajas unaMesa){
        Random random = new Random();
        int nro = random.nextInt((1-0+1)+0);
        this.laMesa=unaMesa;
    }
    public void run(){
        while(true){
            try {
                laMesa.ponerBotella(this.tipo);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
