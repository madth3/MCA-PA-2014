package mca.pa2014.examen01

/**
 * El metodo recibe una lista y regresa otra lista de todos los numeros que 
 * están en la lista inicial y que NO inician y terminan con el mismo digito. 
 * Ademas, la lista resultado debera estar ordenada de mayor a menor.
 */
def quitarNumeros(lista) {
    def listaResultado = lista.findAll{ elem ->
        def elemStr = elem.toString()
        return elemStr[0] != elemStr[-1]
    }
    return listaResultado.sort{ -it }
}

/**                 NO MODIFICAR DEBAJO DE ESTAS LINEAS                      **/
def runTests(metodo, tests) {
    def correctos = 0
    tests.each{args, esperado ->
        try {
            def resultado = metodo(args[0])
            if (resultado == esperado) correctos++
            else {
                println "Se obtuvo <<$resultado>> y se esperaba <<$esperado>>"
            }
        }
        catch (Exception ex) {
            ex.printStackTrace()
        }
    }
    println "Pasó $correctos tests de ${tests.size()}"
}

casos = [:]
casos[[[]]] = []
casos[[1..9]] = []
casos[[12..21]] = 21..12
casos[[1..20]] = [20,19,18,17,16,15,14,13,12,10]
casos[[[20,1,19,2,18,3,17,4,16,5,15,6,14,7,13,8,12,9]]] = [20,19,18,17,16,15,14,13,12]
casos[[[123,234,345]]] = [345,234,123]
casos[[[1231,2311,4514,1145,7,98765,87058]]] = [98765,2311,1145]
casos[[[1234543210,1972318787,27394729348,2034802323]]] = [27394729348, 2034802323, 1972318787, 1234543210]
casos[[[12345432100,1972318787001,27394729348000,203480232300002]]] = [27394729348000, 12345432100]
casos[[[1873481273648234682374176823401801]]] = []

runTests({l -> quitarNumeros(l)}, casos)
