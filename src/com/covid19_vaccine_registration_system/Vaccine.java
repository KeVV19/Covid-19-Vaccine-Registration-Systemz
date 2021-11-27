package com.covid19_vaccine_registration_system;

public class Vaccine {
    private String name;
    private int quantity;
    private int dose;

    public Vaccine(String name, int quantity, int dose) {
        this.name = name;
        this.quantity = quantity;
        this.dose = dose;
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
}
