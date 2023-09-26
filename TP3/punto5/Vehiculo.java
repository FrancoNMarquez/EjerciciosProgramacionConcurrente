package TP3.punto5;

public abstract class Vehiculo{
    protected String patente;
    protected String modelo;
    protected String marca;
    protected int km;
    protected int cantCombustible;
    public Vehiculo(String patente, String modelo, String marca, int km,int combustible) {
        this.patente = patente;
        this.modelo = modelo;
        this.marca = marca;
        this.km = km;
        this.cantCombustible = combustible;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getCantCombustible() {
        return cantCombustible;
    }
    public void setCantCombustible(int cantCombustible) {
        this.cantCombustible = cantCombustible;
    }
    /*Un auto al recorrer varios kilómetros consume
combustible, y cuando llega al nivel de la reserva debe cargar combustible para poder
continuar.
Considere que se desea simular la siguiente situación: Varios autos recorriendo
la ciudad y un surtidor que despacha combustible.
. Realice un programa para representar la situación. ¿Cómo representará los autos? ¿y el
surtidor? Realice una prueba del programa con 5 autos como mínimo.
- Considere que el surtidor tiene capacidad para maximo litros de combustible, que se
van gastando a medida que los autos pasan a abastecerse.
- Cada vez que se realiza una carga de combustible escriba un mensaje apropiado para
informar el estado actual del surtidor*/
}
