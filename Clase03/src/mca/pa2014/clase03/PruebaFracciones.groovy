package mca.pa2014.clase03

def f1 = new Fraccion(1,2)
def f2 = new Fraccion(1,4)
def f3 = f1 + f2
println f3**3

def lista = []
lista << f3

def rnd = new Random()
(1..10).each { 
    lista << new Fraccion(rnd.nextInt(21), rnd.nextInt(20)+1)
}
println lista
lista.sort()
println lista











