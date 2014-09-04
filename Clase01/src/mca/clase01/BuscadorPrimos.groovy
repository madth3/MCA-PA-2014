package mca.clase01

def divisores(n){
    return (1..n).findAll{ k ->
        n % k == 0
    }
}
def esPrimo(n) {
  return (divisores(n).size() == 2)  
}

(2..100).each{n ->
    if (esPrimo(n)) println n
}
