package com.covid19_vaccine_registration_system;

import java.io.Serializable;
import java.util.ArrayList;

public class People implements Serializable{

    private String username, password;
    private Gender gender;
    private int age;
    private ArrayList<Appointment> myAppointment = new ArrayList<Appointment>();

    public People(String username, String password, Gender gender, int age){
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.age = age;
    }

    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setGender(Gender gender) { this.gender = gender; }
    public void setAge (int age) { this.age = age; }

    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public Gender getGender() { return gender; }
    public int getAge() { return age; }

    public ArrayList<Appointment> getMyAppointment() {
        return myAppointment;
    }

    public void setMyAppointment(ArrayList<Appointment> myAppointment) {
        this.myAppointment = myAppointment;
    }
}
