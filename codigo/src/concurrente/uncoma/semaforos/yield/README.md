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