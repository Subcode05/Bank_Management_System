import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountDetails extends JFrame implements ActionListener
{
    JButton submit,cancel;
    JRadioButton savings,fd,currentac,rd;
    JCheckBox atmcard,internetb,mobileb,alert,check,statement,oath;

    public AccountDetails()
    {
        JLabel header=new JLabel("Page 3: Account Details");
        header.setBounds(170,20,500,50);
        header.setFont(new Font("Raleway",Font.BOLD,20));
        add(header);

        JLabel acctype=new JLabel("Account Type:");
        acctype.setBounds(50,80,200,30);
        acctype.setFont(new Font("Raleway",Font.BOLD,17));
        add(acctype);
        savings=new JRadioButton("Savings Account");
        savings.setBounds(50,110,170,30);
        savings.setBackground(Color.WHITE);
        add(savings);
        fd=new JRadioButton("Fixed Deposit Account");
        fd.setBounds(220,110,170,30);
        fd.setBackground(Color.WHITE);
        add(fd);
        currentac=new JRadioButton("Current Account");
        currentac.setBounds(50,140,170,30);
        currentac.setBackground(Color.WHITE);
        add(currentac);
        rd=new JRadioButton("Recurring Deposit Account");
        rd.setBounds(220,140,190,30);
        rd.setBackground(Color.WHITE);
        add(rd);
        ButtonGroup ac=new ButtonGroup();
        ac.add(rd);
        ac.add(currentac);
        ac.add(fd);
        ac.add(savings);


        JLabel cardno=new JLabel("Card Number:");
        cardno.setBounds(50,190,200,30);
        cardno.setFont(new Font("Raleway",Font.BOLD,17));
        add(cardno);
        JLabel instruct=new JLabel("Your 16 Digit Card Number");
        instruct.setBounds(50,210,200,30);
        instruct.setFont(new Font("Raleway",Font.BOLD,9));
        add(instruct);

        JLabel pin=new JLabel("PIN:");
        pin.setBounds(50,260,200,30);
        pin.setFont(new Font("Raleway",Font.BOLD,17));
        add(pin);
        JLabel instructp=new JLabel("Your 4 Digit Password");
        instructp.setBounds(50,280,200,30);
        instructp.setFont(new Font("Raleway",Font.BOLD,9));
        add(instructp);

        JLabel sevice=new JLabel("Services Required:");
        sevice.setBounds(50,330,200,30);
        sevice.setFont(new Font("Raleway",Font.BOLD,17));
        add(sevice);
        atmcard=new JCheckBox("ATM Card");
        atmcard.setBounds(50,360,100,30);
        atmcard.setBackground(Color.WHITE);
        add(atmcard);
        internetb=new JCheckBox("Internet Banking");
        internetb.setBounds(220,360,150,30);
        internetb.setBackground(Color.WHITE);
        add(internetb);
        mobileb=new JCheckBox("Mobile Banking");
        mobileb.setBounds(50,390,150,30);
        mobileb.setBackground(Color.WHITE);
        add(mobileb);
        alert=new JCheckBox("Email & SMS Alert");
        alert.setBounds(220,390,200,30);
        alert.setBackground(Color.WHITE);
        add(alert);
        check=new JCheckBox("Check Book");
        check.setBounds(50,420,100,30);
        check.setBackground(Color.WHITE);
        add(check);
        statement=new JCheckBox("E-Statement");
        statement.setBounds(220,420,100,30);
        statement.setBackground(Color.WHITE);
        add(statement);

        oath=new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.");
        oath.setBounds(70,470,570,30);
//      oath.setSize(5,5);
        oath.setFont(new Font("Raleway",Font.BOLD,9));
        oath.setBackground(Color.WHITE);
        add(oath);


        cancel=new JButton("Cancel");
        cancel.addActionListener(this);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setBounds(120,520,100,30);
        add(cancel);

        submit=new JButton("Submit");
        submit.addActionListener(this);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setBounds(350,520,100,30);
        add(submit);



        setLayout(null);
        setVisible(true);
        setSize(580,650);
        setLocation(480,80);
        getContentPane().setBackground(Color.WHITE);

    }


    public void actionPerformed(ActionEvent ae)
    {
        try{
            if (ae.getSource()==submit)
            {
                String account_type=null;
                if(savings.isSelected())
                {
                    account_type="Savings Account";
                }

            } else if (ae.getSource()==cancel) {

            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }


    public static void main(String[] args)
    {
        new AccountDetails();
    }
}
