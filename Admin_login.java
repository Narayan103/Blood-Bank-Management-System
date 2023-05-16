import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Admin_login extends JFrame implements ActionListener {

    JLabel l1, l2, l3;   //label for email and password

    JTextField tf1;

    JButton btn1,btn2;

    JPasswordField p1;

    Admin_login() {




        setTitle("Login");
        this.getContentPane().setBackground(new Color (250,160,160));
        setSize(400, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l1 = new JLabel("Admin Login");
        l1.setForeground(new Color(128,0,0));
        l1.setFont(new Font("halvetica", Font.BOLD, 20));
        l1.setBounds(140, 50, 400, 40);

        l2 = new JLabel("Enter UserName:");
        l2.setFont(new Font("halvetica", Font.BOLD, 15));
        l2.setForeground(new Color(128,0,0));
        l2.setBounds(50, 120, 200, 30);

        l3 = new JLabel("Enter Password:");
        l3.setFont(new Font("halvetica", Font.BOLD, 15));
        l3.setForeground(new Color(128,0,0));
        l3.setBounds(50, 200, 200, 30);

        tf1 = new JTextField();
        tf1.setBounds(180, 120, 170, 30);

        p1 = new JPasswordField();
        p1.setBounds(180, 200, 170, 30);

        btn1 = new JButton("Submit");
        btn1.setBackground(new Color(128,0,0));
        btn1.setForeground(new Color(255,255,255));
        btn1.setFont(new Font("halvetica", Font.BOLD, 15));
        btn1.setBounds(200, 280, 100, 50);

        btn2 = new JButton("Back");
        btn2.setBackground(new Color(128,0,0));
        btn2.setForeground(new Color(255,255,255));
        btn2.setFont(new Font("halvetica", Font.BOLD, 15));
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
                String q = "select * from login where User_Name='"+tf1.getText()+"' and Password='"+p1.getText()+"'";
                ResultSet rs = c1.s.executeQuery(q);
                if(rs.next()){
                    new admin_interface();
                    setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    tf1.setText("");
                    p1.setText("");
                }
            }catch(Exception ae){
                ae.printStackTrace();
            }
        }
        else if(e.getSource()==btn2) {
            new Home();
            setVisible(false);
        }
    }
    public static void main(String arr[]) {
        new Admin_login();
    }
}
