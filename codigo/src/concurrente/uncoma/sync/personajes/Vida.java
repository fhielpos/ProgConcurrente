package concurrente.uncoma.sync.personajes;

public class Vida {
    private int vida;

    public Vida(int valorVida) {
        this.vida = valorVida;
    }

    public int getVida() {
        return this.vida;
    }

    public synchronized void descontar(int valor) {
        if (this.vida > 0) {
            this.vida = this.vida - valor;
            System.out.println(Thread.currentThread().getName() + " atacando");
        } else
            System.out.println("Ya estoy muerto");
    }

    public synchronized void curar(int valor) {
        System.out.println(Thread.currentThread().getName() +" curando");
        this.vida = this.vida + valor;
    }
}
