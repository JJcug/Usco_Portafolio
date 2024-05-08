/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoapp.Parcial2;

import java.util.ArrayList;
import java.util.List;

public class Garaje implements iGarage {
    private static final int NUMERO_ESPACIOS = 100; // Número de espacios en el garaje
    private List<Vehiculo> espacios; // Colección de espacios de vehículos

    // Constructor
    public Garaje() {
        this.espacios = new ArrayList<>(NUMERO_ESPACIOS);
    }

   
    @Override
    public double calcularIngresos() {
        double ingresos = 0;
        for (Vehiculo vehiculo : espacios) {
            ingresos += vehiculo.getCuotaMesGaraje();
        }
        return ingresos;
    }

    
    @Override
    public int calcularOcupacionPorTipoVehiculo(Vehiculo v) {
        int contador = 0;
        for (Vehiculo vehiculo : espacios) {
            if (vehiculo.getClass().equals(v.getClass())) {
                contador++;
            }
        }
        return contador;
    }

   

   
    public void agregarVehiculo(Vehiculo vehiculo) {
        if (espacios.size() < NUMERO_ESPACIOS) {
            espacios.add(vehiculo);
            System.out.println("Vehículo agregado al garaje.");
        } else {
            System.out.println("El garaje está lleno. No se puede agregar más vehículos.");
        }
    }

  
    public void eliminarVehiculo(Vehiculo vehiculo) {
        espacios.remove(vehiculo);
        System.out.println("Vehículo eliminado del garaje.");
    }

    
}