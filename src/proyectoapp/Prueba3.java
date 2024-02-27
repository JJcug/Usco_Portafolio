
package proyectoapp;

import java.util.Scanner;

public class Prueba3 {
    public static void main(String[] args) {
        
        double DESCUENTOMAYOR500 = 0.1;
        double DESCUENTOMARCANOSY = 0.05;
        double IVA = 0.19;
        
        Scanner scanner = new Scanner(System.in); 
        System.out.println("Ingrese el precio del producto: ");
        double Preciodelproducto = scanner.nextInt();
        System.out.println("Ingrese la Marca: ");
        String marca = scanner.next().toUpperCase();
        
        double descuento = 0;
        if (Preciodelproducto >= 500) {
             descuento += DESCUENTOMAYOR500;    
        } 
        if (marca.equals("NOSY")) {
            descuento += DESCUENTOMARCANOSY;
        }
 
        double precioConDescuentos = Preciodelproducto* (1 - descuento);
        double precioConIVA = precioConDescuentos * (1 + IVA);
        
        System.out.println("Precio con iva incluido: $" + precioConIVA);
        
        
    }
    
}
 