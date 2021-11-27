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

    public static ArrayList<Centre> allCentre =
            new ArrayList<Centre>();

    public static ArrayList<Vaccine> allVaccine =
            new ArrayList<Vaccine>();

    public static void read(){
        try{
            Scanner sc1 = new Scanner(new File("Citizen.txt"));
            while(sc1.hasNext()){
                String a = sc1.nextLine();
                String b = sc1.nextLine();
                Gender c = Gender.valueOf(sc1.nextLine());
                int d = Integer.parseInt(sc1.nextLine());
                int e = Integer.parseInt(sc1.nextLine());
                int f = Integer.parseInt(sc1.nextLine());

                sc1.nextLine();
                Citizen cit = new Citizen(a, b, c, d, e, f);
                allCitizen.add(cit);
            }
            Scanner sc2 = new Scanner(new File("NonCitizen.txt"));
            while(sc2.hasNext()){
                String a = sc2.nextLine();
                String b = sc2.nextLine();
                Gender c = Gender.valueOf(sc2.nextLine());
                int d = Integer.parseInt(sc2.nextLine());
                int e = Integer.parseInt(sc2.nextLine());
                int f = Integer.parseInt(sc2.nextLine());

                sc2.nextLine();
                NonCitizen ncit = new NonCitizen(a, b, c, d, e, f);
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
            Scanner sc4 = new Scanner(new File("Appointment.txt"));
            while(sc4.hasNext()){
                int a = Integer.parseInt(sc4.nextLine());
                Centre b = DataIO.checkingcen(sc4.nextLine());
                Day c = Day.valueOf(sc4.nextLine());
                int d = Integer.parseInt(sc4.nextLine());
                sc4.nextLine();
                Appointment app = new Appointment(a,b,c,d);
                allAppointment.add(app);
            }
            Scanner sc5 = new Scanner(new File("Centre.txt"));
            while(sc5.hasNext()){
                String a = sc5.nextLine();
                String b = sc5.nextLine();
                String c = sc5.nextLine();
                sc5.nextLine();
                Centre cen = new Centre(a,b,c);
                allCentre.add(cen);
            }
            Scanner sc6 = new Scanner(new File("Vaccine.txt"));
            while(sc6.hasNext()){
                String a = sc6.nextLine();
                int b = Integer.parseInt(sc6.nextLine());
                int c = Integer.parseInt(sc6.nextLine());
                sc6.nextLine();
                Vaccine vac = new Vaccine(a,b,c);
                allVaccine.add(vac);
            }
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
                c.println(cit.getIsVaccinated());
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
                nc.println(ncit.getIsVaccinated());
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

            PrintWriter ap = new PrintWriter("Appointment.txt");
            for (Appointment app : allAppointment) {
                ap.println(app.getId());
                ap.println(app.getCentre());
                ap.println(app.getDay());
                ap.println(app.getTime());
                ap.println();
            }
            ap.close();

            PrintWriter ce = new PrintWriter("Centre.txt");
            for (Centre cen : allCentre) {
                ce.println(cen.getName());
                ce.println(cen.getCity());
                ce.println(cen.getStreet());
                ce.println();
            }
            ce.close();

            PrintWriter v = new PrintWriter("Vaccine.txt");
            for (Vaccine vac : allVaccine) {
                v.println(vac.getName());
                v.println(vac.getQuantity());
                v.println(vac.getDose());
                v.println();
            }
            v.close();

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
    public static Centre checkingcen(String x) {
        Centre found = null;
        for(Centre cen : allCentre){
            if(x.equals(cen.getName())){
                return cen;
            }
        }
        return null;
    }
    public static Vaccine checkingvac(String x) {
        Vaccine found = null;
        for(Vaccine vac : allVaccine){
            if(x.equals(vac.getName())){
                return vac;
            }
        }
        return null;
    }
}