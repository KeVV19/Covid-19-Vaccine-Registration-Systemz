package com.covid19_vaccine_registration_system;

import java.util.ArrayList;

public class Citizen extends People{

    private int citizenID;

    public Citizen(String username, String password, Gender gender, int age, int isVaccinated, int citizenID) {
        super(username, password, gender, age, isVaccinated);
        this.citizenID = citizenID;
    }

    public int getCitizenID() {
        return citizenID;
    }
    public void setCitizenID(int citizenID) {
        this.citizenID = citizenID;
    }
}