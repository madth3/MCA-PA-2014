package mca.pa2014.clase02

def name='Julio'

println "Hello $name!"
println 'Hello $name!'
println "Hello " + name
def saludoEspaniol = "Hola ${name.toUpperCase()+'...'}"
println saludoEspaniol

def cadenaLarga = '''Esta es
una cadena, hecha $name
de mas de una
linea'''
println cadenaLarga

def otraCadenaLarga = """Esta es
una cadena, hecha por $name,
de mas de una
linea"""
println otraCadenaLarga

println otraCadenaLarga[5]
println otraCadenaLarga[5..8]
println otraCadenaLarga[-2..8]
println otraCadenaLarga[-12..20]
println otraCadenaLarga[-1..0]
println otraCadenaLarga.length()

otraCadenaLarga.each{ c->
    println c
}






