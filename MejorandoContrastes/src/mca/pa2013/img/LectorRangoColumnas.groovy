package mca.pa2013.img

import java.util.concurrent.RecursiveTask
/**
 *
 * @author PCEL
 */
class LectorRangoColumnas extends RecursiveTask<RangoValores> {
    
    static int LIMITE = 10
    int[] pixeles
    int colA
    int colB
    int altura
    
    LectorRangoColumnas(int[] pixs, int a, int b, int h){
        pixeles = pixs
        colA = a
        colB = b
        altura = h
        //println "Cols $a - $b"
    }
    
    @Override
    protected RangoValores compute() {
        if (colB - colA < LIMITE) {
            return encontrarRango()
        }
        else {
            int colM = (colA + colB).div(2)
            LectorRangoColumnas izq = new LectorRangoColumnas(pixeles, colA, colM, altura)
            LectorRangoColumnas der = new LectorRangoColumnas(pixeles, colM+1, colB, altura)
            izq.fork()
            RangoValores resDer = der.compute()
            RangoValores resIzq = izq.join()
            if (resDer == null) return resIzq
            if (resIzq == null) return resDer
            resIzq.mezclarCon(resDer)
            return resIzq
        }
    }
    
    RangoValores encontrarRango() {
        RangoValores resultados = new RangoValores()
        println("De ${colA * altura} a ${colB * altura}")
        for (k in colA * altura ..< colB * altura) {
            int gris = pixeles[k] & 0xFF
            if (gris > resultados.maximo) {
                resultados.maximo = gris
            }
            if (gris < resultados.minimo) {
                resultados.minimo = gris
            }
        }
        return resultados
    }
}

