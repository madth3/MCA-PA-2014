package mca.pa2014.concurrencia

import java.util.concurrent.Executors

def verificador = new VerificadorNumero()
println verificador.numeroOculto

def buscadores = ['Google', 'Altavista', 'Yahoo','Bing'].collect { nombre ->
    new BuscadorAleatorio(nombre, 20, verificador)
}

def ejecutor = Executors.newFixedThreadPool(4)
try {
    def resultado = ejecutor.invokeAny(buscadores)
    ejecutor.shutdown()
    if (resultado != null) {
        println "El numero era $resultado"
    }
    else {
        println "Perdimos, era ${verificador.numeroOculto}"
    }
} catch (NumeroNoEncontradoException nnee) {
}

