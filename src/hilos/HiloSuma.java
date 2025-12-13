package hilos;
import recursos.Acumulador;

// HiloSuma implementa Runnable, lo que significa que define el código a ejecutar por un hilo.

public class HiloSuma implements Runnable {

// Campos para definir el rango de la suma que este hilo calculará.
	
    private int inicio;
    private int fin;
    
 // Referencia al objeto compartido donde se depositará el resultado.
    
    private Acumulador acumulador;
    
    /**
     * Constructor que inicializa los límites del rango y la referencia al Acumulador.
     */

    public HiloSuma(int inicio, int fin, Acumulador acumulador) {
        this.inicio = inicio;
        this.fin = fin;
        this.acumulador = acumulador;
    }
    
    /**
     * Método run(): El código que se ejecuta cuando el hilo es iniciado (thread.start()).
     */

    @Override
    public void run() {
        long sumaParcial = 0; // Variable local para acumular el resultado de este hilo.
    // Bucle que calcula la suma f(i) = i^2 + 3i + 1 dentro del rango [inicio, fin].
        for (int i = inicio; i <= fin; i++) {
    // Se usa 'long' (con 3L y 1L) para asegurar que la multiplicación i*i no desborde antes de ser asignada a 'long termino'.
            long termino = (long) i * i + 3L * i + 1;
            sumaParcial += termino;
        }
   // Una vez terminada la suma local, el resultado es enviado al objeto compartido.
  // La llamada a acumular() está protegida por 'synchronized' en la clase Acumulador.
        acumulador.acumular(sumaParcial);
    }
}