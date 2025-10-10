/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;
import model.clima;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EBER
 */
public class CSVLector {
    public static List<clima> leercsv(String lectura) throws IOException{
        List<clima> lista = new ArrayList<>();
        FileReader archivo1 = new FileReader("C:/Users/EBER/Documents/NetBeansProjects/Taller-programacion-Proyecto-Final-/Proyecto_Final/src/datos/VariablesMeteorologicas.csv");
        BufferedReader buffer1 = new BufferedReader(archivo1);
        String linea = buffer1.readLine();
        
        while((linea= buffer1.readLine()) != null){
            if(linea.trim().isEmpty()){
                continue;
            }
            String[] seccion = linea.split(",");
            int id = Integer.parseInt(seccion[0].trim());
            String fecha = seccion[1].trim();
            String hora = seccion[2].trim();
            float temperatura = Float.parseFloat(seccion[3].trim());
            String departamento = seccion[4].trim();
            double longitud = Double.parseDouble(seccion[5].trim());
            double latitud = Double.parseDouble(seccion[6].trim()); 
            lista.add(new clima(id,fecha,hora,temperatura,departamento,longitud,latitud));
        }
        buffer1.close();
        return lista;   
    }    
}
