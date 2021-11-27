package com.covid19_vaccine_registration_system;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Page1_Main extends JFrame implements ActionListener {

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == exit){
            System.exit(0);
        } else if (e.getSource() == login) {
            setVisible(false);
            Main.third.setVisible(true);
        } else if (e.getSource() == register) {
            setVisible(false);
            Main.second.setVisible(true);
        }
    }

    private Button login, register, exit;
    Label l;

    public Page1_Main(){
        setTitle("Main Menu");
        setSize(250, 100);
        setLocation(700, 200);
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

        setVisible(true);
    }
}