package TP3.punto4;
// identificar objetos activos
/*
* identificar donde hay que sincronizar
* maximizar la concurrencia, no exceder el uso de synchronized
* poner to do en el hilo, responsabilidad
* sublime
* */

public class principal {
    public static void main(String[] args) {
        Hamaca unaHamaca = new Hamaca();
        Plato unPlato = new Plato();
        Rueda unaRueda = new Rueda();

        Hamster[] hamsters = new Hamster[5];

        for(int i = 0; i< hamsters.length;i++){
            hamsters[i] = new Hamster(unPlato, unaRueda, unaHamaca, "Hamster "+i);
        }
        for (Hamster hamster : hamsters) {
            hamster.start();
        }

    }
}
