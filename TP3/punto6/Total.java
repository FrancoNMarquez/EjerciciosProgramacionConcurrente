package TP3.punto6;

public class Total {
    private int total;

    public Total(){
        total=0;
    }
    public int getTotal(){
        return total;
    }
    public synchronized void incrementar(int sumaParcial){
        total += sumaParcial;
    }
}
