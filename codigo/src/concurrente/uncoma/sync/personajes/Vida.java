package concurrente.uncoma.sync.personajes;

public class Vida {
    private int vida;

    public Vida(int valorVida) {
        this.vida = valorVida;
    }

    public int getVida() {
        return this.vida;
    }

    public synchronized void operarVida(int valor) {
        if (vida != 0) { // Si no estoy muerto, operar sobre la vida
            System.out.println(Thread.currentThread().getName() + " está operando sobre la vida");
            System.out.println("Vida actual: " + this.vida);
            this.vida = this.vida + valor;
            System.out.println("Vida nueva: " + this.vida);
        } else {  // Estoy muerto
            System.out.println("Ya estoy muerto.");
        }
    }
}
