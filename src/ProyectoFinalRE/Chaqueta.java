/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoFinalRE;

public class Chaqueta extends Componente {
    private int numBotones;

    public Chaqueta(int id, String nombre, String talla, String color, boolean escomunitario, double precio, int numBotones) {
        super(id, nombre, talla, color, escomunitario, precio);
        this.numBotones = numBotones;
        setPrecio(getPrecio() + numBotones * 2);
    }

    public int getNumBotones() { return numBotones; }
    public void setNumBotones(int numBotones) { this.numBotones = numBotones; }

    @Override
    public String toString() {
        return super.toString() + ", Chaqueta{" +
                "numBotones=" + numBotones +
                '}';
    }
}
