package concurrente.uncoma.sync.surtidor;

import java.util.Random;

public class Auto extends Vehiculo implements Runnable {
    private String patente;
    private int kmFaltantes;
    private int kilometraje = 0;
    private boolean reserva = false;
    private Surtidor surtidor;

    public Auto(String unaPatente, int kmRestantes, Surtidor unSurtidor) {
        this.patente = unaPatente;
        this.kmFaltantes = kmRestantes;
        this.surtidor = unSurtidor;
    }

    public Auto(String unaMarca, String unModelo, String unaPatente, int kmRestantes, Surtidor unSurtidor) {
        super(unaMarca, unModelo);
        this.patente = unaPatente;
        this.kmFaltantes = kmRestantes;
        this.surtidor = unSurtidor;

    }

    public int getKmFaltantes() {
        return this.kmFaltantes;
    }

    public int getKilometraje() {
        return this.kilometraje;
    }

    public String getPatente() {
        return this.patente;
    }

    private void recorrer(int kilometros) throws InterruptedException{
        if (this.reserva) {
            // System.out.println("En reserva, debe cargar nafta");
        } else {
            Thread.sleep(1000);
            this.kilometraje = this.kilometraje + kilometros;
            this.kmFaltantes = this.kmFaltantes - kilometros;
            if (this.kmFaltantes <= 0) {
                this.reserva = true;
                this.kmFaltantes = 0;
            }
        }
    }

    private void cargarNafta(int nuevosKm) {
        this.kmFaltantes = this.kmFaltantes + nuevosKm;
        this.reserva = false;
    }

    @Override
    public void run() {
        int kilometros = 0;
        for (int i = 0; i < 2; i++) {
            kilometros = new Random().nextInt(12) * 100;
            System.out.println(Thread.currentThread().getName() + " recorriendo: " + kilometros);
            try {
                this.recorrer(kilometros);
            } catch (InterruptedException ex){
                ex.printStackTrace();
            }
            if (this.reserva) {
                System.out.println(Thread.currentThread().getName() + " en reserva, yendo a cargar");
                try {
                    if (this.surtidor.ocupar()) {
                        // Cargando 600km
                        System.out.println(Thread.currentThread().getName() + " cargando nafta");
                        this.cargarNafta(600);
                    } else
                        System.out.println("Surtidor ocupado");
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

}

