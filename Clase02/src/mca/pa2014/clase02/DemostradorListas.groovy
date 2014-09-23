package mca.pa2014.clase02

def lista1 = [1,3,6,8,0]
println lista1.class
assert lista1[-1] == 0
assert lista1[2] == 6
assert lista1[2..2] == [6]
lista2 = lista1 + [9,15,5]
lista2 = lista2 + 7
println lista2
lista1 << [9,15,5]
println lista1
println lista1.flatten()

def listaLigada = new LinkedList()
"Hola".each { c->
    listaLigada << c.charAt(0)
}
println listaLigada
println listaLigada.any{ c -> c.isUpperCase() }

def lista3 = new HashSet()
assert lista3 != null
lista3 << 10
lista3 << 20
lista3 << 20
assert lista3.size() == 3

