package mca.pa2014.concurrencia

import java.util.concurrent.Callable

/**
 *
 * @author LANIA
 */
class BuscadorAleatorio implements Callable<Integer> {

    String nombre
    int maxIntentos
    VerificadorNumero verificador
    
    public BuscadorAleatorio(nombre, maxIntentos, verificador) {
        this.nombre = nombre
        this.maxIntentos = maxIntentos
        this.verificador = verificador
    }
    
    public Integer intentarAdivinarNumero() {
        def k = 0;
        def rnd = new Random()
        while (k < maxIntentos) {
            def intento = rnd.nextInt(VerificadorNumero.LIMITE)
            if (verificador.adivinarNumero(intento)) {
                println "Es $intento!!!"
                return intento
            }
            else {
                println "$nombre: No es $intento"
            }
            k++
        }
        throw new NumeroNoEncontradoException()        
    }
    
    public Integer call() {
        return intentarAdivinarNumero()
    }
}







