/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reportes;
import java.util.Map;
import java.text.DecimalFormat;

/**
 *
 * @author EBER
 */
public class generador {
    private static final String[] meses ={
        "ENERO","FEBRERO","MARZO","ABRIL","MAYO","JUNIO",
        "JULIO","AGOSTO","SETIEMBRE","OCTUBRE","NOVIEMBRE","DICIEMBRE"
    };
    
    private static final DecimalFormat decimal_formato = new DecimalFormat("0.00");
    
    public static String Reporte_Años(Map<Integer,Integer> organizar) {
        StringBuilder cadena = new StringBuilder();
        cadena.append("REPORTE: Eventos por AÑO (rango)\n");
        cadena.append("AÑO\tFREC\n");
        int total = 0;
        for (Map.Entry<Integer,Integer> recorrido : organizar.entrySet()) {
            cadena.append(recorrido.getKey()).append("\t").append(recorrido.getValue()).append("\n");
            total += recorrido.getValue();
        }
        cadena.append("TOTAL\t").append(total).append("\n");
        return cadena.toString();
    }
    
    
    public static String Reporte_Mes(Map<Integer,Integer> organizar, int año) {
        StringBuilder cadena = new StringBuilder();
        cadena.append("REPORTE: Eventos por MES - Año ").append(año).append("\n");
        cadena.append("Nº MES\tFREC\tPORC\n");
        int total = 0;
        for (int i = 1; i <= 12; i++) {
            total += organizar.getOrDefault(i, 0);      
        }
        for (int i = 1; i <= 12; i++) {
            int frecuencia = organizar.getOrDefault(i, 0);
            double porcentaje = total == 0 ? 0 : (frecuencia * 100.0) / total;
            cadena.append(String.format("%02d %s\t%d\t%s%%\n", i, meses[i-1], frecuencia, decimal_formato.format(porcentaje)));
        }
        cadena.append("-----\nTOTAL\t").append(total).append("\t100.00%\n");
        return cadena.toString();
    }
    
    
     
    public static String Reporte_Mes_Temp(Map<Integer,Integer> organizar, int año, double minT, double maxT) {
        StringBuilder cadena = new StringBuilder();
        cadena.append("REPORTE: Eventos por MES (Temp ").append(minT).append("-").append(maxT).append(") - Año ").append(año).append("\n");
        cadena.append("Nº MES\tFREC\tPORC\n");
        int total = 0;
        for (int i = 1; i <= 12; i++) {
            total += organizar.getOrDefault(i, 0); 
        }
        for (int i = 1; i <= 12; i++) {
            int frecuencia = organizar.getOrDefault(i, 0);
            double porcentaje = total == 0 ? 0 : (frecuencia * 100.0) / total;
            cadena.append(String.format("%02d %s\t%d\t%s%%\n", i, meses[i-1], frecuencia, decimal_formato.format(porcentaje)));
        }
        cadena.append("-----\nTOTAL\t").append(total).append("\t100.00%\n");
        return cadena.toString();
    }
    
    public static String Reporte_Hora(Map<Integer,Integer> organizar, int año) {
        StringBuilder cadena = new StringBuilder();
        cadena.append("REPORTE: Eventos por HORA - Año ").append(año).append("\n");
        cadena.append("HORA\tFREC\tPORC\n");
        int total = 0;
        for (Integer v : organizar.values()) total += v;
        for (int h = 0; h <= 23; h++) {
            int frecuencia = organizar.getOrDefault(h, 0);
            double porcentaje = total == 0 ? 0 : (frecuencia * 100.0) / total;
            cadena.append(String.format("%02d:00\t%d\t%s%%\n", h, frecuencia, decimal_formato.format(porcentaje)));
        }
        cadena.append("-----\nTOTAL\t").append(total).append("\t100.00%\n");
        return cadena.toString();
    }
    
     
     
     
     
     
     
     
     
     
     
     
    
    
    
}
