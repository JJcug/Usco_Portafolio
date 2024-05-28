/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoFinal;

import java.io.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GestorDeArchivosTraje implements IGestorDeArchivos<Traje> {
    private String archivo;

    public GestorDeArchivosTraje (String archivo) {
        this.archivo = archivo;
    }

    GestorDeArchivosTraje() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void guardarObjeto(Traje traje) throws IOException {
        List<Traje> trajes = obtenerTodosLosObjetos();
        trajes.add(traje);
        guardarTodosLosObjetos(trajes);
    }

    @Override
    public List<Traje> obtenerTodosLosObjetos() {
        List<Traje> trajes = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            trajes = (List<Traje>) ois.readObject();
        } catch (FileNotFoundException e) {
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return trajes;
    }

    @Override
    public Optional<Traje> obtenerObjeto(Predicate<Traje> criterio) {
        return obtenerTodosLosObjetos().stream().filter(criterio).findFirst();
    }

    @Override
    public void actualizarObjeto(Traje objetoAntiguo, Traje objetoNuevo) {
        List<Traje> trajes = obtenerTodosLosObjetos().stream()
                .map(t -> t.equals(objetoAntiguo) ? objetoNuevo : t)
                .collect(Collectors.toList());
        try {
            guardarTodosLosObjetos(trajes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarObjeto(Traje traje) {
        List<Traje> trajes = obtenerTodosLosObjetos().stream()
                .filter(t -> !t.equals(traje))
                .collect(Collectors.toList());
        try {
            guardarTodosLosObjetos(trajes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void guardarTodosLosObjetos(List<Traje> trajes) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(trajes);
        }
    }
}
