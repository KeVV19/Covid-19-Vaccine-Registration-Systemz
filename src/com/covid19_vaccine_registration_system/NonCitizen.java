package com.covid19_vaccine_registration_system;

public class NonCitizen extends People {

    int passportNum;

    public NonCitizen(String username, String password, char gender, int age, int PassportNum){
        super(username, password, gender, age);
        this.passportNum = PassportNum;
    }

    public int getPassportNum() {
        return passportNum;
    }
    public void setPassportNum(int passportNum) {
        this.passportNum = passportNum;
    }
}
