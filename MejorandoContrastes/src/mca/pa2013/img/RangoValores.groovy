package mca.pa2013.img

/**
 *
 * @author PCEL
 */
class RangoValores {
    int maximo
    int minimo
    
    RangoValores() {
        maximo = Integer.MIN_VALUE
        minimo = Integer.MAX_VALUE
    }
    
    void mezclarCon(otroRango) {
        minimo = Math.min(minimo, otroRango.minimo)
        maximo = Math.max(maximo, otroRango.maximo)
    }
    
    String toString() {
        return "[$minimo, $maximo]"
    }
    
    int ajustarValor(int val) {
        return (val - minimo)*255/(maximo-minimo)
    }
}

