package com.covid19_vaccine_registration_system;

import javax.swing.*;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class Page4c_CitizenAppointment extends JFrame implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == makeApp){
            setVisible(false);
            MakeApp();
        }else if(e.getSource() == viewApp){
            setVisible(false);
            ViewApp();
        }else if(e.getSource() == compApp){
            setVisible(false);
            CompApp();
        }else if(e.getSource() == cancelApp){
            setVisible(false);
            CancelApp();
        }else if(e.getSource() == back){
            setVisible(false);
            Main.fourthA.setVisible(true);
        }
    }

    private JButton makeApp,viewApp,compApp,cancelApp,back;

    public Page4c_CitizenAppointment(){
        setTitle("Appointment Menu");
        setSize(350,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,3));

        makeApp = new JButton("Make Appointment");
        viewApp = new JButton("View Appointment");
        compApp = new JButton("Complete Appointment");
        cancelApp = new JButton("Cancel Appointment");
        back = new JButton("Go Back");

        add(makeApp);
        add(viewApp);
        add(compApp);
        add(cancelApp);
        add(back);

        makeApp.addActionListener(this);
        viewApp.addActionListener(this);
        compApp.addActionListener(this);
        cancelApp.addActionListener(this);
        back.addActionListener(this);

       /* setVisible(true);*/
    }

    private void MakeApp(){
        int s = Main.clogin.getMyAppointment().size();
        if(s == 0) {
            Centre[] centres = {Centre.CentreA, Centre.CentreB, Centre.CentreC};
            Centre cen = (Centre) JOptionPane.showInputDialog(makeApp, "Select Centre: ", "Centre Selection",
                    JOptionPane.DEFAULT_OPTION, null, centres, centres[0]);

            ArrayList<String> vaclist = new ArrayList<String>();
            DefaultListModel<String> vacname = new DefaultListModel<String>();

            JList jl = new JList(vacname);
            jl.setEnabled(false);
            Font font = new Font("Courier", Font.BOLD, 14);
            jl.setFont(font);

            boolean flag = true;
            for (int i = 0; i < DataIO.allVaccine.size(); i++) {
                Vaccine vac = DataIO.allVaccine.get(i);
                if (vac.getCentre().equals(cen)) {
                    vaclist.add(String.valueOf(vac.getName()));
                    vacname.addElement(vaclist.get(i));
                } else {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                JFrame x = new JFrame();
                x.setTitle(String.valueOf(cen));
                x.setSize(500, 300);
                x.setLocationRelativeTo(null);
                x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                x.setLayout(new GridLayout(4, 1));

                Panel y1 = new Panel();
                JLabel y1lab = new JLabel("Vaccine Available: ");
                y1.setLayout(new FlowLayout());
                y1.add(y1lab);
                y1.add(jl);

                Panel y2 = new Panel();
                y2.setLayout(new BoxLayout(y2, BoxLayout.Y_AXIS));
                int size = DataIO.allAppointment.size();

                Panel y3 = new Panel();
                y3.setLayout(new FlowLayout());

                Panel y4 = new Panel();
                y4.setLayout(new FlowLayout());

                ArrayList<Integer> idlist = new ArrayList<Integer>();
                JComboBox<Integer> idBox = new JComboBox<Integer>();

                String[] columnNames = {"ID", "Centre", "Day", "Time"};
                String[][] data = new String[size][4];
                for (int j = 0; j < size; j++) {
                    Appointment a = DataIO.allAppointment.get(j);
                    if (a.getCentre().equals(cen)) {
                        data[j][0] = Integer.toString(a.getId());
                        data[j][1] = "" + a.getCentre();
                        data[j][2] = "" + a.getDay();
                        data[j][3] = "" + a.getTime();
                        idlist.add(Integer.parseInt(String.valueOf(a.getId())));
                        idBox.addItem(Integer.parseInt(String.valueOf(a.getId())));
                    }
                }
                DefaultTableModel z = new DefaultTableModel(data, columnNames);
                JTable z1 = new JTable(z);
                z1.setEnabled(false);  //Disable Table Editing
                z1.setRowSelectionAllowed(true);
                z1.setColumnSelectionAllowed(false);
                JScrollPane sp = new JScrollPane(z1);
                y2.add(sp);

                JLabel idlab = new JLabel("Select Appointment ID: ");
                y3.add(idlab);
                y3.add(idBox);

                Button ok = new Button("Ok");
                Button cancel = new Button("Cancel");
                ok.setPreferredSize(new Dimension(25, 25));
                cancel.setPreferredSize(new Dimension(45, 30));
                y4.add(ok);
                y4.add(cancel);

                ok.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        /*String vacSelect = (String) comboBox.getSelectedItem();*/
                        Integer idSelect = (Integer) idBox.getSelectedItem();
                        boolean add = true;
                        for (int k = 0; k < size; k++) {
                            Appointment apps = DataIO.allAppointment.get(k);
                            if (idSelect == apps.getId()) {
                                apps.getParticipants().add(new People(Main.clogin.getUsername(), Main.clogin.getPassword(),
                                        Main.clogin.getGender(), Main.clogin.getAge(), Main.clogin.getIsVaccinated()));
                                Appointment g = new Appointment(apps.getId(), apps.getCentre(), apps.getDay(), apps.getTime());
                                Main.clogin.getMyAppointment().add(g);
                                break;
                            }
                        }

                        JOptionPane.showMessageDialog(makeApp,"Appointment has been made!");
                        x.setVisible(false);
                        Main.fourthC.setVisible(true);
                    }
                });

                cancel.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        x.setVisible(false);
                        Main.fourthC.setVisible(true);
                    }
                });

                x.add(y1);
                x.add(y2);
                x.add(y3);
                x.add(y4);
                x.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(makeApp, "This centre has no vaccine available");
                Main.fourthC.setVisible(true);
            }
        }else{
            JOptionPane.showMessageDialog(makeApp, "You have an unattended appointment");
            Main.fourthC.setVisible(true);

        }
    }

    private void ViewApp(){
        int s = Main.clogin.getMyAppointment().size();
        if(s == 0) {
            JOptionPane.showMessageDialog(viewApp,"You do not have any appointment");
            setVisible(false);
            Main.fourthC.setVisible(true);
        }else{
            JTextField id = new JTextField(Integer.toString(Main.clogin.getMyAppointment().get(0).getId()), 5);
            JTextField centre = new JTextField(Main.clogin.getMyAppointment().get(0).getCentre().toString());
            JTextField day = new JTextField(Main.clogin.getMyAppointment().get(0).getDay().toString());
            JTextField time = new JTextField(Integer.toString(Main.clogin.getMyAppointment().get(0).getTime()));

            Object[] message = {
                    "Appointment ID: ", id,
                    "Vaccination Centre : ", centre,
                    "Day : ", day,
                    "Time (Hour) : ", time,
            };
            id.setEditable(false);
            centre.setEditable(false);
            day.setEditable(false);
            time.setEditable(false);

            int option = JOptionPane.showConfirmDialog(null, message, "View Appointment", JOptionPane.DEFAULT_OPTION);
            setVisible(false);
            Main.fourthC.setVisible(true);
        }
    }

    private void CompApp(){
        int s = Main.clogin.getMyAppointment().size();
        if (s == 0) {
            JOptionPane.showMessageDialog(compApp, "You do not have any appointment");
            setVisible(false);
            Main.fourthC.setVisible(true);
        }else{
            int vacNum = Main.clogin.getIsVaccinated() + 1;
            System.out.println(vacNum);
            Main.clogin.setIsVaccinated(vacNum);
            DataIO.write();

            Main.clogin.getMyAppointment().remove(0);
            JOptionPane.showMessageDialog(compApp, "Your Appointment have been Complete!\nCongrats on your no "+ vacNum +"vaccination");

            setVisible(false);
            Main.fourthC.setVisible(true);
        }
    }

    private void CancelApp(){
        int s = Main.clogin.getMyAppointment().size();
        if (s == 0) {
            JOptionPane.showMessageDialog(compApp, "You do not have any appointment");
            setVisible(false);
            Main.fourthC.setVisible(true);
        }else{
            Main.clogin.getMyAppointment().remove(0);
            JOptionPane.showMessageDialog(compApp, "Your Appointment have been Canceled!");

            setVisible(false);
            Main.fourthC.setVisible(true);
        }
    }
}
