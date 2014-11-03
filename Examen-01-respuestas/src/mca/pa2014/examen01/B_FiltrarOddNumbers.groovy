package mca.pa2014.examen01

/**
 * El metodo recibe una lista y elimina los elementos que aparecen una cantidad 
 * impar de veces en la lista.
 */
def filtrarOddNumbers(lista) {
    def frecs = [:]
    lista.each{ 
        if (it in frecs) {
            frecs[it] = frecs[it] + 1
        }
        else {
            frecs[it] = 1
        }
    }
    return lista.findAll{ frecs[it] % 2 == 0}
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
casos[[[1]]] = []
casos[[1..10]] = []
casos[[[1,1,2,2,3,3]]] = [1,1,2,2,3,3]
casos[[(1..10) + [9,5,3]]] = [3,5,9,9,5,3]
casos[[('A'..'Z') + ('D'..'W') + ('E'..'V')]] = ['D','W','D','W']
def templist = (['a']*11) + (['b']*9) + (['c']*7) + (['d']*5)
Collections.shuffle(templist)
casos[[templist]] = []
templist = (['5']*11) + ([new Date()]*9) + ([3]*7) + ([4]*5) + ([5]*8)
Collections.shuffle(templist)
casos[[templist]] = [5]*8
templist = ([1]*10) + ([2]*8) + ([3]*6) + ([4]*4)
Collections.shuffle(templist)
casos[[templist]] = templist
casos[[((1..100).collect{(1..it.div(2))})]] = []

runTests({l -> filtrarOddNumbers(l)}, casos)