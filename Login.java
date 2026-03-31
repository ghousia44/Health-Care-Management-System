package healthcare.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Login extends JFrame implements ActionListener {
    JTextField textField;
    JPasswordField jPasswordField;
    JButton b1, b2;

    Login() {
        JLabel nameLabel = new JLabel("Username :");
        nameLabel.setBounds(40, 20, 100, 30);
        nameLabel.setFont(new Font("tahoma", Font.BOLD, 17));
        nameLabel.setForeground(Color.BLACK);
        add(nameLabel);

        JLabel password = new JLabel("Password :");
        password.setBounds(40, 70, 100, 30);
        password.setFont(new Font("tahoma", Font.BOLD, 17));
        password.setForeground(Color.BLACK);
        add(password);

        textField = new JTextField();
        textField.setBounds(150, 20, 150, 30);
        textField.setFont(new Font("tahoma", Font.PLAIN, 15));
        textField.setBackground(new Color(127, 154, 198));
        add(textField);

        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(150, 70, 150, 30);
        jPasswordField.setFont(new Font("tahoma", Font.PLAIN, 15));
        jPasswordField.setBackground(new Color(127, 154, 198));
        add(jPasswordField);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/logo.png"));
        Image i1 = imageIcon.getImage().getScaledInstance(470, 500, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(300, -40, 500, 500);
        add(label);

        b1 = new JButton("Login");
        b1.setBounds(40, 140, 120, 30);
        b1.setFont(new Font("serif", Font.BOLD, 17));
        b1.setBackground(Color.YELLOW);
        b1.setForeground(Color.RED);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(180, 140, 120, 30);
        b2.setFont(new Font("serif", Font.BOLD, 17));
        b2.setBackground(Color.YELLOW);
        b2.setForeground(Color.RED);
        add(b2);
        add(b1);
        b1.addActionListener(this);
        add(b2);
        b2.addActionListener(this);


        getContentPane().setBackground(new Color(255, 255, 255));
        setSize(800, 400);
        setLocation(400, 270);
        setTitle("Health Care Management System");
        setLayout(null);
        setResizable(false);
        setVisible(true);
    }


    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        String username = textField.getText();
        String password = new String(jPasswordField.getPassword());

        if (e.getSource() == b1) {
            if (username.equals("admin") && password.equals("1234")) {
                JOptionPane.showMessageDialog(this, "Login Successful");

                // Open Dashboard
                new Dashboard();

                // Close Login Window
                this.setVisible(false);

            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
        }
        if (e.getSource() == b2) {
            textField.setText("");
            jPasswordField.setText("");
        }
    }
}



