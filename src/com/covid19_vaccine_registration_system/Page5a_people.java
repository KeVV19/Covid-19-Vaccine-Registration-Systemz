package com.covid19_vaccine_registration_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Page5a_people extends JFrame implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == register){
           Register();
        }
    }
    private Button register, modify, view, search, back;

    public Page5a_people(){
        setTitle("Manage Citizens/Non-Citizens");
        setSize(300, 400);
        setLocation(700, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 5, 5)); //top-bottom, center alignment

        register = new Button("Register People");
        modify = new Button("Modify People");
        view = new Button("View People");
        search = new Button("Search People");
        back = new Button("Go Back");

        add(register);
        add(modify);
        add(view);
        add(search);
        add(back);

        register.addActionListener(this);
        modify.addActionListener(this);
        view.addActionListener(this);
        search.addActionListener(this);
        back.addActionListener(this);
        /*setVisible(true);*/
    }

    private void Register(){
        JFrame f = new JFrame("Select an account: ");
        JPanel panel=new JPanel();
        panel.setBounds(40,80,200,200);
        panel.setBackground(Color.gray);
        JButton b1=new JButton("Citizen");
        b1.setBounds(50,100,80,30);
        b1.setBackground(Color.yellow);
        JButton b2=new JButton("Non-Citizen");
        b2.setBounds(100,100,80,30);
        b2.setBackground(Color.green);
        panel.add(b1); panel.add(b2);
        f.add(panel);
        f.setSize(400,400);
        f.setLayout(new BorderLayout());
        f.setVisible(true);
    }
}
