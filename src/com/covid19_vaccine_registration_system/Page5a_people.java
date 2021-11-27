package com.covid19_vaccine_registration_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class Page5a_people extends JFrame implements ActionListener {
    public static ArrayList<Citizen> allCitizen = new ArrayList<Citizen>();

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == register){
            setVisible(false);
            Register();
        }else if(e.getSource() == modify){
            setVisible(false);
            Modify();
        }else if(e.getSource() == view){
            setVisible(false);
            View();
        }else if(e.getSource() == search){
            setVisible(false);
            Search();
        }else if(e.getSource() == back){
            setVisible(false);
            Main.fifth.setVisible(true);
        }
    }
    private Button register, modify, view, search, back;

    public Page5a_people(){
        setTitle("Manage Citizens/Non-Citizens");
        setSize(350, 400);
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
        setVisible(true);
    }

    private void Register(){
        JFrame f = new JFrame("Select an account: ");
        JPanel panel=new JPanel();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton citizenReg = new JButton("Citizen");
        JButton nCitizenReg = new JButton("Non-Citizen");
        JButton back = new JButton("Go Back");
        panel.setLayout(new FlowLayout());
        panel.add(citizenReg);
        panel.add(nCitizenReg);
        panel.add(back);
        f.add(panel);
        f.setSize(400,100);
        f.setLocation(636, 200);
        f.setVisible(true);

        citizenReg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

                int option = JOptionPane.showConfirmDialog(null, message, "Citizen Register", JOptionPane.OK_CANCEL_OPTION);
                String nmInput = username.getText();
                String psInput = password.getText();
                Gender gdInput = Gender.valueOf(gender.getText());
                int ageInput = Integer.parseInt(age.getText());
                int citIdInp = Integer.parseInt(citID.getText());

                Citizen found = DataIO.checking(nmInput);
                if(found == null){
                    Citizen c = new Citizen(nmInput,psInput,gdInput,ageInput,0, citIdInp);
                    DataIO.allCitizen.add(c);
                    DataIO.write();
                    JOptionPane.showMessageDialog(null, "Record Successfully Saved");
                }else{
                    JOptionPane.showMessageDialog(null,"The username has been used!");
                }
            }
        });
        nCitizenReg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField username = new JTextField(16);
                JTextField password = new JPasswordField(16);
                JTextField gender = new JTextField(5);
                JTextField age = new JTextField(5);
                JTextField passportNum = new JTextField(16);

                Object[] message = {
                        "Username: ", username,
                        "Password: ", password,
                        "Gender : ", gender,
                        "Age : ", age,
                        "Passport ID : ", passportNum
                };

                int option = JOptionPane.showConfirmDialog(null, message, "NonCitizen Register", JOptionPane.OK_CANCEL_OPTION);
                String nmInput = username.getText();
                String psInput = password.getText();
                Gender gdInput = Gender.valueOf(gender.getText());
                int ageInput = Integer.parseInt(age.getText());
                int passportInput = Integer.parseInt(passportNum.getText());

                NonCitizen found = DataIO.checkingn(nmInput);
                if(found == null){
                    NonCitizen nc = new NonCitizen(nmInput,psInput,gdInput,ageInput,0, passportInput);
                    DataIO.allNonCitizen.add(nc);
                    DataIO.write();
                    JOptionPane.showMessageDialog(null, "Record Successfully Saved");
                }else{
                    JOptionPane.showMessageDialog(null,"The username has been used!");
                }
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                setVisible(true);
            }
        });
    }
    private void Modify() {
        JFrame f = new JFrame("Select an account: ");
        JPanel panel = new JPanel();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton citizenMod = new JButton("Citizen");
        JButton nCitizenMod = new JButton("Non-Citizen");
        JButton back = new JButton(("Go Back"));
        panel.setLayout(new FlowLayout());
        panel.add(citizenMod);
        panel.add(nCitizenMod);
        panel.add(back);
        f.add(panel);
        f.setSize(400, 100);
        f.setLocation(636, 200);
        f.setVisible(true);

        citizenMod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Citizen found = null;
                try {
                    String usrInput = JOptionPane.showInputDialog(citizenMod, "Enter Citizen Username: ");
                    if (usrInput != null) {
                        found = DataIO.checking(usrInput);
                        Main.clogin = found;
                    }
                }catch (Exception a){
                    JOptionPane.showMessageDialog(citizenMod, "Please Try Again");
                }

                JTextField username = new JTextField(Main.clogin.getUsername(),16);
                JTextField password = new JTextField(Main.clogin.getPassword(),16);
                JTextField gender = new JTextField(String.valueOf(Main.clogin.getGender()),5);
                JTextField age = new JTextField(Integer.toString(Main.clogin.getAge()),5);
                JTextField vaccine = new JTextField(Integer.toString(Main.clogin.getIsVaccinated()), 5);
                JTextField citID = new JTextField(Integer.toString(Main.clogin.getCitizenID()),16);

                username.setEditable(false);

                Object[] message = {
                        "Username: ", username,
                        "Password: ", password,
                        "Gender : ", gender,
                        "Age : ", age,
                        "Vaccines Received : ", vaccine,
                        "Citizen ID : ", citID
                };

                int option = JOptionPane.showConfirmDialog(null, message, "Profile Update", JOptionPane.OK_CANCEL_OPTION);
                String nmInput = username.getText();
                String psInput = password.getText();
                Gender gdInput = Gender.valueOf(gender.getText());
                int ageInput = Integer.parseInt(age.getText());
                int vacInput = Integer.parseInt(vaccine.getText());
                int citIDInput = Integer.parseInt(citID.getText());

                if(option == JOptionPane.OK_OPTION && found != null){
                    Main.clogin.setUsername(nmInput);
                    Main.clogin.setPassword(psInput);
                    Main.clogin.setGender(gdInput);
                    Main.clogin.setAge(ageInput);
                    Main.clogin.setIsVaccinated(vacInput);
                    Main.clogin.setCitizenID(citIDInput);
                    DataIO.write();
                    JOptionPane.showMessageDialog(null, "Record Updated");
                }else{
                    JOptionPane.showMessageDialog(null, "Record Not Updated");

                }
            }
        });
        nCitizenMod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NonCitizen found = null;
                try {
                    String usrInput = JOptionPane.showInputDialog(citizenMod, "Enter Non-Citizen Username: ");
                    if (usrInput != null) {
                        found = DataIO.checkingn(usrInput);
                        Main.nclogin = found;
                    }
                }catch (Exception a){
                    JOptionPane.showMessageDialog(citizenMod, "Please Try Again");
                }
                JTextField username = new JTextField(Main.nclogin.getUsername(),16);
                JTextField password = new JTextField(Main.nclogin.getPassword(),16);
                JTextField gender = new JTextField(String.valueOf(Main.nclogin.getGender()),5);
                JTextField age = new JTextField(Integer.toString(Main.nclogin.getAge()),5);
                JTextField vaccine = new JTextField(Integer.toString(Main.clogin.getIsVaccinated()), 5);
                JTextField passportNum = new JTextField(Integer.toString(Main.nclogin.getPassportNum()),16);

                username.setEditable(false);

                Object[] message = {
                        "Username: ", username,
                        "Password: ", password,
                        "Gender : ", gender,
                        "Age : ", age,
                        "Vaccines Received : ", vaccine,
                        "Passport ID : ", passportNum,
                };

                int option = JOptionPane.showConfirmDialog(null, message, "Profile Update", JOptionPane.OK_CANCEL_OPTION);
                String nmInput = username.getText();
                String psInput = password.getText();
                Gender gdInput = Gender.valueOf(gender.getText());
                int ageInput = Integer.parseInt(age.getText());
                int vacInput = Integer.parseInt(vaccine.getText());
                int passportInput = Integer.parseInt(passportNum.getText());

                if(option == JOptionPane.OK_OPTION && found != null){
                    Main.nclogin.setUsername(nmInput);
                    Main.nclogin.setPassword(psInput);
                    Main.nclogin.setGender(gdInput);
                    Main.nclogin.setAge(ageInput);
                    Main.nclogin.setIsVaccinated(vacInput);
                    Main.nclogin.setPassportNum(passportInput);
                    DataIO.write();
                    JOptionPane.showMessageDialog(null, "Record Updated");
                }else{
                    JOptionPane.showMessageDialog(null, "Record Not Updated");

                }
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                setVisible(true);
            }
        });
    }
    private void /*NotDone*/View() {
        JFrame f = new JFrame("Select an account: ");
        JPanel panel = new JPanel();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton citizenView = new JButton("Citizen");
        JButton nCitizenView = new JButton("Non-Citizen");
        JButton back = new JButton(("Go Back"));
        panel.setLayout(new FlowLayout());
        panel.add(citizenView);
        panel.add(nCitizenView);
        panel.add(back);
        f.add(panel);
        f.setSize(400, 100);
        f.setLocation(636, 200);
        f.setVisible(true);

        citizenView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, allCitizen);

                for(Citizen c : allCitizen){
                    String username = c.getUsername();
                    String password = c.getPassword();
                    Gender gender = c.getGender();
                    int age = c.getAge();
                    int citID = c.getCitizenID();

                    Object[] message = {
                            "Username: ", username,
                            "Password: ", password,
                            "Gender : ", gender,
                            "Age : ", age,
                            "Citizen ID : ", citID
                    };
                    JOptionPane.showMessageDialog(citizenView, message);
                }
            }
        });
    }
    private void Search() {
        JFrame f = new JFrame("Select an account: ");
        JPanel panel = new JPanel();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton citizenSearch = new JButton("Citizen");
        JButton nCitizenSearch = new JButton("Non-Citizen");
        JButton back = new JButton(("Go Back"));
        panel.setLayout(new FlowLayout());
        panel.add(citizenSearch);
        panel.add(nCitizenSearch);
        panel.add(back);
        f.add(panel);
        f.setSize(400, 100);
        f.setLocation(636, 200);
        f.setVisible(true);

        citizenSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Citizen found = null;
                try {
                    String usrInput = JOptionPane.showInputDialog(citizenSearch, "Enter Citizen Username: ");
                    if (usrInput != null) {
                        found = DataIO.checking(usrInput);
                        Main.clogin = found;
                    }
                }catch (Exception a){
                    JOptionPane.showMessageDialog(citizenSearch, "Please Try Again");
                }

                JTextField username = new JTextField(Main.clogin.getUsername(),16);
                JTextField password = new JTextField(Main.clogin.getPassword(),16);
                JTextField gender = new JTextField(String.valueOf(Main.clogin.getGender()),5);
                JTextField age = new JTextField(Integer.toString(Main.clogin.getAge()),5);
                JTextField vaccine = new JTextField(Integer.toString(Main.clogin.getIsVaccinated()), 5);
                JTextField citID = new JTextField(Integer.toString(Main.clogin.getCitizenID()),16);

                Object[] message = {
                        "Username: ", username,
                        "Password: ", password,
                        "Gender : ", gender,
                        "Age : ", age,
                        "Vaccines Received : ", vaccine,
                        "Citizen ID : ", citID
                };
                username.setEditable(false);
                password.setEditable(false);
                gender.setEditable(false);
                age.setEditable(false);
                vaccine.setEditable(false);
                citID.setEditable(false);
                JOptionPane.showMessageDialog(citizenSearch, message);
            }
        });
        nCitizenSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NonCitizen found = null;
                try {
                    String usrInput = JOptionPane.showInputDialog(nCitizenSearch, "Enter Non-Citizen Username: ");
                    if (usrInput != null) {
                        found = DataIO.checkingn(usrInput);
                        Main.nclogin = found;
                    }
                }catch (Exception a){
                    JOptionPane.showMessageDialog(nCitizenSearch, "Please Try Again");
                }

                JTextField username = new JTextField(Main.nclogin.getUsername(),16);
                JTextField password = new JTextField(Main.nclogin.getPassword(),16);
                JTextField gender = new JTextField(String.valueOf(Main.nclogin.getGender()),5);
                JTextField age = new JTextField(Integer.toString(Main.nclogin.getAge()),5);
                JTextField passportNum = new JTextField(Integer.toString(Main.nclogin.getPassportNum()),16);

                Object[] message = {
                        "Username: ", username,
                        "Password: ", password,
                        "Gender : ", gender,
                        "Age : ", age,
                        "Passport ID : ", passportNum,
                };
                username.setEditable(false);
                password.setEditable(false);
                gender.setEditable(false);
                age.setEditable(false);
                passportNum.setEditable(false);
                JOptionPane.showMessageDialog(citizenSearch, message);
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                setVisible(true);
            }
        });
    }
}