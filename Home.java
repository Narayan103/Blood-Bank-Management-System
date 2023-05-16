import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Home  extends JFrame implements ActionListener {
    JLabel l1,back;
    JButton btn1, btn2,btn3;
    ImageIcon background;
    Image img;
    Image temp;
    Home(){

        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\naray\\OneDrive\\Desktop\\dbms img\\5.jpg");
        this.setIconImage(icon);
        this.setSize(500,500);
        this.setLocationRelativeTo(null);

        setSize(500, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Home");

        l1 = new JLabel("BLOOD BANK DONATION");
        l1.setForeground(new Color(228,20,60));
        l1.setFont(new Font("halvetica ", Font.BOLD+Font.ITALIC, 30));
        l1.setBounds(60, 100, 500, 50);


        btn1 = new JButton("Admin");
        btn1.setBackground(new Color(220,20,60));
        btn1.setForeground(new Color(255,255,255));
        btn1.setBounds(185, 320, 120, 50);
        btn1.setFont(new Font("helvetica",Font.ITALIC,20));

        btn2 = new JButton("Sign Up");
        btn2.setBackground(new Color(220,20,60));
        btn2.setForeground(new Color(255,255,255));
        btn2.setBounds(320, 225, 120, 50);
        btn2.setFont(new Font("helvetica",Font.ITALIC,20));


        btn3 = new JButton("Sign In");
        btn3.setBackground(new Color(220,20,60));
        btn3.setForeground(new Color(255,255,255));
        btn3.setBounds(50, 225, 120, 50);
        btn3.setFont(new Font("helvetica",Font.ITALIC,20));

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);


        add(l1);
        add(btn1);
        add(btn2);
        add(btn3);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {


        if(e.getSource()==btn1) {
            new Admin_login();
            setVisible(false);
        }

        if(e.getSource()==btn3) {
            new Login();
            setVisible(false);

        }
        else if(e.getSource()==btn2) {

            new Registration();
            setVisible(false);
        }
    }


    public static void main(String[] args) {
        new Home();
    }

}