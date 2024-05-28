/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoFinalRE;

import java.util.ArrayList;

public class Traje {
    private ArrayList<Componente> piezas;
    private String nombre;

    public Traje(String nombre) {
        this.piezas = new ArrayList<>();
        this.nombre = nombre;
    }

    public ArrayList<Componente> getPiezas() { return piezas; }
    public void setPiezas(ArrayList<Componente> piezas) { this.piezas = piezas; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    @Override
    public String toString() {
        return "Traje{" +
                "piezas=" + piezas +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}