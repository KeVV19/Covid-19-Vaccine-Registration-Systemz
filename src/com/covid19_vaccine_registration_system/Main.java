package com.covid19_vaccine_registration_system;
//Commenting = CTRL + SHIFT + /
//Indenting/De-indent Block = TAB / SHIFT + TAB

import java.io.*;
import java.util.Scanner;


public class Main {

    public static Page1_Main first = new Page1_Main();
    public static Page2_Register second = new Page2_Register();
    public static Page3_Login third = new Page3_Login();
    public static Page4a_Citizen fourthA = new Page4a_Citizen();
    public static Page4b_NonCitizen fourthB = new Page4b_NonCitizen();
    public static Page5_Admin fifth = new Page5_Admin();
    public static Page5a_people fifthA = new Page5a_people();
    public static Page5b_appointment fifthB = new Page5b_appointment();
    public static Page5c_supply fifthC = new Page5c_supply();
    public static Citizen clogin;
    public static NonCitizen nclogin;
    public static Admin alogin;

    public static void main(String[] args) throws IOException {
        DataIO.read();
    }
}
