package concurrente.uncoma.thread;

public class MiEjecucion extends Thread {
    public void run() {
        ir();
    }

    public void ir() {
        hacerMas();
    }

    public void hacerMas() {
        System.out.println("En la pila");
    }
}

class ThreadTesting {
    public static void main(String[] args) {
        Thread miHilo = new MiEjecucion();
        miHilo.start();
        // Agregar join para que main espere a que el proceso referenciado termine
        try {
            miHilo.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("En el main");
    }
}

/*

Ejecucion 1 a 5:
En el main
En la pila

Ejecucion con join:
En la pila
En el main

 */