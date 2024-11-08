package banking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {

    JTextField amount;
    JButton withdraw, back;
    String pinNumber;

    Withdrawl(String pinNumber) {

        this.pinNumber = pinNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(750, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 750, 750);
        add(image);

        JLabel text = new JLabel("Enter The Amount You Want To Withdraw");
        text.setBounds(220, 190, 400, 30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(230, 230, 300, 30);
        image.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(440, 340, 150, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);

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
            String number = amount.getText();
            Date date = new Date();

            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount");
            } else {
                try {
                    Conn con = new Conn();
                    ResultSet rs = con.s.executeQuery("select * from bank where pin = '" + pinNumber + "'");
                    int balance = 0;
                    while (rs.next()) {
                        if (rs.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(rs.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }

                    if (balance < Integer.parseInt(number)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                    String query = "insert into bank values('" + pinNumber + "', '" + date + "', 'Withdrawl', '"
                            + number
                            + "')";
                    con.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "RS " + number + " Withdraw Successfully");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        new Withdrawl("");
    }
}