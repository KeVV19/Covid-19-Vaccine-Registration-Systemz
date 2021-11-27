package com.covid19_vaccine_registration_system;

public class NonCitizen extends People {

    int passportNum;

    public NonCitizen(String username, String password, Gender gender, int age, int vaccinated, int passportNum) {
        super(username, password, gender, age, vaccinated);
        this.passportNum = passportNum;
    }

    public int getPassportNum() {
        return passportNum;
    }
    public void setPassportNum(int passportNum) {
        this.passportNum = passportNum;
    }
}
