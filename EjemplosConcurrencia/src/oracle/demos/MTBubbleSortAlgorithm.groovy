package oracle.demos

import java.util.concurrent.Executors
import java.util.concurrent.ExecutorService

/**
 *
 * @author LANIA
 */
class MTBubbleSortAlgorithm extends SortAlgorithm {
    
    ExecutorService ejecutor = Executors.newFixedThreadPool(2)
    
    void sort(Integer[] a) throws Exception {
        for (int i = a.length; --i >= 1;) {
            boolean swapped = false
            int iEntreDos = i/2
            BuscadorMaximo izquierdo = new BuscadorMaximo(a, 0, iEntreDos)
            BuscadorMaximo derecho = new BuscadorMaximo(a, iEntreDos + 1, i)
            def resultados = ejecutor.invokeAll([izquierdo, derecho]).collect{it.get()}
            def posicionMaximo = resultados[1]
            if (a[resultados[0]] > a[resultados[1]]) {
                posicionMaximo = resultados[0]
            }
            def temp = a[i]
            a[i] = a[posicionMaximo]
            a[posicionMaximo] = temp
        }
        ejecutor.shutdown()
    }
}





            
            
            
            