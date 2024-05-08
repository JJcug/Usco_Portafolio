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
                    alquilarEspacio(garaje, scanner);
                    break;
                case 2:
                    retirarVehiculo(garaje, scanner);
                    break;
                case 3:
                    double ingresos = garaje.calcularIngresos();
                    System.out.println("Ingresos mensuales del garaje: $" + ingresos);
                    break;
                case 4:
                    verificarProporcionAutosMotos(garaje);
                    break;
                case 5:
                    listarVehiculos(garaje);
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

    private static void alquilarEspacio(Garaje garaje, Scanner scanner) {
        if (garaje.getEspacios().size() >= Garaje.NUMERO_ESPACIOS) {
            System.out.println("El garaje está lleno. No se pueden alquilar más espacios.");
            return;
        }

        Vehiculo vehiculo = crearVehiculo(scanner);
        if (vehiculo == null) {
            System.out.println("No se puede alquilar un vehículo sin matrícula.");
            return;
        }

        int motosOcupadas = garaje.calcularOcupacionPorTipoVehiculo(new Moto());
        if ((double) motosOcupadas / Garaje.NUMERO_ESPACIOS >= 0.8) {
            System.out.println("No se pueden alquilar más plazas para motos. La ocupación de motos ya supera el 80%.");
            return;
        }

        garaje.agregarVehiculo(vehiculo);
    }

    private static void retirarVehiculo(Garaje garaje, Scanner scanner) {
        System.out.print("Ingrese la matrícula del vehículo a retirar: ");
        String matricula = scanner.next();
        Vehiculo vehiculo = buscarVehiculoPorMatricula(garaje, matricula);
        if (vehiculo != null) {
            garaje.eliminarVehiculo(vehiculo);
        } else {
            System.out.println("No se encontró ningún vehículo con la matrícula ingresada.");
        }
    }

    private static Vehiculo crearVehiculo(Scanner scanner) {
        System.out.print("Ingrese la matrícula del vehículo: ");
        String matricula = scanner.next();
        if (matricula.isEmpty()) {
            return null;
        }

        System.out.print("Ingrese la marca del vehículo: ");
        String marca = scanner.next();
        System.out.print("Ingrese el precio del vehículo: ");
        double precio = scanner.nextDouble();
        System.out.print("Ingrese el cilindraje del vehículo: ");
        int cilindraje = scanner.nextInt();


        return new Vehiculo(matricula, marca, precio, cilindraje);
    }

    private static Vehiculo buscarVehiculoPorMatricula(Garaje garaje, String matricula) {
        for (Vehiculo vehiculo : garaje.getEspacios()) {
            if (vehiculo.getPlaca().equals(matricula)) {
                return vehiculo;
            }
        }
        return null;
    }

    private static void verificarProporcionAutosMotos(Garaje garaje) {
        int autos = garaje.calcularOcupacionPorTipoVehiculo(new Auto());
        int motos = garaje.calcularOcupacionPorTipoVehiculo(new Moto());
        double proporcionAutos = (double) autos / Garaje.NUMERO_ESPACIOS;
        double proporcionMotos = (double) motos / Garaje.NUMERO_ESPACIOS;

        System.out.println("Proporción autos / motos en el garaje:");
        System.out.println("Autos: " + autos + " (" + proporcionAutos * 100 + "%)");
        System.out.println("Motos: " + motos + " (" + proporcionMotos * 100 + "%)");
    }

    private static void listarVehiculos(Garaje garaje) {
        System.out.println("Listado de matrículas, cuota mensual y tipo de vehículo:");
        for (Vehiculo vehiculo : garaje.getEspacios()) {
            System.out.println("Matrícula: " + vehiculo.getPlaca());
            System.out.println("Cuota mensual: $" + vehiculo.getCuotaMesGaraje());
            System.out.println("Tipo de vehículo: " + vehiculo.getClass().getSimpleName());
            System.out.println("------------------------");
        }
    }

   
        
    
}
