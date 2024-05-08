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
    private boolean tieneSidecar;

    public Moto(String placa, String marca, double precio, int cilindraje, boolean tieneSidecar) {
        super(placa, marca, precio, cilindraje, 0, 0);
        this.tieneSidecar = tieneSidecar;
        calcularImpuestoCirculacion(); 
        actualizarCuotaMesGaraje(); 
    }

  


    public boolean isTieneSidecar() {
        return tieneSidecar;
    }

    public void setTieneSidecar(boolean tieneSidecar) {
        this.tieneSidecar = tieneSidecar;
        calcularImpuestoCirculacion();
        actualizarCuotaMesGaraje();
    }

    
    public void calcularImpuestoCirculacion() {
        if (tieneSidecar) {
            impuestoCirculacion = precio * 0.02 * 1.10; 
        } else {
            impuestoCirculacion = precio * 0.02;
        }
    }

    
    private void actualizarCuotaMesGaraje() {
        if (tieneSidecar) {
            cuotaMesGaraje *= 1.5; 
        }
    }
}