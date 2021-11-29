package com.covid19_vaccine_registration_system;

import java.util.ArrayList;

public class Vaccine {
    private int id;
    private VaccineName name;
    private int quantity;
    private int dose;
    private Centre centre;
    /*private ArrayList<Centre> centres = new ArrayList<Centre>();*/

    public Vaccine(int id, VaccineName name, int quantity, int dose, Centre centre) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.dose = dose;
        this. centre = centre;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public VaccineName getName() {
        return name;
    }
    public void setName(VaccineName name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getDose() {
        return dose;
    }
    public void setDose(int dose) {
        this.dose = dose;
    }

    public Centre getCentre() {
        return centre;
    }
    public void setCentre(Centre centre) {
        this.centre = centre;
    }

    /*public ArrayList<Centre> getCentre() {
    return centres;
    }
    public void setCentre(ArrayList<Centre> centre) {
        this.centres = centre;
    }*/
}
