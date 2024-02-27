
package proyectoapp;
import java.util.Scanner;

// Javier Jose Cuellar Garcia #Codigo: 20232215547  Ejercicio #3

public class Prueba4 {
    public static void main(String[] args) {
        double DESCUENTO0a2= 0.0;
        double DESCUENTO2a5 = 0.1;
        double DESCUENTO5a10 = 0.15;
        double DESCUENTO10omas = 0.2;
         Scanner scanner = new Scanner(System.in);
         System.out.println("El precio de el kilo de manzana es de 12000, cuantos desea?: ");
         double cantidadKilos = scanner.nextDouble();
         
         double descuento = 0;
         
         if (cantidadKilos > 0 && cantidadKilos <= 2 ) {
             descuento = DESCUENTO0a2;
        } else if (cantidadKilos <=5) {
            descuento = DESCUENTO2a5;
        } else if (cantidadKilos <=10) {
            descuento = DESCUENTO5a10;
        } else  {
            descuento = DESCUENTO10omas;
        }
         
         double precioporkilo = 12000;
         double precioTotal = cantidadKilos * precioporkilo  * (1 - descuento);
         System.out.println("El precio total es de: " + precioTotal);


}
    }