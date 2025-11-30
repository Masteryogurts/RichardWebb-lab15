import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import java.util.*;
public class EnigmaFrame{
    /*JComboBox : for selecting the rotor numbers
    JTextField : for selecting the start of the rotors
    JTextArea : for providing input to and output from Enigma
    JButton : for selecting encrypt or decrypt
    JLabel : for including other text references, such as “Inner” or “Middle”*/
    public static void main(String[] args){
        Enigma e = new Enigma(4, 2, 3, "X#Y");
        String[] rotorsinit = e.rotorInit;
        JComboBox<String> box = new JComboBox<>(rotorsinit);
        
        JFrame f = new JFrame();
        f.setLayout(new GridLayout(2,0));
        f.setTitle("Enigma");
        f.setSize(700,700);
        f.setLocation(400,0);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("Encrypt");
        JButton button2 = new JButton("Decrypt");
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 250,10));
        JTextArea j = new JTextArea(10,40);
        Font font = new Font("Arial", Font.BOLD, 14);
        j.setFont(font);
        j.setBackground(Color.LIGHT_GRAY);
        j.setEditable(true);
        JTextArea j2 = new JTextArea(10,40);
        j2.setText("Output: ");
        j2.setFont(font);
        j2.setBackground(Color.LIGHT_GRAY);
        j2.setEditable(false);
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 250, 10));
        panel2.setBackground(Color.DARK_GRAY);
        panel2.add(j, BorderLayout.NORTH);
        panel2.add(j2, BorderLayout.NORTH);
        panel.add(button, BorderLayout.EAST);
        panel.add(button2, BorderLayout.WEST);  
        panel.setBackground(Color.GRAY);
        panel.add(box);
        f.add(panel, BorderLayout.NORTH);
        f.add(panel2, BorderLayout.SOUTH);


        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                String message = j.getText().toUpperCase();
                String result = e.encrypt(message);
                j2.setText("Output: " + result);
                j.setText(result);
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event2){
                String message = j.getText().toUpperCase();
                String result = e.decrypt(message);
                j2.setText("Output: " + result);
                j.setText(result);
            }
        });


        f.setVisible(true);


    
    }

}
