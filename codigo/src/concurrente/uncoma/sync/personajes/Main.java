package concurrente.uncoma.sync.personajes;

public class Main {
    public static void main(String[] args) {
        Vida vida = new Vida(10);

        // Curandero suma 3 de vida
        Personaje curandero = new Personaje(3, vida);
        curandero.setName("Curandero");

        // Orco suma -3 de vida
        Personaje orco = new Personaje(-3, vida);
        orco.setName("Orco");

        curandero.start();
        orco.start();
    }

}
