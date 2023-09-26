package TP2;

public class TestCajero {
    public static void main(String[] args) {
        Cliente6 cliente1 = new Cliente6("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
        Cliente6 cliente2 = new Cliente6("Cliente 2", new int[] { 1, 3, 5, 1, 1 });
        Cajera cajero1 = new Cajera("Cajero 1");
// Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();
        cajero1.procesarCompra(cliente1, initialTime);
        cajero1.procesarCompra(cliente2, initialTime);
    }

}
