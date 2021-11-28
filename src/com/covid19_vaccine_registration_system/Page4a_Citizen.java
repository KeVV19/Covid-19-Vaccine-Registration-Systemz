package com.covid19_vaccine_registration_system;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;

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
                    "Gender:", gender,
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
                setVisible(false);
                Main.fourthA.setVisible(true);
            }

        }else if(e.getSource() == appointment){
            setVisible(false);
            manageAppointment();

        }else if(e.getSource() == status){
            int size = Main.clogin.getMyAppointment().size();
            int vacNum = Main.clogin.getIsVaccinated();
            if(vacNum == 0){
                JOptionPane.showMessageDialog(status, "You haven't been vaccinated!\nPlease complete an appointment first!");
            }
            else if(vacNum == 1){
                Centre cen = Main.clogin.getMyAppointment().get(size).getCentre();
                System.out.println(cen);
            }else if(vacNum == 2){

            }
        }
    }
    private Button profile, appointment, status, logout;
    private JRadioButton male, female;

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

    private void manageAppointment(){
        JFrame f = new JFrame("Manage Appointment");
        JPanel panel = new JPanel();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton makeApp = new JButton("Make Appointment");
        JButton viewApp = new JButton("View Appointment");
        JButton signApp = new JButton("Sign Appointment");
        JButton cancelApp = new JButton("Cancel Appointment");
        JButton back = new JButton("Go Back");
        panel.add(makeApp);
        panel.add(viewApp);
        panel.add(signApp);
        panel.add(cancelApp);
        panel.add(back);
        f.add(panel);
        f.setSize(400,110);
        f.setLocation(636,200);
        f.setVisible(true);

        makeApp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int size = Main.clogin.getMyAppointment().size();
                if (size == 0){
                    try {
                        Centre[] centres = {Centre.CentreA,Centre.CentreB,Centre.CentreC};
                        Centre a = (Centre) JOptionPane.showInputDialog(makeApp, "Select Centre: ", "Centre Selection",
                                JOptionPane.OK_CANCEL_OPTION, null, centres, centres[0]);

                        int op = JOptionPane.showConfirmDialog(makeApp, a, "Select Centre", JOptionPane.OK_CANCEL_OPTION);

                        if(op == JOptionPane.OK_OPTION){
                            ArrayList<String> vaclist= new ArrayList<String>();
                            JComboBox<String> comboBox = new JComboBox<String>();
                            boolean flag = true;
                            for(int i = 0; i < DataIO.allVaccine.size(); i++){
                                Vaccine vac = DataIO.allVaccine.get(i);
                                if(vac.getCentre().contains(a)) {
                                    vaclist.add(vac.getName());
                                    comboBox.addItem(vaclist.get(i));
                                }else{
                                    flag = false;
                                    break;
                                }
                            }

                            if(flag == true){
                                int opt = JOptionPane.showConfirmDialog(makeApp, comboBox, "Select Vaccine", JOptionPane.OK_CANCEL_OPTION);

                                if(opt == JOptionPane.OK_OPTION) {
                                    String vacSelect = (String) comboBox.getSelectedItem();
                                    JOptionPane.showMessageDialog(makeApp, "Centre: " + a +"\nSelected vaccine: " + vacSelect);

                                    /*ArrayList<Integer> appId= new ArrayList<Integer>();

                                    JComboBox<Integer> comboBox1 = new JComboBox<Integer>();

                                    String[] subItems1 = {};
                                    ArrayList subItems1 = new ArrayList();
                                    JComboBox comboBox1 = new JComboBox();
                                    comboBox1.addActionListener(this);
                                    getContentPane().add(comboBox1, BorderLayout.WEST);


                                    Hashtable subItems = new Hashtable();
                                    JComboBox subComboBox = new JComboBox();
                                    subComboBox.setPrototypeDisplayValue("XXXXXXXXXX");
                                    getContentPane().add(subComboBox, BorderLayout.EAST);

                                    Integer[] subItems2 = {};
                                    ArrayList subItems2 = new ArrayList();
                                    for (int j = 0; j < DataIO.allAppointment.size(); j++) {
                                        Appointment app = DataIO.allAppointment.get(j);
                                        if(a.equals(app.getCentre())) {
                                            subItems1.add(app.getDay());
                                            subItems2.add(app.getTime());
                                        }
                                    }
                                    System.out.println(subItems1.get(0));
                                    System.out.println(subItems2.get(0));

                                    subItems.put(subItems1.get(0),subItems1);
                                    subItems.put(subItems2.get(1),subItems2);
                                    comboBox1.setSelectedIndex(0);

                                    Day subItem1 = (Day) comboBox1.getSelectedItem();
                                    Object o = subItems.get(subItem1);

                                    if(o == null){
                                        subComboBox.setModel(new DefaultComboBoxModel());
                                    }else{
                                        subComboBox.setModel(new DefaultComboBoxModel((Day[])o));
                                    }

                                    if(a.equals(app.getCentre())) {
                                        Object[] message = {
                                                "Day: ", app.getDay(),
                                                "Time: ", app.getTime(),
                                                "Click OK to confirm appointment"
                                        };
                                        int acc = JOptionPane.showConfirmDialog(makeApp, message,
                                                "Appointment Timetable", JOptionPane.OK_CANCEL_OPTION);
                                    }*/

                                }else {
                                    setVisible(false);
                                    f.setVisible(true);
                                }
                            }else{
                                JOptionPane.showMessageDialog(makeApp,"This centre don't have vaccine available..\nPlease try another centre!");
                            }
                        }else{
                            setVisible(false);
                            f.setVisible(true);
                        }

                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(makeApp, "Wrong input!");
                    }
                }else{
                    JOptionPane.showMessageDialog(makeApp,"You have an unattended appointment!");
                }
            }
        });

        viewApp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int size = Main.clogin.getMyAppointment().size();
                if(size ==0){
                    JOptionPane.showMessageDialog(viewApp,"You don't have an appointment!");
                }else{

                }
            }
        });

        cancelApp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int size = Main.clogin.getMyAppointment().size();

            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                Main.fourthA.setVisible(true);
            }
        });

    }
}
