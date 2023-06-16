package Bank_Management_System;

import com.toedter.calendar.JDateChooser;

import javax.management.relation.RelationNotFoundException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUpTwo extends JFrame  implements ActionListener{
    JButton nextButton;
    JComboBox religionDropDown,categoryDropDown,incomeDropDown,educationDropDown,occupationDropDown;
    JTextField aadharText,panText;
    JRadioButton syes,sNo,eayes,eaNo;
    ButtonGroup exisitingABG,seniorCBG;
    String formno;
    SignUpTwo(String formno)
    {
        this.formno=formno;
        setTitle("New Account Application Form - Page 2");
        JLabel additionalDetails=new JLabel("Page 2 : Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD,22));
        additionalDetails.setBounds(275,90,500,25);
        add(additionalDetails);

        JLabel religion=new JLabel("Religion : ");
        religion.setFont(new Font("Raleway", Font.BOLD,20));
        religion.setBounds(160,140,200,25);
        add(religion);
        String[] religions ={"Hindu","Muslim","Christian","Sikh","Other"};
        religionDropDown=new JComboBox(religions);
        religionDropDown.setBounds(335,140,300,25);
        religionDropDown.setFont(new Font("Raleway", Font.BOLD,14));
        add(religionDropDown);

        JLabel category=new JLabel("Category : ");
        category.setFont(new Font("Raleway", Font.BOLD,20));
        category.setBounds(160,175,175,25);
        add(category);
        String[] categories ={"General","OBC","SC","ST","Other"};
        categoryDropDown=new JComboBox(categories);
        categoryDropDown.setBounds(335,175,300,25);
        categoryDropDown.setFont(new Font("Raleway", Font.BOLD,14));
        add(categoryDropDown);


        JLabel income=new JLabel("Income : ");
        income.setFont(new Font("Raleway", Font.BOLD,20));
        income.setBounds(160,210,200,25);
        add(income);
        String[] income_categories ={"None","<1.5 Lakh","<2.5 Lakh","< 5 Lakh","<10 Lakh",">10 Lakh"};
        incomeDropDown=new JComboBox(income_categories);
        incomeDropDown.setBounds(335,210,300,25);
        incomeDropDown.setFont(new Font("Raleway", Font.BOLD,14));
        add(incomeDropDown);

        JLabel education=new JLabel("Educational");
        education.setFont(new Font("Raleway", Font.BOLD,20));
        education.setBounds(160,245,200,25);
        add(education);
        JLabel qualification=new JLabel("Qualification : ");
        qualification.setFont(new Font("Raleway", Font.BOLD,20));
        qualification.setBounds(160,270,200,25);
        add(qualification);
        String[] education_categories ={"None","Graduate","Post Graduate","Doctrate","Other"};
        educationDropDown=new JComboBox(education_categories);
        educationDropDown.setBounds(335,260,300,25);
        educationDropDown.setFont(new Font("Raleway", Font.BOLD,14));
        add(educationDropDown);

        JLabel occupation=new JLabel("Occupation : ");
        occupation.setFont(new Font("Raleway", Font.BOLD,20));
        occupation.setBounds(160,315,200,25);
        add(occupation);
        String[] occupation_categories ={"Salaried","Self-Employed","Business","Student","Other"};
        occupationDropDown=new JComboBox(occupation_categories);
        occupationDropDown.setBounds(335,315,300,25);
        occupationDropDown.setFont(new Font("Raleway", Font.BOLD,14));
        add(occupationDropDown);

        JLabel panNo=new JLabel("Pan Number : ");
        panNo.setFont(new Font("Raleway", Font.BOLD,20));
        panNo.setBounds(160,350,200,25);
        add(panNo);
        panText=new JTextField();
        panText.setBounds(335,350,300,25);
        panText.setFont(new Font("Raleway", Font.BOLD,14));
        add(panText);

        JLabel aadharNumber=new JLabel("Aadhar Number : ");
        aadharNumber.setFont(new Font("Raleway", Font.BOLD,20));
        aadharNumber.setBounds(160,385,200,25);
        add(aadharNumber);
        aadharText=new JTextField();
        aadharText.setBounds(335,385,300,25);
        aadharText.setFont(new Font("Raleway", Font.BOLD,14));
        add(aadharText);

        JLabel seniorCitizen=new JLabel("Senior Citizen : ");
        seniorCitizen.setFont(new Font("Raleway", Font.BOLD,20));
        seniorCitizen.setBounds(160,420,200,25);
        add(seniorCitizen);

        syes=new JRadioButton("Yes");
        syes.setBounds(335,420,60,25);
        syes.setFont(new Font("Raleway", Font.BOLD,14));
        add(syes);
        sNo=new JRadioButton("No");
        sNo.setBounds(435,420,60,25);
        sNo.setFont(new Font("Raleway", Font.BOLD,14));
        add(sNo);

        seniorCBG=new ButtonGroup();
        seniorCBG.add(syes);
        seniorCBG.add(sNo);

        JLabel existingAccount=new JLabel("Existing Account : ");
        existingAccount.setFont(new Font("Raleway", Font.BOLD,20));
        existingAccount.setBounds(160,455,200,25);
        add(existingAccount);

        eayes=new JRadioButton("Yes");
        eayes.setBounds(335,455,60,25);
        eayes.setFont(new Font("Raleway", Font.BOLD,14));
        add(eayes);
        eaNo=new JRadioButton("No");
        eaNo.setBounds(435,455,60,25);
        eaNo.setFont(new Font("Raleway", Font.BOLD,14));
        add(eaNo);

        exisitingABG=new ButtonGroup();
        exisitingABG.add(eayes);
        exisitingABG.add(eaNo);

        nextButton=new JButton("Next");
        nextButton.setForeground(Color.WHITE);
        nextButton.setBackground(Color.BLACK);
        nextButton.setBounds(335,530,300,25);
        add(nextButton);
        nextButton.addActionListener(this);

        setLayout(null);
        setSize(850,700);
        setLocation(500,150);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton) {
            String sreligion = (String) religionDropDown.getSelectedItem();
            String scategory = (String) categoryDropDown.getSelectedItem();
            String sincome = (String) incomeDropDown.getSelectedItem();
            String seducation = (String) educationDropDown.getSelectedItem();
            String soccupation=(String) occupationDropDown.getSelectedItem();
            String span= panText.getText();
            String saadhar=aadharText.getText();
            String senior=null;
            String existing=null;
            if (syes.isSelected()) senior = "True";
            else senior = "False";
            if (eayes.isSelected()) existing = "True";
            else  existing= "False";

            Random random=new Random();
            String cardNumber=""+Math.abs((random.nextLong()%90000000L)+5234513400000000L);
            String pin=""+Math.abs(((random.nextLong()%9000L))+1000L);

            try {
                Conn conn = new Conn();
                String query = "insert into signuptwo values('"+formno+"','"+ sreligion + "','" + scategory + "','" + sincome + "' ,'" + seducation + "' ,'" + soccupation + "' ,'" + span + "' ,'" + saadhar + "' ,'" + senior + "' ,'" + existing + "')";
                conn.s.executeUpdate(query);
            } catch (Exception exception) {
                System.out.println(exception);
            }
            setVisible(false);
            new SignUpThree(formno,cardNumber,pin).setVisible(true);

        }
    }

}
