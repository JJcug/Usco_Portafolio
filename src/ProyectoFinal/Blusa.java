/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoFinal;


public class Blusa extends Componente  {
    private boolean esMangaLarga;

    // Constructor
    public Blusa(int id, String nombre, String talla, String color, boolean importado, double precio, boolean esMangaLarga) {
        super(id, nombre, talla, color, importado, precio);
        this.esMangaLarga = esMangaLarga;
    }

    // Getters y Setters
    public boolean isEsMangaLarga() {
        return esMangaLarga;
    }

    public void setEsMangaLarga(boolean esMangaLarga) {
        this.esMangaLarga = esMangaLarga;
    }

    @Override
    public String toString() {
        return super.toString() + ", Blusa{" +
                "esMangaLarga=" + esMangaLarga +
                '}';
    }

}
