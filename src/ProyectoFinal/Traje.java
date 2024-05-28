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

public class Traje implements Serializable, IGestorDeArchivos<Traje> {
    private int id;
    private String nombre;
    private List<Componente> componentes;

    
    public Traje(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.componentes = new ArrayList<>();
    }

    
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

    public List<Componente> getComponentes() {
        return componentes;
    }

    public void setComponentes(List<Componente> componentes) {
        this.componentes = componentes;
    }

    public void addComponente(Componente componente) {
        this.componentes.add(componente);
    }

    @Override
    public String toString() {
        return "Traje{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", componentes=" + componentes +
                '}';
    }

    
    private static final String FILE_NAME = "trajes.dat";

    @Override
    public void guardarObjeto(Traje traje) throws IOException {
        List<Traje> trajes = obtenerTodosLosObjetos();
        trajes.add(traje);
        guardarListaEnArchivo(trajes);
    }

    @Override
    public List<Traje> obtenerTodosLosObjetos() {
        List<Traje> trajes = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            trajes = (List<Traje>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
         
        }
        return trajes;
    }

    @Override
    public Optional<Traje> obtenerObjeto(Predicate<Traje> criterio) {
        return obtenerTodosLosObjetos().stream().filter(criterio).findFirst();
    }

    @Override
    public void actualizarObjeto(Traje trajeAntiguo, Traje trajeNuevo) {
        List<Traje> trajes = obtenerTodosLosObjetos();
        int index = trajes.indexOf(trajeAntiguo);
        if (index != -1) {
            trajes.set(index, trajeNuevo);
            guardarListaEnArchivo(trajes);
        }
    }

    @Override
    public void eliminarObjeto(Traje traje) {
        List<Traje> trajes = obtenerTodosLosObjetos();
        trajes.remove(traje);
        guardarListaEnArchivo(trajes);
    }

    private void guardarListaEnArchivo(List<Traje> trajes) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(trajes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
