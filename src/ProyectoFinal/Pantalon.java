/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoFinal;


public class Pantalon extends Componente {
    private boolean esFormal;

    
    public Pantalon(int id, String nombre, String talla, String color, boolean importado, double precio, boolean esFormal) {
        super(id, nombre, talla, color, importado, precio);
        this.esFormal = esFormal;
    }

  
    public boolean isEsFormal() {
        return esFormal;
    }

    public void setEsFormal(boolean esFormal) {
        this.esFormal = esFormal;
    }

    @Override
    public String toString() {
        return super.toString() + ", Pantalon{" +
                "esFormal=" + esFormal +
                '}';
    }

   

  
}
