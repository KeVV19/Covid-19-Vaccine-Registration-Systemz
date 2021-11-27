package com.covid19_vaccine_registration_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Page4a_Citizen extends JFrame implements ActionListener {
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == logout){
            Main.clogin = null;
            setVisible(false);
            Main.first.setVisible(true);

        }else if(e.getSource() == profile){
            JTextField username = new JTextField(Main.clogin.getUsername(),16);
            JTextField password = new JTextField(Main.clogin.getPassword(),16);
            JTextField gender = new JTextField(String.valueOf(Main.clogin.getGender()),5);
            JTextField age = new JTextField(Integer.toString(Main.clogin.getAge()),5);
            JTextField citID = new JTextField(Integer.toString(Main.clogin.getCitizenID()),16);

            username.setEditable(false);

            Object[] message = {
                    "Username: ", username,
                    "Password: ", password,
                    "Gender : ", gender,
                    "Age : ", age,
                    "Citizen ID : ", citID
            };

            int option = JOptionPane.showConfirmDialog(profile, message, "Profile Update", JOptionPane.OK_CANCEL_OPTION);
            String nmInput = username.getText();
            String psInput = password.getText();
            Gender gdInput = Gender.valueOf(gender.getText());
            int ageInput = Integer.parseInt(age.getText());
            int citIDInput = Integer.parseInt(citID.getText());

            Citizen found = DataIO.checking(nmInput);
            if(option == JOptionPane.OK_OPTION && found != null){
                Main.clogin.setUsername(nmInput);
                Main.clogin.setPassword(psInput);
                Main.clogin.setGender(gdInput);
                Main.clogin.setAge(ageInput);
                Main.clogin.setCitizenID(citIDInput);
                DataIO.write();
                JOptionPane.showMessageDialog(profile, "Record Updated");
            }else{
                JOptionPane.showMessageDialog(profile, "Cancelled");

            }

        }else if(e.getSource() == appointment){
            int size = Main.clogin.getMyAppointment().size();
            
        }else if(e.getSource() == status){
            int vacNum = Main.clogin.getIsVaccinated();
            if(vacNum == 0){
                JOptionPane.showMessageDialog(appointment, "You haven't been vaccinated!\nPlease make an appointment first!");
            }
            else if(vacNum == 1){

            }else {

            }
        }
    }
    private Button profile, appointment, status, logout;

    public Page4a_Citizen(){
        setSize(250, 100);
        setLocation(700, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout()); //top-bottom, center alignment

        profile = new Button("Profile");
        appointment = new Button("Vaccination Appointment");
        status = new Button("Vaccination Status");
        logout = new Button("Logout");

        add(profile);
        add(status);
        add(appointment);
        add(logout);

        profile.addActionListener(this);
        status.addActionListener(this);
        appointment.addActionListener(this);
        logout.addActionListener(this);

        /*setVisible(true);*/
    }
}
