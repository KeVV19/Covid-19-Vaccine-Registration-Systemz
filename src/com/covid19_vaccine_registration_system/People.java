package com.covid19_vaccine_registration_system;

import java.util.ArrayList;

public class People{

    private String username, password;
    private Gender gender;
    private int age;
    private int isVaccinated;
    private ArrayList<VaccineName> vaccines = new ArrayList<VaccineName>();
    private ArrayList<Appointment> myAppointment = new ArrayList<Appointment>();

    public People(String username, String password, Gender gender, int age, int isVaccinated){
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.age = age;
        this.isVaccinated = isVaccinated;
    }

    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setGender(Gender gender) { this.gender = gender; }
    public void setAge (int age) { this.age = age; }
    public void setIsVaccinated(int isVaccinated) {
        this.isVaccinated = isVaccinated;
    }


    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }

    public Gender getGender() { return gender; }
    public int getAge() { return age; }

    public int getIsVaccinated() {
        return isVaccinated;
    }

    public ArrayList<VaccineName> getVaccines() {
        return vaccines;
    }
    public void setVaccines(ArrayList<VaccineName> vaccines) {
        this.vaccines = vaccines;
    }

    public ArrayList<Appointment> getMyAppointment() {
        return myAppointment;
    }
    public void setMyAppointment(ArrayList<Appointment> myAppointment) {
        this.myAppointment = myAppointment;
    }
}
