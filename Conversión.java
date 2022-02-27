/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author danie
 */
public class Conversión {
    
    public static PilaADT <Character> cambioAPostfija(String operacion){
        PilaADT <Character> signos = new PilaA();
        PilaADT <Character> sale = new PilaA();
        
        for(int i=0; i<operacion.length();i++)
            switch (operacion.charAt(i)) {
                case '(':
                    signos.push(operacion.charAt(i));
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                        //while(signos.peek())//Falta la condición de comparar jerarquias si es que es mayor o igual
                    sale.push(signos.pop());
                    signos.push(operacion.charAt(i));
                    break;
                case ')':
                    while(signos.peek()!='(')
                        sale.push(signos.pop());
                    signos.pop();
                    break;
                default:
                    sale.push(operacion.charAt(i));
                    break;
            }                
                
        return sale;
        }
    
}
