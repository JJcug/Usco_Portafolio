/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoFinal;


public class Chaqueta extends Componente  {
    private boolean esImpermeable;

    // Constructor
    public Chaqueta(int id, String nombre, String talla, String color, boolean importado, double precio, boolean esImpermeable) {
        super(id, nombre, talla, color, importado, precio);
        this.esImpermeable = esImpermeable;
    }

    // Getters y Setters
    public boolean isEsImpermeable() {
        return esImpermeable;
    }

    public void setEsImpermeable(boolean esImpermeable) {
        this.esImpermeable = esImpermeable;
    }

    @Override
    public String toString() {
        return super.toString() + ", Chaqueta{" +
                "esImpermeable=" + esImpermeable +
                '}';
    }


 
    
}
