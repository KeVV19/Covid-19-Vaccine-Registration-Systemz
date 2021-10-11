package com.covid19_vaccine_registration_system;

public class Citizen extends People{

    int citizenID;

    public Citizen(String username, String password, char gender, int age, int citID){
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