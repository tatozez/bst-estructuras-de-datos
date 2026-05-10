/**
 * Árbol Binario de Búsqueda (BST) - Implementación en Java
 * Universidad Da Vinci de Guatemala
 * Curso: Estructuras de Datos
 * Estudiante: Roberto Estuardo Chavarría Zelada
 * Carnet: 202504060
 */
class Nodo {
    int valor;
    Nodo izq, der;
    
    Nodo(int v) {
        valor = v;
        izq = der = null;
    }
}

public class BST {
    private Nodo raiz;
    
    public BST() {
        raiz = null;
    }
    
    // ---------- INSERCIÓN ----------
    public void insert(int valor) {
        raiz = insertarRec(raiz, valor);
    }
    
    private Nodo insertarRec(Nodo nodo, int valor) {
        if (nodo == null) {
            return new Nodo(valor);
        }
        if (valor < nodo.valor) {
            nodo.izq = insertarRec(nodo.izq, valor);
        } else if (valor > nodo.valor) {
            nodo.der = insertarRec(nodo.der, valor);
        }
        // Si es igual, no se inserta (no se permiten duplicados)
        return nodo;
    }
    
    // ---------- BÚSQUEDA ----------
    public boolean search(int valor) {
        return buscarRec(raiz, valor);
    }
    
    private boolean buscarRec(Nodo nodo, int valor) {
        if (nodo == null) return false;
        if (nodo.valor == valor) return true;
        if (valor < nodo.valor) {
            return buscarRec(nodo.izq, valor);
        } else {
            return buscarRec(nodo.der, valor);
        }
    }
    
    // ---------- ELIMINACIÓN ----------
    public void delete(int valor) {
        raiz = eliminarRec(raiz, valor);
    }
    
    private Nodo eliminarRec(Nodo nodo, int valor) {
        if (nodo == null) return null;
        
        if (valor < nodo.valor) {
            nodo.izq = eliminarRec(nodo.izq, valor);
        } else if (valor > nodo.valor) {
            nodo.der = eliminarRec(nodo.der, valor);
        } else {
            // Caso 1: nodo sin hijos (hoja)
            if (nodo.izq == null && nodo.der == null) {
                return null;
            }
            // Caso 2: nodo con un solo hijo
            if (nodo.izq == null) return nodo.der;
            if (nodo.der == null) return nodo.izq;
            
            // Caso 3: nodo con dos hijos
            // Buscamos el sucesor in-order (menor del subárbol derecho)
            nodo.valor = encontrarMinimo(nodo.der);
            nodo.der = eliminarRec(nodo.der, nodo.valor);
        }
        return nodo;
    }
    
    private int encontrarMinimo(Nodo nodo) {
        while (nodo.izq != null) {
            nodo = nodo.izq;
        }
        return nodo.valor;
    }
    
    // ---------- RECORRIDOS ----------
    public void recorridoInOrder() {
        System.out.print("In-Order: ");
        inOrderRec(raiz);
        System.out.println();
    }
    
    private void inOrderRec(Nodo nodo) {
        if (nodo != null) {
            inOrderRec(nodo.izq);
            System.out.print(nodo.valor + " ");
            inOrderRec(nodo.der);
        }
    }
    
    public void recorridoPreOrder() {
        System.out.print("Pre-Order: ");
        preOrderRec(raiz);
        System.out.println();
    }
    
    private void preOrderRec(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            preOrderRec(nodo.izq);
            preOrderRec(nodo.der);
        }
    }
    
    public void recorridoPostOrder() {
        System.out.print("Post-Order: ");
        postOrderRec(raiz);
        System.out.println();
    }
    
    private void postOrderRec(Nodo nodo) {
        if (nodo != null) {
            postOrderRec(nodo.izq);
            postOrderRec(nodo.der);
            System.out.print(nodo.valor + " ");
        }
    }
    
    // ---------- MAIN PARA PROBAR ----------
    public static void main(String[] args) {
        BST arbol = new BST();
        
        // Insertando valores
        arbol.insert(50);
        arbol.insert(30);
        arbol.insert(70);
        arbol.insert(20);
        arbol.insert(40);
        arbol.insert(60);
        arbol.insert(80);
        
        System.out.println("Árbol después de inserciones:");
        arbol.recorridoInOrder();    // 20 30 40 50 60 70 80
        arbol.recorridoPreOrder();   // 50 30 20 40 70 60 80
        arbol.recorridoPostOrder();  // 20 40 30 60 80 70 50
        
        // Búsquedas
        System.out.println("\n¿Existe 40? " + arbol.search(40));  // true
        System.out.println("¿Existe 99? " + arbol.search(99));    // false
        
        // Eliminación
        System.out.println("\nEliminando 20 (sin hijos)...");
        arbol.delete(20);
        arbol.recorridoInOrder();
        
        System.out.println("\nEliminando 30 (un hijo)...");
        arbol.delete(30);
        arbol.recorridoInOrder();
        
        System.out.println("\nEliminando 50 (dos hijos, es la raíz)...");
        arbol.delete(50);
        arbol.recorridoInOrder();
    }
}
