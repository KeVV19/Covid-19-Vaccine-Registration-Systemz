package com.covid19_vaccine_registration_system;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DataIO {

    public static ArrayList<Citizen> allCitizen =
            new ArrayList<Citizen>();

    public static ArrayList<NonCitizen> allNonCitizen =
            new ArrayList<NonCitizen>();

    public static ArrayList<Admin> allAdmin =
            new ArrayList<Admin>();
			
	public static ArrayList<Appointment> allAppointment =
			new ArrayList<Appointment>();

    public static void read(){
        try{
            Scanner sc1 = new Scanner(new File("Citizen.txt"));
            while(sc1.hasNext()){
                String a = sc1.nextLine();
                String b = sc1.nextLine();
                Gender c = Gender.valueOf(sc1.nextLine());
                int d = Integer.parseInt(sc1.nextLine());
                int e = Integer.parseInt(sc1.nextLine());

                sc1.nextLine();
                Citizen cit = new Citizen(a, b, c, d, e);
                allCitizen.add(cit);
            }
            Scanner sc2 = new Scanner(new File("NonCitizen.txt"));
            while(sc2.hasNext()){
                String a = sc2.nextLine();
                String b = sc2.nextLine();
                Gender c = Gender.valueOf(sc2.nextLine());
                int d = Integer.parseInt(sc2.nextLine());
                int e = Integer.parseInt(sc2.nextLine());

                sc2.nextLine();
                NonCitizen ncit = new NonCitizen(a, b, c, d, e);
                allNonCitizen.add(ncit);
            }
            Scanner sc3 = new Scanner(new File("Admin.txt"));
            while(sc3.hasNext()){
                String a = sc3.nextLine();
                String b = sc3.nextLine();
                Gender c = Gender.valueOf(sc3.nextLine());
                int d = Integer.parseInt(sc3.nextLine());

                sc3.nextLine();
                Admin ad = new Admin(a, b, c, d);
                allAdmin.add(ad);
            }
            PrintWriter sc4 = new PrintWriter("Appointment.txt");
            for (Appointment j : allAppointment) {
                sc4.println(j.getId());
                sc4.println(j.getCentre());
                sc4.println(j.getDay());
                sc4.println(j.getTime());
                sc4.println(j.isVaccinated());
                sc4.println(j.getOwner().getUsername());
                sc4.println();
            }
            sc4.close();
        } catch(Exception e){
            System.out.println("Error while reading");
        }
    }

    public static void write(){
        try{
            PrintWriter c = new PrintWriter("Citizen.txt");
            for (Citizen cit : allCitizen) {
                c.println(cit.getUsername());
                c.println(cit.getPassword());
                c.println(cit.getGender());
                c.println(cit.getAge());
                c.println(cit.getCitizenID());
                c.println();
            }
            c.close();

            PrintWriter nc = new PrintWriter("NonCitizen.txt");
            for (NonCitizen ncit : allNonCitizen) {
                nc.println(ncit.getUsername());
                nc.println(ncit.getPassword());
                nc.println(ncit.getGender());
                nc.println(ncit.getAge());
                nc.println(ncit.getPassportNum());
                nc.println();
            }
            nc.close();

            PrintWriter a = new PrintWriter("Admin.txt");
            for (Admin ad : allAdmin) {
                a.println(ad.getUsername());
                a.println(ad.getPassword());
                a.println(ad.getGender());
                a.println(ad.getAge());
                a.println();
            }
            a.close();

            PrintWriter sc4 = new PrintWriter("Appointment.txt");
            for (Appointment app : allAppointment) {
                sc4.println(app.getId());
                sc4.println(app.getCentre());
                sc4.println(app.getDay());
                sc4.println(app.getTime());
                sc4.println(app.isVaccinated());
                sc4.println(app.getOwner());
                sc4.println();
            }
            sc4.close();

        } catch(Exception e){
            System.out.println("Error while writing");
        }
    }


    public static Citizen checking(String x) {
        Citizen found = null;
        for(Citizen c : allCitizen){
            if(x.equals(c.getUsername())){
                return c;
            }
        }
        return null;
    }

    public static NonCitizen checkingn(String x) {
        NonCitizen found = null;
        for(NonCitizen nc : allNonCitizen){
            if(x.equals(nc.getUsername())){
                return nc;
            }
        }
        return null;
    }

    public static Admin checkinga(String x) {
        Admin found = null;
        for(Admin a : allAdmin){
            if(x.equals(a.getUsername())){
                return a;
            }
        }
        return null;
    }
    public static Appointment checkingapp(int x) {
        Appointment found = null;
        for(Appointment app : allAppointment){
            if(x == app.getId()){
                return app;
            }
        }
        return null;
    }
}