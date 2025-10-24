package model;

public class SchoolController {
        
        private String name;
        private int hourSpendSupport;

    public SchoolController(String name, int hourSpendSupport) {
        this.name = name;
        this.hourSpendSupport = hourSpendSupport;
    }

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


    public SchoolController() {
    
    }

    public void agregarComputador() {
     
    }

    public void agregarIncidenteEnComputador() {

    }

    public void getComputerList() {

    }

}
