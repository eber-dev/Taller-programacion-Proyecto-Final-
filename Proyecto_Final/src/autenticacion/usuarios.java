/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autenticacion;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



/**
 *
 * @author EBER
 */
class usuarios {
    public static void main(String[] args) throws IOException{
        String usuario, contraseña;
        FileReader archivo = new FileReader("C:/Users/EBER/Documents/NetBeansProjects/Taller-programacion-Proyecto-Final-/Proyecto_Final/src/autenticacion/usuarios.txt");
        BufferedReader buffer = new BufferedReader(archivo);
        
        usuario = buffer.readLine();
        contraseña = buffer.readLine();
        buffer.close();
        
        System.out.println(usuario);
        System.out.println(contraseña);
        

        
    }
    
}
