package com.macelcode;

import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void ctznLog(){
        System.out.println("Citizen Login");
    }

    public static void nCtznLog(){
        System.out.println("non-Citizen Login");
    }

    public static void admLog(){
        System.out.println("Admin Login");
    }

    public static void main(String[] args) {

        System.out.println("\nCovid-19 Vaccine Registration System\n------------------------------------");
        int inp = -1;

        do{
        System.out.println("Choose an account: \n1. Citizens\n2. non-Citizens\n3. Admin\n0. Exit");
        inp = sc.nextInt();
        }while(inp<0 || inp>3);

        switch (inp) {
            case 1 -> {
                System.out.println("\nLogging in as Citizen");
                ctznLog();
            }
            case 2 -> {
                System.out.println("\nLogging in as non-Citizen");
                nCtznLog();
            }
            case 3 -> {
                System.out.println("\nLogging in as Admin");
                admLog();
            }
            case 0 -> {
                System.out.println("\n~Exiting Program~");
                System.exit(0);
            }
        }
    }
}
