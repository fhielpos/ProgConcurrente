package concurrente.uncoma.sync.surtidor;

public abstract class Vehiculo {
    private String modelo;
    private String marca;

    public Vehiculo(String unaMarca, String unModelo) {
        this.modelo = unModelo;
        this.marca = unaMarca;
    }

    public Vehiculo(){
        this.modelo = "Null";
        this.marca = "Null";
    }

    public String toString() {
        return (this.marca + " " + this.modelo);
    }
}
