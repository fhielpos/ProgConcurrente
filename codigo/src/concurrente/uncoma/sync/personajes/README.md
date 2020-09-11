# TP 3 - Synchronized

## Ej 2
## Enunciado
    2) Realice un programa en donde se muestre el comportamiento de dos personajes que
    alteran nuestro puntos de VIDA (recurso compartido) que se inicializa con 10, de la
    siguiente manera:
    
    El Orco (hilo 1) nos golpea quitándonos (-) 3 de VIDA.
    El Curandero (hilo 2) nos cura dándonos (+) 3 de VIDA.
    
    Debe tener en cuenta que las operaciones son: obtener VIDA, operarlo y volverlo a
    guardar.
    
        a) Pruebe la ejecución varias veces e indique el valor resultante en cada una.
        b) ¿Qué puede concluir?
        c) Ahora modifique el programa utilizando alguna herramienta para sincronizar la
        ejecución.


## Respuestas
### A)
    
Resultados finales:
```
Ya estoy muerto.
```
```
Ya estoy muerto.
```
```
Orco está operando sobre la vida
Vida actual: 13
Vida nueva: 10
```

### B) 
   
Al no estar sincronizado, en ocaciones termino muerto, cuando debería quedar con 10 de vida siempre.

### C)

Se sincroniza el metodo operarVida() de Vida.