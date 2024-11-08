# Monitores

## Ejercicio 1
*Implementar un monitor **Contador** que permita incrementar y decrementar concurrentemente de forma segura*

```java

monitor Contador {

    int valor = 0; 

    public void incrementar(){
        valor++
    }

    public void decrementar(){
        valor--
    }

} 

```