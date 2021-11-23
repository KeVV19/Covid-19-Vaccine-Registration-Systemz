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
        }
    }

    private Button people, appointment, supply;

    public Page5_Admin(){
        setSize(250, 100);
        setLocation(700, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout()); //top-bottom, center alignment

        people = new Button("Manage People");
        appointment = new Button("Manage Appointments");
        supply = new Button("Manage Vaccination Supply");
        add(people);
        add(appointment);
        add(supply);

        people.addActionListener(this);
        appointment.addActionListener(this);
        supply.addActionListener(this);

        /*setVisible(true);*/
    }
}
