package concurrente.uncoma.sync.arreglo;

public class Sumador implements Runnable {
    private int[] arreglo;      // Arreglo sobre el cual trabajar
    private int inicio;         // Inicio del rango
    private int fin;            // Fin del rango
    private int resultado;      // Resultado de la suma

    public Sumador(int[] unArreglo, int inicioRango, int finRango){
        this.arreglo = unArreglo;
        this.inicio = inicioRango;
        this.fin = finRango;
    }

    private void sumar(){
        this.resultado = 0;
        for (int i = inicio; i < fin; i++){
            resultado = resultado + arreglo[i];
        }
    }

    public int getResultado(){
        return this.resultado;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +" sumando desde " +this.inicio +" hasta " +this.fin);
        this.sumar();
        System.out.println(Thread.currentThread().getName() +" resultado: " +this.resultado);
    }
}
