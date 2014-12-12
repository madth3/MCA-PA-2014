package mca.pa2014.codingbat

def makeBricks(small, big, goal) {
    def residuo = goal % 5
    if (residuo > small) return false
    return goal <= small + 5 * big
}

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
casos[[[3, 1, 8]]] = true
casos[[[3, 1, 9]]] = false	    
casos[[[3, 2, 10]]] = true
casos[[[3, 2, 8]]] = true
casos[[[3, 2, 9]]] = false
casos[[[6, 1, 11]]] = true
casos[[[6, 0, 11]]] = false
casos[[[1, 4, 11]]] = true
casos[[[0, 3, 10]]] = true
casos[[[1, 4, 12]]] = false
casos[[[3, 1, 7]]] = true
casos[[[1, 1, 7]]] = false
casos[[[2, 1, 7]]] = true
casos[[[7, 1, 11]]] = true
casos[[[7, 1, 8]]] = true
casos[[[7, 1, 13]]] = false
casos[[[43, 1, 46]]] = true
casos[[[40, 1, 46]]] = false
casos[[[40, 2, 47]]] = true
casos[[[40, 2, 50]]] = true
casos[[[40, 2, 52]]] = false
casos[[[22, 2, 33]]] = false
casos[[[0, 2, 10]]] = true
casos[[[1000000, 1000, 1000100]]] = true
casos[[[2, 1000000, 100003]]] = false
casos[[[20, 0, 19]]] = true
casos[[[20, 0, 21]]] = false
casos[[[20, 4, 51]]] = false
casos[[[20, 4, 39]]] = true
runTests({l -> makeBricks(l[0],l[1],l[2])}, casos)