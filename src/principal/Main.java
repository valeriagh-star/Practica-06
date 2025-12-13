package principal;
import java.util.Scanner;
import hilos.HiloSuma;
import recursos.Acumulador;

/**
 * Main
 *
 * Calcula S = sum_{i=1}^{1_000_000} f(i) donde f(i) = i^2 + 3i + 1
 * Demuestra cómo dividir el trabajo en N tareas paralelas (hilos), cada una
 * calculando un subrango y almacenando su resultado parcial de forma segura
 * para hilos.
 *
 * El programa mide el tiempo de ejecución usando 1 hilo (secuencial) y usando 
 * N hilos, luego imprime los resultados y la aceleración observada en nanosegundos.
 *
 * Uso: ejecutar sin argumentos y proporcionar N cuando se solicite, o pasar N
 * como primer argumento en la línea de comandos.
 */

public class Main {

    private static final int TOTAL_NUMEROS = 1000000; // Límite superior de la suma (1,000,000).

    @SuppressWarnings("resource")
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("---- PRÁCTICA 06: HILOS EN JAVA ----");
        System.out.print("Ingrese el número de hilos (N) para la prueba paralela: ");
        
        int nHilos = 0;
     // 1. Manejo de errores: Asegura que la entrada sea un entero.
        if (sc.hasNextInt()) {
            nHilos = sc.nextInt();
        } else {
            System.out.println("Error: Debe ingresar un número entero.");
            return;
        }
     // 2. Manejo de errores: Asegura que el número de hilos sea válido.
        if (nHilos < 1) {
            System.out.println("Error: El número de hilos debe ser mayor a 0.");
            return;
        }
     // Ejecución de la prueba secuencial para la línea base de tiempo.
        System.out.println("\n==== INICIANDO PRUEBA CON 1 HILO (SECUENCIAL) ====");
        ejecutarPrueba(1);
     // Ejecución de la prueba paralela con el número de hilos solicitado por el usuario.
        System.out.println("\n==== INICIANDO PRUEBA CON " + nHilos + " HILOS (PARALELO) ====");
        ejecutarPrueba(nHilos);
        
        sc.close(); // Cierra el recurso Scanner.
    }

    private static void ejecutarPrueba(int numeroHilos) {
     // Objeto compartido. Cada hilo escribirá su resultado parcial aquí.
        Acumulador acumulador = new Acumulador();
        
     // Arreglo para almacenar y gestionar los hilos.
        Thread[] hilos = new Thread[numeroHilos];
        
     // Lógica de División de Rango:
        int rango = TOTAL_NUMEROS / numeroHilos; // Tamaño de la porción principal.
        int resto = TOTAL_NUMEROS % numeroHilos; // Sobrante para asignar al último hilo.
        int inicio = 1; // Punto de partida de la suma.

     // Inicia la medición de tiempo.
        long tiempoInicio = System.nanoTime();

     // Bucle de creación, configuración y lanzamiento de hilos.
        for (int i = 0; i < numeroHilos; i++) {
            int fin = inicio + rango - 1;
            
     // Ajusta el límite superior del último hilo para incluir el resto.
            if (i == numeroHilos - 1) {
                fin += resto;
            }

    // Crea la tarea HiloSuma con su rango y el Acumulador compartido.
            HiloSuma tarea = new HiloSuma(inicio, fin, acumulador);
    // Crea y lanza el hilo.
            hilos[i] = new Thread(tarea);
            hilos[i].start();
    // Establece el inicio del rango para el siguiente hilo.
            inicio = fin + 1;
        }

     // --- Ensamblado del Resultado: Espera (Join) ---
     // Bucle para esperar a que CADA hilo termine. Esto es la sincronización de fin.
        for (int i = 0; i < numeroHilos; i++) {
            try {
    // join() garantiza que el hilo principal NO continúe con la medición del tiempo ni lea el resultado final hasta que
    // este hilo worker haya completado su tarea y escrito su resultado.
                hilos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

   // Fin de la medición de tiempo.
        long tiempoFin = System.nanoTime();
        long duracion = tiempoFin - tiempoInicio;

    // Imprime el resultado final acumulado y el tiempo de ejecución.
   // El resultado final se obtiene del Acumulador (todos los hilos ya terminaron).
        System.out.println("Resultado de la suma: " + acumulador.getTotal());
        System.out.println("Tiempo de ejecución: " + duracion + " nanosegundos");
    }
}