package com.covid19_vaccine_registration_system;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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

            Scanner sc3 = new Scanner(new File("Appointment.txt"));
            while(sc3.hasNext()){
                int a = Integer.parseInt(sc3.nextLine());
                Centre b = Centre.valueOf(sc3.nextLine());
                Day c = Day.valueOf(sc3.nextLine());
                int d = Integer.parseInt(sc3.nextLine());
                boolean e = Boolean.parseBoolean(sc3.nextLine());
                People f = DataIO.checking(sc3.nextLine());
                sc3.nextLine();
                Appointment x = new Appointment(a, b, c, d, e, f);
                allAppointment.add(x);
                f.getMyAppointment().add(x);
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

            PrintWriter q = new PrintWriter("Appointment.txt");
            for (Appointment j : allAppointment) {
                q.println(j.getId());
                q.println(j.getCentre());
                q.println(j.getDay());
                q.println(j.getTime());
                q.println(j.isVaccinated());
                q.println(j.getOwner().getUsername());
                q.println();
            }
            q.close();
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

    /*public static void updateProfile(String newUsername,String newPassword,Gender newGender,Integer newAge,Integer newCitID){
        String tempFile = "temp.txt";
        File oldFile = new File("Citizen.txt");
        File newFile = new File(tempFile);
        String username = ""; String password = ""; String gender = ""; String age; String citID;
        try{
            FileWriter fw = new FileWriter(tempFile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            Scanner x = new Scanner(new File("Citizen.txt"));
            x.useDelimiter("(\\n)|;");

            while (x.hasNext()){
                username = x.next();
                password = x.next();
                gender = x.next();
                age = x.next();
                citID = x.next();
                if(username.equals(newUsername)){
                    pw.println(newUsername + "\n" + newPassword + "\n" + newGender + "\n" + newAge + "\n" + newCitID +"\n");
                }else{
                    pw.println(username + "\n" + password + "\n" + gender + "\n" + age + "\n" + citID +"\n");
                }
            }
            x.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File("Citizen.txt");
            newFile.renameTo(dump);

        }catch(Exception ex){
            System.out.println("Error");
        }
    }*/

    public static void update(String nmInput, String psInput, Gender gdInput, int ageInput, int citIDInput) {
        try {
            Scanner sc = new Scanner(new File("Citizen.txt"));
            while (sc.hasNext()) {
                String a = sc.nextLine();
                String b = sc.nextLine();
                Gender c = Gender.valueOf(sc.nextLine());
                int d = Integer.parseInt(sc.nextLine());
                int e = Integer.parseInt(sc.nextLine());
                sc.nextLine();
                if(a.equals(nmInput)){
                    PrintWriter x = new PrintWriter("Citizen.txt");
                    Citizen cit = new Citizen(nmInput, psInput, gdInput, ageInput, citIDInput);
                    allCitizen.add(cit);
                    x.close();
                }else{
                    System.out.println("error");
                }
            }
        }catch (Exception e){
            System.out.println("Error");
        }
    }
}
