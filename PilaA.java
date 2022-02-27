/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author danie
 */
public class PilaA <T> implements PilaADT <T>{

    private T[] datoPila;
    private int tope;
    private final int MAX=20;
    
    public PilaA(){
        datoPila=(T[])new Object[MAX];
        tope=-1;
    }

    public void push(T dato) {
        if(tope== this.datoPila.length-1)
            expand();
        tope++;
        datoPila[tope]=dato;
        
        
    }
    
    public void expand(){
        T[]crece= (T[])new Object[this.datoPila.length *2];
        
        for ( int i=0; i<=tope;i++){
            crece[i]=datoPila[i];
            datoPila=crece;
        }
        
                
    }

    @Override
    public T pop() {
        if(this.isEmpty())
            throw new Excepciones("La pila está vacia"); 
        T resultado;
        
        resultado=this.datoPila[tope];
        this.datoPila[tope]=null;
        tope--; 
        
        return resultado;
        
    }

    @Override
    public boolean isEmpty() {
        return tope==-1;
    }

    @Override
    public T peek() {
        if(this.isEmpty()){
             throw new Excepciones("La pila está vacia");
        }
        return this.datoPila[tope];
       
    }
    public String toString(){
        StringBuilder sB=new StringBuilder();
        
        for(int i=tope; i>=0;i--)
            sB.append(datoPila[i]).append("\n");
        
        return sB.toString(); 
    }
    public static void main(String[] args) {
        PilaA<String> dias = new PilaA();
        PilaA<Integer> edades=new PilaA();
        PilaA pila=new PilaA();
        
        
        //C2 Quita con Pila vacia
        
        try{
            System.out.println("\nEl elemento quitado: " + dias.pop());
        }catch(Exception e){
        System.out.println("\n Error:" + e);
        }
        
        
        dias.push("Lunes");
        dias.push("Martes");
        dias.push("Miercoles");
        dias.push("Jueves");
        dias.push("Viernes");
        
        //C3 Quitar de una pila
        
        try{
            System.out.println(dias.peek());
            System.out.println("Elemento quitado" + dias.pop());   
        }catch(Exception e){
        System.out.println("\nPila de Dias: \n" + dias);
        }
        
        
        
    }
    
}
