package mca.pa2014.clase04

def buscarPalindromoMaximo(String cadena) {
    def n = cadena.length()
    def matriz = new int[n][n]
    def maximo = [1,0,0]
    (0..<n).each { j->
        (0..j).each { i->
            if (i == j) matriz[i][j] = 1
            else if (i + 1 == j && cadena[i].equals(cadena[j])) matriz[i][j] = 2
            else if (cadena[i].equals(cadena[j])) {
                if (matriz[i+1][j-1] > 0) matriz [i][j] = matriz[i+1][j-1] + 2
                else matriz[i][j] = -1
            } 
            else matriz[i][j] = -1
            // Comparamos con lo mejor que llevamos
            if (matriz[i][j] > maximo[0]) maximo = [matriz[i][j], i, j]
        }
    }
    //println matriz
    return cadena[maximo[1]..maximo[2]]
}

println buscarPalindromoMaximo('abracadabra')
println buscarPalindromoMaximo('dabraaaaaaa')

println buscarPalindromoMaximo('anitalavalatina')


