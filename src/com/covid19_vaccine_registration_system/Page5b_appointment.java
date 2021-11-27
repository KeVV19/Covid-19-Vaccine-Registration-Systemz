package com.covid19_vaccine_registration_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Page5b_appointment extends JFrame implements ActionListener {
    public static ArrayList<Citizen> allCitizen = new ArrayList<Citizen>();

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            setVisible(false);
            Add();
        }else if (e.getSource() == remove){
            setVisible(false);

        } else if (e.getSource() == modify) {
            setVisible(false);

        } else if (e.getSource() == view) {
            setVisible(false);

        } else if (e.getSource() == search) {
            setVisible(false);

        } else if (e.getSource() == back) {
            setVisible(false);
            Main.fifth.setVisible(true);
        }
    }

    private Button add, remove, modify, view, search, back;

    public Page5b_appointment() {
        setTitle("Manage Vaccination Appointment");
        setSize(350, 400);
        setLocation(700, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 5, 5)); //top-bottom, center alignment

        add = new Button("Register Appointment");
        remove = new Button("Remove Appointment");
        modify = new Button("Modify Appointment");
        view = new Button("View Appointment");
        search = new Button("Search Appointment");
        back = new Button("Go Back");

        add(add);
        add(remove);
        add(modify);
        add(view);
        add(search);
        add(back);

        add.addActionListener(this);
        remove.addActionListener(this);
        modify.addActionListener(this);
        view.addActionListener(this);
        search.addActionListener(this);
        back.addActionListener(this);
        /*setVisible(true);*/
    }

    private void /*NotDone*/Add(){
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

    }
}
