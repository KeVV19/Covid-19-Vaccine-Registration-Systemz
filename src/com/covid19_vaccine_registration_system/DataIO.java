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

    public static ArrayList<Admin> allAdmins =
            new ArrayList<Admin>();

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

            /*Scanner sc3 = new Scanner(new File("Appointment.txt"));
            while(t.hasNext()){
                int a = Integer.parseInt(t.nextLine());
                Consultant b = Consultant.valueOf(t.nextLine());
                Day c = Day.valueOf(t.nextLine());
                int d = Integer.parseInt(t.nextLine());
                boolean e = Boolean.parseBoolean(t.nextLine());
                MyCustomer f = DataIO.checking(t.nextLine());
                t.nextLine();
                Booking x = new Booking(a, b, c, d, e, f);
                allBookings.add(x);
                f.getMyBookings().add(x);
            }*/
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
            for (Admin ad : allAdmins) {
                a.println(ad.getUsername());
                a.println(ad.getPassword());
                a.println(ad.getGender());
                a.println(ad.getAge());
                a.println();
            }
            a.close();

            /*PrintWriter q = new PrintWriter("booking.txt");
            for (Booking j : allBookings) {
                q.println(j.getId());
                q.println(j.getConsultant());
                q.println(j.getDay());
                q.println(j.getTime());
                q.println(j.isPaid());
                q.println(j.getOwner().getName());
                q.println();
            }
            q.close();*/
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
        for(Admin a : allAdmins){
            if(x.equals(a.getUsername())){
                return a;
            }
        }
        return null;
    }
}
