package com.covid19_vaccine_registration_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Page2_Register extends JFrame implements ActionListener {

    Scanner sc = new Scanner(System.in);

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == citizen){
            JTextField username = new JTextField(16);
            JTextField password = new JPasswordField(16);
            JTextField gender = new JTextField(5);
            JTextField age = new JTextField(5);
            JTextField citID = new JTextField(16);

            Object[] message = {
                    "Username: ", username,
                    "Password: ", password,
                    "Gender : ", gender,
                    "Age : ", age,
                    "Citizen ID : ", citID

            };

            int option = JOptionPane.showConfirmDialog(null, message, "Citizen Register", JOptionPane.OK_CANCEL_OPTION);
            String nmInput = username.getText();



        } else if (e.getSource() == nCitizen) {

        } else if (e.getSource() == admin) {

        } else if (e.getSource() == back) {
            setVisible(false);
            new Page1_Main().setVisible(true);
        }
    }

    private Button citizen, nCitizen, admin, back;

    public Page2_Register(){
        setSize(400, 300);
        setLocation(700, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 4, 5, 5)); //top-bottom, center alignment

        citizen = new Button("Citizen");
        nCitizen = new Button("Non-Citizen");
        admin = new Button("Admin");
        back = new Button("Go Back");
        add(citizen);
        add(nCitizen);
        add(admin);
        add(back);

        citizen.addActionListener(this);
        nCitizen.addActionListener(this);
        admin.addActionListener(this);
        back.addActionListener(this);

        setVisible(true);
    }
}
