import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import java.util.*;
public class EnigmaFrame extends JFrame{
    /*JComboBox : for selecting the rotor numbers
    JTextField : for selecting the start of the rotors
    JTextArea : for providing input to and output from Enigma
    JButton : for selecting encrypt or decrypt
    JLabel : for including other text references, such as “Inner” or “Middle”*/
    public EnigmaFrame(){
        this.setLayout(new GridLayout(4,0));
        this.setTitle("Enigma");
        this.setSize(700,700);
        this.setLocation(400,0);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("Encrypt");
        JButton button2 = new JButton("Decrypt");
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 250,10));
        JTextArea j = new JTextArea(2,10);
        Font font = new Font("Arial", Font.BOLD, 14);
        j.setFont(font);
        j.setBackground(Color.LIGHT_GRAY);
        j.setEditable(true);
        j.setText("type something here");
        JTextArea j2 = new JTextArea(2,10);
        j2.setText("Output: ");
        j2.setFont(font);
        j2.setBackground(Color.LIGHT_GRAY);
        j2.setEditable(false);
        String[] rotorchoices = {"1", "2", "3", "4", "5"};
        JComboBox<String> innerpicker = new JComboBox<>(rotorchoices);
        JComboBox<String> middlepicker = new JComboBox<>(rotorchoices);
        JComboBox<String> outerpicker = new JComboBox<>(rotorchoices);
        JTextArea startfield = new JTextArea("Put 3 letters here for start");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                String start = startfield.getText().toUpperCase();
                String selected = (String) innerpicker.getSelectedItem();
                int innerpicked = Integer.parseInt(selected);
                String selected2 = (String) middlepicker.getSelectedItem();
                int middlepicked = Integer.parseInt(selected2);
                String selected3 = (String) outerpicker.getSelectedItem();
                int outerpicked = Integer.parseInt(selected3);
                Enigma e = new Enigma(innerpicked, middlepicked, outerpicked, start);
                String message = j.getText().toUpperCase();
                String result = e.encrypt(message);
                j2.setText("Output: " + result);
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event2){
                String start = startfield.getText().toUpperCase();
                String selected = (String) innerpicker.getSelectedItem();
                int innerpicked = Integer.parseInt(selected);
                String selected2 = (String) middlepicker.getSelectedItem();
                int middlepicked = Integer.parseInt(selected2);
                String selected3 = (String) outerpicker.getSelectedItem();
                int outerpicked = Integer.parseInt(selected3);
                Enigma e = new Enigma(innerpicked, middlepicked, outerpicked, start);
                String message = j.getText().toUpperCase();
                String result = e.decrypt(message);
                j2.setText("Output: " + result);
            }
        });
        JLabel outer = new JLabel();
        outer.setText("outer: ");
        JLabel inner = new JLabel();
        inner.setText("inner: ");
        JLabel middle = new JLabel();
        middle.setText("middle: ");
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 10));
        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 120, 30));
        JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 10));
        JPanel panel5 = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 10));
        JTextArea innertext = new JTextArea();
        innertext.setText("choose inner: Default 1");
        JTextArea outertext = new JTextArea();
        outertext.setText("choose outer: Default 1");
        JTextArea middletext = new JTextArea();
        middletext.setText("choose middle: Default 1");
        innerpicker.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                String selected = (String) innerpicker.getSelectedItem();
                if (selected.equals("1")){
                    innertext.setText("#GNUAHOVBIPWCJQXDKRYELSZFMT");
                }else if (selected.equals("2")){
                    innertext.setText("EJOTYCHMRWAFKPUZDINSXBGLQV");
                }else if (selected.equals("3")){
                    innertext.setText("#BDFHJLNPRTVXZACEGIKMOQSUWY");
                }else if (selected.equals("4")){
                    innertext.setText("#NWDKHGXZVRIFJBLMAOPSCYUTQE");
                }else if (selected.equals("5")){
                    innertext.setText( "#TGOWHLIFMCSZYRVXQABUPEJKND");
                }
            }
        });
        middlepicker.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                String selected = (String) middlepicker.getSelectedItem();
                if (selected.equals("1")){
                    middletext.setText("#GNUAHOVBIPWCJQXDKRYELSZFMT");
                }else if (selected.equals("2")){
                    middletext.setText("EJOTYCHMRWAFKPUZDINSXBGLQV");
                }else if (selected.equals("3")){
                    middletext.setText("#BDFHJLNPRTVXZACEGIKMOQSUWY");
                }else if (selected.equals("4")){
                    middletext.setText("#NWDKHGXZVRIFJBLMAOPSCYUTQE");
                }else if (selected.equals("5")){
                    middletext.setText( "#TGOWHLIFMCSZYRVXQABUPEJKND");
                }
            }
        });

        outerpicker.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                String selected = (String) outerpicker.getSelectedItem();
                if (selected.equals("1")){
                    outertext.setText("#GNUAHOVBIPWCJQXDKRYELSZFMT");
                }else if (selected.equals("2")){
                    outertext.setText("EJOTYCHMRWAFKPUZDINSXBGLQV");
                }else if (selected.equals("3")){
                    outertext.setText("#BDFHJLNPRTVXZACEGIKMOQSUWY");
                }else if (selected.equals("4")){
                    outertext.setText("#NWDKHGXZVRIFJBLMAOPSCYUTQE");
                }else if (selected.equals("5")){
                    outertext.setText( "#TGOWHLIFMCSZYRVXQABUPEJKND");
                }
            }
        });
        panel3.add(outer);
        panel3.add(outertext);
        panel3.add(middle);
        panel3.add(middletext);
        panel3.add(inner);
        panel3.add(innertext);
        panel3.setBackground(Color.LIGHT_GRAY);
        panel4.setBackground(Color.LIGHT_GRAY);
        panel5.setBackground(Color.LIGHT_GRAY);
        panel2.setBackground(Color.DARK_GRAY);
        panel2.add(j, BorderLayout.NORTH);
        panel2.add(j2, BorderLayout.NORTH);
        panel.add(button, BorderLayout.EAST);
        panel.add(button2, BorderLayout.WEST);  
        panel.setBackground(Color.GRAY);
        panel4.setBackground(Color.GRAY);
        panel4.add(innerpicker);
        panel4.add(middlepicker);
        panel4.add(outerpicker);
        panel4.add(startfield);
        this.add(panel);
        this.add(panel2);
        this.add(panel3);
        this.add(panel4);
        this.pack();


        this.setVisible(true);


    
    }
}


