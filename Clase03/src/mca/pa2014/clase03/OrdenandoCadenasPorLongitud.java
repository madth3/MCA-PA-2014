package mca.pa2014.clase03;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author jaguilar
 */
public class OrdenandoCadenasPorLongitud {
    public static void main(String[] args) {
        String[] cadenas = "Este es un arreglo de     cadenas".split("\\s+,");
        Arrays.sort(cadenas, new Comparator<String>(){
            public int compare(String s1, String s2){ 
                return s1.length() - s2.length();
            }
        });
        for (String s: cadenas) {
            System.out.println(s);
        }
    }
}








