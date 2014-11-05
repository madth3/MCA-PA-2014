package oracle.demos

def ordenador = new MTBubbleSortAlgorithm()

def arreglo = [15,22,8,0,-2,100,50,3,14,8,17,15].toArray(new Integer[0])
ordenador.sort(arreglo)
println arreglo