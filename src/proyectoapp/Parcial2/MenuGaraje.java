/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoapp.Parcial2;

import java.util.Scanner;

public class MenuGaraje {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Garaje garaje = new Garaje();

        int opcion;
        do {
            System.out.println("\n--- Menú de Gestión del Garaje ---");
            System.out.println("1.- Alquilar un espacio");
            System.out.println("2.- Retirar vehículo");
            System.out.println("3.- Consulta de ingresos mensuales");
            System.out.println("4.- Consulta proporción autos / motos");
            System.out.println("5.- Listado de matrículas y cuota mensual y tipo vehículo");
            System.out.println("0.- Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Alquilar un espacio
                    // (Implementación depende de cómo se ingresan los datos del vehículo)
                    break;
                case 2:
                    // Retirar vehículo
                    // (Implementación depende de cómo se identifica el vehículo a retirar)
                    break;
                case 3:
                    // Consulta de ingresos mensuales
                    double ingresos = garaje.calcularIngresos();
                    System.out.println("Ingresos mensuales del garaje: $" + ingresos);
                    break;
                case 4:
                    // Consulta proporción autos / motos
                    int autos = garaje.calcularOcupacionPorTipoVehiculo(new Auto());
                    int motos = garaje.calcularOcupacionPorTipoVehiculo(new Moto());
                    System.out.println("Proporción autos / motos en el garaje:");
                    System.out.println("Autos: " + autos);
                    System.out.println("Motos: " + motos);
                    break;
                case 5:
                    // Listado de matrículas y cuota mensual y tipo vehículo
                    System.out.println("Listado de matrículas y cuota mensual y tipo vehículo:");
                    for (Vehiculo vehiculo : garaje.getEspacios()) {
                        System.out.println("Matrícula: " + vehiculo.getPlaca());
                        System.out.println("Cuota mensual: $" + vehiculo.getCuotaMesGaraje());
                        System.out.println("Tipo de vehículo: " + vehiculo.getClass().getSimpleName());
                        System.out.println("------------------------");
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
