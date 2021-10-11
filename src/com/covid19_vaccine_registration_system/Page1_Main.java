package com.covid19_vaccine_registration_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Page1_Main extends JFrame implements ActionListener {

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == exit){
            System.exit(0);
        } else if (e.getSource() == login) {
            new Page3_Login();
        } else if (e.getSource() == register) {
            setVisible(false);
            new Page2_Register();
        }
    }

    private Button login, register, exit;

    public Page1_Main(){
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
