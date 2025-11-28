import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.Border;
public class EnigmaFrame{
    /*JComboBox : for selecting the rotor numbers
    JTextField : for selecting the start of the rotors
    JTextArea : for providing input to and output from Enigma
    JButton : for selecting encrypt or decrypt
    JLabel : for including other text references, such as “Inner” or “Middle”*/
    public static void main(String[] args){
        Enigma g = new Enigma(0, 0, 0, null);
        
        JFrame f = new JFrame();
        f.setLayout(new GridLayout(2,0));
        f.setTitle("Enigma");
        f.setSize(700,700);
        f.setLocation(400,0);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("Encrypt");
        JButton button2 = new JButton("Decrypt");
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 250,10));
        JTextArea j = new JTextArea("Input: ");
        Font font = new Font("Arial", Font.BOLD, 14);
        j.setFont(font);
        j.setBackground(Color.LIGHT_GRAY);
        
        JTextArea j2 = new JTextArea("Output: ");
        j2.setFont(font);
        j2.setBackground(Color.LIGHT_GRAY);
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 250, 10));
        panel2.setBackground(Color.DARK_GRAY);
        panel2.add(j, BorderLayout.NORTH);
        panel2.add(j2, BorderLayout.NORTH);
        panel.add(button, BorderLayout.EAST);
        panel.add(button2, BorderLayout.WEST);  
        panel.setBackground(Color.GRAY);
        f.add(panel, BorderLayout.NORTH);
        f.add(panel2, BorderLayout.SOUTH);




        f.setVisible(true);


    
    }

}
