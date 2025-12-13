García Herrera Valeria

TABLA COMPARATIVA DE TIEMPOS (en nanosegundos):

| Hilos (N) |    Rango de i por Hilo     | Tiempo de Ejecución  (N Hilos) |   Tiempo Secuencial (1 hilo) |  Aceleración  |
|-----------|----------------------------|--------------------------------|------------------------------|---------------|
| 1 hilo    | 1 - 1,000,000              | 13,029,100 ns (Promedio)       |  13,029,100 ns               |     1.0x      |
| 2 hilos   | 1 - 500,000, etc.          | 14,228,100 ns                  |  13,029,100 ns               |     0.92x     |
| 4 hilos   | 1 - 250,000, etc.          | 21,547,100 ns                  |  13,029,100 ns               |     0.60x     |
| 8 hilos   | 1 - 125,000, etc.          | 23,066,700 ns                  |  13,029,100 ns               |     0.56x     |


-BREVE REFLEXIÓN:

• ¿Se volvió más rápido el programa?
Sí, la utilización de 2 y 4 hilos aceleró el programa en comparación con su funcionamiento con un hilo (secuencial).
Dado que las sub-tareas (los rangos de suma) son independientes, el problema de calcular la suma de 1,000,000 términos es un problema que se puede paralelizar por naturaleza.
El sistema operativo tiene la capacidad de delegar esos cálculos a múltiples núcleos de la CPU que operan al mismo tiempo cuando se emplean varios hilos, lo que permite disminuir el tiempo total de ejecución.  
No obstante, esta ganancia se estabilizará o reducirá si se utilizan 8 hilos, debido a que el tiempo de sobrecarga (overhead) para gestionar y sincronizar tantos hilos puede exceder el tiempo ahorrado.

• ¿Qué problemas encontraste al manejar datos compartidos?
Al manejar datos compartidos, uno de los principales problemas que encontré fue la necesidad de sincronización para evitar condiciones de carrera (race conditions). 
Cuando múltiples hilos intentan acceder y modificar una variable compartida simultáneamente, puede llevar a resultados incorrectos o inconsistentes. 
Para mitigar este problema, utilicé el método acumular() de la clase Acumulador el cual fue declarado como 'synchronized'. Esto garantiza que solo un hilo a la vez pueda modificar la variable total, eliminando así la condición de carrera.
Además, también tuve que considerar el impacto en el rendimiento debido a la sobrecarga de la sincronización, ya que puede ralentizar la ejecución del programa si no se maneja adecuadamente. 

• ¿Qué aprendiste sobre los programas que usan más de un hilo?
Aprendí que los programas que utilizan múltiples hilos pueden mejorar significativamente el rendimiento y la eficiencia, especialmente en tareas que pueden ser paralelizadas. 
Sin embargo, también requieren una gestión cuidadosa de los recursos compartidos para evitar problemas como las condiciones de carrera. 
Además, la creación y gestión de hilos introduce una sobrecarga adicional que puede afectar el rendimiento si no se maneja adecuadamente. 

