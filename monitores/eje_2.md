# Monitores

## Ejercicio 2
*Definir un monitor **Semaforo** que implemente las operaciones de un semáforo (acquire y release). ¿Garantiza su solución ausencia de starvation?*

```java

monitor Semaforo {

    int permisos = 0; 

    public void aquired(){
        while (permisos == 0) {
            wait()
        }
        permisos--
    }

    public void release(){
        permisos++
        notifyAll()
    }

} 

```