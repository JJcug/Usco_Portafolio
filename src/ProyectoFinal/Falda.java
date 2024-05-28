/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoFinal;


public class Falda extends Componente {
    private boolean esLarga;

    
    public Falda(int id, String nombre, String talla, String color, boolean importado, double precio, boolean esLarga) {
        super(id, nombre, talla, color, importado, precio);
        this.esLarga = esLarga;
    }

    
    public boolean isEsLarga() {
        return esLarga;
    }

    public void setEsLarga(boolean esLarga) {
        this.esLarga = esLarga;
    }

    @Override
    public String toString() {
        return super.toString() + ", Falda{" +
                "esLarga=" + esLarga +
                '}';
    }

  
   
        
    
}