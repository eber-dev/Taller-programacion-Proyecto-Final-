/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utileria;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author EBER
 */
public class auditoria {
    private static final String LOG = "auditoria.log";

    public static void registrar(Exception e, String usuario) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(LOG, true));
            String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            bw.write("[" + now + "] Usuario: " + usuario + " | " +
                     e.getClass().getSimpleName() + " | " + e.getMessage() + "\n");
            bw.close();
        } catch (IOException ex) {
            System.err.println("Error escribiendo auditoria: " + ex.getMessage());
        }
    }
    
}

