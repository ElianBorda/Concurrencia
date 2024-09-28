#  Simulacro Concurrencia

Ejercicio 2 [Semaforos]

*Se desea diseñar un sistema de control para un local de lavado de autos automatizado. El proceso de lavado se lleva a cabo por maquinaria especializada localizada en las siguientes 5 estaciones: remojado, enjabonado, enjuague, secado, encerado. Un vehículo avanza a través de las estaciones en secuencia. En cada estación sólo puede haber un vehículo en un momento dado, por lo que el sistema debe evitar que un veh ́ıculo avance hasta que la estación siguiente esté libre. No obstante, el sistema debe permitir el lavado simultáneo de múltiples vehículos siempre y cuando no haya riesgo de colisiones. Resuelva los siguientes puntos teniendo en cuenta que (i) el proceso realizado por cada máquina no es una acción atómica, y por lo tanto, requiere de cierto tiempo durante el cuál el vehículo debe permanecer en la estación correspondiente; y (ii) el desplazarse de una estación a la siguiente también requiere de cierto tiempo durante el cuál se considera que el vehículo ocupa las dos estaciones.*

```java
permisoIniciar[] = [0,0,0,0,0]
maquinas[] = [1,1,1,1,1,1]

thread Vehiculo() {
  maquina[0].acquired()
  for(i in range(0,5)){

    permisoIniciar[i].release()
    permisoContinuar[i].aquired()
    maquinas[i+1].acquire()
    maquinas[i].release()
  }
  maquinas[5].release()
}

thread Maquina(id) {
  while(true){
    permisoIniciar[id].aquired()
    //Lavar
    permisoContinuar[id].release()
  }
}

```
