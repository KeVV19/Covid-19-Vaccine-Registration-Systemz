package com.covid19_vaccine_registration_system;
//Commenting = CTRL + SHIFT + /
//Indenting/De-indent Block = TAB / SHIFT + TAB

import java.io.*;
import java.util.Scanner;


public class Main {

    public static Page1_Main first = new Page1_Main();
    public static Page2_Register second = new Page2_Register();
    public static Page3_Login third = new Page3_Login();
    public static Page4_Citizen fourth = new Page4_Citizen();
    public static Citizen clogin;
    public static NonCitizen nclogin;
    public static Admin alogin;

    public static void main(String[] args) throws IOException {
        DataIO.read();
    }
}
