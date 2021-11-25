package com.covid19_vaccine_registration_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Page5_Admin extends JFrame implements ActionListener {
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == people){
            setVisible(false);
            Main.fifthA.setVisible(true);
        }else if(e.getSource() == appointment){
            setVisible(false);
            Main.fifthB.setVisible(true);
        }else if(e.getSource() == supply){
            setVisible(false);
            Main.fifthC.setVisible(true);
        }else if(e.getSource() == back){
            setVisible(false);
            Main.first.setVisible(true);
        }
    }

    private Button people, appointment, supply, back;

    public Page5_Admin(){
        setTitle("Admin Menu");
        setSize(400, 200);
        setLocation(700, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 5, 5, 5)); //top-bottom, center alignment

        people = new Button("Manage People");
        appointment = new Button("Manage Appointments");
        supply = new Button("Manage Vaccination Supply");
        back = new Button("Go Back");
        add(people);
        add(appointment);
        add(supply);
        add(back);

        people.addActionListener(this);
        appointment.addActionListener(this);
        supply.addActionListener(this);
        back.addActionListener(this);

        /*setVisible(true);*/
    }
}
