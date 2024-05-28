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

public class GestorDeArchivosPantalon implements IGestorDeArchivos<Pantalon> {
    private static final String FILE_NAME = "pantalones.dat";

    @Override
    public void guardarObjeto(Pantalon pantalon) throws IOException {
        List<Pantalon> pantalones = obtenerTodosLosObjetos();
        pantalones.add(pantalon);
        guardarListaEnArchivo(pantalones);
    }

    @Override
    public List<Pantalon> obtenerTodosLosObjetos() {
        List<Pantalon> pantalones = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            pantalones = (List<Pantalon>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            
        }
        return pantalones;
    }

    @Override
    public Optional<Pantalon> obtenerObjeto(Predicate<Pantalon> criterio) {
        return obtenerTodosLosObjetos().stream().filter(criterio).findFirst();
    }

    @Override
    public void actualizarObjeto(Pantalon pantalonAntiguo, Pantalon pantalonNuevo) {
        List<Pantalon> pantalones = obtenerTodosLosObjetos();
        int index = pantalones.indexOf(pantalonAntiguo);
        if (index != -1) {
            pantalones.set(index, pantalonNuevo);
            guardarListaEnArchivo(pantalones);
        }
    }

    @Override
    public void eliminarObjeto(Pantalon pantalon) {
        List<Pantalon> pantalones = obtenerTodosLosObjetos();
        pantalones.remove(pantalon);
        guardarListaEnArchivo(pantalones);
    }

    private void guardarListaEnArchivo(List<Pantalon> pantalones) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(pantalones);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
