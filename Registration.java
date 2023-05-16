import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Registration extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6,  User_Name1, Password1, back;  //all labels for textField
    JTextField tf1, tf2, tf3, tf4, tf5, User_Name2;   // others fields
    JButton btn1, btn2,Picture;  //buttons for signup and clear
    JPasswordField Password2;
    int ln;


    Registration() {

        setSize(600, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Registration Form");
        l1 = new JLabel("Registration", JLabel.CENTER);
        l1.setForeground(new Color(128,0,0));
        l1.setFont(new Font("halvetica", Font.BOLD, 25));

        l2 = new JLabel("Name:");
        l2.setForeground(new Color(128,0,0));
        l2.setFont(new Font("halvetica", Font.BOLD, 15));

        l3 = new JLabel("Blood Group");
        l3.setForeground(new Color(128,0,0));
        l3.setFont(new Font("halvetica", Font.BOLD, 15));

        l4 = new JLabel("Age:");
        l4.setForeground(new Color(128,0,0));
        l4.setFont(new Font("halvetica", Font.BOLD, 15));

        l5 = new JLabel("Phone:");
        l5.setForeground(new Color(128,0,0));
        l5.setFont(new Font("halvetica", Font.BOLD, 15));

        l6 = new JLabel("Gender:");
        l6.setForeground(new Color(128,0,0));
        l6.setFont(new Font("halvetica", Font.BOLD, 15));



        User_Name1 = new JLabel("Set User_Name");
        User_Name1.setForeground(new Color(128,0,0));
        User_Name1.setFont(new Font("halvetica", Font.BOLD, 15));

        Password1 = new JLabel("Set Password");
        Password1.setForeground(new Color(128,0,0));
        Password1.setFont(new Font("halvetica", Font.BOLD, 15));

        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();

        User_Name2 = new JTextField();
        Password2 = new JPasswordField();
        btn1 = new JButton("Submit");
        btn2 = new JButton("Back");


        l1.setBounds(80, 10, 400, 30);
        l2.setBounds(80, 70, 200, 30);
        l3.setBounds(80, 110, 200, 30);
        l4.setBounds(80, 150, 200, 30);
        l5.setBounds(80, 190, 200, 30);
        l6.setBounds(80, 230, 200, 30);

        User_Name1.setBounds(80, 270, 200, 30);
        Password1.setBounds(80, 310, 200, 30);
        tf1.setBounds(300, 70, 200, 30);
        tf2.setBounds(300, 110, 200, 30);
        tf3.setBounds(300, 150, 200, 30);
        tf4.setBounds(300, 190, 200, 30);
        tf5.setBounds(300, 230, 200, 30);

        User_Name2.setBounds(300, 270, 200, 30);
        Password2.setBounds(300, 310, 200, 30);

        btn1.setBounds(170, 380, 100, 40);
        btn1.setBackground(new Color(128,0,0));
        btn1.setForeground(new Color(225,225,225));
        btn1.setFont(new Font("halvetica", Font.BOLD, 15));
        btn1.setFocusable(false);

        btn2.setBounds(300, 380, 100, 40);
        btn2.setBackground(new Color(128,0,0));
        btn2.setForeground(new Color(225,225,225));
        btn2.setFont(new Font("halvetica", Font.BOLD, 15));
        btn2.setFocusable(false);
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\naray\\OneDrive\\Desktop\\dbms img\\5.jpg");




        this.setIconImage(icon);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(250,160,160));

        add(l1);
        add(l2);
        add(tf1);
        add(l3);
        add(tf2);
        add(l4);
        add(tf3);
        add(l5);
        add(tf4);
        add(l6);
        add(tf5);

        add(User_Name1);
        add(User_Name2);
        add(Password1);
        add(Password2);

        add(btn1);
        add(btn2);



        btn1.addActionListener(this);
        btn2.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String a = tf1.getText();
        String b = tf2.getText();
        String c = tf3.getText();
        String d = tf4.getText();
        String f = tf5.getText();

        String k = User_Name2.getText();
        String l = Password2.getText();


        if (e.getSource() == btn1) {
            try {
                DBSConnection cc = new DBSConnection();
                String q = "INSERT INTO bloodbank (Name , Blood_Group, age, Phone_no , Gender, Username, Password) values('" + a + "','" + b + "','" + c + "','" + d + "','" + f + "','" + k + "','" + l + "')";

                cc.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Details Successfully Inserted");
                new Home();
                setVisible(false);
            } catch (Exception ee) {
                System.out.println("The error is:" + ee);
            }
        }
        if (e.getSource() == btn2) {
            new Home();
            setVisible(false);
        }
    }


    public static void main(String args[]) {

        new Registration();
    }
}
