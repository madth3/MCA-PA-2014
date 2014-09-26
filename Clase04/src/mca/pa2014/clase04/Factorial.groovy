package mca.pa2014.clase04

def factorial(n) {
    def fac = BigInteger.ONE
    (1..n).each { k->
        fac *= k
    }
    return fac
}

println factorial(100)
println factorial(0)