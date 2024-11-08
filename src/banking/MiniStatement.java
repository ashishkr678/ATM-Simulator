package banking;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class MiniStatement extends JFrame implements ActionListener {
    String pinNumber;
    JButton back;

    MiniStatement(String pinNumber) {
        this.pinNumber = pinNumber;
        setLayout(null);
        setTitle("Mini Statement");

        JLabel bank = new JLabel("GITA Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);

        try {
            Conn con = new Conn();
            ResultSet rs = con.s.executeQuery("select * from login where pin = '"+pinNumber+"'");
            while(rs.next()) {
                card.setText("Card Number: "+ rs.getString("cardnumber").substring(0,4) + "-XXXX-XXXX-" + rs.getString("cardnumber").substring(12));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);

        JLabel mini = new JLabel();
        mini.setBounds(20, 140, 400, 200);
        add(mini);

        try {
            Conn con = new Conn();
            int bal = 0;
            ResultSet rs = con.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
            while(rs.next()) {
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your current account balance is Rs "+ bal);
        } catch (Exception e) {
            System.out.println(e);
        }


        setSize(400, 600);
        setLocation(30, 30);
        getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pinNumber).setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("").setVisible(true);
    }
}
