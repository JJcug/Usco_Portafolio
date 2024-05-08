/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoapp.Parcial2;

/**
 *
 * @author javax
 */
public class Moto extends Vehiculo {
    public boolean tieneSidecar;
            
    public Moto(String placa, String marca, double precio, int cilindraje, double impuestoCirculacion, double cuotaMesGaraje) {
        super(placa, marca, precio, cilindraje, impuestoCirculacion, cuotaMesGaraje);
        this.tieneSidecar = tieneSidecar;
    }

    public boolean isTieneSidecar() {
        return tieneSidecar;
    }
    
    public double calcularimpuestocirculaciion() {
       
    }   
}
