package com.covid19_vaccine_registration_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Page5c_supply extends JFrame implements ActionListener{
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add){
            setVisible(false);
            Add();
        }else if(e.getSource() == delete){
            setVisible(false);
            Remove();
        }else if(e.getSource() == edit){
            setVisible(false);
            Edit();
        }else if(e.getSource() == view){
            setVisible(false);
            View();
        }else if(e.getSource() == view){
            setVisible(false);
            Search();
        }else if(e.getSource() == back){
            setVisible(false);
            Main.fifth.setVisible(true);
        }
    }
    private Button add, delete, edit, view, search, back;

    public Page5c_supply(){
        setTitle("Manage Vaccine");
        setSize(350, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 5, 5)); //top-bottom, center alignment

        add = new Button("Add Vaccine");
        delete = new Button("Delete Vaccine");
        edit = new Button("Edit Vaccine Details");
        view = new Button("View Vaccines");
        search = new Button("Search Vaccines");
        back = new Button("Go Back");

        add(add);
        add(delete);
        add(edit);
        add(view);
        add(search);
        add(back);

        add.addActionListener(this);
        delete.addActionListener(this);
        edit.addActionListener(this);
        view.addActionListener(this);
        search.addActionListener(this);
        back.addActionListener(this);
        /*setVisible(true);*/
    }

    private void Add(){
        try{
            JTextField id = new JTextField(5);
            JTextField name = new JTextField(16);
            JTextField qty = new JTextField(5);
            JTextField dose = new JTextField(5);
            JTextField centre = new JTextField(16);

            Object[] message = {
                    "Vaccine ID: ", id,
                    "Vaccine Name: ", name,
                    "Vaccine Quantity (in Mil): ", qty,
                    "Vaccine Dose: ", dose,
                    "Vaccination Centre: ", centre,
            };
            int option = JOptionPane.showConfirmDialog(null, message, "Add Appointment", JOptionPane.OK_CANCEL_OPTION);

            int idInp = Integer.parseInt(id.getText());
            String nmInp = name.getText();
            int qntInp = Integer.parseInt(qty.getText());
            int doseInp = Integer.parseInt(dose.getText());
            Centre cntInp = Centre.valueOf(centre.getText());

            Vaccine found = DataIO.checkingvac(idInp);
            if(found == null){
                Vaccine a = new Vaccine(idInp, nmInp, qntInp, doseInp, cntInp);
                DataIO.allVaccine.add(a);
                DataIO.write();
                JOptionPane.showMessageDialog(null, "Record Successfully Saved");
                setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null,"The Vaccine ID has been used!");
                setVisible(true);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Unsuitable Input Detected, Please Try Again");
            setVisible(true);
        }
    }
    private void Remove(){

    }
    private void Edit(){

    }
    private void View(){

    }
    private void Search(){

    }

}
