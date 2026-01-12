import javax.swing.*; //Jframe creates frame
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener
{
    JButton login,clean,signUp;
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login()
    {
        setTitle("ATM");

        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2); //image to imageicon kind if like type casting
        JLabel label=new JLabel(i3);
        label.setBounds(200,10,100,100);
        add(label);

        getContentPane().setBackground(Color.WHITE);//color of the frame background

        JLabel label1=new JLabel("Bank of India");
        label1.setFont(new Font("Osward",Font.BOLD,36));
        label1.setBounds(300,40,400,40);
        add(label1);

        JLabel cardNo=new JLabel("Card No:");
        cardNo.setFont(new Font("Osward",Font.BOLD,28));
        cardNo.setBounds(150,150,200,40);
        add(cardNo);
        cardTextField=new JTextField();
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        cardTextField.setBounds(300,150,350,40);
        add(cardTextField);

        JLabel pin=new JLabel("Pin:");
        pin.setFont(new Font("Osward",Font.BOLD,28));
        pin.setBounds(150,200,200,40);
        add(pin);
        pinTextField=new JPasswordField();
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        pinTextField.setBounds(300,200,350,40);
        add(pinTextField);

        login=new JButton("Sign In");
        login.setBounds(175,275,200,35);
        add(login);
        login.addActionListener(this);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);

        clean =new JButton("Clear");
        clean.setBounds(425,275,200,35);
        add(clean);
        clean.addActionListener(this);
        clean.setBackground(Color.BLACK);
        clean.setForeground(Color.WHITE);

        signUp=new JButton("Sign Up");
        signUp.setBounds(200,350,400,35);
        add(signUp);
        signUp.addActionListener(this);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);

        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    public  void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==clean)
        {
            cardTextField.setText(null);
        } else if (ae.getSource()==login) {

        } else if (ae.getSource()==signUp) {
            setVisible(false);
            new SignupOne();
        }
    }

    public static void main(String[] args)
    {
        new Login();
    }
}


