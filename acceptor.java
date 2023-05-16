import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSetMetaData;
import java.awt.Color;

public class acceptor extends JFrame implements ActionListener {
    JLabel l1;
    JTextField tf1;
    JButton btn1,btn2;
    acceptor(){

        setTitle("Acceptor");

        setSize(300, 300);
        this.getContentPane().setBackground(new Color (250,160,160));
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        l1 = new JLabel("Blood Group Required: ");
        l1.setBounds(30, 50, 400, 30);
        l1.setFont(new Font("halvetica", Font.BOLD, 15));
        l1.setForeground(new Color(128,0,0));

        tf1 = new JTextField();
        tf1.setBounds(30, 90, 150, 30);

        btn1 = new JButton("Submit");
        btn1.setBounds(30, 150, 100, 30);
        btn1.setBackground(new Color(128,0,0));
        btn1.setForeground(new Color(255,255,255));

        btn2 = new JButton("Back");
        btn2.setBounds(150, 150, 100, 30);
        btn2.setBackground(new Color(128,0,0));
        btn2.setForeground(new Color(255,255,255));

        add(l1);
        add(tf1);
        add(btn1);
        add(btn2);

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String a = tf1.getText();


        if(e.getSource()==btn1) {

            try {
                DBSConnection cc = new DBSConnection();
                ResultSet rs =cc.s.executeQuery("select count(bloodtype) from acceptor where bloodtype='"+a+"'");
                int count=0;
                if(rs.next()){
                    count=rs.getInt(1);
                }
                if (count!=0){
                    JOptionPane.showMessageDialog(null,"Blood Group is Available");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Blood Group is Not Available");
                }
            }catch(Exception ee){
                System.out.println("The error is:"+ee);
            }
        }

        if(e.getSource()==btn2) {
            new Interface(" ");
            setVisible(false);

        }

    }
    public static void main(String arr[]) {

        new acceptor();

    }

}


