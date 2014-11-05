package oracle.demos

import java.util.concurrent.Callable

/**
 *
 * @author LANIA
 */
class BuscadorMaximo implements Callable {
    
    int[] arreglo
    int inicio
    int fin
    
    public BuscadorMaximo(arr, i, f) {
        this.arreglo = arr
        this.inicio = i
        this.fin = f
    }
    
    Integer call() {
        print "Buscando [$inicio, $fin] -> "
        int posicionMaximo = inicio;
        for (int k = inicio; k <= fin; k++) {
            if (arreglo[k] > arreglo[posicionMaximo]) posicionMaximo = k
        }
        println posicionMaximo
        return posicionMaximo
    }
}






