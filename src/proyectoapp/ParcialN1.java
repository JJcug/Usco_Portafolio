
package proyectoapp;

// Javier Jose Cuellar Garcia     Codigo: 20232215547


import java.util.Random;


public class ParcialN1 {
    

    public static void main(String[] args) {
      
      int Carreras = 20;
      int PuntosGanador = 5;
      int PuntosSegundo = 3;
      int PuntosTercero = 1;

        Random random = new Random();

        // Punto 1: Registro de nombre de competidores
        String[] nombresjinetes = new String[]{"Ana", "Pedro", "Juan", "Cesar", "Diana", "Maria"};

        // Variable para numero aleatorio de carreras
        int numCarreras = random.nextInt(Carreras) + 1;

        // Punto 2: Resultados de carreras 
        int[][] ResCarrera = new int[numCarreras][4];
        for (int i = 0; i < numCarreras; i++) {
            ResCarrera[i][0] = i + 1; // numero de carrera
            ResCarrera[i][1] = random.nextInt(nombresjinetes.length); // Ganador
            int segundoLugar;
            do {
                segundoLugar = random.nextInt(nombresjinetes.length);
            } while (segundoLugar == ResCarrera[i][1]);ResCarrera[i][2] = segundoLugar; // Segundo
            int tercerLugar;
            do {
                tercerLugar = random.nextInt(nombresjinetes.length);
            } while (tercerLugar == ResCarrera[i][1] || tercerLugar == ResCarrera[i][2]);ResCarrera[i][3] = tercerLugar; // Tercero
        }

        // Calcular puntaje 
        int[][] PuntajeJinetes = new int[nombresjinetes.length][3];
        for (int i = 0; i < numCarreras; i++) {
            int ganador = ResCarrera[i][1];
            int segundo = ResCarrera[i][2];
            int tercero = ResCarrera[i][3];

            // Ganador
            PuntajeJinetes[ganador][0]++;
            PuntajeJinetes[ganador][2] += PuntosGanador;

            // Segundo
            PuntajeJinetes[segundo][1]++;
            PuntajeJinetes[segundo][2] += PuntosSegundo;

            // Tercero
            PuntajeJinetes[tercero][2] += PuntosTercero;
        }

        // Punto 3: Podio
        System.out.println("Resultados del torneo:");
        System.out.println("-----------------------");
        System.out.printf("%-10s %-10s %-10s %-10s\n", "Carrera", "Ganador", "Segundo", "Tercero");
        for (int[] carrera : ResCarrera) {
            System.out.printf("%-10d %-10s %-10s %-10s\n",carrera[0], nombresjinetes[carrera[1]], nombresjinetes[carrera[2]], nombresjinetes[carrera[3]]);
        }

        System.out.println();
        System.out.println("Puntuaciones de los Jinetes:");
        System.out.println("-------------------------");
        System.out.printf("%-10s %-10s %-10s %-10s\n", "Jinete", "Carreras ganadas", "Segundo lugar", "Puntos");
        for (int i = 0; i < PuntajeJinetes.length; i++) {
            System.out.printf("%-10s %-10d %-10d %-10d\n",nombresjinetes[i], PuntajeJinetes[i][0], PuntajeJinetes[i][1], PuntajeJinetes[i][2]);
        }
    }
}
