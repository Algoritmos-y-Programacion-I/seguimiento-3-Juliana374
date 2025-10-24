package model;

import java.time.LocalDate;

public class Computer {

private String serialNumber;
private boolean nextWindow;

    public Computer(String serialNumber, boolean nextWindow) {
        this.serialNumber = serialNumber;
        this.nextWindow = nextWindow;

    }
    public String getSerialNumber() {
        return serialNumber;
    }
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public boolean isNextWindow() {
        return nextWindow;
    }

    public void setNextWindow(boolean nextWindow) {
        this.nextWindow = nextWindow;
    }


    }


