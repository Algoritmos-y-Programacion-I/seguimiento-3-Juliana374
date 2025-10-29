package model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase que representa un computador dentro de la institución.
 *
 * ENTRADAS: Número de serie y condición junto a ventana.
 * PROCESO: Crear un computador con sus características e inicializar su lista
 * de incidentes.
 * SALIDA: Objeto Computer con lista vacía de incidentes.
 */
public class Computer {

    // -------------------- ATRIBUTOS --------------------
    private String serialNumber; // Número de serie del computador
    private boolean nextWindow;
    private ArrayList<Incident> incidents; // Lista de incidentes asociados

    // -------------------- CONSTRUCTOR --------------------
    /**
     * Constructor de la clase Computer.
     *
     * @param serialNumber Número de serie del computador.
     * @param nextWindow   Indica si está junto a una ventana.
     *
     *                     ENTRADAS: serialNumber y nextWindow.
     *                     PROCESO: Asignar los valores recibidos y crear una lista
     *                     vacía de incidentes.
     *                     SALIDA: Objeto Computer inicializado correctamente.
     */
    public Computer(String serialNumber, boolean nextWindow) {
        this.serialNumber = serialNumber;
        this.nextWindow = nextWindow;
        this.incidents = new ArrayList<>();

    }

    // -------------------- MÉTODO ESPECIAL --------------------
    /**
     * Agrega un incidente al computador.
     *
     * @param description Descripción del problema.
     * @param dateReport  Fecha del reporte.
     *
     *                    ENTRADAS: descripción y fecha.
     *                    PROCESO: Crear un nuevo incidente y añadirlo a la lista.
     *                    SALIDA: Incidente agregado correctamente.
     */
    public void addIncident(String description, LocalDate dateReport, boolean solution, int solutionHours) {
        Incident incident = new Incident(dateReport, description, solution, solutionHours);
        incidents.add(incident);
    }

    // -------------------- MÉTODOS GET --------------------
    /**
     * Métodos de acceso (getters).
     *
     * ENTRADAS: Ninguna.
     * PROCESO: Consultar y retornar los valores de los atributos.
     * SALIDA: Valores almacenados en los atributos.
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    public boolean isNextWindow() {
        return nextWindow;
    }

    public ArrayList<Incident> getIncidents() {
        return incidents;
    }

    // -------------------- MÉTODOS SET --------------------
    /**
     * Métodos de modificación (setters).
     *
     * @param Nuevos valores que reemplazarán los actuales.
     *               ENTRADAS: Reciben datos válidos para actualizar los atributos.
     *               PROCESO: Sustituir el valor anterior por el nuevo.
     *               SALIDA: Atributos actualizados correctamente.
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setNextWindow(boolean nextWindow) {
        this.nextWindow = nextWindow;
    }
}
