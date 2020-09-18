package concurrente.uncoma.sync.hamsters;

import java.util.Random;

public abstract class Amenity {

    // Clase que define los amenities dentro de la jaula de Hamsters

    public synchronized void usar() throws InterruptedException {
        int sleep = (new Random().nextInt(500) + 500);
        Thread.sleep(sleep);
    }
}
