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

public class GestorDeArchivosFalda implements IGestorDeArchivos<Falda> {
    private static final String FILE_NAME = "faldas.dat";

    @Override
    public void guardarObjeto(Falda falda) throws IOException {
        List<Falda> faldas = obtenerTodosLosObjetos();
        faldas.add(falda);
        guardarListaEnArchivo(faldas);
    }

    @Override
    public List<Falda> obtenerTodosLosObjetos() {
        List<Falda> faldas = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            faldas = (List<Falda>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            
        }
        return faldas;
    }

    @Override
    public Optional<Falda> obtenerObjeto(Predicate<Falda> criterio) {
        return obtenerTodosLosObjetos().stream().filter(criterio).findFirst();
    }

    @Override
    public void actualizarObjeto(Falda faldaAntigua, Falda faldaNueva) {
        List<Falda> faldas = obtenerTodosLosObjetos();
        int index = faldas.indexOf(faldaAntigua);
        if (index != -1) {
            faldas.set(index, faldaNueva);
            guardarListaEnArchivo(faldas);
        }
    }

    @Override
    public void eliminarObjeto(Falda falda) {
        List<Falda> faldas = obtenerTodosLosObjetos();
        faldas.remove(falda);
        guardarListaEnArchivo(faldas);
    }

    private void guardarListaEnArchivo(List<Falda> faldas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(faldas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
