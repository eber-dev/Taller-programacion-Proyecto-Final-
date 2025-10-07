/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utileria;


/**
 *
 * @author EBER
 */
public class metodos {
    
    public static int obtener_año(String fecha){
        if (fecha == null || fecha.length()<8){
            return 0;
        }
        return Integer.parseInt(fecha.substring(0, 4));  
    }
    
    public static int obtener_mes(String fecha){
        if (fecha == null || fecha.length()<6){
            return 0;
        }
        return Integer.parseInt(fecha.substring(4, 6));  
    }
    
        public static int obtener_hora(String hora){
        if (hora == null || hora.length()<6){
            return 0;
        }
        return Integer.parseInt(hora.substring(4, 6));  
    }  
}
