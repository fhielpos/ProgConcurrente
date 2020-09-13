package concurrente.uncoma.sync.arreglo;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Resultado final
        int resultado = 0;

        // Hilos
        int cantHilos = 10;                              // Cantidad de hilos
        Sumador sumadores[] = new Sumador[cantHilos];
        Thread hilosSumadores[] = new Thread[cantHilos];

        // Arreglo de n elementos
        int n = 50000;                                     // Cantidad de elementos en el arreglo
        int[] arreglo = new int[n];

        // Rangos
        int inicio = 0;
        int segmento = (int) Math.ceil(n / cantHilos);  // Cada hilo suma rangos con una longitud de segmento
        int fin = segmento;

        // Llenar el arreglo
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (new Random().nextInt(10) + 1);
        }

        // Crear Sumadores y sus hilos
        for (int j = 0; j < cantHilos; j++) {
            sumadores[j] = new Sumador(arreglo, inicio, fin);
            hilosSumadores[j] = new Thread(sumadores[j], "Sumador: " + j);
            hilosSumadores[j].start();

            inicio = fin;               // Comenzar desde donde finalizo el ultimo hilo
            fin = fin + segmento;       // Finalizar en el siguiente segmento
            if (j + 1 == cantHilos - 1)
                // Si el proximo hilo es el ultimo, suma hasta el final
                fin = arreglo.length;
        }

        for (int l = 0; l < cantHilos; l++) {
            // Espero a que terminen los hilos antes de seguir
            try {
                hilosSumadores[l].join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        // Obtener resultados
        for (int k = 0; k < cantHilos; k++) {
            resultado = resultado + sumadores[k].getResultado();
        }

        System.out.println("Resultado final: " + resultado);

        // sumaPrueba(arreglo);

    }

    private static void sumaPrueba(int[] arreglo) {
        // Solo para comprobar que la suma estaba bien
        int resultado = 0;
        for (int i = 0; i < arreglo.length; i++) {
            resultado = resultado + arreglo[i];
        }

        System.out.println("Resultado del arreglo: " + resultado);
    }
}
