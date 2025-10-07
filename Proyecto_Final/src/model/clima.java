/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


/**
 *
 * @author EBER
 */
public class clima {
    private int id;
    private String fecha;
    private String hora;
    private float temperatura;
    private String departamento;
    private double longitud;
    private double latitud;
    
    
    public clima(int id, String fecha, String hora, float temperatura, String departamento, 
            double longitud, double latitud){
        this.id = id;
        this.fecha=fecha;
        this.hora = hora;
        this.temperatura = temperatura;
        this.departamento = departamento;
        this.longitud = longitud;
        this.latitud = latitud;
    }
    
    public int getid(){
        return id;
    }

    public String getfecha() { 
        return fecha; 
    }
    
    public String gethora() { 
        return hora; 
    }
    
    public float gettemperatura() { 
        return temperatura; 
    }
    
    public String getdepartamento() { 
        return departamento; 
    }
    
    public double getlongidud() { 
        return longitud; 
    }
    public double getlatitud() { 
        return latitud; 
    }
       
    
}
