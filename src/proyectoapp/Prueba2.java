

package proyectoapp;

// Javier Jose Cuellar Garcia #Codigo: 20232215547  Ejercicio #2

import java.util.Scanner;

 
public class Prueba2 {
    public static void main(String[] args) {
        int Preciomenosdecinco = 100;
        int Preciodecincoadies = 75;
        int PrecioMasDeDiez = 50;
    Scanner scanner = new Scanner(System.in);
    System.out.print("Cuantas llantas desea comprar?: ");
    int cantidadLlantas = scanner.nextInt();
    
    int PrecioPorLLanta;
    if (cantidadLlantas < 5) {
        PrecioPorLLanta = Preciomenosdecinco;
     } else if (cantidadLlantas <= 10) {
         PrecioPorLLanta = Preciodecincoadies;
     } else {
         PrecioPorLLanta = PrecioMasDeDiez;
     }
    
    
    int Total = cantidadLlantas * PrecioPorLLanta;
        System.out.println("Precio por llantas: $" + PrecioPorLLanta);
        System.out.println("Total de la compra: $" + Total);
}


    
}

