package com.covid19_vaccine_registration_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//TEST GUI :)
public class Login extends JFrame{
    private JPasswordField passwordField;
    private JTextField usernameField;
    private JButton loginButton;
    private JPanel mainPanel;
    private JFrame frame;

    public Login() {
        frame = new JFrame("Covid-19 Vaccination Registration");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(250,200));
        frame.setResizable(true);

        frame.add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = passwordField.getText();
                if(username.equals("Macel") && password.equals("Celma")){
                    JOptionPane.showMessageDialog(null,"Login Successful 6969");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Login Failed Mampus");
                }
            }
        });
    }
}
