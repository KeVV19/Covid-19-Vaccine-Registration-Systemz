package com.covid19_vaccine_registration_system;

public class Appointment {
    private int id;
    private Centre centre;
    private Day day;
    private int time;
    private boolean vaccinated;
    private People owner;

    public Appointment(int id, Centre centre, Day day, int time, boolean vaccinated, People owner) {
        this.id = id;
        this.centre = centre;
        this.day = day;
        this.time = time;
        this.vaccinated = vaccinated;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Centre getCentre() {
        return centre;
    }

    public void setCentre(Centre centre) {
        this.centre = centre;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    public People getOwner() {
        return owner;
    }

    public void setOwner(People owner) {
        this.owner = owner;
    }
}
