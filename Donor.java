import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Color;

public class Donor extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6;
    JTextField tf2, tf3,tf4;
    JButton btn1, btn2;

    Donor(String name) {

        setTitle("Bloodbank");
        setSize(300, 400);
        this.getContentPane().setBackground(new Color(250,160,160));
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l1 = new JLabel("Name:");
        l2 = new JLabel("Location:");
        l3 = new JLabel("Blood Type:");
        l4 = new JLabel("phone_no:");
        l5 = new JLabel();
        l6= new JLabel(name);
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        btn1 = new JButton("Submit");
        btn2 = new JButton("Back");

        l1.setBounds(30, 30, 400, 30);
        l1.setFont(new Font("halvetica", Font.BOLD, 15));
        l1.setForeground(new Color(128,0,0));

        l2.setBounds(30, 90, 400, 30);
        l2.setFont(new Font("halvetica", Font.BOLD, 15));
        l2.setForeground(new Color(128,0,0));

        l3.setBounds(30, 150, 400, 30);
        l3.setFont(new Font("halvetica", Font.BOLD, 15));
        l3.setForeground(new Color(128,0,0));

        l4.setBounds(30, 210, 400, 30);
        l4.setFont(new Font("halvetica", Font.BOLD, 15));
        l4.setForeground(new Color(128,0,0));

        l5.setBounds(200, 30, 400, 30);
        l5.setFont(new Font("halvetica", Font.BOLD, 15));
        l5.setForeground(new Color(128,0,0));

        l6.setBounds(200, 30, 400, 30);
        l6.setFont(new Font("halvetica", Font.BOLD, 15));
        l6.setForeground(new Color(128,0,0));


        tf4.setBounds(130, 210, 140, 30);
        tf2.setBounds(130, 90, 140, 30);
        tf3.setBounds(130, 150, 140, 30);
        btn1.setBounds(40, 290, 100, 30);
        btn1.setBackground(new Color(128,0,0));
        btn1.setForeground(new Color(225,225,225));
        btn2.setBounds(150, 290, 100, 30);
        btn2.setBackground(new Color(128,0,0));
        btn2.setForeground(new Color(225,225,225));

        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(tf2);
        add(tf3);
        add(tf4);
        add(l5);
        add(l6);
        add(btn1);
        add(btn2);

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        String a = l6.getText();
        String b = tf2.getText();
        String c = tf3.getText();
        String d = tf4.getText();


        if (e.getSource() == btn1) {

            try {
                DBSConnection cc = new DBSConnection();
                String q = "INSERT INTO location (Username,Location,bloodtype,phone_no) values('" + a +"','" + b + "','" + c + "','" + d + "')";
                String q1 = "INSERT INTO acceptor (Username,Location,bloodtype) values('" + a +"','" + b + "','" + c + "')";
                cc.s.executeUpdate(q);
                cc.s.executeUpdate(q1);
                JOptionPane.showMessageDialog(null, "We will contact you shortly.");
            } catch (Exception ee) {
                System.out.println("The error is:" + ee);
            }
        }
        if (e.getSource() == btn2) {
            new Interface("");
            setVisible(false);

        }

    }

    public static void main(String arr[]) {

        new Donor("");

    }

}

