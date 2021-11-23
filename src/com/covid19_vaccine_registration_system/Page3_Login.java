package com.covid19_vaccine_registration_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Page3_Login extends JFrame implements ActionListener {
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == citizen){
            JTextField username = new JTextField(16);
            JTextField password = new JPasswordField(16);

            Object[] message = {
                    "Username: ", username,
                    "Password: ", password,
            };

            int option = JOptionPane.showConfirmDialog(null, message, "Citizen Register", JOptionPane.OK_CANCEL_OPTION);

            String usrInput = username.getText();
            String pwInput = password.getText();

            if (Objects.equals(usrInput, "name") && Objects.equals(pwInput, "password")){
                JOptionPane.showMessageDialog(null, "Works!");
            }

        } else if (e.getSource() == nCitizen) {

        } else if (e.getSource() == admin) {

        } else if (e.getSource() == back) {
            setVisible(false);
            new Page1_Main().setVisible(true);
        }
    }

    private Button citizen, nCitizen, admin, back;

    public Page3_Login(){
        setSize(400, 300);
        setLocation(700, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 4, 5, 5));

        citizen = new Button("Citizen");
        nCitizen = new Button("Non-Citizen");
        admin = new Button("Admin");
        back = new Button("Go Back");
        add(citizen);
        add(nCitizen);
        add(admin);
        add(back);

        citizen.addActionListener(this);
        nCitizen.addActionListener(this);
        admin.addActionListener(this);
        back.addActionListener(this);

        setVisible(true);
    }
}
