package com.covid19_vaccine_registration_system;

import java.util.ArrayList;

public class Appointment {
    private int id;
    private Centre centre;
    private Day day;
    private int time;
    private ArrayList<People> Participants = new ArrayList<People>();

    public Appointment(int id, Centre centre, Day day, int time) {
        this.id = id;
        this.centre = centre;
        this.day = day;
        this.time = time;
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

    public ArrayList<People> getParticipants() {
        return Participants;
    }
    public void setParticipants(ArrayList<People> participants) {
        Participants = participants;
    }
}
