package concurrente.uncoma.thread;

public class PingPong extends Thread {
    private String cadena; // Lo que va a escribir.
    private int delay; // Tiempo entre escritura

    public PingPong(String cartel, int cantMs) {
        cadena = cartel;
        delay = cantMs;
    }

    public void run() {
        for (int i = 1; i < delay * 2; i++) {
            System.out.println(cadena + " ");
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    } //fin método run()
} //fin clase PingPong

class testPingPong {
    public static void main(String[] args) {
        PingPong t1 = new PingPong("PING", 33);
        PingPong t2 = new PingPong("PONG", 11);
        PingPong t3 = new PingPong("PANG", 22);
        PingPong t4 = new PingPong("PUNG", 44);

        // Activación
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // Ej 3B - Main, t1 y t2 se ejecutan concurrentemente
        for (int i = 0; i < 150; i++) {
            System.out.print(" Iteracion: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        // Espera unos segundos
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Finaliza la ejecución de los threads
    }
}
