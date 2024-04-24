
package proyectoapp.TallerPunto7_B_4;


public class Nombres {
   
    private String[] nombres;
    private int maxNombres;
    private int numNombres;

    public Nombres(int maxNombres) {
        this.maxNombres = maxNombres;
        this.nombres = new String[maxNombres];
        this.numNombres = 0;
    }

    public boolean anadir(String nombre) {
        if (estaLlena() || existeNombre(nombre)) {
            return false;
        }

        nombres[numNombres] = nombre;
        numNombres++;
        return true;
    }

    public boolean eliminar(String nombre) {
        int posicion = buscarNombre(nombre);
        if (posicion == -1) {
            return false;
        }

        nombres[posicion] = null;
        correrNombresIzquierda(posicion);
        numNombres--;
        return true;
    }

    public void vaciar() {
        for (int i = 0; i < numNombres; i++) {
            nombres[i] = null;
        }
        numNombres = 0;
    }

    public String mostrar(int posicion) {
        if (posicion < 0 || posicion >= numNombres) {
            return null;
        }
        return nombres[posicion];
    }

    public int numNombres() {
        return numNombres;
    }

    public int maxNombres() {
        return maxNombres;
    }

    public boolean estaLlena() {
        return numNombres == maxNombres;
    }

    private boolean existeNombre(String nombre) {
        for (int i = 0; i < numNombres; i++) {
            if (nombres[i].equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    private int buscarNombre(String nombre) {
        for (int i = 0; i < numNombres; i++) {
            if (nombres[i].equals(nombre)) {
                return i;
            }
        }
        return -1;
    }

    private void correrNombresIzquierda(int desde) {
        for (int i = desde; i < numNombres - 1; i++) {
            nombres[i] = nombres[i + 1];
        }
        nombres[numNombres - 1] = null;
    }
}
