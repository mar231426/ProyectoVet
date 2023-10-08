import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Funciones {
    public static void main(String[] args) {
        CitasProximas.iniciar();
    }
}

class CitasProximas {
    public static void iniciar() {
        // Estas líneas de código inicializan una lista llamada `Citas` y un objeto `Scanner` llamado `citas`.
        List<LocalDate> Citas = new ArrayList<>();
        Scanner citas = new Scanner(System.in);

        // El bucle `while (true)` es un bucle infinito que continúa ejecutándose hasta que se encuentra una declaración de interrupción.
        while (true) {
            System.out.print("Ingrese la fecha en la que desea calendarizar la cita: (YYYY-MM-DD) o escriba 'salir' para terminar: ");
            String citaingresada = citas.nextLine();
            if (citaingresada.equalsIgnoreCase("salir")) {
                break;
            }

            // Este bloque de código es responsable de analizar la entrada del usuario como una fecha y agregarla a la lista `Citas`.
            try {
                LocalDate fecha = LocalDate.parse(citaingresada);
                Citas.add(fecha);
            } catch (Exception e) {
                System.out.println("Ha ingresado la fecha con un formato incorrecto, por favor, inténtelo de nuevo. Use el formato YYYY-MM-DD.");
            }
        }

        ordenarproximas(Citas);

        // Este código imprime la lista ordenada de fechas ("Citas") y luego itera sobre cada fecha en la lista y la imprime.
        System.out.println("Estas son las citas ordenadas por proximidad:");
        for (LocalDate cita : Citas) {
            System.out.println(cita);
        }
    }

    // El método 'ordenarproximas' es un método privado que toma como parámetro la lista.
    private static void ordenarproximas(List<LocalDate> citas) {
        LocalDate proximafecha = LocalDate.now();

        // El código `Collections.sort(citas, (uno, dos) -> {...})` ordena las fechas (`citas`) según su proximidad respecto a la fecha actual (`proximafecha`).
        Collections.sort(citas, (uno, dos) -> {
            long diferencia = ChronoUnit.DAYS.between(proximafecha, uno);
            long diferencias = ChronoUnit.DAYS.between(proximafecha, dos);
            return Long.compare(Math.abs(diferencia), Math.abs(diferencias));
        });
    }
}
