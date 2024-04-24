
package proyectoapp.Tallerpunto8_a_7;

import java.util.Scanner;

public class Pepetest {
    
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----- Creación de empleados -----");
        Empleado[] empleados = new Empleado[4];

        for (int i = 0; i < empleados.length; i++) {
            System.out.print("Introduzca el nombre del empleado " + (i + 1) + ": ");
            String nombre = scanner.nextLine();

            System.out.print("Introduzca el teléfono del empleado " + (i + 1) + ": ");
            String telefono = scanner.nextLine();

            empleados[i] = new Empleado(nombre, telefono);
        }

        System.out.println("\n----- Datos de los empleados -----");
        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }

        System.out.println("\n----- Número de empleados -----");
        System.out.println("Número total de empleados: " + Empleado.getNumeroEmpleados());
    }
}
