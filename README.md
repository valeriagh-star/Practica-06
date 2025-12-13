 # Practica 06

## ✅ Objetivo
<div align="justify">
El objetivo de esta practica es dividir un problema matemático en sub-tareas que se ejecuten en paralelo mediante hilos y, después, combinar los resultados correctamente.
 
## ✍️ Descripción

* **🎯 Problema Matemático:** Esta práctica consiste en calcular la suma total de la función $f(i) = i^2 + 3i + 1$ desde $i=1$ hasta $1,000,000$.

La tarea se divide entre **$N$ hilos** (donde $N$ es un valor ingresado por el usuario), cada uno responsable de calcular un rango parcial de la suma. El hilo principal debe ensamblar los resultados parciales y garantizar la sincronización para evitar errores. Finalmente, se compararán los tiempos de ejecución para $1, 2, 4$ y $8$ hilos para evaluar el rendimiento.

### 🧮 Ecuación a Resolver

Se debe calcular la suma definida por:

$$
S = \sum_{i=1}^{1000000} f(i)
$$

Donde:

$$
f(i) = i^2 + 3i + 1
$$

### I. Requisitos de Implementación:

1.  **Configuración de Hilos:** El programa debe aceptar como entrada del usuario el número de hilos ($N$) a utilizar.
2.  **División de Trabajo:** El rango total de la suma ($1$ a $1,000,000$) debe dividirse equitativamente entre los $N$ hilos.
    * *Ejemplo para N=4:* Hilo 1: $1 \rightarrow 250,000$, Hilo 2: $250,001 \rightarrow 500,000$, etc.
3.  **Sincronización:** Cada hilo debe calcular su resultado parcial y guardarlo en una estructura compartida **sin generar condiciones de carrera**.
    * Se deben usar mecanismos de sincronización (por ejemplo, `synchronized`, `Locks`) o estructuras concurrentes (`Atomic...`, `ConcurrentHashMap`, etc.).
4.  **Ensamblado:** El hilo principal debe:
    * Esperar a que todos los hilos finalicen (usando `join()` o un mecanismo similar).
    * Sumar los resultados parciales para obtener el resultado final.
    * Imprimir el resultado.

 ## II. Medición de Tiempos

El programa debe medir el tiempo total de ejecución para los siguientes escenarios:

* Tiempo total con **1 hilo** (Línea base).
* Tiempo total con **$N$ hilos** (configurable).

### III. Entregables Obligatorios

1.  **Código Java:** Código fuente bien estructurado y documentado. Debe incluir manejo de errores para el valor de $N$ ingresado por el usuario.
2.  **Tabla de Tiempos:** Una tabla que compare los tiempos de ejecución para:
    * 1 hilo
    * 2 hilos
    * 4 hilos
    * 8 hilos
3. **README:** Contestar en un readme las preguntas que vienen en las instrucciones de la práctica, las cuales serán una breve reflexión.

## ⚙️ Tecnologías utilizadas

* **Lenguaje:** JavaSE-24.
* **IDE:** Eclipse IDE.

## 📁 Estructura del Proyecto

El proyecto está organizado en la siguiente estructura de directorios:

**Practica06/**

**├── src/**

**│   ├── hilos/**

**│   │   └── HiloSuma.java**

**│   ├── principal/**

**│   │   └── Main.java**

**│   └── recursos/**

**│       └── Acumulador.java**

**└── README.txt**

## 📸 Evidencias (Capturas de pantalla)

Aquí se muestran las pruebas de ejecución del programa, demostrando la correcta división de la carga de trabajo, la sincronización y la medición de los tiempos para el cálculo de la suma.

![Captura 1 de la Ejecución de Main](practica06(1).png)
![Captura 2 de la Ejecución de Main](practica06(2).png)
![Captura 3 de la Ejecución de Main](practica06(3).png)
![Captura 4 de la Tabla Comparativa](practica06(4).png)


El código fuente de los directorios está organizado por paquetes y se puede revisar directamente en la carpeta [src/](https://github.com/valeriagh-star/Practica-06/tree/main/src).

| Carpetas | Ruta del Archivo .java |
| :--- | :--- |
| **Clase HiloSuma** | [src/hilos/HiloSuma.java](https://github.com/valeriagh-star/Practica-06/blob/main/src/hilos/HiloSuma.java) |
| **Clase Acumulador** | [src/recursos/Acumulador.java](https://github.com/valeriagh-star/Practica-06/blob/main/src/recursos/Acumulador.java) |
| **Clase Main** | [src/principal/Main.java](https://github.com/valeriagh-star/Practica-06/blob/main/src/principal/Main.java) |
| **README** | [Practica06/main/README.txt](https://github.com/valeriagh-star/Practica-06/blob/main/README.txt) | 

## ▶️ Instrucciones de ejecución

1.  **Clonar/Importar el repositorio el Repositorio:** Importa la carpeta Proyecto como un proyecto Java existente en Eclipse o IntelliJ.
2.  **Abrir Main:** Localiza la clase Main.java en package principal.
3.  **Ejecutar:** Haz clic derecho sobre Main.java y selecciona "Run As" -> "Java Application".
4.  **Interacción:** Una vez que el programa se inicie, se detendrá esperando tu entrada en la consola de Eclipse: El programa te pedirá que ingreses el número de hilos ($N$) a utilizar para el cálculo. Para realizar las pruebas de la práctica, ejecuta el programa cuatro veces, ingresando los siguientes valores en cada ocasión:
    * 1 
    * 2 
    * 4 
    * 8
 5. **Resultados:** Después de cada ejecución, la consola mostrará el resultado final de la suma y el tiempo total de ejecución en nanosegundos (ns).
 6. **Comparación:** Guarda estos valores (especialmente el tiempo) para cada uno de los 4 escenarios, ya que estos datos se utilizarán para generar la tabla comparativa de tiempos en el readme.txt.
</div>
















  
</div>
