package com.covid19_vaccine_registration_system;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
                JOptionPane.showMessageDialog(profile, "Record Not Updated");

            }

        }else if(e.getSource() == appointment){
            int size = Main.clogin.getMyAppointment().size();
            if(size == 0 || Main.clogin.getMyAppointment().get(size-1).isVaccinated()){
                try{
                    Centre[] centres = {Centre.CentreA,Centre.CentreB,Centre.CentreC,Centre.CentreD,Centre.CentreE,Centre.CentreF};
                    Centre a = (Centre) JOptionPane.showInputDialog(appointment,"Select Centre: ","Centre Selection",JOptionPane.QUESTION_MESSAGE,null,centres,centres[0]);
                    Day[] days = {Day.Monday,Day.Tuesday,Day.Wednesday,Day.Thursday,Day.Friday,Day.Saturday,Day.Sunday};
                    Day b = (Day) JOptionPane.showInputDialog(appointment,"Select day","Day Selection",JOptionPane.QUESTION_MESSAGE,null,days,days[0]);
                    int c = Integer.parseInt(JOptionPane.showInputDialog("Time"));
                    if(c<9 || c>16){
                        throw new Exception();
                    }

                    boolean flag = true;
                    for(int i=0; i<DataIO.allAppointment.size(); i++){
                        Appointment j = DataIO.allAppointment.get(i);
                        if(a.equals(j.getCentre())&&b.equals(j.getDay())&&c==j.getTime()){
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        int id = 1 + DataIO.allAppointment.size();
                        JOptionPane.showMessageDialog(appointment,"Your Appointment ID: "+id);
                        Appointment x = new Appointment(id,a,b,c,false,Main.clogin);
                        DataIO.allAppointment.add(x);
                        DataIO.write();
                    }
                    else{
                        JOptionPane.showMessageDialog(appointment,"Not Available");
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(appointment,"Wrong input!");
                }
            }else{
                JOptionPane.showMessageDialog(appointment, "You have an unattended appointment!");
            }
        }else if(e.getSource() == status){

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
