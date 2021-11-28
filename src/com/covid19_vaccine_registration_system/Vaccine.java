package com.covid19_vaccine_registration_system;

import java.util.ArrayList;

public class Vaccine {
    private int id;
    private String name;
    private int quantity;
    private int dose;
    private ArrayList<Centre> centres = new ArrayList<Centre>();

    public Vaccine(int id, String name, int quantity, int dose) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.dose = dose;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
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

    public ArrayList<Centre> getCentre() {
        return centres;
    }
    public void setCentre(ArrayList<Centre> centre) {
        this.centres = centre;
    }
}
