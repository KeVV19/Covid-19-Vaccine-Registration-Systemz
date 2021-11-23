package com.covid19_vaccine_registration_system;

import java.util.ArrayList;

public class Citizen extends People{

    private int citizenID;
    private ArrayList<Appointment> myAppointment = new ArrayList<Appointment>();

    public Citizen(String username, String password, Gender gender, int age, int citID){
        super(username, password, gender, age);
        this.citizenID = citID;
    }

    public int getCitizenID() {
        return citizenID;
    }
    public void setCitizenID(int citizenID) {
        this.citizenID = citizenID;
    }
}