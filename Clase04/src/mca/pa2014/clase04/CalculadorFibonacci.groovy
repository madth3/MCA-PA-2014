package mca.pa2014.clase04

valoresFib = [:]
valoresFib[0] = BigInteger.ZERO
valoresFib[1] = BigInteger.ONE

def fib_r(n) {
    if (n < 2) return n
    return fib_r(n-1) + fib_r(n-2)
}

def fib_rm(n) {
   if (valoresFib.containsKey(n)) return valoresFib[n]
   valoresFib[n] = fib_rm(n-1) + fib_rm(n-2)
   return valoresFib[n]
}

def fib_i(n) {
    if (n < 2) return n
    def penultimo = BigInteger.ZERO
    def ultimo = BigInteger.ONE
    def t = 0
    (2..n).each {
        t = penultimo + ultimo
        penultimo = ultimo
        ultimo = t
    }
    return ultimo
}

println fib_rm(100)
println fib_i(100)






