package Toboganes;

public class Visitante implements Runnable{
    Mirador mirador  = new Mirador();
    int tobogan;
    public void run(){
        while(true){
            try {
                mirador.subirEscalera();
                tobogan=mirador.subirBase();
                mirador.tirarse(tobogan);
                mirador.irse(tobogan);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
