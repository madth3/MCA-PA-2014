package mca.pa2014.codingbat

def makebricks(small, big, goal) {
    return false
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
casos[[[3,1,8]]] = true

runTests({l -> makebricks(l[0],l[1],l[2])}, casos)