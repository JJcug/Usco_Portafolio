/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoFinalRE;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class FabricaDeTrajes implements IFabricaTrajes {
    private ArrayList<Componente> componentesEnAlmacen = new ArrayList<>();
    private TreeSet<Traje> trajesEnAlmacen = new TreeSet<>();
    private boolean sonRebajas = false;
    private ArrayList<Envio> envios = new ArrayList<>();
    
public void escribirMenu() {
    Scanner scanner = new Scanner(System.in);
    int option;
    do {
        System.out.println("MENU FABRICA TRAJES");
        System.out.println("1.- Añadir Componente a almacén");
        System.out.println("2.- Listar Componentes del almacén");
        System.out.println("3.- Crear traje y añadir a almacén");
        System.out.println("4.- Listar trajes del almacén");
        System.out.println("5.- Crear envío");
        System.out.println("6.- Consultar envíos");
        System.out.println("7.- Activar/Desactivar las rebajas");
        System.out.println("10.- Salir del programa");
        System.out.print("Opción? ");
        option = scanner.nextInt();
        scanner.nextLine(); // consume newline
        switch (option) {
            case 1:
                añadirComponenteAAlmacen();
                break;
            case 2:
                listarComponentes();
                break;
            case 3:
                añadirTrajeAAlmacen();
                break;
            case 4:
                listarTrajes();
                break;
            case 5:
                crearEnvio();
                break;
            case 6:
                consultarEnvio();
                break;
            case 7:
                activadDesactivarRebajas();
                break;
            case 10:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción no válida");
        }
    } while (option != 10);
}

    @Override
    public void añadirComponenteAAlmacen() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el tipo de componente (Falda, Chaqueta, Pantalon, Blusa): ");
        String tipo = scanner.nextLine();
        System.out.println("Ingrese los detalles del componente");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Talla: ");
        String talla = scanner.nextLine();
        System.out.print("Color: ");
        String color = scanner.nextLine();
        System.out.print("Es comunitario (true/false): ");
        boolean escomunitario = scanner.nextBoolean();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();

        Componente componente = null;
        switch (tipo.toLowerCase()) {
            case "falda":
                System.out.print("Con cremallera (true/false): ");
                boolean conCremalleraFalda = scanner.nextBoolean();
                componente = new Falda(id, nombre, talla, color, escomunitario, precio, conCremalleraFalda);
                break;
            case "chaqueta":
                System.out.print("Número de botones: ");
                int numBotones = scanner.nextInt();
                componente = new Chaqueta(id, nombre, talla, color, escomunitario, precio, numBotones);
                break;
            case "pantalon":
                System.out.print("Con cremallera (true/false): ");
                boolean conCremalleraPantalon = scanner.nextBoolean();
                componente = new Pantalon(id, nombre, talla, color, escomunitario, precio, conCremalleraPantalon);
                break;
            case "blusa":
                System.out.print("Manga larga (true/false): ");
                boolean mangaLarga = scanner.nextBoolean();
                componente = new Blusa(id, nombre, talla, color, escomunitario, precio, mangaLarga);
                break;
            default:
                System.out.println("Tipo de componente no válido");
                return;
        }
        componentesEnAlmacen.add(componente);
        System.out.println("Componente añadido al almacén");
    }

    @Override
    public void listarComponentes() {
        if (componentesEnAlmacen.isEmpty()) {
            System.out.println("No hay componentes en el almacén");
        } else {
            for (Componente componente : componentesEnAlmacen) {
                System.out.println(componente);
            }
        }
    }

    @Override
    public void añadirTrajeAAlmacen() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del traje: ");
        String nombre = scanner.nextLine();
        Traje traje = new Traje(nombre);
        System.out.println("Añadiendo componentes al traje, ingrese el ID de los componentes uno por uno. Ingrese 0 para terminar.");
        while (true) {
            System.out.print("ID del componente: ");
            int id = scanner.nextInt();
            if (id == 0) break;
            Componente componente = buscarComponentePorId(id);
            if (componente != null) {
                traje.getPiezas().add(componente);
                System.out.println("Componente añadido al traje");
            } else {
                System.out.println("Componente no encontrado");
            }
        }
        trajesEnAlmacen.add(traje);
        System.out.println("Traje añadido al almacén");
    }

    private Componente buscarComponentePorId(int id) {
        for (Componente componente : componentesEnAlmacen) {
            if (componente.getId() == id) {
                return componente;
            }
        }
        return null;
    }

    @Override
    public void listarTrajes() {
        if (trajesEnAlmacen.isEmpty()) {
            System.out.println("No hay trajes en el almacén");
        } else {
            for (Traje traje : trajesEnAlmacen) {
                System.out.println(traje);
            }
        }
    }

    @Override
    public void activadDesactivarRebajas() {
        sonRebajas = !sonRebajas;
        if (sonRebajas) {
            System.out.println("Rebajas activadas");
        } else {
            System.out.println("Rebajas desactivadas");
        }
    }

 @Override
public void crearEnvio() {
    if (trajesEnAlmacen.isEmpty()) {
        System.out.println("No hay trajes disponibles para enviar.");
        return;
    }

    Envio envio = new Envio();
    Scanner scanner = new Scanner(System.in);

    System.out.println("Añadiendo trajes al envío, ingrese el nombre de los trajes uno por uno. Ingrese '0' para terminar.");
    while (true) {
        System.out.print("Nombre del traje: ");
        String nombre = scanner.nextLine();
        if (nombre.equals("0")) break;

        Traje traje = buscarTrajePorNombre(nombre);
        if (traje != null) {
            envio.añadirTraje(traje);
            trajesEnAlmacen.remove(traje);
            System.out.println("Traje añadido al envío.");
        } else {
            System.out.println("Traje no encontrado.");
        }
    }

    envios.add(envio);
    System.out.println("Envío creado y añadido a la lista de envíos.");
}

@Override
public void consultarEnvio() {
    if (envios.isEmpty()) {
        System.out.println("No hay envíos disponibles.");
        return;
    }

    for (Envio envio : envios) {
        System.out.println(envio);
        for (Traje traje : envio.getTrajes()) {
            System.out.println(" - " + traje);
        }
    }
}

private Traje buscarTrajePorNombre(String nombre) {
    for (Traje traje : trajesEnAlmacen) {
        if (traje.getNombre().equals(nombre)) {
            return traje;
        }
    }
    return null;
}
}