package com.dignosticTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Prescription extends JFrame implements ActionListener {



    String pin;
    JTextField textpName,textdname,textcname;

    JButton b1,b2,b3;
    JLabel label1;

    Random ran = new Random();

    long first4 =(ran.nextLong() % 9000L) +1000L;
    String first = " " + Math.abs(first4);




    Prescription(String pin){

        this.pin = pin;




        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icons/test.png"));
        Image ii2 = ii1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel image = new JLabel(ii3);
        image.setBounds(25,10,150,150);
        add(image);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/backmain.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        label1 = new JLabel("ORDER DETAILS");
        label1.setForeground(Color.black);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 35));
        label1.setBounds(450,125,450,40);
        l3.add(label1);


        JLabel label2 = new JLabel("Patient's Name : ");
        label2.setForeground(Color.black);
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(430,220,150,35);
        l3.add(label2);


        textpName = new JTextField();
        textpName.setFont(new Font("Raleway",Font.BOLD, 14));
        textpName.setBounds(600,220,250,25);
        add(textpName);

        JLabel label3 = new JLabel("Doctor's Name : ");
        label3.setForeground(Color.black);
        label3.setFont(new Font("System", Font.BOLD, 16));
        label3.setBounds(430,250,400,35);
        l3.add(label3);

        textdname = new JTextField();
        textdname.setFont(new Font("Raleway",Font.BOLD, 14));
        textdname.setBounds(600,255,250,25);
        add(textdname);









        b1 = new JButton("Submit");
        b1.setBounds(350,406,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);


        b2 = new JButton("Delete");
        b2.setBounds(750,406,150,35);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);



        b3 = new JButton("Back");
        b3.setBounds(550,406,150,35);
        b3.setBackground(new Color(65,125,128));
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        l3.add(b3);



        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);







    }


















    @Override
    public void actionPerformed(ActionEvent e) {


        try{
            //String Cardno =textcname.getText();
            String formno = first;
            String Patient = textpName.getText();
            String Doctor = textdname.getText();


            if (e.getSource()==b1){

                if (textpName.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Fill all the fields");
                }else {
                    Connn c2 = new Connn();
                    String q11 = "insert into patient values('"+formno+"','"+Patient+"','"+Doctor+"')";
                    c2.statement.executeUpdate(q11);
                    JOptionPane.showMessageDialog(null,"order successful");
                    new imageUploadForm(pin);
                    setVisible(false);


                }
            } else if (e.getSource()==b2) {
                textpName.setText("");
                textdname.setText("");
            }else if (e.getSource()==b3) {
                new main_Class(pin);
                setVisible(false);
            }



        }catch(Exception E){
            E.printStackTrace();

        }

    }


    public static void main(String[] args) {
        new Prescription("");



    }
}

/*and

public class ImageUploadForm extends JFrame {
    private JTextField textField;
    private JLabel imageLabel;

    public ImageUploadForm() {


        setTitle("Image Upload Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new FlowLayout());
        textField = new JTextField(20);
        JButton browseButton = new JButton("Browse");
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                browseButtonClicked();
            }
        });

        inputPanel.add(textField);
        inputPanel.add(browseButton);

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        add(inputPanel, BorderLayout.NORTH);
        add(imageLabel, BorderLayout.CENTER);
    }
    private void browseButtonClicked() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            String selectedImagePath = fileChooser.getSelectedFile().getAbsolutePath();
            textField.setText(selectedImagePath);

            ImageIcon imageIcon = new ImageIcon(selectedImagePath);
            Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(image);
            imageLabel.setIcon(imageIcon);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ImageUploadForm().setVisible(true);
            }
        });
    }
}*/
