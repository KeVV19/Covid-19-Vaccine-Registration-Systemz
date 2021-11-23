package com.covid19_vaccine_registration_system;

public class NonCitizen extends People {

    int passportNum;
    Gender gender;

    public NonCitizen(String username, String password, Gender gender, int age, int PassportNum){
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
