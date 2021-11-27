package com.covid19_vaccine_registration_system;

import java.util.ArrayList;

public class Centre {
    private String name;
    private String city;
    private String street;
    private ArrayList<Appointment> ceAppointment = new ArrayList<Appointment>();

    public Centre(String name, String city, String street) {
        this.name = name;
        this.city = city;
        this.street = street;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }

    public ArrayList<Appointment> getCeAppointment() {
        return ceAppointment;
    }
    public void setCeAppointment(ArrayList<Appointment> ceAppointment) {
        this.ceAppointment = ceAppointment;
    }
}
