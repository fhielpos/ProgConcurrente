package concurrente.uncoma.sync.hamsters;

public class Hamaca extends Amenity {
    @Override
    public synchronized void usar() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " usando la hamaca...");
        super.usar();
    }
}
