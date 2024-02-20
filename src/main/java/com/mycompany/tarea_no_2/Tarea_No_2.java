package com.mycompany.tarea_no_2;

import java.util.Scanner;

abstract class Tarea{
    
    abstract void mostrar();
    
}

class TareaSimple extends Tarea{
       
    private String descripcion;
    
    public TareaSimple(String descripcion){
        
        this.descripcion = descripcion;
    }
    
    @Override
    void mostrar(){
        System.out.println("Tarea Simple: \n" + descripcion);
    }
}

class TareaCompleja extends Tarea{
    
    private String descripcion;
    private String detalles;
    
    public TareaCompleja(String descripcion, String detalles){
        this.descripcion = descripcion;
        this.detalles = detalles;
    }
    
    @Override
    void mostrar(){
        System.out.println("LA TAREA COMPLEJA ES: \n" + descripcion + " \n(" + detalles + ")");
    }
}
    abstract class TareaFactory{
        abstract Tarea crearTareaSimple(String descripcion);
    }
    
abstract class TareaFactory2{
    abstract Tarea crearTareaCompleja(String descripcion, String detalles);
}
    class TareaSimpleFactory extends TareaFactory{
        @Override
        Tarea crearTareaSimple(String descripcion){
            return new TareaSimple(descripcion);
        }
    }

    class TareaComplejaFactory extends TareaFactory2{
    @Override
    Tarea crearTareaCompleja(String descripcion, String detalles){
        return new TareaCompleja(descripcion, detalles);
    }
}

class GestorTareas{
    private TareaFactory tareaFactory;
    private TareaFactory2 tareaFactory2;
    
    public GestorTareas (TareaFactory tareaFactory){
        this.tareaFactory = tareaFactory;
    }
    
    public GestorTareas (TareaFactory2 tareaFactory2){
        this.tareaFactory2 = tareaFactory2;
    }
    
    public void addTareaSimple(){
        String descripcion;
        Scanner sc = new Scanner(System.in);
        System.out.println("Añade una Tarea Simple: ");
        descripcion = sc.nextLine();
        
        Tarea tarea = tareaFactory.crearTareaSimple(descripcion);
        tarea.mostrar();
    }
      public void addTareaCompleja(){
        String descripcion;
        String detalles;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Añade una Tarea Compleja: ");
        descripcion = sc.nextLine();
        System.out.println("Agrega detalles: ");
        detalles = sc.nextLine();
        
        Tarea tarea = tareaFactory2.crearTareaCompleja(descripcion, detalles);
        tarea.mostrar();
    }
}

  
public class Tarea_No_2 {
    public static void main(String[] args) {
        
        TareaFactory TareaSimpleFactory = new TareaSimpleFactory();
        GestorTareas GestorTareasSimple = new GestorTareas(TareaSimpleFactory);
        
        GestorTareasSimple.addTareaSimple();
        
        TareaFactory2 TareaComplejaFactory = new TareaComplejaFactory();
        GestorTareas GestorTareaCompleja = new GestorTareas(TareaComplejaFactory);
        
        GestorTareaCompleja.addTareaCompleja();
    }
    
}
