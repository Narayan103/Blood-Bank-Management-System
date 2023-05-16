import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.ResultSet;
import java.awt.*;

public class Login extends JFrame implements ActionListener {

    JLabel l1, l2, l3,l4;

    JTextField tf1;

    JButton btn1,btn2;

    JPasswordField p1;


    Login() {



        setTitle("Login");
        this.getContentPane().setBackground(new Color (225,130,140));
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);


        l4=new JLabel("Login");
        l1 = new JLabel("Login");
        l1.setForeground(new Color(128,0,0));
        l1.setFont(new Font("halvetica", Font.BOLD, 30));
        l2 = new JLabel("Enter UserName:");
        l2.setFont(new Font("halvetica", Font.BOLD, 15));
        l2.setForeground(new Color(128,0,0));
        l3 = new JLabel("Enter Password:");
        l3.setFont(new Font("halvetica", Font.BOLD, 15));
        l3.setForeground(new Color(128,0,0));
        tf1 = new JTextField();
        p1 = new JPasswordField();

        btn1 = new JButton("Login");
        btn1.setBackground(new Color(128,0,0));
        btn1.setForeground(new Color(225,225,225));
        btn1.setFont(new Font("halvetica", Font.BOLD, 15));


        btn2 = new JButton("Back");
        btn2.setBackground(new Color(128,0,0));
        btn2.setForeground(new Color(225,225,225));
        btn2.setFont(new Font("halvetica", Font.BOLD, 15));

        l1.setBounds(140, 50, 400, 40);
        l2.setBounds(50, 120, 200, 30);
        l3.setBounds(50, 200, 200, 30);
        tf1.setBounds(180, 120, 170, 30);
        p1.setBounds(180, 200, 170, 30);
        btn1.setBounds(200, 280, 100, 50);
        btn2.setBounds(70, 280, 100, 50);

        add(l1);
        add(l2);
        add(tf1);
        add(l3);
        add(p1);
        add(btn1);
        add(btn2);



        btn1.addActionListener(this);
        btn2.addActionListener(this);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==btn1) {
            try{
                DBSConnection c1 = new DBSConnection();
                String q = "select * from bloodbank where Username='"+tf1.getText()+"' and Password='"+p1.getText()+"'";
                ResultSet rs = c1.s.executeQuery(q);
                if(rs.next()){
                    new Interface(tf1.getText());
                    setVisible(false);

                }else{
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    tf1.setText("");
                    p1.setText("");

                }
            }catch(Exception ae){
                ae.printStackTrace();
                //System.out.print(e);
            }
        }
        else if(e.getSource()==btn2) {
            new Home();
            setVisible(false);
        }


    }


    public static void main(String arr[]) {

        new Login();

    }

}