package Bank_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SignUpThree extends JFrame  implements ActionListener{
    JButton submitButton,cancelButton;
    JRadioButton savingsAccount,currentAccount,recurringDepositAccount,fixedDepositAccount;
    ButtonGroup account_Type;
    String formno,card_Number,pin_Number;
    JCheckBox atmCard,internetBanking,mobileBanking,emailandSMS,estatement,chequeBook,declaration;
    SignUpThree(String formno,String card_Number,String pin_Number)
    {
        this.formno=formno;
        this.card_Number=card_Number;
        this.pin_Number=pin_Number;

        setTitle("New Account Application Form - Page 2");
        JLabel accountDetails=new JLabel("Page 3 : Account Details");
        accountDetails.setFont(new Font("Raleway", Font.BOLD,22));
        accountDetails.setBounds(275,90,500,25);
        add(accountDetails);

        JLabel accountType=new JLabel("Account Type : ");
        accountType.setFont(new Font("Raleway", Font.BOLD,20));
        accountType.setBounds(120,140,200,25);
        add(accountType);

        savingsAccount=new JRadioButton("Savings Account");
        savingsAccount.setBounds(120,170,200,25);
        add(savingsAccount);

        fixedDepositAccount=new JRadioButton("Fixed Deposit Account");
        fixedDepositAccount.setBounds(350,170,200,25);
        add(fixedDepositAccount);

        currentAccount=new JRadioButton("Current Account");
        currentAccount.setBounds(120,200,200,25);
        add(currentAccount);

        recurringDepositAccount=new JRadioButton("Recurring Deposit Account");
        recurringDepositAccount.setBounds(350,200,200,25);
        add(recurringDepositAccount);

        account_Type=new ButtonGroup();
        account_Type.add(savingsAccount);
        account_Type.add(currentAccount);
        account_Type.add(recurringDepositAccount);
        account_Type.add(fixedDepositAccount);

        JLabel cardNumber=new JLabel("Card Number : ");
        cardNumber.setFont(new Font("Raleway", Font.BOLD,20));
        cardNumber.setBounds(120,250,200,20);
        add(cardNumber);

        JLabel cardNumberText=new JLabel("Your 16 digit card number ");
        cardNumberText.setFont(new Font("Raleway", Font.BOLD,10));
        cardNumberText.setBounds(120,270,200,25);
        add(cardNumberText);

        JLabel cardNumberActual=new JLabel("XXXX-XXXX-XXXX-"+this.card_Number.substring(12,16));
        cardNumberActual.setFont(new Font("Raleway", Font.BOLD,20));
        cardNumberActual.setBounds(310,260,300,25);
        add(cardNumberActual);

        JLabel pinNumber=new JLabel("Pin : ");
        pinNumber.setFont(new Font("Raleway", Font.BOLD,20));
        pinNumber.setBounds(120,330,200,20);
        add(pinNumber);

        JLabel pinNumberText=new JLabel("Your 4 digit password ");
        pinNumberText.setFont(new Font("Raleway", Font.BOLD,10));
        pinNumberText.setBounds(120,350,200,25);
        add(pinNumberText);

        JLabel pinNumberActual=new JLabel("XXXX");
        pinNumberActual.setFont(new Font("Raleway", Font.BOLD,20));
        pinNumberActual.setBounds(310,340,300,25);
        add(pinNumberActual);

        JLabel servicesRequired=new JLabel("Services Required : ");
        servicesRequired.setFont(new Font("Raleway", Font.BOLD,20));
        servicesRequired.setBounds(120,410,200,20);
        add(servicesRequired);

        atmCard=new JCheckBox("ATM Card");
        atmCard.setBounds(120,450,200,20);
        add(atmCard);

        mobileBanking=new JCheckBox("Mobile Banking");
        mobileBanking.setBounds(120,490,200,20);
        add(mobileBanking);

        chequeBook=new JCheckBox("Cheque Book");
        chequeBook.setBounds(120,530,200,20);
        add(chequeBook);

        internetBanking=new JCheckBox("Internet Banking");
        internetBanking.setBounds(350,450,200,20);
        add(internetBanking);

        emailandSMS=new JCheckBox("Email and SMS Alerts");
        emailandSMS.setBounds(350,490,200,20);
        add(emailandSMS);

        estatement=new JCheckBox("E-Statement");
        estatement.setBounds(350,530,200,20);
        add(estatement);

        declaration=new JCheckBox("I hereby declare that all the details entered are correct to the best of my knowledge");
        declaration.setBounds(120,600,500,20);
        add(declaration);


        submitButton=new JButton("Submit");
        submitButton.setForeground(Color.WHITE);
        submitButton.setBackground(Color.BLACK);
        submitButton.setBounds(180,650,100,25);
        add(submitButton);
        submitButton.addActionListener(this);

        cancelButton=new JButton("Cancel");
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setBounds(450,650,100,25);
        add(cancelButton);
        cancelButton.addActionListener(this);

        setLayout(null);
        setSize(850,800);
        setLocation(500,150);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            if(!declaration.isSelected()){
                JOptionPane.showMessageDialog(null,"Declaration is Required");
                return;
            }
            String accountType=null;
            if(savingsAccount.isSelected())accountType="Savings Account";
            else if(fixedDepositAccount.isSelected())accountType="Fixed Deposit Account";
            else if(currentAccount.isSelected())accountType="Current Account";
            else if(recurringDepositAccount.isSelected())accountType="Recurring Deposit Account";

            String cardNumber=card_Number;
            String pin=pin_Number;

            String services_list="";
            if(atmCard.isSelected())services_list=services_list+"ATM Card-";
            if(mobileBanking.isSelected())services_list=services_list+"Mobile Banking-";
            if(emailandSMS.isSelected())services_list=services_list+"Email and SMS Alerts-";
            if(estatement.isSelected())services_list=services_list+"E-Statement-";
            if(chequeBook.isSelected())services_list=services_list+"Cheque Book-";
            if(internetBanking.isSelected())services_list=services_list+"Internet Banking-";


            try {
                Conn conn = new Conn();
                String query = "insert into signupthree values('"+formno+"','"+ accountType + "','" + cardNumber + "','" + pin + "' ,'" + services_list + "')";
                String query2 = "insert into login values('"+formno+"','" + cardNumber + "','" + pin + "')";
                String query3= "insert into bank values('"+cardNumber+"',0)";
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
            } catch (Exception exception) {
                System.out.println(exception);
            }
        }
        JOptionPane.showMessageDialog(null,"Card Number : "+card_Number+ "\n Pin : "+pin_Number);
        setVisible(false);
        new Login().setVisible(true);
    }


}
