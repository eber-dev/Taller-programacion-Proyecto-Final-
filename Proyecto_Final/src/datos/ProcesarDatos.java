/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;
import model.clima;
import utileria.metodos;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author EBER
 */
public class ProcesarDatos {
    
    public static Map<Integer, Integer> Cuenta_Año(List<clima> datos, int inicio, int fin){
        Map<Integer, Integer> organizar = new TreeMap<>();
        for(clima recorre: datos){
            int año_formato = metodos.obtener_año(recorre.getfecha());
            if(año_formato>=inicio && año_formato<= fin){
                organizar.put(año_formato, organizar.getOrDefault(año_formato,0) + 1);   
            }
        }
        
        return organizar;   
    }
    
    public static Map<Integer,Integer> Cuenta_Mes_Año(List<clima> datos, int año) {
        Map<Integer,Integer> organizar = new TreeMap<>();
        for (clima c : datos) {
            int año_formato = metodos.obtener_año(c.getfecha());
            if (año_formato == año) {
                int mes_formato = metodos.obtener_mes(c.getfecha());
                organizar.put(mes_formato, organizar.getOrDefault(mes_formato,0) + 1);
            }
        }
        return organizar;
    }
    
    
    public static Map<Integer,Integer> Cuenta_Mes_Temp(List<clima> datos, int año, double minTemp, double maxTemp) {
        Map<Integer,Integer> organizar = new TreeMap<>();
        for (clima c : datos) {
            int año_formato = metodos.obtener_año(c.getfecha());
            if (año_formato == año && c.gettemperatura() >= minTemp && c.gettemperatura() <= maxTemp) {
                int mes_formato = metodos.obtener_mes(c.getfecha());
                organizar.put(mes_formato, organizar.getOrDefault(mes_formato,0) + 1);
            }
        }
        return organizar;
    }
    
    
    public static Map<Integer,Integer> Cuenta_Hora(List<clima> datos, int año) {
        Map<Integer,Integer> organizar = new TreeMap<>();
        for (clima c : datos) {
            int año_formato = metodos.obtener_año(c.getfecha());
            if (año_formato == año) {
                int hora_formato = metodos.obtener_hora(c.gethora());
                organizar.put(hora_formato, organizar.getOrDefault(hora_formato,0) + 1);
            }
        }
        return organizar;
    }
        
}
