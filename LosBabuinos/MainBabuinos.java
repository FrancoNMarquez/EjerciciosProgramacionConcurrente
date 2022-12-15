package LosBabuinos;

public class MainBabuinos {
    public static void main(String[] args) {
        Cuerda cuerda = new Cuerda();
        Babuino[] babuinos = new Babuino[100];
        Thread[] hilosBabuinos = new Thread[100];

        for (int i = 0; i <100 ; i++) {
            if(i%2==0){
                babuinos[i]= new Babuino('d',cuerda);
            }else{
                babuinos[i]= new Babuino('i',cuerda);
            }
            hilosBabuinos[i] = new Thread(babuinos[i]);
            hilosBabuinos[i].start();
        }
    }
}
