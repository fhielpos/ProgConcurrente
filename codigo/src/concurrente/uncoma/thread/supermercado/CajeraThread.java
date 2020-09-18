package concurrente.uncoma.thread.supermercado;

public class CajeraThread extends Thread {
    private String nombre;
    private Cliente cliente;
    private long initialTime;

    public CajeraThread(String unNombre, Cliente unCliente) {
        this.nombre = unNombre;
        this.cliente = unCliente;
        this.initialTime = System.currentTimeMillis();
    }



    public void run() {
        System.out.println("La cajera: " + this.nombre +
                " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "
                + this.cliente.getNombre() + " EN EL TIEMPO: "
                + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
        for (int i = 0; i < this.cliente.getCarroCompra().length; i++) {
            // this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesado el producto " + (i + 1)
                    + " del cliente" + this.cliente.getNombre()
                    + "->Tiempo: " + (System.currentTimeMillis() - this.initialTime) / 1000 + " seg");
        }
        System.out.println("La cajera" + this.nombre
                + "HA TERMINADO DE PROCESAR " + this.cliente.getNombre()
                + " EN EL TIEMPO: " + (System.currentTimeMillis() - this.initialTime) / 1000 + " seg");
    }
}

class MainThread {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Cliente 1", new int[]{2, 2, 1, 5,
                2, 3});
        Cliente cliente2 = new Cliente("Cliente 2", new int[]{1, 3, 5, 1,
                1});
    }
}