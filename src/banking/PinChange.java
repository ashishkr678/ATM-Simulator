package banking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PinChange extends JFrame implements ActionListener {

    String pinNumber;
    JPasswordField pin, repin;
    JButton change, back;

    PinChange(String pinNumber) {
        this.pinNumber = pinNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(750, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 750, 750);
        add(image);

        JLabel text = new JLabel("Change Your PIN");
        text.setBounds(300, 160, 400, 30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 18));
        image.add(text);

        JLabel pinText = new JLabel("New PIN:");
        pinText.setBounds(170, 230, 200, 30);
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("System", Font.BOLD, 16));
        image.add(pinText);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 16));
        pin.setBounds(320, 230, 150, 30);
        image.add(pin);

        JLabel rePinText = new JLabel("Re-enter New PIN:");
        rePinText.setBounds(170, 280, 200, 30);
        rePinText.setForeground(Color.WHITE);
        rePinText.setFont(new Font("System", Font.BOLD, 16));
        image.add(rePinText);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 16));
        repin.setBounds(320, 280, 150, 30);
        image.add(repin);

        change = new JButton("Change");
        change.setBounds(440, 340, 150, 30);
        change.addActionListener(this);
        image.add(change);

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
        if (ae.getSource() == change) {
            try {
                String npin = pin.getText();
                String rpin = repin.getText();

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }

                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter New PIN");
                    return;
                }

                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Re-Enter New PIN");
                    return;
                }

                Conn conn = new Conn();
                String query1 = "update bank set pin = '" + rpin + "' where pin = '" + pinNumber + "'";
                String query2 = "update login set pin = '" + rpin + "' where pin = '" + pinNumber + "'";
                String query3 = "update signupthree set pin = '" + rpin + "' where pin = '" + pinNumber + "'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN Changed Successfully");

                setVisible(false);
                new Transactions(rpin).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
