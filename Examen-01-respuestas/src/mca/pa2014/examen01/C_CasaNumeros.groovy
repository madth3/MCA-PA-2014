package mca.pa2014.examen01

def sumaDigitos(n) {
    return (n.toString().collect{ c -> Integer.parseInt(c)}).sum()
}

def f(n) { return (n - sumaDigitos(n))/9 } ///

/**
 * A un numero n le aplicamos el proceso de:
 * restarle la suma de sus digitos y dividir la diferencia entre 9.
 * Si repetimos este proceso en algun momento llegaremos a cero.
 * Por ejemplo: 2014 ==> (2014-7)/9 = 223 ==> (223-7)/9 = 24 ==> (24-6)/9 = 2 ==> (2-2)/9 = 0
 * El numero al que llegamos antes cero sera la casa de n. (P.e. casa(2014) = 2)
 */
def casa(n) {
    if (n == 0) return 0
    while (n > 0) {
        if (f(n) == 0) return n
        n = f(n)
    }
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
casos[[0]] = 0
casos[[2]] = 2
casos[[2014]] = 2
casos[[2000014]] = 3
casos[[200000014]] = 4

runTests({l -> casa(l)}, casos)