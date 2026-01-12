import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.toedter.calendar.JDateChooser;
import java.util.Random;


public class SignupOne extends JFrame implements ActionListener
{
    long random;
    JTextField nameField,fnameField,emailField,addrField,city_villField,stateField,pinField;
    JButton next;
    JRadioButton gender_b,gender_f,gender_o;
    JComboBox sts;
    JDateChooser dobj;


    SignupOne()
    {
        setLayout(null);

        Random ran=new Random();
        random=Math.abs((ran.nextLong() % 9000L)+1000L);

        JLabel header=new JLabel("APLICATION FORM NO. "+random);
        header.setBounds(175,50,400,30);
        header.setFont(new Font("Osward" ,Font.BOLD,20));
        add(header);

        JLabel name=new JLabel("Name:");
        name.setFont(new Font("Raleway" ,Font.BOLD,15));
        name.setBounds(70,100,100,30);
        add(name);
        nameField=new JTextField();
        nameField.setBounds(200,100,300,30);
        add(nameField);


        JLabel fname=new JLabel("Father's Name:");
        fname.setFont(new Font("Osward" ,Font.BOLD,15));
        fname.setBounds(70,150,150,30);
        add(fname);
        fnameField=new JTextField();
        fnameField.setBounds(200,150,300,30);
        add(fnameField);

        JLabel dob=new JLabel("Date of Birth:");
        dob.setFont(new Font("Osward" ,Font.BOLD,15));
        dob.setBounds(70,200,150,30);
        add(dob);
        dobj=new JDateChooser();
        dobj.setBounds(200,200,300,30);
        add(dobj);




        JLabel gender=new JLabel("Gender:");
        gender.setFont(new Font("Osward" ,Font.BOLD,15));
        gender.setBounds(70,250,100,30);
        add(gender);

        JLabel email=new JLabel("Email ID:");
        email.setFont(new Font("Osward" ,Font.BOLD,15));
        email.setBounds(70,300,100,30);
        add(email);
        emailField=new JTextField();
        emailField.setBounds(200,300,300,30);
        add(emailField);

        JLabel marital=new JLabel("Marital Status:");
        marital.setFont(new Font("Osward" ,Font.BOLD,15));
        marital.setBounds(70,350,150,30);
        add(marital);

        sts=new JComboBox<>(new String[]{"","Single","Married","Divorced","Widowed"});
        sts.setBounds(200,350,300,30);
        sts.setBackground(Color.WHITE);
        add(sts);
        //also can add text item or options like this***
//       sts.addItem("Single");
//       sts.addItem("Married");

        JLabel address=new JLabel("Address:");
        address.setFont(new Font("Osward" ,Font.BOLD,15));
        address.setBounds(70,400,100,30);
        add(address);
        addrField=new JTextField();
        addrField.setBounds(200,400,300,30);
        add(addrField);

        JLabel city_vill=new JLabel("City/Village:");
        city_vill.setFont(new Font("Osward" ,Font.BOLD,15));
        city_vill.setBounds(70,450,100,30);
        add(city_vill);
        city_villField=new JTextField();
        city_villField.setBounds(200,450,300,30);
        add(city_villField);

        JLabel state=new JLabel("State:");
        state.setFont(new Font("Osward" ,Font.BOLD,15));
        state.setBounds(70,500,100,30);
        add(state);
        stateField=new JTextField();
        stateField.setBounds(200,500,300,30);
        add(stateField);

        JLabel pinCode=new JLabel("Pin Code:");
        pinCode.setFont(new Font("Osward" ,Font.BOLD,15));
        pinCode.setBounds(70,550,100,30);
        add(pinCode);
        pinField=new JTextField();
        pinField.setBounds(200,550,300,30);
        add(pinField);

        gender_b=new JRadioButton("Male");
        gender_b.setBounds(200,250,100,30);
        gender_b.setFont(new Font("Osward" ,Font.BOLD,15));
        gender_b.setBackground(Color.WHITE);
        add(gender_b);

        gender_f=new JRadioButton("Female");
        gender_f.setBounds(300,250,100,30);
        gender_f.setFont(new Font("Osward" ,Font.BOLD,15));
        gender_f.setBackground(Color.WHITE);
        add(gender_f);

        gender_o=new JRadioButton("Others");
        gender_o.setBounds(400,250,100,30);
        gender_o.setFont(new Font("Osward" ,Font.BOLD,15));
        gender_o.setBackground(Color.WHITE);
        add(gender_o);

        ButtonGroup gen3=new ButtonGroup();
        gen3.add(gender_b);
        gen3.add(gender_f);
        gen3.add(gender_o);

        next=new JButton("Next");
        next.setBounds(270,600,90,30);
        next.setBackground(Color.BLACK);//for the button color
        next.setForeground(Color.WHITE);//for the text color
        next.addActionListener(this);
        add(next);


        setTitle("Form:1");
        setVisible(true);
        setSize(650,700);
        setLocation(430,80);
        getContentPane().setBackground(Color.white);
    }

    public void actionPerformed(ActionEvent ae)
    {
//      String v=Long.toString(random);
        String formno=""+random;
        String name=nameField.getText();
        String fname=fnameField.getText();
        String dob=((JTextField)dobj.getDateEditor().getUiComponent()).getText();//***** typecasting to text field to extract text.*****
        String gender=null;
        if (gender_b.isSelected())
        {
            gender="Male";
        } else if (gender_f.isSelected())
        {
            gender="Female";
        }else
        {
            gender="Others";
        }

        String mstatus=(String)sts.getSelectedItem();
        String email=emailField.getText();
        String addr=addrField.getText();
        String cityvill=city_villField.getText();
        String state=stateField.getText();
        String pin=pinField.getText();

        try
        {
            if(name.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Name is Required");
            }else
            {
                Connect c=new Connect();
                String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+mstatus+"','"+email+"','"+addr+"','"+cityvill+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupTwo(formno);
            }

        }catch(Exception e)
        {
            System.out.println(e);
        }

    }

    public static void main(String[] args)
    {
            new SignupOne();
    }
}
