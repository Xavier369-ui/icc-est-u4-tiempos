import java.util.concurrent.Callable;

import models.Results;

public class BenchMarking {


    public static Results medir_tiempo(Callable<Void> func, int sampleSize, String functionName) {
        try {
            long inicio = System.nanoTime();
            func.call();
            long fin = System.nanoTime();

            return new Results(
                sampleSize,
                functionName,
                (fin - inicio) / 1_000_000_000.0
            );

        } catch (Exception e) {
            throw new RuntimeException("ERROR midiendo el tiempo", e);
        }
    }
    /* 
    long inicio_milis = System.currentTimeMillis();
        long inicio = System.nanoTime();
        for(int i =0; i<100000;i++){
            String s = "Numero: " + i;
            System.out.println(s);
        }
        long fin = System.nanoTime();
        System.out.println("Tiempo transcurrido: " + (fin-inicio) + " nanos segundos");
        System.out.println("Tiempo transcurrido: " + (fin-inicio)/1_000_000_000.0 + " segundos");
        Results result = new Results(
            1,
            "Imprimir 100000 numeros",
            (fin-inicio) / 1_000_000_000.0);
        System.out.println(result);
    */

    
    
}
