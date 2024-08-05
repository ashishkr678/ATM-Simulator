package banking;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton savingAccount, currentAccount, fdAccount, recurringAccount;
    JCheckBox atmCard, internetBanking, mobileBanking, alerts, chequeBook, eStatement, declaration;
    JButton submit, cancel;
    String formno;

    SignupThree(String formno) {
        this.formno = formno;
        setLayout(null);

        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel accountType = new JLabel("Account Type");
        accountType.setFont(new Font("Raleway", Font.BOLD, 22));
        accountType.setBounds(100, 140, 200, 40);
        add(accountType);

        savingAccount = new JRadioButton("Saving Account");
        savingAccount.setFont(new Font("Raleway", Font.BOLD, 16));
        savingAccount.setBackground(Color.WHITE);
        savingAccount.setBounds(100,180,150,20);
        add(savingAccount);

        fdAccount = new JRadioButton("Fixed Deposit Account");
        fdAccount.setFont(new Font("Raleway", Font.BOLD, 16));
        fdAccount.setBackground(Color.WHITE);
        fdAccount.setBounds(350,180,250,20);
        add(fdAccount);

        currentAccount = new JRadioButton("Current Account");
        currentAccount.setFont(new Font("Raleway", Font.BOLD, 16));
        currentAccount.setBackground(Color.WHITE);
        currentAccount.setBounds(100,220,250,20);
        add(currentAccount);

        recurringAccount = new JRadioButton("Recurring Deposit Account");
        recurringAccount.setFont(new Font("Raleway", Font.BOLD, 16));
        recurringAccount.setBackground(Color.WHITE);
        recurringAccount.setBounds(350,220,250,20);
        add(recurringAccount);

        ButtonGroup groupAccount = new ButtonGroup();
        groupAccount.add(savingAccount);
        groupAccount.add(fdAccount);
        groupAccount.add(currentAccount);
        groupAccount.add(recurringAccount);

        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 300, 200, 30);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-2584");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330, 300, 300, 30);
        add(number);

        JLabel cardDetail = new JLabel("Your 16 Digit Card Number");
        cardDetail.setFont(new Font("Raleway", Font.BOLD, 12));
        cardDetail.setBounds(100, 330, 300, 20);
        add(cardDetail);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 370, 200, 30);
        add(pin);

        JLabel pinNumber = new JLabel("XXXX");
        pinNumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pinNumber.setBounds(330, 370, 300, 30);
        add(pinNumber);

        JLabel pinDetail = new JLabel("Your 4 Digit PIN");
        pinDetail.setFont(new Font("Raleway", Font.BOLD, 12));
        pinDetail.setBounds(100, 400, 300, 20);
        add(pinDetail);

        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100, 450, 400, 30);
        add(services);

        atmCard = new JCheckBox("ATM Card");
        atmCard.setBackground(Color.WHITE);
        atmCard.setFont(new Font("Raleway", Font.BOLD, 16));
        atmCard.setBounds(100, 500, 200, 30);
        add(atmCard);

        internetBanking = new JCheckBox("Internet Banking");
        internetBanking.setBackground(Color.WHITE);
        internetBanking.setFont(new Font("Raleway", Font.BOLD, 16));
        internetBanking.setBounds(350, 500, 200, 30);
        add(internetBanking);

        mobileBanking = new JCheckBox("Mobile Banking");
        mobileBanking.setBackground(Color.WHITE);
        mobileBanking.setFont(new Font("Raleway", Font.BOLD, 16));
        mobileBanking.setBounds(100, 550, 200, 30);
        add(mobileBanking);

        alerts = new JCheckBox("Email & SMS Alerts");
        alerts.setBackground(Color.WHITE);
        alerts.setFont(new Font("Raleway", Font.BOLD, 16));
        alerts.setBounds(350, 550, 200, 30);
        add(alerts);

        chequeBook = new JCheckBox("Cheque Book");
        chequeBook.setBackground(Color.WHITE);
        chequeBook.setFont(new Font("Raleway", Font.BOLD, 16));
        chequeBook.setBounds(100, 600, 200, 30);
        add(chequeBook);

        eStatement = new JCheckBox("E-Statement");
        eStatement.setBackground(Color.WHITE);
        eStatement.setFont(new Font("Raleway", Font.BOLD, 16));
        eStatement.setBounds(350, 600, 200, 30);
        add(eStatement);

        declaration = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge.");
        declaration.setBackground(Color.WHITE);
        declaration.setFont(new Font("Raleway", Font.BOLD, 12));
        declaration.setBounds(100, 660, 600, 30);
        add(declaration);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(250, 720, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(420, 720, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String accountType = null;

            if (savingAccount.isSelected()) {
                accountType = "Saving Account";
            } else if (currentAccount.isSelected()) {
                accountType = "Current Account";
            } else if (fdAccount.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (recurringAccount.isSelected()) {
                accountType = "Recurring Deposit Account";
            }

            Random random = new Random();
            String cardNumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);

            String pinNumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String facility = "";
            if (atmCard.isSelected()) {
                facility = facility + " ATM Card";
            } else if (internetBanking.isSelected()) {
                facility = facility + " Internet Banking";
            } else if (mobileBanking.isSelected()) {
                facility = facility + " Mobile Banking";
            } else if (alerts.isSelected()) {
                facility = facility + " Email & SMS Alerts";
            } else if (chequeBook.isSelected()) {
                facility = facility + " Cheque Book";
            } else if (eStatement.isSelected()) {
                facility = facility + " e-Statement";
            }

            try {
                if (accountType.equals("")) {
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                } else {
                    Conn con = new Conn();
                    String query1 = "insert into signupthree values('" + formno + "', '" + accountType + "', '" + cardNumber + "', '" + pinNumber
                            + "', '" + facility + "')";
                    con.s.executeUpdate(query1);

                    String query2 = "insert into login values('" + formno + "', '" + cardNumber + "', '" + pinNumber + "')";
                    con.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Card Number: " + cardNumber + "\nPIN: " + pinNumber);
                
                    setVisible(false);
                    new Deposit(pinNumber).setVisible(true);
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new SignupThree("");
    }

}
