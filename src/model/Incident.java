package model;

import java.time.LocalDate;

public class Incident {
    
private LocalDate dateReport;
private String description; 
private boolean solution;
private int solutionHours;


      public void Incident(LocalDate dateReport, String description, boolean solution, int solutionHours) {
 
        this.dateReport = dateReport;
        this.description = description;
        this.solution = solution;
        this.solutionHours = solutionHours;     }


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




