package ui;

import java.util.Scanner;
import model.SchoolController;

/**
 * Interfaz de consola que conecta al usuario con el modelo (SchoolController).
 *
 * ENTRADAS: Datos ingresados por el usuario a través de consola (nombre del
 * colegio, seriales, fechas, etc.).
 * PROCESO: Recibir opciones del menú y delegar operaciones al SchoolController.
 * SALIDA: Mensajes informativos con los resultados de las operaciones.
 */
public class SchoolApp {

    /*
     * Relación con el modelo: controlador principal
     */
    private SchoolController controller;

    private Scanner input;

    public static void main(String[] args) {
        SchoolApp ui = new SchoolApp();
        ui.menu();
    }

    // Constructor
    public SchoolApp() {
        input = new Scanner(System.in);

        // Pedimos el nombre de la institución al iniciar y creamos el controller

        System.out.println("          INICIALIZANDO SISTEMA           ");
        System.out.println("==========================================");
        System.out.print("Ingrese el nombre de la institución: ");
        String schoolName = input.nextLine();

        // Inicializa SchoolController con el nombre (hourSpendSupport inicia en 0
        // dentro del controlador)
        controller = new SchoolController(schoolName);
        System.out.println("Sistema inicializado para: " + schoolName);
    }

    /*
     * Menú principal: presenta opciones y llama a los métodos correspondientes.
     */
    public void menu() {
        System.out.println("\nBienvenido a Computaricemos");

        int option = 0;
        do {
            System.out.println("\nMenu Principal");
            System.out.println("--------------------------------------------------------");
            System.out.println("Digite alguna de las siguientes opciones");
            System.out.println("1) Registrar computador");
            System.out.println("2) Registrar incidente en computador");
            System.out.println("3) Consultar el computador con más incidentes");
            System.out.println("4) Ver total de horas de soporte"); // opción adicional útil
            System.out.println("5) Contar computadores junto a ventana"); // opción adicional útil
            System.out.println("0) Salir del sistema");
            System.out.print("Opción: ");

            // Validación básica de entrada numérica
            while (!input.hasNextInt()) {
                System.out.println("Por favor ingrese un número válido para la opción.");
                input.next(); // limpiar token inválido
            }
            option = input.nextInt();
            input.nextLine(); // limpiar buffer

            switch (option) {
                case 1:
                    registrarComputador();
                    break;
                case 2:
                    registrarIncidenteEnComputador();
                    break;
                case 3:
                    consultarComputadorConMasIncidentes();
                    break;
                case 4:
                    System.out.println("Horas totales de soporte técnico: " + controller.getHourSpendSupport());
                    break;
                case 5:
                    System.out.println(controller.countComputersNextToWindow());
                    break;
                case 0:
                    System.out.println("\nGracias por usar nuestros servicios. Adios!");
                    break;
                default:
                    System.out.println("\nOpcion invalida. Intente nuevamente.");
                    break;
            }

        } while (option != 0);

        input.close();
    }

    /**
     * Permite al usuario registrar un computador.
     *
     * ENTRADAS: piso (int), serial (String), nextWindow (true/false).
     * PROCESO: Solicita datos al usuario y delega la creación al SchoolController.
     * SALIDA: Muestra el mensaje devuelto por el controlador.
     */
    public void registrarComputador() {
        System.out.println("\n--- Registrar Computador ---");

        // Solicitar piso con validación simple
        System.out.print("Ingrese el piso (1 - " + SchoolController.FLOORS + "): ");
        while (!input.hasNextInt()) {
            System.out.println("Por favor ingrese un número de piso válido.");
            input.next();
        }
        int floor = input.nextInt();
        input.nextLine();

        // Serial
        System.out.print("Ingrese el número de serie del computador: ");
        String serial = input.nextLine().trim();

        // nextWindow (true/false)
        System.out.print("¿Está junto a una ventana? (true/false): ");
        while (!input.hasNextBoolean()) {
            System.out.print("Respuesta inválida. Ingrese true o false: ");
            input.next();
        }
        boolean nextWindow = input.nextBoolean();
        input.nextLine();

        String result = controller.addComputer(floor, serial, nextWindow);
        System.out.println(result);
    }

    /**
     * Permite al usuario registrar un incidente en un computador existente.
     *
     * ENTRADAS: serial (String), descripción (String), fecha (año, mes, día) y
     * horas de soporte (int).
     * PROCESO: Solicita datos, valida formatos básicos y delega el registro al
     * controlador.
     * SALIDA: Muestra el mensaje devuelto por el controlador (éxito o error).
     */
    public void registrarIncidenteEnComputador() {
        System.out.println("\n--- Registrar Incidente en Computador ---");

        System.out.print("Ingrese el número de serie del computador: ");
        String serial = input.nextLine().trim();

        System.out.print("Ingrese la descripción del incidente: ");
        String description = input.nextLine().trim();

        // Fecha: año
        System.out.print("Ingrese el año del reporte (ej: 2025): ");
        while (!input.hasNextInt()) {
            System.out.print("Ingrese un año válido (número): ");
            input.next();
        }
        int year = input.nextInt();

        // Mes
        System.out.print("Ingrese el mes del reporte (1-12): ");
        while (!input.hasNextInt()) {
            System.out.print("Ingrese un mes válido (1-12): ");
            input.next();
        }
        int month = input.nextInt();

        // Día
        System.out.print("Ingrese el día del reporte (1-31): ");
        while (!input.hasNextInt()) {
            System.out.print("Ingrese un día válido (1-31): ");
            input.next();
        }
        int day = input.nextInt();

        // Horas de soporte
        System.out.print("Ingrese las horas de soporte invertidas (entero >= 0): ");
        while (!input.hasNextInt()) {
            System.out.print("Ingrese un número entero válido para las horas: ");
            input.next();
        }
        int hours = input.nextInt();
        input.nextLine(); // limpiar buffer

        System.out.print("¿Se ha solucionado el incidente?: ");
        Boolean solution = input.nextBoolean();

        // Llamada al controlador (se asume que el controlador valida existencia del
        // serial)
        String result = controller.addIncidentToComputer(serial, description, year, month, day, hours, solution);
        System.out.println(result);
    }

    /**
     * Consulta y muestra el computador que tiene más incidentes.
     *
     * ENTRADAS: Ninguna.
     * PROCESO: Llama al controlador para obtener la información.
     * SALIDA: Muestra el mensaje devuelto por el controlador.
     */
    public void consultarComputadorConMasIncidentes() {
        System.out.println("\n--- Computador con más incidentes ---");
        String result = controller.computerMostIncidents();
        System.out.println(result);
    }
}