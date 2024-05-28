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

public class GestorDeArchivosBlusa  {
    private static final String FILE_NAME = "blusas.dat";

   
    public void guardarObjeto(Blusa blusa) throws IOException {
        List<Blusa> blusas = obtenerTodosLosObjetos();
        blusas.add(blusa);
        guardarListaEnArchivo(blusas);
    }

   
    public List<Blusa> obtenerTodosLosObjetos() {
        List<Blusa> blusas = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            blusas = (List<Blusa>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
          
        }
        return blusas;
    }

    
    public Optional<Blusa> obtenerObjeto(Predicate<Blusa> criterio) {
        return obtenerTodosLosObjetos().stream().filter(criterio).findFirst();
    }

   
    public void actualizarObjeto(Blusa blusaAntigua, Blusa blusaNueva) {
        List<Blusa> blusas = obtenerTodosLosObjetos();
        int index = blusas.indexOf(blusaAntigua);
        if (index != -1) {
            blusas.set(index, blusaNueva);
            guardarListaEnArchivo(blusas);
        }
    }

    public void eliminarObjeto(Blusa blusa) {
        List<Blusa> blusas = obtenerTodosLosObjetos();
        blusas.remove(blusa);
        guardarListaEnArchivo(blusas);
    }

    private void guardarListaEnArchivo(List<Blusa> blusas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(blusas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
