/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoapp.Parcial2;

/**
 *
 * @author javax
 */
public class PruebaGaraje {
    public static void main(String[] args) {
        // Crear algunos vehículos y motos
        Vehiculo vehiculo1 = new Vehiculo("ABC123", "Toyota", 15000, 2000, 0, 100);
        Vehiculo vehiculo2 = new Vehiculo("DEF456", "Honda", 18000, 1800, 0, 120);
        Moto moto1 = new Moto("GHI789", "Yamaha", 12000, 1000, false);
        Moto moto2 = new Moto("JKL012", "Suzuki", 14000, 1200, true);

        // Crear un garaje
        Garaje garaje = new Garaje();

        // Agregar vehículos y motos al garaje
        garaje.agregarVehiculo(vehiculo1);
        garaje.agregarVehiculo(vehiculo2);
        garaje.agregarVehiculo(moto1);
        garaje.agregarVehiculo(moto2);

        // Mostrar ingresos mensuales del garaje
        System.out.println("Ingresos mensuales del garaje: $" + garaje.calcularIngresos());

        // Consultar la ocupación de motos en el garaje
        int motosEnGaraje = garaje.calcularOcupacionPorTipoVehiculo(new Moto());
        System.out.println("Número de motos en el garaje: " + motosEnGaraje);

        // Listar los vehículos en el garaje
        System.out.println("Listado de vehículos en el garaje:");
        for (Vehiculo vehiculo : garaje.getEspacios()) {
            System.out.println("Matrícula: " + vehiculo.getPlaca());
            System.out.println("Marca: " + vehiculo.getMarca());
            System.out.println("Precio: $" + vehiculo.getPrecio());
            System.out.println("Cuota mensual: $" + vehiculo.getCuotaMesGaraje());
            System.out.println("------------------------");
        }
    }
}