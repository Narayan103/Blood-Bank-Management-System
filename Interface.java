import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class Interface extends JFrame implements ActionListener {
    JLabel l1,l21;
    JButton btn1, btn2, btn3 ;


    Interface(String username) {

        this.getContentPane().setBackground(new Color (250,160,160));




        setTitle("Bank Interface");
        setSize(470, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        l1 = new JLabel("Bank Interface", JLabel.CENTER);
        l1.setForeground(new Color(128,0,0));
        l1.setFont(new Font("halvetica", Font.BOLD, 30));
        l1.setBackground(Color.decode("#243665"));


        btn1 = new JButton("Donor");
        btn1.setBackground(new Color(128,0,0));
        btn1.setForeground(new Color(225,225,225));
        btn1.setFont(new Font("halvetica", Font.BOLD, 15));
        btn1.setFocusable(false);

        btn2 = new JButton("Acceptor");
        btn2.setBackground(new Color(128,0,0));
        btn2.setForeground(new Color(225,225,225));
        btn2.setFont(new Font("halvetica", Font.BOLD, 15));
        btn2.setFocusable(false);



        btn3 = new JButton("Back");
        btn3.setBackground(new Color(128,0,0));
        btn3.setForeground(new Color(225,225,225));
        btn3.setFont(new Font("halvetica", Font.BOLD, 15));
        btn3.setFocusable(false);


        l1.setBounds(20, 170, 400, 40);
        btn1.setBounds(60, 270, 130, 40);
        btn2.setBounds(230, 270, 130, 40);
        btn3.setBounds(155, 350, 100, 40);





        add(l1);
        add(btn1);
        add(btn2);
        add(btn3);


        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        setVisible(true);
        l21 = new JLabel(username);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn1) {

            new Donor(l21.getText());
            setVisible(false);
        }
        else if(e.getSource()==btn2) {
            new acceptor();
            setVisible(false);
        }
        else if(e.getSource()==btn3) {
            new Home();
            setVisible(false);
        }


    }


    public static void main(String arr[]) {

        new Interface("");

    }


}

