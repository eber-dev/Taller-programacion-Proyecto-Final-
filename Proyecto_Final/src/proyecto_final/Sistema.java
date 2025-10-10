/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_final;
import java.util.Scanner;
import autenticacion.Login;
import datos.CSVLector;
import datos.ProcesarDatos;
import model.clima;
import reportes.generador;
import reportes.exportador;
import utileria.auditoria;
import java.io.IOException;
import java.util.List;
import java.util.Map;


/**
 *
 * @author EBER
 */
public class Sistema {

    public static void main(String[] args) throws IOException {
        int opcion;

        Scanner lector = new Scanner(System.in);
        List<clima> datos = CSVLector.leercsv("C:/Users/EBER/Documents/NetBeansProjects/Taller-programacion-Proyecto-Final-/Proyecto_Final/src/datos/Variables Meteorologicas.csv");
        String usuario = null;
        try{
            System.out.println("Sistema de reportes del clima");
            Login sesion = new Login();
            if (usuario == null) return;


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

                do{
                    System.out.println(menu);
                    System.out.println("Ingrese un de las siguientes opciones del menu: ");
                    opcion = lector.nextInt();

                    switch(opcion){
                        case 1:
                            System.out.println("caso1");
                            System.out.print("Año inicio: ");
                            int ai = Integer.parseInt(lector.nextLine().trim());
                            System.out.print("Año fin: ");
                            int af = Integer.parseInt(lector.nextLine().trim());
                            Map<Integer,Integer> mapaA = ProcesarDatos.Cuenta_Año(datos, ai, af);
                            String repA = generador.Reporte_Años(mapaA);
                            System.out.println(repA);
                            preguntarExportar(lector, repA, usuario);
                            break;
                        case 2:
                            System.out.println("caso2");
                            System.out.print("Año: ");
                            int y2 = Integer.parseInt(lector.nextLine().trim());
                            Map<Integer,Integer> mapaM = ProcesarDatos.Cuenta_Mes_Año(datos, y2);
                            String repM = generador.Reporte_Mes(mapaM, y2);
                            System.out.println(repM);
                            preguntarExportar(lector, repM, usuario);
                            break;

                        case 3:
                            System.out.println("case3");
                            System.out.print("Año: ");
                            int y3 = Integer.parseInt(lector.nextLine().trim());
                            System.out.print("Temp mínima: ");
                            double tmin = Double.parseDouble(lector.nextLine().trim());
                            System.out.print("Temp máxima: ");
                            double tmax = Double.parseDouble(lector.nextLine().trim());
                            Map<Integer,Integer> mapaTR = ProcesarDatos.Cuenta_Mes_Temp(datos, y3, tmin, tmax);
                            String repTR = generador.Reporte_Mes_Temp(mapaTR, y3, tmin, tmax);
                            System.out.println(repTR);
                            preguntarExportar(lector, repTR, usuario);
                            break;

                        case 4:
                            System.out.println("case 4");
                            System.out.print("Año: ");
                            int y4 = Integer.parseInt(lector.nextLine().trim());
                            Map<Integer,Integer> mapaH = ProcesarDatos.Cuenta_Hora(datos, y4);
                            String repH = generador.Reporte_Hora(mapaH, y4);
                            System.out.println(repH);
                            preguntarExportar(lector, repH, usuario);
                            break;

                        case 5:
                            System.out.println("Hasta luego");
                            break;

                        default:
                            System.out.println("La opcion ingresada es incorrecta");
                    }

                }while(opcion != 5);


            }catch(Exception e){
                System.out.println("Ocurrió un error. Se registró en auditoria.");
                auditoria.registrar(e, usuario == null ? "desconocido" : usuario);
            }  
    }
    
    private static void preguntarExportar(Scanner sc, String reporte, String usuario) {
        System.out.print("Desea exportar el reporte? (s/n): ");
        String r = sc.nextLine().trim().toLowerCase();
        if (r.equals("s") || r.equals("si")) {
            String nombre = "reporte_" + System.currentTimeMillis() + ".txt";
            try {
                exportador.exportar(reporte, nombre);
            } catch (Exception e) {
                System.out.println("Error al exportar. Registrando en auditoria.");
                auditoria.registrar(e, usuario);
            }
        }
    }
    
    
    
    
    
    
}
