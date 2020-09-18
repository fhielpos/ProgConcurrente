package concurrente.uncoma.thread.supermercado;

public class Cliente {
    private String nombre;
    private int[] carroCompra;

    public Cliente(String unNombre, int[] unCarro){
        this.nombre = unNombre;
        this.carroCompra = unCarro;
    }

    public int[] getCarroCompra(){
        return this.carroCompra;
    }

    public String getNombre(){
        return this.nombre;
    }

}
