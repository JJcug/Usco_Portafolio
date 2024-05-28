/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoFinal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.io.IOException;

public class FabricaDeTrajes implements IFabricaDeTrajes {
   
    private static final Scanner scanner = new Scanner(System.in);
    private static final GestorDeArchivosFalda gestorFalda = new GestorDeArchivosFalda();
    private static final GestorDeArchivosPantalon gestorPantalon = new GestorDeArchivosPantalon();
    private static final GestorDeArchivosBlusa gestorBlusa = new GestorDeArchivosBlusa();
    private static final GestorDeArchivosChaqueta gestorChaqueta = new GestorDeArchivosChaqueta();
    private static final GestorDeArchivosTraje gestorTraje = new GestorDeArchivosTraje();

    private static final List<Componente> componentesEnAlmacen = new ArrayList<>();
    private static final List<Traje> trajesEnAlmacen = new ArrayList<>();
    private static boolean rebajasActivas = false;

    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Crear componente");
            System.out.println("2. Ver componentes");
            System.out.println("3. Actualizar componente");
            System.out.println("4. Eliminar componente");
            System.out.println("5. Crear traje");
            System.out.println("6. Ver trajes");
            System.out.println("7. Actualizar traje");
            System.out.println("8. Eliminar traje");
            System.out.println("9. Añadir componente a almacen");
            System.out.println("10. Listar componentes del almacen");
            System.out.println("11. Añadir traje a almacen");
            System.out.println("12. Listar trajes del almacen");
            System.out.println("13. Activar/Desactivar rebajas");
            System.out.println("14. Crear envío");
            System.out.println("15. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            try {
                switch (opcion) {
                    case 1:
                        crearComponente();
                        break;
                    case 2:
                        verComponentes();
                        break;
                    case 3:
                        actualizarComponente();
                        break;
                    case 4:
                        eliminarComponente();
                        break;
                    case 5:
                        crearTraje();
                        break;
                    case 6:
                        verTrajes();
                        break;
                    case 7:
                        actualizarTraje();
                        break;
                    case 8:
                        eliminarTraje();
                        break;
                    case 9:
                        añadirComponenteAAlmacen();
                        break;
                    case 10:
                        listarComponentes();
                        break;
                    case 11:
                        añadirTrajeAAlmacen();
                        break;
                    case 12:
                        listarTrajes();
                        break;
                    case 13:
                        activarDesactivarRebajas();
                        break;
                    case 14:
                        crearEnvio();
                        break;
                    case 15:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void crearComponente() throws IOException {
        System.out.println("Seleccione el tipo de componente:");
        System.out.println("1. Falda");
        System.out.println("2. Pantalón");
        System.out.println("3. Blusa");
        System.out.println("4. Chaqueta");

        int tipo = scanner.nextInt();
        scanner.nextLine();

        Componente nuevoComponente = null;

        switch (tipo) {
            case 1:
                nuevoComponente = crearFalda();
                gestorFalda.guardarObjeto((Falda) nuevoComponente);
                break;
            case 2:
                nuevoComponente = crearPantalon();
                gestorPantalon.guardarObjeto((Pantalon) nuevoComponente);
                break;
            case 3:
                nuevoComponente = crearBlusa();
                gestorBlusa.guardarObjeto((Blusa) nuevoComponente);
                break;
            case 4:
                nuevoComponente = crearChaqueta();
                gestorChaqueta.guardarObjeto((Chaqueta) nuevoComponente);
                break;
            default:
                System.out.println("Tipo de componente inválido.");
                return;
        }

        System.out.println("Componente creado y guardado correctamente.");
    }

    private static Falda crearFalda() {
        System.out.print("ID de la falda: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Color de la falda: ");
        String color = scanner.nextLine();
        System.out.print("Tamaño de la falda: ");
        String tamano = scanner.nextLine();
        System.out.print("¿Tiene cremallera? (true/false): ");
        boolean tieneCremallera = scanner.nextBoolean();
        scanner.nextLine(); 

        return new Falda(id, color, tamano, tieneCremallera);
    }

    private static Pantalon crearPantalon() {
        System.out.print("ID del pantalón: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Color del pantalón: ");
        String color = scanner.nextLine();
        System.out.print("Tamaño del pantalón: ");
        String tamano = scanner.nextLine();
        System.out.print("¿Tiene cremallera? (true/false): ");
        boolean tieneCremallera = scanner.nextBoolean();
        scanner.nextLine(); 

        return new Pantalon(id, color, tamano, tieneCremallera);
    }

    private static Blusa crearBlusa() {
        System.out.print("ID de la blusa: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Color de la blusa: ");
        String color = scanner.nextLine();
        System.out.print("Tamaño de la blusa: ");
        String tamano = scanner.nextLine();
        System.out.print("¿Es de manga larga? (true/false): ");
        boolean esMangaLarga = scanner.nextBoolean();
        scanner.nextLine();

        return new Blusa(id, color, tamano, esMangaLarga);
    }

    private static Chaqueta crearChaqueta() {
        System.out.print("ID de la chaqueta: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Color de la chaqueta: ");
        String color = scanner.nextLine();
        System.out.print("Tamaño de la chaqueta: ");
        String tamano = scanner.nextLine();
        System.out.print("Número de botones: ");
        int numBotones = scanner.nextInt();
        scanner.nextLine(); 

        return new Chaqueta(id, color, tamano, numBotones);
    }

    private static void verComponentes() {
        System.out.println("Seleccione el tipo de componente a ver:");
        System.out.println("1. Faldas");
        System.out.println("2. Pantalones");
        System.out.println("3. Blusas");
        System.out.println("4. Chaquetas");

        int tipo = scanner.nextInt();
        scanner.nextLine(); 

        switch (tipo) {
            case 1:
                gestorFalda.obtenerTodosLosObjetos().forEach(System.out::println);
                break;
            case 2:
                gestorPantalon.obtenerTodosLosObjetos().forEach(System.out::println);
                break;
            case 3:
                gestorBlusa.obtenerTodosLosObjetos().forEach(System.out::println);
                break;
            case 4:
                gestorChaqueta.obtenerTodosLosObjetos().forEach(System.out::println);
                break;
            default:
                System.out.println("Tipo de componente inválido.");
        }
    }

    private static void actualizarComponente() throws IOException {
        System.out.println("Seleccione el tipo de componente a actualizar:");
        System.out.println("1. Falda");
        System.out.println("2. Pantalón");
        System.out.println("3. Blusa");
        System.out.println("4. Chaqueta");

        int tipo = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("ID del componente a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        switch (tipo) {
            case 1:
                Optional<Falda> faldaOpt = gestorFalda.obtenerObjeto(f -> f.getId() == id);
                if (faldaOpt.isPresent()) {
                    Falda faldaNueva = crearFalda();
                    gestorFalda.actualizarObjeto(faldaOpt.get(), faldaNueva);
                    System.out.println("Falda actualizada correctamente.");
                } else {
                    System.out.println("Falda no encontrada.");
                }
                break;
            case 2:
                Optional<Pantalon> pantalonOpt = gestorPantalon.obtenerObjeto(p -> p.getId() == id);
                if (pantalonOpt.isPresent()) {
                    Pantalon pantalonNuevo = crearPantalon();
                    gestorPantalon.actualizarObjeto(pantalonOpt.get(), pantalonNuevo);
                    System.out.println("Pantalón actualizado correctamente.");
                } else {
                    System.out.println("Pantalón no encontrado.");
                }
                break;
            case 3:
                Optional<Blusa> blusaOpt = gestorBlusa.obtenerObjeto(b -> b.getId() == id);
                if (blusaOpt.isPresent()) {
                    Blusa blusaNueva = crearBlusa();
                    gestorBlusa.actualizarObjeto(blusaOpt.get(), blusaNueva);
                    System.out.println("Blusa actualizada correctamente.");
                } else {
                    System.out.println("Blusa no encontrada.");
                }
                break;
            case 4:
                Optional<Chaqueta> chaquetaOpt = gestorChaqueta.obtenerObjeto(c -> c.getId() == id);
                if (chaquetaOpt.isPresent()) {
                    Chaqueta chaquetaNueva = crearChaqueta();
                    gestorChaqueta.actualizarObjeto(chaquetaOpt.get(), chaquetaNueva);
                    System.out.println("Chaqueta actualizada correctamente.");
                } else {
                    System.out.println("Chaqueta no encontrada.");
                }
                break;
            default:
                System.out.println("Tipo de componente inválido.");
        }
    }

    private static void eliminarComponente() throws IOException {
        System.out.println("Seleccione el tipo de componente a eliminar:");
        System.out.println("1. Falda");
        System.out.println("2. Pantalón");
        System.out.println("3. Blusa");
        System.out.println("4. Chaqueta");

        int tipo = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("ID del componente a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        switch (tipo) {
            case 1:
                Optional<Falda> faldaOpt = gestorFalda.obtenerObjeto(f -> f.getId() == id);
                if (faldaOpt.isPresent()) {
                    gestorFalda.eliminarObjeto(faldaOpt.get());
                    System.out.println("Falda eliminada correctamente.");
                } else {
                    System.out.println("Falda no encontrada.");
                }
                break;
            case 2:
                Optional<Pantalon> pantalonOpt = gestorPantalon.obtenerObjeto(p -> p.getId() == id);
                if (pantalonOpt.isPresent()) {
                    gestorPantalon.eliminarObjeto(pantalonOpt.get());
                    System.out.println("Pantalón eliminado correctamente.");
                } else {
                    System.out.println("Pantalón no encontrado.");
                }
                break;
            case 3:
                Optional<Blusa> blusaOpt = gestorBlusa.obtenerObjeto(b -> b.getId() == id);
                if (blusaOpt.isPresent()) {
                    gestorBlusa.eliminarObjeto(blusaOpt.get());
                    System.out.println("Blusa eliminada correctamente.");
                } else {
                    System.out.println("Blusa no encontrada.");
                }
                break;
            case 4:
                Optional<Chaqueta> chaquetaOpt = gestorChaqueta.obtenerObjeto(c -> c.getId() == id);
                if (chaquetaOpt.isPresent()) {
                    gestorChaqueta.eliminarObjeto(chaquetaOpt.get());
                    System.out.println("Chaqueta eliminada correctamente.");
                } else {
                    System.out.println("Chaqueta no encontrada.");
                }
                break;
            default:
                System.out.println("Tipo de componente inválido.");
        }
    }
    @Override
    public void añadirComponenteAAlmacen() throws IOException, IdException, MuchoExtracomunitarioException, MangaException {
        
        System.out.println("Seleccione el tipo de componente: (1) Blusa, (2) Chaqueta, (3) Falda, (4) Pantalón");
        int tipo = scanner.nextInt();
        scanner.nextLine(); 
        
        
    }

    @Override
    public void listarComponentes() {
        componentesEnAlmacen.forEach(System.out::println);
    }

    @Override
    public void añadirTrajeAAlmacen() throws IOException, ColoresException, TallaException, TrajeYaExisteException {
        System.out.print("ID del traje: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Seleccione una blusa:");
        componentesEnAlmacen.stream().filter(c -> c instanceof Blusa).forEach(System.out::println);
        int idBlusa = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Seleccione una chaqueta:");
        componentesEnAlmacen.stream().filter(c -> c instanceof Chaqueta).forEach(System.out::println);
        int idChaqueta = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Seleccione una falda o pantalón:");
        componentesEnAlmacen.stream().filter(c -> c instanceof Falda || c instanceof Pantalon).forEach(System.out::println);
        int idParteInferior = scanner.nextInt();
        scanner.nextLine(); 

        Optional<Blusa> blusaOpt = componentesEnAlmacen.stream().filter(c -> c instanceof Blusa && c.getId() == idBlusa).map(c -> (Blusa) c).findFirst();
        Optional<Chaqueta> chaquetaOpt = componentesEnAlmacen.stream().filter(c -> c instanceof Chaqueta && c.getId() == idChaqueta).map(c -> (Chaqueta) c).findFirst();
        Optional<Componente> parteInferiorOpt = componentesEnAlmacen.stream().filter(c -> (c instanceof Falda || c instanceof Pantalon) && c.getId() == idParteInferior).findFirst();

        if (!blusaOpt.isPresent() || !chaquetaOpt.isPresent() || !parteInferiorOpt.isPresent()) {
            System.out.println("Componente no encontrado.");
            return;
        }

        Blusa blusa = blusaOpt.get();
        Chaqueta chaqueta = chaquetaOpt.get();
        Componente parteInferior = parteInferiorOpt.get();

        if (!coloresCompatibles(blusa, chaqueta, parteInferior)) {
            throw new ColoresException("Los colores de los componentes no son compatibles.");
        }

        if (!tallasCompatibles(blusa, chaqueta, parteInferior)) {
            throw new TallaException("Las tallas de los componentes no son compatibles.");
        }

        if (trajesEnAlmacen.stream().anyMatch(t -> t.getId() == id)) {
            throw new TrajeYaExisteException("El nombre del traje ya existe en el almacén.");
        }

        Traje nuevoTraje = new Traje(id, blusa, parteInferior, chaqueta);
        trajesEnAlmacen.add(nuevoTraje);
        componentesEnAlmacen.remove(blusa);
        componentesEnAlmacen.remove(chaqueta);
        componentesEnAlmacen.remove(parteInferior);
        System.out.println("Traje añadido al almacén correctamente.");
    }

    @Override
    public void listarTrajes() {
        trajesEnAlmacen.forEach(System.out::println);
    }

    @Override
    public void activarDesactivarRebajas() {
        rebajasActivas = !rebajasActivas;
        if (rebajasActivas) {
            componentesEnAlmacen.forEach(c -> c.setPrecio(c.getPrecio() * 0.8));
            trajesEnAlmacen.forEach(t -> t.setPrecio(t.getPrecio() * 0.8));
        } else {
            componentesEnAlmacen.forEach(c -> c.setPrecio(c.getPrecio() / 0.8));
            trajesEnAlmacen.forEach(t -> t.setPrecio(t.getPrecio() / 0.8));
        }
        System.out.println("Rebajas " + (rebajasActivas ? "activadas." : "desactivadas."));
    }

    @Override
    public void crearEnvio() {
        List<Traje> envio = new ArrayList<>();
        while (true) {
            System.out.println("Seleccione un traje para añadir al envío:");
            trajesEnAlmacen.forEach(t -> System.out.println(t.getId() + ": " + t));
            System.out.println("0: Finalizar envío");

            int id = scanner.nextInt();
            scanner.nextLine(); 

            if (id == 0) break;

            Optional<Traje> trajeOpt = trajesEnAlmacen.stream().filter(t -> t.getId() == id).findFirst();
            if (trajeOpt.isPresent()) {
                envio.add(trajeOpt.get());
                trajesEnAlmacen.remove(trajeOpt.get());
                System.out.println("Traje añadido al envío.");
            } else {
                System.out.println("Traje no encontrado.");
            }
        }

        System.out.println("Envío creado con los siguientes trajes:");
        envio.forEach(System.out::println);
    }

    private boolean coloresCompatibles(Blusa blusa, Chaqueta chaqueta, Componente parteInferior) {
        return (blusa.getColor().charAt(0) == chaqueta.getColor().charAt(0) && blusa.getColor().charAt(0) == parteInferior.getColor().charAt(0))
                || (chaqueta.getColor().charAt(0) == parteInferior.getColor().charAt(0) && chaqueta.getColor().charAt(0) == blusa.getColor().charAt(0));
    }

    private boolean tallasCompatibles(Blusa blusa, Chaqueta chaqueta, Componente parteInferior) {
        return blusa.getTamano().equals(chaqueta.getTamano()) && (parteInferior instanceof Falda || parteInferior.getTamano().equals(blusa.getTamano()));
    }

    private boolean mangaException(Componente nuevoComponente) {
        if (nuevoComponente instanceof Blusa) {
            Blusa blusa = (Blusa) nuevoComponente;
            if (blusa.esMangaLarga()) {
                return componentesEnAlmacen.stream().noneMatch(c -> c instanceof Blusa && !((Blusa) c).esMangaLarga() && c.getColor().equals(blusa.getColor()));
            } else {
                return componentesEnAlmacen.stream().noneMatch(c -> c instanceof Blusa && ((Blusa) c).esMangaLarga() && c.getColor().equals(blusa.getColor()));
            }
        }
        return false;
    }


    private static void crearTraje() throws IOException {
        System.out.print("ID del traje: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Seleccione una blusa:");
        gestorBlusa.obtenerTodosLosObjetos().forEach(System.out::println);
        int idBlusa = scanner.nextInt();
        scanner.nextLine(); 
        Optional<Blusa> blusaOpt = gestorBlusa.obtenerObjeto(b -> b.getId() == idBlusa);

        System.out.println("Seleccione una chaqueta:");
        gestorChaqueta.obtenerTodosLosObjetos().forEach(System.out::println);
        int idChaqueta = scanner.nextInt();
        scanner.nextLine(); 
        Optional<Chaqueta> chaquetaOpt = gestorChaqueta.obtenerObjeto(c -> c.getId() == idChaqueta);

        System.out.println("Seleccione una falda o pantalón:");
        System.out.println("Faldas:");
        gestorFalda.obtenerTodosLosObjetos().forEach(System.out::println);
        System.out.println("Pantalones:");
        gestorPantalon.obtenerTodosLosObjetos().forEach(System.out::println);
        int idParteInferior = scanner.nextInt();
        scanner.nextLine(); 
        Optional<Componente> parteInferiorOpt = gestorFalda.obtenerObjeto(f -> f.getId() == idParteInferior)
                .map(c -> (Componente) c)
                .or(() -> gestorPantalon.obtenerObjeto(p -> p.getId() == idParteInferior)
                        .map(c -> (Componente) c));

        if (!blusaOpt.isPresent() || !chaquetaOpt.isPresent() || !parteInferiorOpt.isPresent()) {
            System.out.println("Componente no encontrado.");
            return;
        }

        Blusa blusa = blusaOpt.get();
        Chaqueta chaqueta = chaquetaOpt.get();
        Componente parteInferior = parteInferiorOpt.get();

        if (!coloresCompatibles(blusa, chaqueta, parteInferior)) {
            System.out.println("Error: Los colores de los componentes no son compatibles.");
            return;
        }

        if (!tallasCompatibles(blusa, chaqueta, parteInferior)) {
            System.out.println("Error: Las tallas de los componentes no son compatibles.");
            return;
        }

        Traje nuevoTraje = new Traje(id, blusa, parteInferior, chaqueta);
        gestorTraje.guardarObjeto(nuevoTraje);
        System.out.println("Traje creado y guardado correctamente.");
    }

    private static void verTrajes() {
        gestorTraje.obtenerTodosLosObjetos().forEach(System.out::println);
    }

    private static void actualizarTraje() throws IOException {
        System.out.print("ID del traje a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        Optional<Traje> trajeOpt = gestorTraje.obtenerObjeto(t -> t.getId() == id);
        if (trajeOpt.isPresent()) {
            System.out.println("Ingrese los nuevos datos del traje:");
            crearTraje();
            Traje trajeNuevo = gestorTraje.obtenerTodosLosObjetos().get(gestorTraje.obtenerTodosLosObjetos().size() - 1);
            gestorTraje.actualizarObjeto(trajeOpt.get(), trajeNuevo);
            System.out.println("Traje actualizado correctamente.");
        } else {
            System.out.println("Traje no encontrado.");
        }
    }

    private static void eliminarTraje() throws IOException {
        System.out.print("ID del traje a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        Optional<Traje> trajeOpt = gestorTraje.obtenerObjeto(t -> t.getId() == id);
        if (trajeOpt.isPresent()) {
            gestorTraje.eliminarObjeto(trajeOpt.get());
            System.out.println("Traje eliminado correctamente.");
        } else {
            System.out.println("Traje no encontrado.");
        }
    }

    private static void añadirComponenteAAlmacen() throws IdException, MuchoExtracomunitarioException, MangaException {
        System.out.println("Seleccione el tipo de componente a añadir:");
        System.out.println("1. Falda");
        System.out.println("2. Pantalón");
        System.out.println("3. Blusa");
        System.out.println("4. Chaqueta");

        int tipo = scanner.nextInt();
        scanner.nextLine(); 

        Componente nuevoComponente = null;

        switch (tipo) {
            case 1:
                nuevoComponente = crearFalda();
                break;
            case 2:
                nuevoComponente = crearPantalon();
                break;
            case 3:
                nuevoComponente = crearBlusa();
                break;
            case 4:
                nuevoComponente = crearChaqueta();
                break;
            default:
                System.out.println("Tipo de componente inválido.");
                return;
        }

       
        if (componentesEnAlmacen.stream().anyMatch(c -> c.getId() == nuevoComponente.getId())) {
            throw new IdException("El ID del componente ya existe.");
        }

        
        long extracomunitarios = componentesEnAlmacen.stream().filter(Componente::esExtracomunitario).count();
        if (nuevoComponente.esExtracomunitario() && extracomunitarios >= componentesEnAlmacen.size() / 2) {
            throw new MuchoExtracomunitarioException("Hay más del 50% de componentes extracomunitarios en el almacén.");
        }

        
        if (mangaException(nuevoComponente)) {
            throw new MangaException("No se puede añadir la blusa debido a la regla de mangas.");
        }

        
        if (nuevoComponente instanceof Chaqueta) {
            Chaqueta chaqueta = (Chaqueta) nuevoComponente;
            chaqueta.setPrecio(chaqueta.getPrecio() + 2 * chaqueta.getNumBotones());
        } else if (nuevoComponente instanceof Pantalon || nuevoComponente instanceof Falda) {
            if (((Pantalon) nuevoComponente).tieneCremallera()) {
                nuevoComponente.setPrecio(nuevoComponente.getPrecio() + 1);
            }
        }

        componentesEnAlmacen.add(nuevoComponente);
        System.out.println("Componente añadido al almacén correctamente.");
    }

    private static void listarComponentes() {
        componentesEnAlmacen.forEach(System.out::println);
    }

    private static void añadirTrajeAAlmacen() throws ColoresException, TallaException, TrajeYaExisteException {
        System.out.print("ID del traje: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        System.out.println("Seleccione una blusa:");
        componentesEnAlmacen.stream().filter(c -> c instanceof Blusa).forEach(System.out::println);
        int idBlusa = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        System.out.println("Seleccione una chaqueta:");
        componentesEnAlmacen.stream().filter(c -> c instanceof Chaqueta).forEach(System.out::println);
        int idChaqueta = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Seleccione una falda o pantalón:");
        componentesEnAlmacen.stream().filter(c -> c instanceof Falda || c instanceof Pantalon).forEach(System.out::println);
        int idParteInferior = scanner.nextInt();
        scanner.nextLine(); 

        Optional<Blusa> blusaOpt = componentesEnAlmacen.stream().filter(c -> c instanceof Blusa && c.getId() == idBlusa).map(c -> (Blusa) c).findFirst();
        Optional<Chaqueta> chaquetaOpt = componentesEnAlmacen.stream().filter(c -> c instanceof Chaqueta && c.getId() == idChaqueta).map(c -> (Chaqueta) c).findFirst();
        Optional<Componente> parteInferiorOpt = componentesEnAlmacen.stream().filter(c -> (c instanceof Falda || c instanceof Pantalon) && c.getId() == idParteInferior).findFirst();

        if (!blusaOpt.isPresent() || !chaquetaOpt.isPresent() || !parteInferiorOpt.isPresent()) {
            System.out.println("Componente no encontrado.");
            return;
        }

        Blusa blusa = blusaOpt.get();
        Chaqueta chaqueta = chaquetaOpt.get();
        Componente parteInferior = parteInferiorOpt.get();

        if (!coloresCompatibles(blusa, chaqueta, parteInferior)) {
            throw new ColoresException("Los colores de los componentes no son compatibles.");
        }

        if (!tallasCompatibles(blusa, chaqueta, parteInferior)) {
            throw new TallaException("Las tallas de los componentes no son compatibles.");
        }

        if (trajesEnAlmacen.stream().anyMatch(t -> t.getId() == id)) {
            throw new TrajeYaExisteException("El nombre del traje ya existe en el almacén.");
        }

        Traje nuevoTraje = new Traje(id, blusa, parteInferior, chaqueta);
        trajesEnAlmacen.add(nuevoTraje);
        componentesEnAlmacen.remove(blusa);
        componentesEnAlmacen.remove(chaqueta);
        componentesEnAlmacen.remove(parteInferior);
        System.out.println("Traje añadido al almacén correctamente.");
    }

    private static void listarTrajes() {
        trajesEnAlmacen.forEach(System.out::println);
    }

    private static void activarDesactivarRebajas() {
        rebajasActivas = !rebajasActivas;
        if (rebajasActivas) {
            componentesEnAlmacen.forEach(c -> c.setPrecio(c.getPrecio() * 0.8));
            trajesEnAlmacen.forEach(t -> t.setPrecio(t.getPrecio() * 0.8));
        } else {
            componentesEnAlmacen.forEach(c -> c.setPrecio(c.getPrecio() / 0.8));
            trajesEnAlmacen.forEach(t -> t.setPrecio(t.getPrecio() / 0.8));
        }
        System.out.println("Rebajas " + (rebajasActivas ? "activadas." : "desactivadas."));
    }

    private static void crearEnvio() {
        List<Traje> envio = new ArrayList<>();
        while (true) {
            System.out.println("Seleccione un traje para añadir al envío:");
            trajesEnAlmacen.forEach(t -> System.out.println(t.getId() + ": " + t));
            System.out.println("0: Finalizar envío");

            int id = scanner.nextInt();
            scanner.nextLine(); 

            if (id == 0) break;

            Optional<Traje> trajeOpt = trajesEnAlmacen.stream().filter(t -> t.getId() == id).findFirst();
            if (trajeOpt.isPresent()) {
                envio.add(trajeOpt.get());
                trajesEnAlmacen.remove(trajeOpt.get());
                System.out.println("Traje añadido al envío.");
            } else {
                System.out.println("Traje no encontrado.");
            }
        }

        System.out.println("Envío creado con los siguientes trajes:");
        envio.forEach(System.out::println);
    }

    private static boolean coloresCompatibles(Blusa blusa, Chaqueta chaqueta, Componente parteInferior) {
        return (blusa.getColor().charAt(0) == chaqueta.getColor().charAt(0) && blusa.getColor().charAt(0) == parteInferior.getColor().charAt(0))
                || (chaqueta.getColor().charAt(0) == parteInferior.getColor().charAt(0) && chaqueta.getColor().charAt(0) == blusa.getColor().charAt(0));
    }

    private static boolean tallasCompatibles(Blusa blusa, Chaqueta chaqueta, Componente parteInferior) {
        return blusa.getTamano().equals(chaqueta.getTamano()) && (parteInferior instanceof Falda || parteInferior.getTamano().equals(blusa.getTamano()));
    }

    private static boolean mangaException(Componente nuevoComponente) {
        if (nuevoComponente instanceof Blusa) {
            Blusa blusa = (Blusa) nuevoComponente;
            if (blusa.esMangaLarga()) {
                return componentesEnAlmacen.stream().noneMatch(c -> c instanceof Blusa && !((Blusa) c).esMangaLarga() && c.getColor().equals(blusa.getColor()));
            } else {
                return componentesEnAlmacen.stream().noneMatch(c -> c instanceof Blusa && ((Blusa) c).esMangaLarga() && c.getColor().equals(blusa.getColor()));
            }
        }
        return false;
    }

    void escribirMenu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
