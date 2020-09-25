# TP 4 - Semaforos

## Ej 1
### Enunciado

1. Analice el siguiente código:

```java
public class DualSynch {
    private Object syncObject = new Object();

    public synchronized void f() {
        for (int i = 0; i < 5; i++) {
            System.out.println("f()");
            Thread.yield();
        }
    }

    public void g() {
        synchronized (syncObject) {
            for (int i = 0; i < 5; i++) {
                System.out.println("g()");
                Thread.yield();
            }
        }
    }
}
```

```java
public class SyncObject {
    public static void main(String[] args) {
        final DualSynch ds = new DualSynch();
        // solo por cuestiones prácticas se trabaja de esta forma
        Thread hilo = new Thread() {
            public void run() {
                ds.f();
            }
        };
        hilo.start();
        ds.g();
    }
}
```

    a. ¿Cuál es el efecto de Thread.yield()?
    b. ¿Cuál es el efecto de "synchronized (syncObject)"?
    c. ¿Cuál es el efecto de "synchronized void f()"?
    d. ¿Cuál es la diferencia entre el yield() y sleep()?
    e. Indique el funcionamiento general de lo presentado.

### Respuestas

1. Thread.yield() le va a avisar al planificador de procesos que el thread actual puede esperar, y el planificador puede decidir darle el procesador a otro thread, o continuar ejecutando el thread que invoco el Thread.yield.
2. Es un bloque sincronizado que utiliza el lock de syncObject para que solo un hilo por vez pueda ejecutar el bloque de codigo.
3. Es un bloque sincronizado que utiliza su propio lock para que un solo hilo por vez pueda ejecutar el metodo.
4. La diferencia es que sleep() duerme el hilo por un tiempo determinado sin importar la situacion, mientras que yield solo suspende la ejecucion del hilo si el planificado lo considera necesario, de lo contrario continua ejecutandose con normalidad.

## Ej 2
### Enunciado

2. Considere la clase DualSynch modificada, ahora con un recurso compartido por los hilos:

```java
public class DualSynch {
    private Object syncObject = new Object();
    int dato= 5 ;
    public synchronized void f () {
        for ( int i = 0 ; i < 5 ; i++) {
            dato = dato * 4 ;
            System.out.println( "f()" + dato);
            Thread.yield();
        }
    }
    public void g () {
        synchronized (syncObject) {
            for ( int i = 0 ; i < 5 ; i++) {
                dato = dato + 20 ;
                System.out.println( "g()" + dato);
                Thread.yield();
            }
        }
    }
}
```

```java
public class SyncObject {
    public static void main (String[] args) {
        final DualSynch ds = new DualSynch();
        Thread hilo = new Thread() {
            public void run () {
                ds.f();
            }
        };
        hilo.start();
        ds.g();
    }
}
```

    a. ¿Cuántos hilos hay en ejecución?
    b. ¿Cuál es el recurso compartido?
    c. la salida, ¿es siempre la esperada?
    d. ¿Es posible obtener la siguiente salida?