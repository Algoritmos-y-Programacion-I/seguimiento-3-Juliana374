package model;

import java.time.LocalDate;

/**
 * Clase que representa un incidente ocurrido en un computador.
 * Guarda la fecha del reporte, una descripción, el estado de solución y las
 * horas empleadas.
 *
 * ENTRADAS: Información relacionada con el incidente.
 * PROCESO: Almacenar los datos que describen el incidente en un objeto.
 * SALIDA: Objeto Incident correctamente inicializado.
 */

public class Incident {

    // -------------------- ATRIBUTOS --------------------
    private LocalDate dateReport; // Fecha del reporte
    private String description; // Descripción del incidente
    private boolean solution; // Estado de solución
    private int solutionHours; // Horas empleadas en la solución

    // -------------------- CONSTRUCTOR --------------------
    /**
     * Constructor de la clase Incident.
     * Permite crear un nuevo incidente con la información proporcionada.
     *
     * @param dateReport    Fecha en que se reportó el incidente.
     * @param description   Descripción detallada del problema.
     * @param solution      Indica si el incidente fue solucionado (true o false).
     * @param solutionHours Horas que tomó resolver el incidente.
     *
     *                      ENTRADAS: fecha, descripción, estado de solución y
     *                      horas.
     *                      PROCESO: Asignar los valores recibidos a los atributos
     *                      del objeto.
     *                      SALIDA: Objeto Incident inicializado con la información
     *                      correspondiente.
     */

    public Incident(LocalDate dateReport, String description, boolean solution, int solutionHours) {
        this.dateReport = dateReport;
        this.description = description;
        this.solution = solution;
        this.solutionHours = solutionHours;
    }

    // -------------------- MÉTODOS GET --------------------
    /**
     * Métodos de acceso (getters).
     *
     * ENTRADAS: Ninguna.
     * PROCESO: Consultar y retornar el valor de los diferentes atributos de la
     * clase.
     * SALIDA: Devuelven el valor actual almacenado en cada atributo.
     */

    // -------------------- MÉTODOS SET --------------------
    /**
     * Métodos de modificación (setters).
     *
     * @param Nuevos valores que reemplazarán los actuales.
     *               ENTRADAS: Reciben datos válidos para actualizar los atributos
     *               del objeto.
     *               PROCESO: Sustituir el valor anterior de cada atributo por el
     *               nuevo valor recibido.
     *               SALIDA: Atributos actualizados correctamente en el objeto.
     */

    public LocalDate getDateReport() {
        return dateReport;
    }

    public void setDateReport(LocalDate dateReport) {
        this.dateReport = dateReport;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsSolution() {
        return solution;
    }

    public void setSolution(boolean solution) {
        this.solution = solution;
    }

    public int getSolutionHours() {
        return solutionHours;
    }

    public void setSolutionHours(int solutionHours) {
        this.solutionHours = solutionHours;
    }

}
