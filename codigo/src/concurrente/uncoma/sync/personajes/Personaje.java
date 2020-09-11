package concurrente.uncoma.sync.personajes;

import java.util.Random;

public class Personaje extends Thread {
    private int valor;
    private Vida vida;

    public Personaje(int unValor, Vida unaVida) {
        this.valor = unValor;
        this.vida = unaVida;
    }

    public int getValor() {
        return this.valor;
    }

    public void run() {
        int rand = new Random().nextInt(5);
        for (int i = 0; i < rand; i++) {
            this.vida.operarVida(this.valor);
        }
    }

}
