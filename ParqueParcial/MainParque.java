package ParqueParcial;

public class MainParque {
    public static void main(String[] args) {
        final  int CANT_HILOS = 10;
        Parque elParque = new Parque();
        Persona[] personas = new Persona[CANT_HILOS];
        Vecino[] vecinos = new Vecino[CANT_HILOS];
        Thread[] hilosVecinos = new Thread[CANT_HILOS];
        Thread[] hilosPersonas = new Thread[CANT_HILOS];

        for (int i = 0; i < CANT_HILOS ; i++) {
            personas[i] = new Persona(elParque);
            hilosPersonas[i]=new Thread(personas[i]);
            hilosPersonas[i].start();
        }
        for (int i = 0; i < CANT_HILOS ; i++) {
            vecinos[i] = new Vecino(elParque);
            hilosVecinos[i]=new Thread(personas[i]);
            hilosVecinos[i].start();
        }
    }
}
