/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Facundo
 */
public class Empleado {
    public String nombre;
    public String telefono;
    public String dni;
    public String id;
    public String sueldo;
    
    

    //Constructor
    

    public Empleado(String dni, String nombre,String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono=telefono;
    }
    public Empleado(String dni, String nombre,String telefono, String id) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono=telefono;
        this.id=id;
    }

    public Empleado(String sueldo){
        this.sueldo=sueldo;
    }
    
    public Empleado(){
        
    }

    public String getSueldo() {
        return sueldo;
    }

    public void setSueldo(String sueldo) {
        this.sueldo = sueldo;
    }

   
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    
}
