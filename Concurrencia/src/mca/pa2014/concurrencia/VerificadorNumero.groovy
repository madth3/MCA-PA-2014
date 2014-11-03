
package mca.pa2014.concurrencia

/**
 *
 * @author LANIA
 */
class VerificadorNumero {
    
    public static final int LIMITE = 100

    int numeroOculto;
    
    public VerificadorNumero() {
        def rnd = new Random()
        numeroOculto = rnd.nextInt(LIMITE);
    }    
    
    public synchronized boolean adivinarNumero(n) {
        return n == numeroOculto
    }
}










