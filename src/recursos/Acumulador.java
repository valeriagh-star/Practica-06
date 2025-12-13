package recursos;

public class Acumulador {
	
	// Campo privado que almacena la suma total. Debe ser 'long' para contener el resultado final.
	
    private long total = 0;

    /**
     * Método para agregar la suma parcial de un hilo al total.
     * Es clave que este método sea 'synchronized', ya que esto asegura que solo un hilo a la vez pueda ejecutar el código dentro de este método.
     * Esto evita las condiciones de carrera (Race Conditions) donde múltiples hilos intentarían leer, modificar y escribir 
     * el valor de 'total' simultáneamente, resultando en un valor incorrecto.
     * @param subtotal La suma parcial calculada por un hilo.
     */
    
    public synchronized void acumular(long subtotal) {
        total += subtotal;
    }

    /**
     * Devuelve la suma total acumulada hasta el momento.
     * @return El valor actual de 'total'.
     */
    
    public long getTotal() {
        return total;
    }
    
    /**
     * Reinicia el acumulador a cero. Útil si la misma instancia se reutiliza para múltiples pruebas.
     */
    
    public void reiniciar() {
        total = 0;
    }
}