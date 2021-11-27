package com.covid19_vaccine_registration_system;

import java.util.ArrayList;

public class Citizen extends People{

    private int citizenID;
    private ArrayList<Appointment> myAppointment = new ArrayList<Appointment>();

    public Citizen(String username, String password, Gender gender, int age, int vaccinated, int citizenID) {
        super(username, password, gender, age, vaccinated);
        this.citizenID = citizenID;
    }

    public int getCitizenID() {
        return citizenID;
    }
    public void setCitizenID(int citizenID) {
        this.citizenID = citizenID;
    }
}