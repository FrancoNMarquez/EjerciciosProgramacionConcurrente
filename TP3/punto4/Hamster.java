package TP3.punto4;

import java.util.Random;

public class Hamster extends Thread{
    private Plato plato;
    private Rueda rueda;
    private Hamaca hamaca;
    private String nombre;
    public Hamster(Plato plato, Rueda rueda, Hamaca hamaca,String nombre) {
        this.plato = plato;
        this.rueda = rueda;
        this.hamaca = hamaca;
        this.nombre=nombre;
    }
    public Plato getPlato() {
        return plato;
    }
    public Rueda getRueda() {
        return rueda;
    }
    public Hamaca getHamaca() {
        return hamaca;
    }
    public String getNombre(){
        return nombre;
    }
    public void run(){
        Random random = new Random();
        int a= random.nextInt((3-1)+1)+1;
        switch (a) {
            case 1 -> {
                System.out.println(this.nombre);plato.comer();
            }
            case 2 -> rueda.correr();
            case 3 -> hamaca.dormir();
            default -> System.out.println("Aguante Concurrente");
        }
    }
}
