package concurrente.uncoma.sync.surtidor;

import java.util.Random;

public class Auto extends Vehiculo implements Runnable {
    private String patente;
    private int kmNafta;
    private int kilometraje = 0;
    private boolean reserva = false;
    private Surtidor surtidor;
    private int kmFaltantesService;

    public Auto(String unaPatente, int kmRestantes, Surtidor unSurtidor) {
        this.patente = unaPatente;
        this.kmNafta = kmRestantes;
        this.surtidor = unSurtidor;
        this.kmFaltantesService = 10000;
    }

    public Auto(String unaMarca, String unModelo, String unaPatente, int kmRestantes, Surtidor unSurtidor) {
        super(unaMarca, unModelo);
        this.patente = unaPatente;
        this.kmNafta = kmRestantes;
        this.surtidor = unSurtidor;

    }

    public int getKmFaltantes() {
        return this.kmNafta;
    }

    public int getKilometraje() {
        return this.kilometraje;
    }

    public String getPatente() {
        return this.patente;
    }

    private void recorrer(int kilometros) throws InterruptedException {
        if (this.reserva) {
            // System.out.println("En reserva, debe cargar nafta");
        } else {
            Thread.sleep(1000);
            this.kilometraje = this.kilometraje + kilometros;
            this.kmNafta = this.kmNafta - kilometros;
            if (this.kmNafta <= 0) {
                this.reserva = true;
                this.kmNafta = 0;
            }
        }
    }

    private void cargarNafta(int nuevosKm) {
        this.kmNafta = this.kmNafta + nuevosKm;
        this.reserva = false;
    }

    public String toString() {
        return ("Auto: " + this.patente);
    }

    @Override
    public void run() {
        int kilometros = 0;
        for (int i = 0; i < 3; i++) {
            // Cantidad de kilometros a recorrer entre 100 y 1000
            kilometros = (new Random().nextInt(10) + 1) * 100;
            System.out.println(Thread.currentThread().getName() + " recorriendo: " + kilometros);

            try {
                this.recorrer(kilometros);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            // Si en reserva, intentar cargar
            while (this.reserva) {
                System.out.println(Thread.currentThread().getName() + " en reserva, yendo a cargar");
                try {
                    if (this.surtidor.ocupar()) {
                        // Cargando 600km
                        System.out.println(Thread.currentThread().getName() + " cargando nafta");
                        this.cargarNafta(600);
                    } else {
                        // Surtidor ocupado, esperar
                        System.out.println("Surtidor ocupado");
                        Thread.sleep(1500);
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

}

