package concurrente.uncoma.sync.surtidor;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int cantAutos = 5;
        Surtidor surtidor = new Surtidor();
        Auto autos[] = new Auto[cantAutos];
        Thread hilosAutos[] = new Thread[cantAutos];

        for (int i = 0; i < cantAutos; i++) {
            // Creando autos
            autos[i] = new Auto(generarPatente(), 800, surtidor);
            // Creando hilos
            hilosAutos[i] = new Thread(autos[i], autos[i].toString());
            // Incializando hilos
            hilosAutos[i].start();
        }

    }

    private static String generarPatente() {
        // Método para generar una patente aleatoria
        String patente = "";
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int numero;

        for (int i = 0; i < 3; i++) {
            patente += letras.charAt(new Random().nextInt(letras.length()));
        }
        numero = new Random().nextInt(999);
        if (numero < 10)
            patente += "00" + numero;
        else if (numero < 100)
            patente += "0" + numero;
        else
            patente += numero;
        return patente;
    }
}
