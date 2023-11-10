package com.dignosticTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class main_Class extends JFrame implements ActionListener {
    JButton b1;
    String pin;

    JButton button1,button2,button3,button4;
    main_Class(String pin){
        this.pin = pin;



        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/test.png"));
        Image i2 = i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(600,10,150,150);
        add(image);


        button1 = new JButton("Change pin");
        button1.setFont(new Font("Arial", Font.BOLD, 14));
        button1.setForeground(Color.black);
        button1.setBackground(Color.WHITE);
        button1.setBounds(300,300,150, 50);
        button1.addActionListener(this);
        add(button1);




        button2 = new JButton("Uplode Prescription");
        button2.setFont(new Font("Arial", Font.BOLD, 14));
        button2.setForeground(Color.BLACK);
        button2.setBackground(Color.WHITE);
        button2.setBounds(900,300,150, 50);
        button2.addActionListener(this);
        add(button2);


        button3 = new JButton("Log out");
        button3.setFont(new Font("Arial", Font.BOLD, 14));
        button3.setForeground(Color.BLACK);
        button3.setBackground(Color.WHITE);
        button3.setBounds(300,500,150, 50);
        button3.addActionListener(this);
        add(button3);



        button4 = new JButton("Exit");
        button4.setFont(new Font("Arial", Font.BOLD, 14));
        button4.setForeground(Color.BLACK);
        button4.setBackground(Color.WHITE);
        button4.setBounds(900,500,150, 50);
        button4.addActionListener(this);
        add(button4);









        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icons/backmain.jpg"));
        Image ii2 = ii1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel l3 = new JLabel(ii3);
        l3.setBounds(0,0,1550,830);
        add(l3);












        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if (e.getSource()==button1){
                new Pin(pin);
                setVisible(false);
            }else if (e.getSource() == button2){
                new Prescription(pin);
                setVisible(false);


            }else if (e.getSource() == button3){
                new Login();
                setVisible(false);

            }else{
                System.exit(0);
            }
        }catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new main_Class("");
    }
}
