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

public class GestorDeArchivosChaqueta implements IGestorDeArchivos<Chaqueta> {
    private static final String FILE_NAME = "chaquetas.dat";

    @Override
    public void guardarObjeto(Chaqueta chaqueta) throws IOException {
        List<Chaqueta> chaquetas = obtenerTodosLosObjetos();
        chaquetas.add(chaqueta);
        guardarListaEnArchivo(chaquetas);
    }

    @Override
    public List<Chaqueta> obtenerTodosLosObjetos() {
        List<Chaqueta> chaquetas = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            chaquetas = (List<Chaqueta>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Archivo no encontrado o vacío, devolver lista vacía
        }
        return chaquetas;
    }

    @Override
    public Optional<Chaqueta> obtenerObjeto(Predicate<Chaqueta> criterio) {
        return obtenerTodosLosObjetos().stream().filter(criterio).findFirst();
    }

    @Override
    public void actualizarObjeto(Chaqueta chaquetaAntigua, Chaqueta chaquetaNueva) {
        List<Chaqueta> chaquetas = obtenerTodosLosObjetos();
        int index = chaquetas.indexOf(chaquetaAntigua);
        if (index != -1) {
            chaquetas.set(index, chaquetaNueva);
            guardarListaEnArchivo(chaquetas);
        }
    }

    @Override
    public void eliminarObjeto(Chaqueta chaqueta) {
        List<Chaqueta> chaquetas = obtenerTodosLosObjetos();
        chaquetas.remove(chaqueta);
        guardarListaEnArchivo(chaquetas);
    }

    private void guardarListaEnArchivo(List<Chaqueta> chaquetas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(chaquetas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
