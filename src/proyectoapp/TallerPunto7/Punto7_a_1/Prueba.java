
package proyectoapp.TallerPunto7.Punto7_a_1;


public class Prueba {
    public static void main(String[] args) {
        
        Triangulo triangulo1 = new Triangulo(5, 8);
        Triangulo triangulo2 = new Triangulo(12, 15);
        Triangulo triangulo3 = new Triangulo(7, 9);

       
        mostrarInformacionTriangulo(triangulo1);
        mostrarInformacionTriangulo(triangulo2);
        mostrarInformacionTriangulo(triangulo3);

    
        triangulo1.setBase(6);
        triangulo1.setAltura(10);
        triangulo2.setAltura(18);

       
        System.out.println("\nTriángulos modificados:");
        mostrarInformacionTriangulo(triangulo1);
        mostrarInformacionTriangulo(triangulo2);
    }

    private static void mostrarInformacionTriangulo(Triangulo triangulo) {
        System.out.println("\nTriángulo:");
        System.out.println("Base: " + triangulo.getBase());
        System.out.println("Altura: " + triangulo.getAltura());
        System.out.println("Área: " + triangulo.calcularArea());
    }
}
