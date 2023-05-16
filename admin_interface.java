import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.sql.ResultSetMetaData;

import java.awt.Color;

public class admin_interface extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4;
    JTable table;
    JScrollPane sp;
    JButton Back,Delete;
    ListSelectionModel model1;
    admin_interface(){


        setTitle("All Donors");
        this.getContentPane().setBackground(new Color(250,160,160));
        setSize(1100, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Back = new JButton("Back");
        Back.setFont(new Font("halvetica ", Font.ITALIC, 18));
        Back.setBounds(50,500,120,40);
        Back.setBackground(new Color(128,0,0));
        Back.setForeground(new Color(255,255,255));
        add(Back);
        Back.addActionListener(this);

        Delete = new JButton("Delete 1st");
        Delete.setFont(new Font("halvetica ", Font.ITALIC, 18));
        Delete.setBounds(250,500,120,40);
        Delete.setBackground(new Color(128,0,0));
        Delete.setForeground(new Color(255,255,255));
        add(Delete);
        Delete.addActionListener(this);

        sp = new JScrollPane(table);
        sp.setPreferredSize(new Dimension(400,150));

        table = new JTable();
        table.setVisible(true);
        table.setRowHeight(25);
        table.setBounds(40,40,1000,400);
        add(table);

        l1=  new JLabel("username");
        l1.setFont(new Font("halvetica ", Font.BOLD, 15));
        l1.setForeground(new Color(128,0,0));
        l1.setBounds(40, 0, 500, 50);
        add(l1);

        l2=  new JLabel("location");
        l2.setFont(new Font("halvetica ", Font.BOLD, 15));
        l2.setForeground(new Color(128,0,0));
        l2.setBounds(293, 0, 500, 50);
        add(l2);

        l3=  new JLabel("bloodtype");
        l3.setFont(new Font("halvetica ", Font.BOLD, 15));
        l3.setForeground(new Color(128,0,0));
        l3.setBounds(539, 0, 500, 50);
        add(l3);

        l4=  new JLabel("phone_no");
        l4.setFont(new Font("halvetica ", Font.BOLD, 15));
        l4.setForeground(new Color(128,0,0));
        l4.setBounds(788, 0, 500, 50);
        add(l4);


        try{

            DBSConnection con = new DBSConnection();
            String q= "select * from location";
            ResultSet rs = con.s.executeQuery(q);
            ResultSetMetaData rsmd = rs.getMetaData();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            String[] header = {"username" ,"location" , "bloodtype","phone_no"};
            model.setColumnIdentifiers(header);
            table.setModel(model);
            String username ,location , bloodtype, phone_no;
            while(rs.next()) {
                username = rs.getString("username");
                location = rs.getString("location");
                bloodtype = rs.getString("bloodtype");
                phone_no = rs.getString("phone_no");

                String[] row = {username ,location , bloodtype,phone_no};
                model.addRow(row);
            }
        }
        catch(Exception e1) {
            e1.printStackTrace();
        }

        setVisible(true);
    }
    public static void main(String arr[]) {

        new admin_interface();

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Back) {
            new Home();
            this.setVisible(false);
        }
        if (e.getSource() == Delete) {
            try {
                DBSConnection cc = new DBSConnection();
                String q = "delete from location limit 1";

                cc.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Blood Successfully Collected");
                new admin_interface();
                setVisible(false);
            } catch (Exception ee) {
                System.out.println("The error is:" + ee);
            }
        }
        // TODO Auto-generated method stub

    }



}

