
package proyectoapp;

import java.util.Scanner;

// Javier Jose Cuellar Garcia #Codigo: 20232215547  Ejercicio #1
public class eaweeqwe {
     public static void main(String[] args) {
        double precioComputadora = 500.0;

        Scanner scanner = new Scanner(System.in);   
        System.out.print("Ingrese la cantidad de computadoras a comprar: ");
        int cantidadComputadoras = scanner.nextInt();
        double totalSinDescuento = precioComputadora * cantidadComputadoras;
        double descuento;
        if (cantidadComputadoras < 5) {
            descuento = 0.1; 
        } else if (cantidadComputadoras < 10) {
            descuento = 0.2; 
        } else {
            descuento = 0.4; 
        }

        double totalConDescuento = totalSinDescuento * (1 - descuento);

        System.out.println("Total sin descuento: $" + totalSinDescuento);
        System.out.println("Descuento aplicado: " + (descuento * 100) + "%");
        System.out.println("Total con descuento: $" + totalConDescuento);
    }
}

