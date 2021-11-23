package com.covid19_vaccine_registration_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Page5a_people extends JFrame implements ActionListener {
    public void actionPerformed(ActionEvent e) {

    }
    private Button citizen, nonCitizen, back;

    public Page5a_people(){
        setSize(250, 100);
        setLocation(700, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout()); //top-bottom, center alignment

        citizen = new Button("Citizen");
        nonCitizen = new Button("Non-Citizen");
        back = new Button("Go Back");
        add(citizen);
        add(nonCitizen);
        add(back);

        citizen.addActionListener(this);
        nonCitizen.addActionListener(this);
        back.addActionListener(this);
        /*setVisible(true);*/
    }
}
