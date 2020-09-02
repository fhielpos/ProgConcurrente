package concurrente.uncoma.thread;
public class Recurso {
    static void uso (){
        // Imprime el nombre del thread en Recurso
        Thread t=Thread.currentThread();
        System.out.println( "en Recurso: Soy " + t.getName());
    }
}
class testeoRecurso {
    public static void main (String[] args){
        Cliente juan= new Cliente();
        juan.setName( "Juan Lopez" );
        Cliente ines= new Cliente ();
        ines.setName ( "Ines Garcia" );
        juan.start();
        ines.start();
    }
}

/*
Ejecucion 1:
soy Ines Garcia
soy Juan Lopez
en Recurso: Soy Ines Garcia
en Recurso: Soy Juan Lopez

Ejecucion 2:
soy Juan Lopez
soy Ines Garcia
en Recurso: Soy Juan Lopez
en Recurso: Soy Ines Garcia

Ejecucion 3:
soy Juan Lopez
soy Ines Garcia
en Recurso: Soy Ines Garcia
en Recurso: Soy Juan Lopez

Ejecucion 4:
soy Ines Garcia
soy Juan Lopez
en Recurso: Soy Ines Garcia
en Recurso: Soy Juan Lopez
 */