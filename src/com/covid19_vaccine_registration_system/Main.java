package com.covid19_vaccine_registration_system;
//Commenting = CTRL + SHIFT + /
//Indenting/De-indent Block = TAB / SHIFT + TAB

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.Scanner;


public class Main {

    private static final Scanner sc = new Scanner(System.in);

    //Login Methods
    public static void citizenLogin(){
        System.out.println("\nCitizen Login\n--------------");
    }

    public static void nonCitizenLogin(){
        System.out.println("\nNon-Citizen Login\n-----------------");
    }

    public static void adminLogin(){
        System.out.println("\nAdmin Login\n-----------");
    }

    //Register Methods
    public static void citizenRegis(){
        System.out.println("\nCitizen Registration\n---------------------");
    }

    public static void nonCitizenRegis(){
        System.out.println("\nNon-Citizen Registration\n------------------------");
    }

    public static void adminRegis(){
        String specialPass = "wordpass";
        System.out.println("\nAdmin Registration\n------------------");
    }



    //Main Method - Done
    public static void main(String[] args) throws IOException {
        System.out.println("\nCovid-19 Vaccine Registration System\n------------------------------------");
        int inp = 69;

        String username = "Macel";
        String password = "Celma";
        char gender = 'M';
        int age = 69;

        Admin admin = new Admin(username, password, gender, age);
        System.out.println("Hello World");
        System.out.println(admin.getGender());

do{
            System.out.println("Choose an Option: \n1. Login\n2. Register\n0. Exit");
            inp = sc.nextInt();
        }while(inp<0 || inp >2);

        if (inp == 1) {
            inp = 69;
            do {
                System.out.println("\nChoose an account to Login: \n1. Citizen\n2. non-Citizens\n3. Admin\n0. Exit");
                inp = sc.nextInt();
            } while (inp < 0 || inp > 3);
            switch (inp) {
                case 1 -> citizenLogin();
                case 2 -> nonCitizenLogin();
                case 3 -> adminLogin();
                case 0 -> System.exit(0);
            }
        } else if (inp == 2){
            inp = 69;
            do {
                System.out.println("\nChoose an account to Register: \n1. Citizen\n2. non-Citizens\n3. Admin (Need Special Pass)\n0. Exit");
                inp = sc.nextInt();
            } while (inp < 0 || inp > 3);
            switch (inp) {
                case 1 -> citizenRegis();
                case 2 -> nonCitizenRegis();
                case 3 -> adminRegis();
                case 0 -> System.exit(0);
            }
        } else{ System.exit(0); }

    }

}
