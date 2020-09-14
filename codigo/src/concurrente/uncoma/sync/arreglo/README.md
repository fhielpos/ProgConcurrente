# TP 3 - Synchronized

## Ej 6
## Enunciado

    6)Se dispone de un arreglo de números enteros comprendidos entre 1 y 10 con capacidad
    para 50.000 números. Se desea disponer de un programa que efectúe la suma de
    los componentes del arreglo utilizando una estrategia concurrente, que obtenga la
    suma final mediante sumas parciales calculadas por una serie de hilos
    independientes.
    Escriba un programa que realice la tarea propuesta, y que cumpla con las
    especificaciones siguientes:
    
    * El arreglo debe llenarse con números enteros entre 1 y 10 generados
    aleatoriamente. Nota: utilizar la clase Random de java.
    * Habrá k hilos, entre los cuales se dividirá el trabajo a realizar: cada uno debe
    ocuparse de proporcionar la suma parcial de un segmento del arreglo.
    * Habrá un programa principal que creará y rellenará el arreglo de datos, y
    escribirá el valor final resultante de la suma realizada por los hilos.
    
## Salida del programa

```log
Sumador: 6 sumando desde 30000 hasta 35000
Sumador: 9 sumando desde 45000 hasta 50000
Sumador: 5 sumando desde 25000 hasta 30000
Sumador: 3 sumando desde 15000 hasta 20000
Sumador: 8 sumando desde 40000 hasta 45000
Sumador: 4 sumando desde 20000 hasta 25000
Sumador: 0 sumando desde 0 hasta 5000
Sumador: 1 sumando desde 5000 hasta 10000
Sumador: 2 sumando desde 10000 hasta 15000
Sumador: 7 sumando desde 35000 hasta 40000
Sumador: 8 resultado: 27793
Sumador: 7 resultado: 27427
Sumador: 3 resultado: 27685
Sumador: 9 resultado: 27282
Sumador: 5 resultado: 27591
Sumador: 1 resultado: 27571
Sumador: 0 resultado: 27431
Sumador: 6 resultado: 27288
Sumador: 2 resultado: 27578
Sumador: 4 resultado: 27482
Resultado final: 275128

Process finished with exit code 0
```
