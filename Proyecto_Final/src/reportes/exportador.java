 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reportes;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author EBER
 */
public class exportador {
    
    public static void exportar(String contenido, String nombreArchivo) throws IOException {
        FileWriter archivo_exportar = new FileWriter(nombreArchivo);
        BufferedWriter buffer = new BufferedWriter(archivo_exportar);
        buffer.write(contenido);
        buffer.close();
        System.out.println("Reporte exportado a " + nombreArchivo);
    }
    
}
