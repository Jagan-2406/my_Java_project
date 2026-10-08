package project;

import java.awt.Font;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
    JLabel tit, l1, l2;
    JTextField t1;
    JPasswordField p1;
    JButton b1, b2;

    Font myfont = new Font("arial", Font.BOLD, 35);

    Login() {

        setTitle("JK Application Login Form");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tit = new JLabel("Login Form");
        l1 = new JLabel("Enter Username : ");
        l2 = new JLabel("Enter Password : ");

        t1 = new JTextField();
        p1 = new JPasswordField();

        b1 = new JButton("Login/SignIn");
        b2 = new JButton("Reset");

        tit.setBounds(100, 100, 250, 50);
        l1.setBounds(100, 200, 150, 30);
        l2.setBounds(100, 250, 150, 30);

        t1.setBounds(250, 200, 150, 30);
        p1.setBounds(250, 250, 150, 30);

        b1.setBounds(250, 300, 130, 30);
        b2.setBounds(450, 300, 100, 30);
        
        b1.addActionListener(this);
        b2.addActionListener(this);

        tit.setFont(myfont);

        add(tit); add(l1); add(l2); add(t1); add(p1); add(b1); add(b2);
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Login f1 = new Login();
            f1.setSize(700, 550);
            f1.setLocationRelativeTo(null);
            f1.setVisible(true);
        });
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            char[] password = p1.getPassword();
            boolean validLogin = t1.getText().equals("JK")
                    && Arrays.equals(password, "jk@123".toCharArray());
            Arrays.fill(password, '\0');

            if (validLogin) {
                setVisible(false);
                SimpleGui window = new SimpleGui();
                window.setSize(700, 500);
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.setLocationRelativeTo(null);
                window.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid User!!!");
            }
        } else if (e.getSource() == b2) {
            t1.setText("");
            p1.setText("");
            t1.requestFocusInWindow();
        }
    }
}