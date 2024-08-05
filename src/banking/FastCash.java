package banking;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.*;

public class FastCash extends JFrame implements ActionListener {

    JButton Rs100, Rs500, Rs1000, Rs2000, Rs5000, Rs10000, back;
    String pinNumber;

    FastCash(String pinNumber) {
        this.pinNumber = pinNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 800);
        add(image);

        JLabel text = new JLabel("Select Withdrawl Amount");
        text.setBounds(180,260,650,30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        Rs100 = new JButton("Rs 100");
        Rs100.setBounds(140, 370, 130, 25);
        Rs100.addActionListener(this);
        image.add(Rs100);

        Rs500 = new JButton("Rs 500");
        Rs500.setBounds(325, 370, 130, 25);
        Rs500.addActionListener(this);
        image.add(Rs500);

        Rs1000 = new JButton("Rs 1000");
        Rs1000.setBounds(140, 400, 130, 25);
        Rs1000.addActionListener(this);
        image.add(Rs1000);

        Rs2000 = new JButton("Rs 2000");
        Rs2000.setBounds(325, 400, 130, 25);
        Rs2000.addActionListener(this);
        image.add(Rs2000);

        Rs5000 = new JButton("Rs 5000");
        Rs5000.setBounds(140, 430, 130, 25);
        Rs5000.addActionListener(this);
        image.add(Rs5000);

        Rs10000 = new JButton("Rs 10000");
        Rs10000.setBounds(325, 430, 130, 25);
        Rs10000.addActionListener(this);
        image.add(Rs10000);

        back = new JButton("Back");
        back.setBounds(325, 460, 130, 25);
        back.addActionListener(this);
        image.add(back);

        setSize(800,800);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
                int balance = 0;
                while(rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if (ae.getSource() != back && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                Date date = new Date();
                String query = "insert into bank values('"+pinNumber+"','"+date+"','Withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+amount+ " Debited Successfully");

                setVisible(false);
                new Transactions(pinNumber).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args) {
        new FastCash("");
    }
}
