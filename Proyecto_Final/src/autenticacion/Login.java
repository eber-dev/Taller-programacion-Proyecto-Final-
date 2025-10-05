/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autenticacion;
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
    public static String[] Credenciales() throws IOException{
        String[] log = new String[2];
        FileReader archivo = new FileReader("C:/Users/EBER/Documents/NetBeansProjects/Taller-programacion-Proyecto-Final-/Proyecto_Final/src/autenticacion/usuarios.txt");
        BufferedReader buffer = new BufferedReader(archivo);
        log[0] = buffer.readLine();
        log[1] = buffer.readLine();
        buffer.close();
        return log;
    }
    
    public boolean Validacion(){
        String usuario, contraseña;
        int contador=1;
        Scanner lector  = new Scanner(System.in);
        try{
            String[] credenciales = Login.Credenciales();  
            String usuariotexto = credenciales[0].trim();
            String contraseñatexto = credenciales[1].trim();
            do{
                System.out.println("Ingrese su usuario: ");
                usuario= lector.nextLine().trim();
        
                System.out.println("Ingrese su contraseña: ");
                contraseña = lector.nextLine().trim();
                
                if(usuario.equals(usuariotexto) && contraseña.equals(contraseñatexto)){
                    System.out.println("Acceso Concedido");
                    return true;
                }else{
                    System.out.println("Acceso Denegado");
                    System.out.println("Ingrese nuevamente su usuario y contraseña");
                }
                contador++;
            }while(contador<4);
            
            if(contador>3){
                System.out.println("Demasiados intentos fallidos");
                return false;
            } 
        }catch(FileNotFoundException e){    
            System.out.println("No se encontro el archivo: " + e.getMessage());
            return false;
        }catch(IOException e){
            System.out.println("Error de lectura: "+ e.getMessage());
            return false;
        }
        return false;
    }

}
