package concurrente.uncoma.sync.hamsters;

public class Plato extends Amenity {
    @Override
    public synchronized void usar() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " comiendo...");
        super.usar();
    }
}
