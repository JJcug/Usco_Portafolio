
package proyectoapp.TallerPunto7_B_5;
import java.util.Scanner;
import java.util.ArrayList;

public class Prueba {
    
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de passwords a generar: ");
        int cantidadPasswords = scanner.nextInt();

        System.out.print("Ingrese la longitud deseada para las passwords: ");
        int longitudPassword = scanner.nextInt();

        ArrayList<Password> passwords = new ArrayList<>();
        ArrayList<Boolean> sonFuertes = new ArrayList<>();

        for (int i = 0; i < cantidadPasswords; i++) {
            Password password = new Password(longitudPassword);
            passwords.add(password);
            sonFuertes.add(password.esFuerte());
        }

        System.out.println("\nPasswords generadas:");
        for (Password password : passwords) {
            System.out.println(password);
        }

        System.out.println("\n¿Son fuertes las passwords?");
        for (Boolean esFuerte : sonFuertes) {
            System.out.println(esFuerte);
        }
    }
}
