# TP 3 - Synchronized

## Ej 1

### Output 1 - Método sin sincronizar

```
Luis está realizando un retiro de: 10.
Manuel está realizando un retiro de: 10.
Luis: Retiro realizado.
Manuel: Retiro realizado.
Manuel: Los fondos son de:30
Manuel está realizando un retiro de: 10.
Luis: Los fondos son de:30
Luis está realizando un retiro de: 10.
Manuel: Retiro realizado.
Manuel: Los fondos son de:10
Luis: Retiro realizado.
Luis: Los fondos son de:10
Manuel está realizando un retiro de: 10.
Luis está realizando un retiro de: 10.
Manuel: Retiro realizado.
Manuel: Los fondos son de:-10
La cuenta está sobregirada.
Luis: Retiro realizado.
Luis: Los fondos son de:-10
La cuenta está sobregirada.
No hay suficiente dinero en la cuenta para realizar el retiro Sr. Manuel
No hay suficiente dinero en la cuenta para realizar el retiro Sr. Luis
Su saldo actual es de: -10
Su saldo actual es de: -10
La cuenta está sobregirada.
La cuenta está sobregirada.

Process finished with exit code 0
```
Como ámbos están accediendo a la misma variable al mismo tiempo, están operando con datos erróneos sobre la cuenta, al punto que ámbos hacen un retiro dejando la cuenta en `-10`.


