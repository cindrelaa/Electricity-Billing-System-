package electricity.billing.system;


import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class newCustomer extends JFrame implements ActionListener  {
    JLabel heading ,meternumText,customerName,meterNum, address,city,state,email,phone;
    JButton next, cancel;
    TextField nameText, addressText, cityText, stateText ,emailText,phoneText;
    newCustomer()
    {   super("New Customer");
        setSize(700,500);
        setLocation(400,200);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(75,0,130));
        add(panel);

        heading = new JLabel("NEW CUSTOMER");
        heading.setBounds(180,10,200,20);
        heading.setFont(new Font("Open Sans",Font.BOLD,20));
        heading.setForeground(new Color(255, 255, 255));
        panel.add(heading);

        customerName = new JLabel("New Customer");
        customerName.setBounds(50,80,100,20);
        customerName.setForeground(new Color(255, 255, 255));
        panel.add(customerName);

        nameText = new TextField();
        nameText.setBounds(180,80,150,20);
        panel.add(nameText);

        meterNum = new JLabel("Meter Number");
        meterNum.setBounds(50,120,100,20);
        meterNum.setForeground(new Color(255, 255, 255));
        panel.add(meterNum);

        meternumText = new JLabel("");
        meternumText.setBounds(180,120,150,20);
        meternumText.setForeground(new Color(255, 255, 255));
        panel.add( meternumText);

        Random ran = new Random();
        long number = ran.nextLong() % 1000000;
        meternumText.setText(""+ Math.abs(number) );

        address = new JLabel("Address ");
        address.setBounds(50,160,100,20);
        address.setForeground(new Color(255, 255, 255));
        panel.add(address);

        addressText = new TextField();
        addressText.setBounds(180,160,150,20);
        panel.add(addressText);

        city = new JLabel("City ");
        city.setBounds(50,200,100,20);
        city.setForeground(new Color(255, 255, 255));
        panel.add(city);

        cityText = new TextField();
        cityText.setBounds(180,200,150,20);
        panel.add(cityText);

        state = new JLabel("State ");
        state.setBounds(50,240,100,20);
        state.setForeground(new Color(255, 255, 255));
        panel.add(state);

        stateText = new TextField();
        stateText.setBounds(180,240,150,20);
        panel.add(stateText);

        email = new JLabel("Email ");
        email.setBounds(50,280,100,20);
        email.setForeground(new Color(255, 255, 255));
        panel.add(email);

        emailText = new TextField();
        emailText.setBounds(180,280,150,20);
        panel.add(emailText);

        phone = new JLabel("Phone ");
        phone.setBounds(50,320,100,20);
        phone.setForeground(new Color(255, 255, 255));
        panel.add(phone);

        phoneText = new TextField();
        phoneText.setBounds(180,320,150,20);
        panel.add(phoneText);


        next = new JButton("Next");
        next.setBounds(120,390,100,25);
        next.setBackground(Color.white);
        next.setForeground(Color.black);
        next.addActionListener(this);
        panel.add(next);

        cancel = new JButton("Cancel");
        cancel.setBounds(230,390,100,25);
        cancel.setBackground(Color.white);
        cancel.setForeground(Color.black);
        cancel.addActionListener(this);
        panel.add(cancel);

        setLayout(new BorderLayout());
        add(panel,"Center");
        setVisible(true);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/boyx.png"));
        Image i2 = i1.getImage().getScaledInstance(230,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel imgLable = new JLabel(i3);
        add(imgLable,"West");







    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==next){
            String sname = nameText.getText();
            String smeter = meternumText.getText();
            String saddress = addressText.getText();
            String scity = cityText.getText();
            String sstate = stateText.getText();
            String eemail = emailText.getText();
            String sphone = phoneText.getText();


            String query_customer = "insert into new_customer values('"+sname+"','"+smeter+"','"+saddress+"','"+scity+"','"+sstate+"','"+eemail+"','"+sphone+"')";
            String query_signup = "insert into Signup values('"+smeter+"','','"+sname+"','','')";

            try{
                database c = new database();
                c.statement.executeUpdate(query_customer);
                c.statement.executeUpdate(query_signup);

                JOptionPane.showMessageDialog(null,"Customer details added successfully");
                setVisible(false);
                new meterInfo(smeter);
            }catch (Exception E){
                E.printStackTrace();
            }


        }

        else
        {
            setVisible(false);
        }

    }
    public static void main(String[] args)
    {
        new newCustomer();

    }
}
