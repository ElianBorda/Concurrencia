# Simulacro de parcial
## Mensajes

```java



global Channel hotel;
global Channel vuelo; 
global Channel auto;
global Channel agencia; 

process Agencia {
    while(true){
        pedido = agencia.receive()

        hotel.send(pedido.fecha)
        auto.send(pedido.fecha)
        vuelo.send(pedido.fecha)

        paqueteDisponible = hotel.receive() && auto.receive() && vuelo.receive()

        pedido.channel.send(paqueteDisponible)
    }
}
```


```java
process Agencia {
    while(true){
        pedido = agencia.receive()

        thread(pedido){
            hotel.send(pedido.fecha)
            auto.send(pedido.fecha)
            vuelo.send(pedido.fecha)

            paqueteDisponible = hotel.receive() && auto.receive() && vuelo.receive()

            pedido.channel.send(paqueteDisponible)
        }
        
    }
}

```

```java

global Channel[] hotel;
global Channel[] vuelo; 
global Channel[] auto;
global Channel[] agencia; 
global Bool puedeHotel = false;
global Bool puedeVuelo = false;
global Bool puedeAuto = false;

process Agencia {
    while(true){
        pedido = agencia.receive()

        thread(pedido){
                for (h : hotel) {
                    thread(h, pedido){
                        h.send(pedido.fecha)
                        if (!puedeHotel){
                            puedeHotel = puedeHotel && h.receive()    
                        }
                        
                    }
                }
                for (a : auto) {
                    thread(a, pedido){
                        a.send(pedido.fecha)
                        if(!puedeAuto){
                            puedeAuto = puedeAuto && a.receive()
                        }
                    }
                    
                }   
                for (v : vuelo) {
                    thread(v, pedido){
                        v.send(pedido.fecha)
                        if(!puedeVuelo){
                            puedeVuelo = puedeVuelo && v.receive()
                        }
                    }
                }

            paqueteDisponible = puedeHotel && puedeAuto && puedeVuelo
            pedido.channel.send(paqueteDisponible)
        }
        
    }
}

```