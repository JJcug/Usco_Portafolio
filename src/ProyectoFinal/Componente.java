/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoFinal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Componente implements IGestorDeArchivos<Componente>, Serializable {
    private int id;
    private String nombre;
    private String talla;
    private String color;
    private boolean importado;
    private double precio;

    // Constructor
    public Componente(int id, String nombre, String talla, String color, boolean importado, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.talla = talla;
        this.color = color;
        this.importado = importado;
        this.precio = precio;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isImportado() {
        return importado;
    }

    public void setImportado(boolean importado) {
        this.importado = importado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Componente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", talla='" + talla + '\'' +
                ", color='" + color + '\'' +
                ", importado=" + importado +
                ", precio=" + precio +
                '}';
    }

    // Implementación de IGestorDeArchivos
    private static final String FILE_NAME = "componentes.dat";

    @Override
    public void guardarObjeto(Componente componente) throws IOException {
        List<Componente> componentes = obtenerTodosLosObjetos();
        componentes.add(componente);
        guardarListaEnArchivo(componentes);
    }

    @Override
    public List<Componente> obtenerTodosLosObjetos() {
        List<Componente> componentes = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            componentes = (List<Componente>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Archivo no encontrado o vacío, devolver lista vacía
        }
        return componentes;
    }

    @Override
    public Optional<Componente> obtenerObjeto(Predicate<Componente> criterio) {
        return obtenerTodosLosObjetos().stream().filter(criterio).findFirst();
    }

    @Override
    public void actualizarObjeto(Componente componenteAntiguo, Componente componenteNuevo) {
        List<Componente> componentes = obtenerTodosLosObjetos();
        int index = componentes.indexOf(componenteAntiguo);
        if (index != -1) {
            componentes.set(index, componenteNuevo);
            guardarListaEnArchivo(componentes);
        }
    }

    @Override
    public void eliminarObjeto(Componente componente) {
        List<Componente> componentes = obtenerTodosLosObjetos();
        componentes.remove(componente);
        guardarListaEnArchivo(componentes);
    }

    private void guardarListaEnArchivo(List<Componente> componentes) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(componentes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
