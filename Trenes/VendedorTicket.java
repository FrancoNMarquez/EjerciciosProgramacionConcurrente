package Trenes;

public class VendedorTicket implements Runnable {

    private Tren tren;

    public VendedorTicket(Tren tren) {
        this.tren = tren;
    }

    @Override
    public void run() {
        while (true) {
            tren.venderTicket();
            System.out.println("--------- " + Thread.currentThread().getName() + " Va a vender un Ticket ---------");
            vender();
            tren.entregarTicket();
            System.out.println("--------- " + Thread.currentThread().getName() + " Entrego un Ticket ---------");
        }
    }

    private void vender() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}