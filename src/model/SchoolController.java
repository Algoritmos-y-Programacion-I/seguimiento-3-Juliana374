package model;

import java.time.LocalDate;

/**
 * Clase que controla la gestión de computadores e incidentes en una institución
 * educativa.
 *
 * ENTRADAS: Nombre de la institución, número de pisos y columnas, datos de
 * computadores e incidentes.
 * PROCESO: Administra la creación de computadores, el registro de incidentes y
 * el control de soporte técnico.
 * SALIDA: Mensajes informativos sobre los resultados de las operaciones
 * realizadas.
 */
public class SchoolController {

    // -------------------- ATRIBUTOS --------------------
    // Integer[][] lista1 = {{ 1, 2, 3, 4, 5 },
    // { 6, 7, 8, 9, 10 },
    // { 11, 12, 13, 14, 15 }};

    private Computer[][] computersMatrix; // Matriz bidimensional de computadores
    private String name; // Nombre de la institución
    private int hourSpendSupport; // Total de horas invertidas en soporte
    public static final int FLOORS = 5; // Cantidad de pisos
    public static final int COL = 10; // Computadores por piso
    private static final int HOUR_MAX_SUPPORT = 100;

    // -------------------- CONSTRUCTOR --------------------
    /**
     * Constructor de la clase SchoolController.
     *
     * @param name Nombre de la institución.
     *
     *             ENTRADAS: Nombre de la institución.
     *             PROCESO: Inicializa la matriz vacía y define el contador de horas
     *             en cero.
     *             SALIDA: Objeto SchoolController listo para gestionar
     *             computadores.
     */
    public SchoolController(String name) {
        this.name = name;
        this.hourSpendSupport = 0;
        this.computersMatrix = new Computer[FLOORS][COL];
    }

    // -------------------- MÉTODOS GET Y SET --------------------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHourSpendSupport() {
        return hourSpendSupport;
    }

    public void setHourSpendSupport(int hourSpendSupport) {
        this.hourSpendSupport = hourSpendSupport;
    }

    // -------------------- MÉTODO 1: AGREGAR COMPUTADOR --------------------
    /**
     * Registra un nuevo computador en el piso indicado.
     *
     * @param floor        Piso donde se ubicará el computador (1 a 5).
     * @param serialNumber Número de serie del computador.
     * @param nextWindow   Indica si el computador está junto a una ventana.
     *
     *                     ENTRADAS: Piso, número de serie y condición junto a
     *                     ventana.
     *                     PROCESO: Verifica el piso, evita duplicados y guarda el
     *                     computador en la primera posición libre.
     *                     SALIDA: Mensaje informativo sobre el resultado del
     *                     registro.
     */
    public String addComputer(int floor, String serialNumber, boolean nextWindow) {

        if (floor < 1 || floor > FLOORS) {
            return "Error: El piso debe estar entre 1 y " + FLOORS + ".";
        }

        int row = floor - 1;
        // convierte el número de piso humano (1..5) en el índice de la matriz (0..4).

        for (int i = 0; i < FLOORS; i++) {
            for (int j = 0; j < COL; j++) {
                if (computersMatrix[i][j] != null &&
                        computersMatrix[i][j].getSerialNumber().equals(serialNumber)) {
                    return "Error: Ya existe un computador con ese número de serie.";
                }
            }
        }

        for (int j = 0; j < COL; j++) {
            if (computersMatrix[row][j] == null) {
                Computer newComputer = new Computer(serialNumber, nextWindow);
                computersMatrix[row][j] = newComputer;
                return "Computador registrado con éxito en el piso " + floor + ".";
            }
        }

        return "Error: No hay espacio disponible en este piso.";
    }

    // -------------------- MÉTODO 2: AGREGAR INCIDENTE --------------------
    /**
     * Registra un incidente en un computador existente.
     *
     * @param serialNumber Número de serie del computador.
     * @param description  Descripción del incidente.
     * @param year         Año del reporte.
     * @param month        Mes del reporte.
     * @param day          Día del reporte.
     * @param hoursSupport Horas de soporte invertidas en este incidente.
     *
     *                     ENTRADAS: Número de serie, descripción, fecha y horas de
     *                     soporte.
     *                     PROCESO: Busca el computador, agrega el incidente y
     *                     acumula las horas de soporte.
     *                     SALIDA: Mensaje confirmando el registro o indicando
     *                     error.
     */
    public String addIncidentToComputer(String serialNumber, String description, int year, int month, int day,
            int hoursSupport, boolean solution) {

        LocalDate dateReport = LocalDate.of(year, month, day);

        if (this.hourSpendSupport + hoursSupport >= HOUR_MAX_SUPPORT) {
            return "Se ha superado el maximo de horas de soporte";
        }

        for (int i = 0; i < FLOORS; i++) {
            for (int j = 0; j < COL; j++) {
                if (computersMatrix[i][j] != null &&
                        computersMatrix[i][j].getSerialNumber().equals(serialNumber)) {

                    computersMatrix[i][j].addIncident(description, dateReport, solution, hourSpendSupport);

                    this.hourSpendSupport += hoursSupport;

                    return "Incidente registrado con éxito en el computador " + serialNumber +
                            ". Horas de soporte acumuladas: " + hourSpendSupport + ".";
                }
            }
        }

        return "Error: No se encontró ningún computador con ese número de serie.";
    }

    // -------------------- MÉTODO 3: COMPUTADOR CON MÁS INCIDENTES
    // --------------------
    /**
     * Busca el computador con mayor cantidad de incidentes.
     *
     * ENTRADAS: Ninguna.
     * PROCESO: Recorre toda la matriz, compara la cantidad de incidentes y guarda
     * el mayor.
     * SALIDA: Mensaje con la información del computador con más incidentes.
     */
    public String computerMostIncidents() {
        String message = "No hay computadores registrados.";
        int maxIncidents = -1;

        for (int i = 0; i < FLOORS; i++) {
            for (int j = 0; j < COL; j++) {
                if (computersMatrix[i][j] != null) {
                    int count = computersMatrix[i][j].getIncidents().size();
                    if (count > maxIncidents) {
                        maxIncidents = count;
                        message = "Computador con más incidentes:\n" +
                                "Número de serie: " + computersMatrix[i][j].getSerialNumber() + "\n" +
                                "Ubicación: Piso " + (i + 1) + ", Columna " + (j + 1) + "\n" +
                                "Total de incidentes: " + count;
                    }
                }
            }
        }

        return message;
    }

    // -------------------- MÉTODO 4: CONTAR COMPUTADORES JUNTO A VENTANA
    // --------------------
    /**
     * Cuenta cuántos computadores están ubicados junto a una ventana.
     *
     * ENTRADAS: Ninguna.
     * PROCESO: Recorre la matriz y suma los computadores cuyo atributo nextWindow
     * sea true.
     * SALIDA: Mensaje con la cantidad total encontrada.
     */
    public String countComputersNextToWindow() {
        int count = 0;

        for (int i = 0; i < FLOORS; i++) {
            for (int j = 0; j < COL; j++) {
                if (computersMatrix[i][j] != null && computersMatrix[i][j].isNextWindow()) {
                    count++;
                }
            }
        }

        return "Hay " + count + " computadores ubicados junto a una ventana.";
    }
}
