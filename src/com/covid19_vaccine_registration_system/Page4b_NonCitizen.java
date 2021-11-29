package com.covid19_vaccine_registration_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Page4b_NonCitizen extends JFrame implements ActionListener {
    public void actionPerformed(ActionEvent e){

    }
    private Button login, register, exit;

    public Page4b_NonCitizen(){
        setSize(250, 100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout()); //top-bottom, center alignment

        register = new Button("Register");
        login = new Button("Login");
        exit = new Button("Exit");
        add(register);
        add(login);
        add(exit);

        register.addActionListener(this);
        login.addActionListener(this);
        exit.addActionListener(this);

        /*setVisible(true);*/
    }
}
