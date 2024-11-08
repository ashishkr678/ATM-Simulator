package banking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField panTextField, aadharTextField;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox<String> religionBox, categoryBox, occupationBox, educationBox, incomeBox;
    String formno;

    SignupTwo(String formno) {

        this.formno = formno;

        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 20));
        additionalDetails.setBounds(250, 50, 400, 30);
        add(additionalDetails);

        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 16));
        religion.setBounds(80, 100, 100, 30);
        add(religion);

        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religionBox = new JComboBox<>(valReligion);
        religionBox.setBounds(230, 100, 300, 30);
        religionBox.setBackground(Color.WHITE);
        add(religionBox);

        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 16));
        category.setBounds(80, 150, 100, 30);
        add(category);

        String valCategory[] = {"General", "OBC", "SC", "ST", "Other"};
        categoryBox = new JComboBox<>(valCategory);
        categoryBox.setBounds(230, 150, 300, 30);
        categoryBox.setBackground(Color.WHITE);
        add(categoryBox);

        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 16));
        income.setBounds(80, 200, 100, 30);
        add(income);

        String valIncome[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
        incomeBox = new JComboBox<>(valIncome);
        incomeBox.setBounds(230, 200, 300, 30);
        incomeBox.setBackground(Color.WHITE);
        add(incomeBox);

        JLabel educational = new JLabel("Education:");
        educational.setFont(new Font("Raleway", Font.BOLD, 16));
        educational.setBounds(80, 250, 100, 30);
        add(educational);

        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway", Font.BOLD, 16));
        qualification.setBounds(80, 275, 120, 30);
        add(qualification);

        String valEducation[] = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Others"};
        educationBox = new JComboBox<>(valEducation);
        educationBox.setBounds(230, 275, 300, 30);
        educationBox.setBackground(Color.WHITE);
        add(educationBox);

        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 16));
        occupation.setBounds(80, 325, 100, 30);
        add(occupation);

        String valOccupation[] = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Others"};
        occupationBox = new JComboBox<>(valOccupation);
        occupationBox.setBounds(230, 325, 300, 30);
        occupationBox.setBackground(Color.WHITE);
        add(occupationBox);

        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway", Font.BOLD, 16));
        pan.setBounds(80, 375, 120, 30);
        add(pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(230, 375, 300, 30);
        add(panTextField);

        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 16));
        aadhar.setBounds(80, 425, 140, 30);
        add(aadhar);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(230, 425, 300, 30);
        add(aadharTextField);

        JLabel seniorCitizen = new JLabel("Senior Citizen:");
        seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 16));
        seniorCitizen.setBounds(80, 475, 120, 30);
        add(seniorCitizen);

        syes = new JRadioButton("Yes");
        syes.setBounds(230, 475, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(340, 475, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup seniorCitizenGroup = new ButtonGroup();
        seniorCitizenGroup.add(syes);
        seniorCitizenGroup.add(sno);

        JLabel exAccount = new JLabel("Existing Account:");
        exAccount.setFont(new Font("Raleway", Font.BOLD, 16));
        exAccount.setBounds(80, 525, 140, 30);
        add(exAccount);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(230, 525, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(340, 525, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup existingAccountGroup = new ButtonGroup();
        existingAccountGroup.add(eyes);
        existingAccountGroup.add(eno);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(450, 580, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(700, 650);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String religion = (String)religionBox.getSelectedItem();
        String category = (String)categoryBox.getSelectedItem();
        String education = (String)educationBox.getSelectedItem();
        String occupation = (String)occupationBox.getSelectedItem();
        String income = (String)incomeBox.getSelectedItem();

        String seniorCitizen = null;
        if (syes.isSelected()) {
            seniorCitizen = "Yes";
        } else if (sno.isSelected()) {
            seniorCitizen = "No";
        }

        String existingAccount = null;
        if (eyes.isSelected()) {
            existingAccount = "Yes";
        } else if (eno.isSelected()) {
            existingAccount = "No";
        }

        String pan = panTextField.getText();
        String aadhar = aadharTextField.getText();

        try {
            if (pan.equals("")) {
                JOptionPane.showMessageDialog(null, "PAN No. is Required");
            } else {
                Conn c = new Conn();
                String query = "insert into signuptwo values('" + formno + "', '" + religion + "', '" + category + "', '" + income
                        + "', '" + education + "', '" + occupation + "', '" + pan + "', '" + aadhar + "', '" + seniorCitizen
                        + "', '" + existingAccount + "')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignupTwo("");
    }
}
