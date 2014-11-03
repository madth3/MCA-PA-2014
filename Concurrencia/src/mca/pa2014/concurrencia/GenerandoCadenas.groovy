package mca.pa2014.concurrencia

import java.util.concurrent.Executors

/*
def gc1 = new GeneradorCadenas("Julio", 3)
def gc2 = new GeneradorCadenas("Fulano", 5)

new Thread(gc1).start()
new Thread(gc2).start()
*/
println "${Runtime.getRuntime().availableProcessors()} procesadores"

def ejecutor = Executors.newFixedThreadPool(2)

["Hugo","Paco","Luis","Daniel","Ricardo"].each {nombre ->
    ejecutor.submit(new GeneradorCadenas(nombre,5))
}

ejecutor.shutdown()













