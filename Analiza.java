/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import Pilas.PilaA;

/**
 *
 * @author danie
 */
public class Analiza {
    
    public static boolean analizaParentesis (String analiza){
        boolean resp=true;
        PilaA <Character> almacena = new PilaA();
        int contador=0;
        int i=0;
        
           while (i<analiza.length()) {  // Recorremos la expresión carácter a carácter

                if(analiza.charAt(i)=='(') {almacena.push('(');} // Si el paréntesis es de apertura apilamos siempre                               

                else 
                    if  (analiza.charAt(i)==')') {  // Si el paréntesis es de cierre actuamos según el caso

                            if (!almacena.isEmpty()){ almacena.pop(); } // Si la pila no está vacía desapilamos

                            else { almacena.push(')');
                            break; } // La pila no puede empezar con un cierre, apilamos y salimos

                }

                i++;

            }

            if(almacena.isEmpty())
                resp= true; 
             else 
                resp= false;
       
        return resp;
    }
    public static boolean revisaSignos(String revisa){
        boolean resp=true;
        char ant;
        int i=0;
        
        while(i<revisa.length()-1 && resp){
            
            if(revisa.charAt(i)=='+'||revisa.charAt(i)=='-'||revisa.charAt(i)=='*'||revisa.charAt(i)=='/')
                i++;
                if(revisa.charAt(i)=='+'||revisa.charAt(i)=='-'||revisa.charAt(i)=='*'||revisa.charAt(i)=='/')
                    resp=false;
            i++;      
        }
        
        return resp;   
    }
    
    public static void main(String[] args) {
        
        System.out.println("Prueba de analizaParentesis");
        System.out.println("Con los paréntesis puestos correctamente");
        System.out.println("1. " + analizaParentesis("1(a+b)")); 
        System.out.println("2. " +analizaParentesis("34-5+3"));
        
        System.out.println("Con los paréntesis puestos incorrectamente");
        System.out.println("1. " + analizaParentesis("3)4-5+3("));
        System.out.println("2. " +analizaParentesis("34-5+3("));
        System.out.println("3. " +analizaParentesis("3)4-5+3"));
        System.out.println("5. " +analizaParentesis("3)4-5+3"));
        System.out.println("6. " +analizaParentesis("34-5+3("));
        
        
        System.out.println("\nPrueba de analiza signo");
        System.out.println("Con los signos puestos correctamente");
        System.out.println("1. " + revisaSignos("1+7-58/6")); 
        System.out.println("2. " + revisaSignos("34-5+3"));
        
        System.out.println("Con los signos puestos incorrectamente");
        System.out.println("1. " + revisaSignos("34/-5+3("));
        System.out.println("2. " +revisaSignos("34-5+-3("));
        System.out.println("3. " +revisaSignos("3**4-5+3"));
        
    }
    
}
