package concurrente.uncoma.sync.hamsters;

public class Rueda extends Amenity {
    @Override
    public synchronized void usar() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " usando la rueda...");
        super.usar();
    }
}
