package mca.pa2014.codingbat

def xyzMiddle(str) {
    if (str.size()<3) return false
    def l = str.size()
    def m = (l - 3)/2 ///
    return "xyz".equals(str[m..m+2]) || 
        (l%2 == 0 && m+3 < str.size() && "xyz".equals(str[m+1..m+3]))
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
casos[["AAxyzBB"]] = true
casos[["AxyzBB"]] = true    
casos[["AxyzBBB"]] = false    
casos[["AxyzBBBB"]] = false    
casos[["AAAxyzB"]] = false    
casos[["AAAxyzBB"]] = true    
casos[["AAAAxyzBB"]] = false    
casos[["AAAAAxyzBBB"]] = false    
casos[["1x345xyz12x4"]] = true    
casos[["xyzAxyzBBB"]] = true    
casos[["xyzAxyzBxyz"]] = true    
casos[["xyzxyzAxyzBxyzxyz"]] = true    
casos[["xyzxyzxyzBxyzxyz"]] = true    
casos[["xyzxyzAxyzxyzxyz"]] = true    
casos[["xyzxyzAxyzxyzxy"]] = false    
casos[["AxyzxyzBB"]] = false    
casos[[""]] = false    
casos[["x"]] = false    
casos[["xy"]] = false    
casos[["xyz"]] = true    
casos[["xyzz"]] = true
runTests({l -> xyzMiddle(l)}, casos)