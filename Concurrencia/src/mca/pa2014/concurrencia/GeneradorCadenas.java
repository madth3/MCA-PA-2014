package mca.pa2014.concurrencia;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LANIA
 */
public class GeneradorCadenas implements Runnable{

    private final String nombre;
    private int repeticiones = 0;
    private static Random rnd = new Random();

    public GeneradorCadenas(String nombre, int repeticiones) {
        this.nombre = nombre;
        this.repeticiones = repeticiones;
    }
    
    
    @Override
    public void run() {
        for (int k = 0; k < repeticiones; k++) {
            System.out.printf("Hola %s\n", nombre);
            try {
                int retraso = rnd.nextInt(500);
                Thread.sleep(200 + retraso);
            } catch (InterruptedException ex) {
                Logger.getLogger(GeneradorCadenas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}





