# Modelo de parcial
## Ejercicio 2

```java


1. 

monitor Encoder {

    global Object[] frames = new Object[M+1];
    global int begin, end, size = 0; 

    public void putRawFrame(frame){
        while(isFull()){
            wait()
        }
        frames[begin] = frame;
        begin = next(begin);
        size++
        
    }

    public Object[] getPack(){
        while(size < P){
            wait();
        }
        fs = new Object[P];
        for (i=0; i < P; i++){
            fs[i] = frames[end]
            end = next(end)
            size--
        }

        return fs
    }

    public int next(i){
        return (i+1) % (M+1)
    }

    public boolean isFull(){
        return next(begin) == end;
    }
}

```
2. 

```java

monitor Encoder {

    global Object[] frames = new Object[M+1];
    global int begin, end, size = 0; 

    public void putRawFrame(frame){
        while(isFull()){
            wait()
        }
        frames[begin] = frame;
        begin = next(begin);
        size++
        
    }

    public Object[] getPack(p){
        while(size < p){
            wait();
        }
        fs = new Object[p];
        for (i=0; i < p; i++){
            fs[i] = frames[end]
            end = next(end)
            size--
        }

        return fs
    }
}

```