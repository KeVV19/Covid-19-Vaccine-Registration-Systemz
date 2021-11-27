package com.covid19_vaccine_registration_system;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Centre {
    private String name;
    private String city;
    private String street;
    private ArrayList<Appointment> allAppointments = new ArrayList<Appointment>();
    private ArrayList<Vaccine> allVaccines = new ArrayList<Vaccine>();

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

    public ArrayList<Appointment> getAllAppointments() {
        return allAppointments;
    }
    public void setAllAppointments(ArrayList<Appointment> allAppointments) {
        this.allAppointments = allAppointments;
    }

    public ArrayList<Vaccine> getAllVaccines() {
        return allVaccines;
    }
    public void setAllVaccines(ArrayList<Vaccine> allVaccines) {
        this.allVaccines = allVaccines;
    }
}
