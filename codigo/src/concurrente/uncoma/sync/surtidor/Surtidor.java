package concurrente.uncoma.sync.surtidor;

import java.util.Random;

public class Surtidor {
    private boolean libre;

    public Surtidor(){
        this.libre = true;
    }

    public boolean estaDisponible(){
        return this.libre;
    }

    public synchronized boolean ocupar() throws InterruptedException{
        if (this.libre){
            this.libre = false;
            Thread.sleep((new Random().nextInt(3)+1)*1000);
            return true;
        }
        else
            return false;
    }
}
