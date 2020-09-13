package concurrente.uncoma.sync.escritores;

public class Escritor implements Runnable {
    private int id;
    private char escribir;
    private Turnero turno;

    public Escritor(int identificador, char letra, Turnero turnero) {
        this.id = identificador;
        this.escribir = letra;
        this.turno = turnero;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            if (this.turno.getTurno() == this.id) {
                // Escribo mi CHAR la cantidad de veces que valga mi identificador
                for (int j = 0; j < this.id; j++) {
                    System.out.print(this.escribir);
                }
                this.turno.incrementar();
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
