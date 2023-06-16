package Bank_Management_System;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUpOne extends JFrame implements ActionListener {
    JButton nextButton;
    long rnum;
    JTextField nameText,fnameText,emailText,cityText,stateText,pinCodeText,addressText;
    JRadioButton maleField,femaleField,marriedField,unmarriedField;
    JDateChooser dobField;
    ButtonGroup genderGroup,maritalGroup;
    SignUpOne()
    {
        Random random=new Random();
        rnum=Math.abs(random.nextLong()%9000L+1000L);
        JLabel applicationFormNo=new JLabel("Application Form No : "+rnum);
        applicationFormNo.setFont(new Font("Raleway", Font.BOLD,38));
        applicationFormNo.setBounds(160,30,500,40);
        add(applicationFormNo);

        JLabel personalDetails=new JLabel("Page 1 : Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD,22));
        personalDetails.setBounds(275,90,500,25);
        add(personalDetails);

        JLabel name=new JLabel("Name : ");
        name.setFont(new Font("Raleway", Font.BOLD,20));
        name.setBounds(160,140,200,25);
        add(name);
        nameText=new JTextField();
        nameText.setBounds(335,140,300,25);
        nameText.setFont(new Font("Raleway", Font.BOLD,14));
        add(nameText);

        JLabel fname=new JLabel("Father's Name : ");
        fname.setFont(new Font("Raleway", Font.BOLD,20));
        fname.setBounds(160,175,175,25);
        add(fname);
        fnameText=new JTextField();
        fnameText.setBounds(335,175,300,25);
        fnameText.setFont(new Font("Raleway", Font.BOLD,14));
        add(fnameText);


        JLabel dob=new JLabel("Date of Birth : ");
        dob.setFont(new Font("Raleway", Font.BOLD,20));
        dob.setBounds(160,210,200,25);
        add(dob);
        dobField=new JDateChooser();
        dobField.setBounds(335,210,300,25);
        add(dobField);

        JLabel gender=new JLabel("Gender : ");
        gender.setFont(new Font("Raleway", Font.BOLD,20));
        gender.setBounds(160,245,200,25);
        add(gender);
        maleField=new JRadioButton("Male");
        maleField.setBounds(335,245,60,30);
        add(maleField);
        femaleField=new JRadioButton("Female");
        femaleField.setBounds(435,245,120,30);
        add(femaleField);

        genderGroup=new ButtonGroup();
        genderGroup.add(maleField);
        genderGroup.add(femaleField);


        JLabel emailAddress=new JLabel("Email Address : ");
        emailAddress.setFont(new Font("Raleway", Font.BOLD,20));
        emailAddress.setBounds(160,280,200,25);
        add(emailAddress);
        emailText=new JTextField();
        emailText.setBounds(335,280,300,25);
        emailText.setFont(new Font("Raleway", Font.BOLD,14));
        add(emailText);

        JLabel maritalStatus=new JLabel("Marital Status : ");
        maritalStatus.setFont(new Font("Raleway", Font.BOLD,20));
        maritalStatus.setBounds(160,315,200,25);
        add(maritalStatus);
        marriedField=new JRadioButton("Married");
        marriedField.setBounds(335,315,90,30);
        add(marriedField);
        unmarriedField=new JRadioButton("Unmarried");
        unmarriedField.setBounds(435,315,120,30);
        add(unmarriedField);

        maritalGroup=new ButtonGroup();
        maritalGroup.add(marriedField);
        maritalGroup.add(unmarriedField);

        JLabel address=new JLabel("Address : ");
        address.setFont(new Font("Raleway", Font.BOLD,20));
        address.setBounds(160,350,200,25);
        add(address);
        addressText=new JTextField();
        addressText.setBounds(335,350,300,25);
        addressText.setFont(new Font("Raleway", Font.BOLD,14));
        add(addressText);

        JLabel city=new JLabel("City : ");
        city.setFont(new Font("Raleway", Font.BOLD,20));
        city.setBounds(160,385,200,25);
        add(city);
        cityText=new JTextField();
        cityText.setBounds(335,385,300,25);
        cityText.setFont(new Font("Raleway", Font.BOLD,14));
        add(cityText);

        JLabel state=new JLabel("State : ");
        state.setFont(new Font("Raleway", Font.BOLD,20));
        state.setBounds(160,420,200,25);
        add(state);
        stateText=new JTextField();
        stateText.setBounds(335,420,300,25);
        stateText.setFont(new Font("Raleway", Font.BOLD,14));
        add(stateText);

        JLabel pinCode=new JLabel("Pincode : ");
        pinCode.setFont(new Font("Raleway", Font.BOLD,20));
        pinCode.setBounds(160,455,200,25);
        add(pinCode);
        pinCodeText=new JTextField();
        pinCodeText.setBounds(335,455,300,25);
        pinCodeText.setFont(new Font("Raleway", Font.BOLD,14));
        add(pinCodeText);

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
        if(e.getSource()==nextButton)
        {
            String formno=""+rnum;
            String name=nameText.getText();
            String father_name=fnameText.getText();
            String dob=((JTextField)dobField.getDateEditor().getUiComponent()).getText();
            String gender=null;
            if(maleField.isSelected())gender="Male";
            else gender="Female";
            String emailAddress=emailText.getText();
            String maritalStatus=null;
            if(marriedField.isSelected())maritalStatus="Married";
            else maritalStatus="Unmarried";
            String address=addressText.getText();
            String city=cityText.getText();
            String state=stateText.getText();
            String pinCode=pinCodeText.getText();

            try {
                if(name.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Name is Required");
                    return;
                }

                else
                {
                    Conn conn=new Conn();
                    String query="insert into signup values('"+formno+"','"+name+"','"+father_name+"' ,'"+dob+"' ,'"+gender+"' ,'"+emailAddress+"' ,'"+maritalStatus+"' ,'"+address+"' ,'"+city+"' ,'"+state+"' ,'"+pinCode+"')";
                    conn.s.executeUpdate(query);
                }

            }catch (Exception exception)
            {
                System.out.println(exception);
            }

            setVisible(false);
            new SignUpTwo(formno).setVisible(true);

        }
    }


}
