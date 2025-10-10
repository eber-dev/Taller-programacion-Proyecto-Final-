/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autenticacion;
import utileria.auditoria;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 *
 * @author EBER
 */
public class Login {
    public static String[] Credenciales() throws IOException {
        String[] log = new String[2];
        BufferedReader buffer = new BufferedReader(new FileReader("C:/Users/EBER/Documents/NetBeansProjects/Taller-programacion-Proyecto-Final-/Proyecto_Final/src/autenticacion/usuarios.txt"));
        log[0] = buffer.readLine().trim();
        log[1] = buffer.readLine().trim();
        buffer.close();
        return log;
    }

    public String Validacion(Scanner lector) {
        String usuario, contraseña;
        int contador = 1;
        try {
            String[] credenciales = Login.Credenciales();  
            String usuariotexto = credenciales[0];
            String contraseñatexto = credenciales[1];
            
            do {
                System.out.print("Ingrese su usuario: ");
                usuario = lector.nextLine().trim();
        
                System.out.print("Ingrese su contraseña: ");
                contraseña = lector.nextLine().trim();
                
                // Auditoría: Registrar intento de acceso
                if (usuario.equals(usuariotexto) && contraseña.equals(contraseñatexto)) {
                    System.out.println("Acceso Concedido");
                    auditoria.registrar(null, usuario);  // Éxito en el acceso
                    return usuario;  // Retorna el usuario si la validación es exitosa
                } else {
                    System.out.println("Acceso Denegado");
                    System.out.println("Ingrese nuevamente su usuario y contraseña");
                    auditoria.registrar(new Exception("Acceso Denegado"), usuario);  // Intento fallido
                }
                contador++;
            } while (contador < 4);
            
            if (contador > 3) {
                System.out.println("Se alcanzaron 3 intentos fallidos.");
                auditoria.registrar(new Exception("Demasiados intentos fallidos"), usuario);  // Intentos fallidos
                return null;  // Retorna null si se exceden los intentos
            }
        } catch (FileNotFoundException e) {    
            System.out.println("No se encontró el archivo: " + e.getMessage());
            auditoria.registrar(e, "Sistema");  // Error en el archivo
            return null;  // Retorna null en caso de error de archivo
        } catch (IOException e) {
            System.out.println("Error de lectura: " + e.getMessage());
            auditoria.registrar(e, "Sistema");  // Error en la lectura
            return null;  // Retorna null en caso de error de lectura
        }
        return null;  // Retorna null en caso de otros errores inesperados
    }
}
