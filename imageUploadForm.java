package com.dignosticTest;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class imageUploadForm extends JFrame implements ActionListener {
    private JTextField textField;
    private JLabel imageLabel;
    JButton b1,b2;
    String pin;
    Random ran = new Random();
    long first4 =(ran.nextLong() % 9000L) +1000L;
    String first = " " + Math.abs(first4);

    public imageUploadForm(String pin) {
        this.pin = pin;







        setTitle("Image Upload Form");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new FlowLayout());
        textField = new JTextField(20);
        b1 = new JButton("Submit");
        b1.setBounds(500,200,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBounds(500,300,150,35);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

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


    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = first;
        try{
            String Data=textField .getText();
            if (e.getSource()==b1){
                if (textField .getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Fill all the fields");
                }else {
                        Connn c = new Connn();
                        String q1 ="insert into upload values('"+Data+"','"+formno+"')";
                        c.statement.executeUpdate(q1);
                        
                        new main_Class(pin);
                        setVisible(false);

                }

            }else if (e.getSource()==b2) {
                textField.setText("");
            }

        }catch (Exception E){
            E.printStackTrace();
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new imageUploadForm("").setVisible(true);
            }
        });
    }
}
