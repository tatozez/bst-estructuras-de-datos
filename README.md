# 🌳 Árbol Binario de Búsqueda (BST) en Java

Implementación desde cero de un **Árbol Binario de Búsqueda** que almacena números enteros, sin utilizar librerías nativas de árboles de Java.

---
## Fase 1 - Fichas Técnicas

Las fichas técnicas de las estructuras arbóreas investigadas se encuentran en el siguiente archivo PDF:

[Ver Fichas Técnicas en PDF](./Fichas_Tecnicas_Estructuras_Arboreas_Roberto_Chavarria.pdf)

## 📋 Información del Proyecto

| Campo | Detalle |
|-------|---------|
| **Universidad** | Universidad Da Vinci de Guatemala |
| **Facultad** | Ingeniería en Sistemas y Ciencias de la Computación |
| **Curso** | Estructuras de Datos |
| **Estudiante** | Roberto Estuardo Chavarría Zelada |
| **Carnet** | 202504060 |
| **Fase** | Fase 2 — Implementación Práctica y Defensa en Video |

---

## 🎥 Video de Defensa

📺 **Enlace al video en YouTube:** https://youtu.be/DBjGJEg_5-4

> El video (máximo 5 minutos) demuestra:
> - Ejecución en vivo del programa con inserción y eliminación de valores
> - Explicación de la lógica del método de eliminación (3 casos)
> - Justificación verbal de la complejidad Big-O del método de búsqueda

---

## ⚙️ Funcionalidades Implementadas

La clase `BST` contiene los siguientes métodos obligatorios:

| Método | Descripción |
|--------|-------------|
| `insert(int valor)` | Inserta un nodo en la posición correcta manteniendo las reglas del BST. |
| `search(int valor) : boolean` | Retorna `true` o `false` si el valor existe en el árbol. |
| `delete(int valor)` | Elimina el nodo contemplando los 3 casos: sin hijos, un hijo, dos hijos. |
| `recorridoInOrder()` | Imprime los nodos en orden ascendente (Izq - Raíz - Der). |
| `recorridoPreOrder()` | Imprime los nodos en pre-orden (Raíz - Izq - Der). |
| `recorridoPostOrder()` | Imprime los nodos en post-orden (Izq - Der - Raíz). |

---

## 📊 Análisis de Complejidad (Big O)

| Operación | Caso Promedio | Peor Caso |
|-----------|:-------------:|:---------:|
| Búsqueda  | **O(log n)**  | O(n)      |
| Inserción | **O(log n)**  | O(n)      |
| Eliminación | **O(log n)** | O(n)      |

**¿Por qué O(log n) en promedio?**
En cada paso de la búsqueda comparamos el valor con el nodo actual y descartamos la mitad del árbol restante (lado izquierdo o derecho). Esto significa que la cantidad de nodos a revisar se reduce a la mitad en cada nivel, generando una complejidad logarítmica.

**¿Por qué O(n) en el peor caso?**
Si los valores se insertan ya ordenados (por ejemplo: 1, 2, 3, 4, 5...), el árbol degenera en una estructura similar a una lista enlazada, con todos los nodos en una sola rama. En ese caso, hay que recorrer los **n** nodos uno por uno.

---

## 🧠 Lógica del Método de Eliminación (los 3 casos)

El método `delete` es el más complejo porque debe preservar la propiedad del BST tras eliminar un nodo. Se manejan tres casos:

### **Caso 1: Nodo sin hijos (hoja)**
Simplemente se retorna `null` al padre, eliminándolo del árbol.

### **Caso 2: Nodo con un solo hijo**
El hijo único reemplaza directamente al nodo eliminado (el padre apunta al nieto).

### **Caso 3: Nodo con dos hijos (el más complejo)**
Se busca el **sucesor in-order** (el menor valor del subárbol derecho), se copia su valor al nodo a eliminar, y luego se elimina ese sucesor de su posición original. Esto preserva la propiedad del BST.

---

## 🚀 Cómo Ejecutar el Código

### Requisitos
- Java JDK 11 o superior

### Opción 1: Ejecución directa (Java 11+)
```bash
java BST.java
```

### Opción 2: Compilación tradicional
```bash
javac BST.java
java BST
```

---

## 📁 Estructura del Repositorio
