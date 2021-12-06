package com.covid19_vaccine_registration_system;

public class People{

    private String username, password;
    private Gender gender;
    private int age;
    private int vaccinatedAmount;

    public People(String username, String password, Gender gender, int age, int vaccinatedAmount) {
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.age = age;
        this.vaccinatedAmount = vaccinatedAmount;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public int getVaccinatedAmount() {
        return vaccinatedAmount;
    }
    public void setVaccinatedAmount(int vaccinatedAmount) {
        this.vaccinatedAmount = vaccinatedAmount;
    }

    public void addVaccinatedAmt(int addAmt){
        if(Main.clogin != null) {
            int vacNum = Main.clogin.getVaccinatedAmount() + addAmt;
            Main.clogin.setVaccinatedAmount(vacNum);
            DataIO.write();
        }else{
            int vacNum = Main.nclogin.getVaccinatedAmount() + addAmt;
            Main.nclogin.setVaccinatedAmount(vacNum);
            DataIO.write();
        }
    }
}
