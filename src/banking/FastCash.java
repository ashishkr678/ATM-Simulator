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
        Image i2 = i1.getImage().getScaledInstance(750, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 750, 750);
        add(image);

        JLabel text = new JLabel("Select Withdrawal Amount");
        text.setBounds(260, 160, 400, 30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        Rs100 = new JButton("Rs 100");
        Rs100.setBounds(160, 260, 150, 30);
        Rs100.addActionListener(this);
        image.add(Rs100);

        Rs500 = new JButton("Rs 500");
        Rs500.setBounds(440, 260, 150, 30); 
        Rs500.addActionListener(this);
        image.add(Rs500);

        Rs1000 = new JButton("Rs 1000");
        Rs1000.setBounds(160, 300, 150, 30);
        Rs1000.addActionListener(this);
        image.add(Rs1000);

        Rs2000 = new JButton("Rs 2000");
        Rs2000.setBounds(440, 300, 150, 30);
        Rs2000.addActionListener(this);
        image.add(Rs2000);

        Rs5000 = new JButton("Rs 5000");
        Rs5000.setBounds(160, 340, 150, 30); 
        Rs5000.addActionListener(this);
        image.add(Rs5000);

        Rs10000 = new JButton("Rs 10000");
        Rs10000.setBounds(440, 340, 150, 30); 
        Rs10000.addActionListener(this);
        image.add(Rs10000);

        back = new JButton("Back");
        back.setBounds(440, 380, 150, 30); 
        back.addActionListener(this);
        image.add(back);

        setSize(750, 750);
        setLocation(400, 20);
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        } else {
            String amount = ((JButton) ae.getSource()).getText().substring(3);
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinNumber + "'");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if (balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                Date date = new Date();
                String query = "insert into bank values('" + pinNumber + "','" + date + "','Withdrawal','" + amount + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited Successfully");

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
