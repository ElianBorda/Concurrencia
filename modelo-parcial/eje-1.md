# Modelo parcial 
## Monitores

*Se desea implementar un monitor para coordinar multiples threads que participan de un proceso de encoding de video. En este escenario un thread actua como productor de cuadros de video crudos (sin compresion), mientras que otros threads consumen paquetes de cuadros para realizar el proceso de compresion (encoding). Dado que los cuadros de video crudo son pesados, se desea que en ningun momento se almacenen mas de M cuadros en el monitor (i.e, bloqueando al productor de cuadros)*

Resuelva los siguientes puntos: 

1.  

```java

monitor Encoder {

    public void putRawFrame(frame){
        
    }

}

```