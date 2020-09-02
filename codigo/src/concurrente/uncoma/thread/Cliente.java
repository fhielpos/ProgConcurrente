package concurrente.uncoma.thread;

public class Cliente extends Thread {
    @Override
    public void run (){
        // Imprime el nombre del thread actual
        System.out.println("soy " +Thread.currentThread().getName());
        Recurso.uso();
        try {
            Thread.sleep( 2000 );
        } catch (InterruptedException e) {
        };
    };
}