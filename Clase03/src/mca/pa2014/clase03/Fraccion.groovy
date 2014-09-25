package mca.pa2014.clase03

/**
 *
 * @author jaguilar
 */
class Fraccion implements Comparable<Fraccion> {
    
    BigInteger numerador
    BigInteger denominador
        
    public Fraccion(num, den) {
        if (den == 0)
            throw new IllegalArgumentException("El denominador de una fraccion no puede ser cero.")
        numerador = num
        denominador = den
    }
    
    public Fraccion plus(Fraccion f2) {
        def nuevoDenominador = this.denominador * f2.denominador
        def nuevoNumerador = this.numerador * f2.denominador + 
                             f2.numerador * this.denominador
        return new Fraccion(nuevoNumerador, nuevoDenominador)                     
    }
    
    public Fraccion minus(Fraccion f2) {
        def nuevoDenominador = this.denominador * f2.denominador
        def nuevoNumerador = this.numerador * f2.denominador - 
                             f2.numerador * this.denominador
        return new Fraccion(nuevoNumerador, nuevoDenominador)                     
    }
    
    public Fraccion multiply(Fraccion f2) {
        nuevoNumerador = this.numerador * f2.numerador
        nuevoDenominador = this.denominador * f2.denominador
        return new Fraccion(nuevoNumerador, nuevoDenominador)
    }
    
    public Fraccion power(n) {
        return new Fraccion(this.numerador**n, this.denominador**n)
    }
    
    public String toString() {
        return "$numerador/$denominador"
    }
    
    public int compareTo(Fraccion f2) {
        return Math.signum(this.numerador * f2.denominador 
            - f2.numerador * this.denominador)
    }
}







