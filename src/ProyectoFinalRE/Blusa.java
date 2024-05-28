/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoFinalRE;

public class Blusa extends Componente {
    private boolean mangaLarga;

    public Blusa(int id, String nombre, String talla, String color, boolean escomunitario, double precio, boolean mangaLarga) {
        super(id, nombre, talla, color, escomunitario, precio);
        this.mangaLarga = mangaLarga;
    }

    public boolean isMangaLarga() { return mangaLarga; }
    public void setMangaLarga(boolean mangaLarga) { this.mangaLarga = mangaLarga; }

    @Override
    public String toString() {
        return super.toString() + ", Blusa{" +
                "mangaLarga=" + mangaLarga +
                '}';
    }
}
