package mca.pa2014.clase02

def mapa1 = [:]
mapa1[7] = 'Julio'
mapa1[8] = 'Agosto'
mapa1[8] = 'Septiembre'
mapa1[10] = 'Octubre'
mapa1[11] = 'Noviembre'
mapa1[13] = 'File not found'

//println mapa1[8]
println mapa1.class

mapa1.each{ llave,valor ->
    println valor
}


