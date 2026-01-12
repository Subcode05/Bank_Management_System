import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupTwo extends JFrame implements ActionListener
{
    JTextField pan, adhar;
    JRadioButton syes,sno,yes,no;
    JComboBox categorybox,reli,incomebox,educationbox,occupationbox;
    JButton next;
    String formno;

     public SignupTwo(String formno)
    {
        this.formno=formno;

        JLabel header=new JLabel("APLICATION FORM NO : 2");
        header.setBounds(175,50,400,30);
        header.setFont(new Font("Osward" ,Font.BOLD,20));
        add(header);

        JLabel rel=new JLabel("Religion:");
        rel.setFont(new Font("Raleway" ,Font.BOLD,15));
        rel.setBounds(70,100,100,30);
        add(rel);
        reli=new JComboBox<>(new String[]{"","Hindu","Jain","Buddhist"});
        reli.setBackground(Color.WHITE);
        add(reli);
        reli.setBounds(170,100,300,30);

        JLabel category=new JLabel("Category:");
        category.setFont(new Font("Raleway" ,Font.BOLD,15));
        category.setBounds(70,150,100,30);
        add(category);
        categorybox=new JComboBox<>(new String[]{"",});
        categorybox.setBackground(Color.WHITE);
        add(categorybox);
        categorybox.setBounds(170,150,300,30);

        JLabel income=new JLabel("Income:");
        income.setFont(new Font("Raleway" ,Font.BOLD,15));
        income.setBounds(70,200,100,30);
        add(income);
        incomebox=new JComboBox<>(new String[]{"",});
        incomebox.setBackground(Color.WHITE);
        add(incomebox);
        incomebox.setBounds(170,200,300,30);

        JLabel educational=new JLabel("<html>Educational<br>Qualification:");
        educational.setFont(new Font("Raleway" ,Font.BOLD,15));
        educational.setBounds(70,250,200,50);
        add(educational);
        educationbox=new JComboBox<>(new String[]{"",});
        educationbox.setBackground(Color.WHITE);
        add(educationbox);
        educationbox.setBounds(170,270,300,30);

        JLabel occupation=new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway" ,Font.BOLD,15));
        occupation.setBounds(70,320,100,30);
        add(occupation);
        occupationbox=new JComboBox<>(new String[]{"",});
        occupationbox.setBackground(Color.WHITE);
        add(occupationbox);
        occupationbox.setBounds(170,320,300,30);

        JLabel panno=new JLabel("PAN No:");
        panno.setFont(new Font("Raleway" ,Font.BOLD,15));
        panno.setBounds(70,370,100,30);
        add(panno);
        pan=new JTextField();
        pan.setFont(new Font("Raleway" ,Font.BOLD,15));
        pan.setBounds(170,370,300,30);
        add(pan);


        JLabel adharno=new JLabel("Aadhar No:");
        adharno.setFont(new Font("Raleway" ,Font.BOLD,15));
        adharno.setBounds(70,420,100,30);
        add(adharno);
        adhar=new JTextField();
        adhar.setFont(new Font("Raleway" ,Font.BOLD,15));
        adhar.setBounds(170,420,300,30);
        add(adhar);

        JLabel senior=new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway" ,Font.BOLD,15));
        senior.setBounds(70,470,150,30);
        add(senior);

        syes = new JRadioButton("Yes");
        syes.setBounds(230,470,50,30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(380,470,50,30);
        sno.setBackground(Color.WHITE);
        add(sno);

        JLabel ea=new JLabel("Existing Account:");
        ea.setFont(new Font("Raleway" ,Font.BOLD,15));
        ea.setBounds(70,520,150,30);
        add(ea);

        yes = new JRadioButton("Yes");
        yes.setBounds(230,520,50,30);
        yes.setBackground(Color.WHITE);
        add(yes);

        no = new JRadioButton("No");
        no.setBounds(380,520,50,30);
        no.setBackground(Color.WHITE);
        add(no);

        ButtonGroup b=new ButtonGroup();
        b.add(no);
        b.add(yes);

        ButtonGroup c=new ButtonGroup();
        c.add(sno);
        c.add(syes);


        next=new JButton("Next");
        next.setForeground(Color.white);
        next.setBackground(Color.black);
        next.setBounds(270,600,90,30);
        next.addActionListener(this);
        add(next);

//        JCheckBoxMenuItem v= new JCheckBoxMenuItem("join");
//        v.setBounds(170,150,300,30);
//        add(v);


        setLayout(null);
        setTitle("Form:2");
        setVisible(true);
        setSize(650,700);
        setLocation(430,80);
        getContentPane().setBackground(Color.white);

    }

    public void actionPerformed(ActionEvent ae)
    {
        String religions=(String) reli.getSelectedItem();
        String categorys=(String) categorybox.getSelectedItem();
        String incomes=(String)incomebox.getSelectedItem();
        String occupations=(String)occupationbox.getSelectedItem();
        String educations=(String)educationbox.getSelectedItem();
        String pans=pan.getText();
        String adhars=adhar.getText();
        String senior=null;
        String prevacc=null;

        if(syes.isSelected())
        {
            senior="Yes";
        }else {
            senior="No";
        }

        if(yes.isSelected())
        {
            prevacc="Yes";
        }else{
            prevacc="No";
        }

        try{
            if(religions.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Religion is Required");
            }else
            {
                Connect c=new Connect();
                String query="insert into signuptwo values('"+formno+"','"+religions+"','"+categorys+"','"+incomes+"','"+educations+"','"+occupations+"','"+pans+"','"+adhars+"','"+senior+"','"+prevacc+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new AccountDetails();
            }

        }catch(Exception e)
        {
            System.out.println(e);
        }



    }

    public static void main(String[] args)
    {
        new SignupTwo("");
    }
}
