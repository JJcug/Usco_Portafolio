/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoFinalRE;

public class Pantalon extends Componente {
    private boolean conCremallera;

    public Pantalon(int id, String nombre, String talla, String color, boolean escomunitario, double precio, boolean conCremallera) {
        super(id, nombre, talla, color, escomunitario, precio);
        this.conCremallera = conCremallera;
        if (conCremallera) {
            setPrecio(getPrecio() + 1);
        }
    }

    public boolean isConCremallera() { return conCremallera; }
    public void setConCremallera(boolean conCremallera) { this.conCremallera = conCremallera; }

    @Override
    public String toString() {
        return super.toString() + ", Pantalon{" +
                "conCremallera=" + conCremallera +
                '}';
    }
}
