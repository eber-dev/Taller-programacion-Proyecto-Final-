/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_final;
import java.util.Scanner;
import autenticacion.Login;

/**
 *
 * @author EBER
 */
public class Sistema {

    public static void main(String[] args) {
        int opcion;
        Scanner lector = new Scanner(System.in);
        
        System.out.println("Sistema de reportes del clima");
        Login sesion = new Login();
        boolean acceso = sesion.Validacion();  
        
        String menu = """
                      #################################################################################################
                                                            MENU DE OPCIONES
                      #################################################################################################
                      # 1. Tabla con el número de eventos climáticos por año dado un rango de años 
                      # 2. Tabla con el número de eventos climáticos por mes dado un año
                      # 3. Tabla con el número de eventos climáticos por mes dados un rango de magnitudes y un año
                      # 4. Tabla con el número de eventos climáticos por cada hora dado un año
                      # 5. Salir
                      #################################################################################################
                      """;
        
        if(acceso){
            do{
                System.out.println(menu);
                System.out.println("Ingrese un de las siguientes opciones del menu: ");
                opcion = lector.nextInt();
                
                switch(opcion){
                    case 1:
                        System.out.println("caso1");
                        break;
                    case 2:
                        System.out.println("caso2");
                        break;
                        
                    case 3:
                        System.out.println("case3");
                        break;
                    
                    case 4:
                        System.out.println("case 4");
                        break;
                        
                    case 5:
                        System.out.println("Hasta luego");
                        break;
                    
                    default:
                        System.out.println("La opcion ingresada es incorrecta");
                }
                
            }while(true);
        }

                
        
    }
    
}
