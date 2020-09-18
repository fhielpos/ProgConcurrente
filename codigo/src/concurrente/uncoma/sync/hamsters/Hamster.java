package concurrente.uncoma.sync.hamsters;

public class Hamster implements Runnable {
    private Rueda rueda;
    private Plato platoComida;
    private Hamaca hamaca;

    public Hamster(Rueda unaRueda, Plato unPlato, Hamaca unaHamaca) {
        this.rueda = unaRueda;
        this.hamaca = unaHamaca;
        this.platoComida = unPlato;
    }

    public void run() {
        try {
            // Usar rueda
            this.rueda.usar();
            // Usar hamaca
            this.hamaca.usar();
            // Usar el plato
            this.platoComida.usar();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
