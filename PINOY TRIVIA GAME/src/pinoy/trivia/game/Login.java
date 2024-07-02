package pinoy.trivia.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    JButton rules, back;
    JTextField tfname;

    Login() {
        setSize(1240, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(null) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon(Login.class.getResource("/icons/login.png"));
                Image img = backgroundImage.getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };
        setContentPane(panel);

        JLabel heading = new JLabel("PINOY TRIVIA GAME");
        heading.setBounds(250, 150, 800, 110);
        heading.setFont(new Font("Impact", Font.BOLD, 100));
        heading.setForeground(new Color(255, 219, 0));
        panel.add(heading);

        JLabel name = new JLabel("Enter your name:");
        name.setBounds(400, 300, 400, 30);
        name.setFont(new Font("Tahoma", Font.BOLD, 25));
        name.setForeground(new Color(30, 144, 254));
        panel.add(name);

        tfname = new JTextField();
        tfname.setBounds(650, 300, 200, 30);
        tfname.setFont(new Font("Tahoma", Font.BOLD, 25));
        panel.add(tfname);

        rules = new JButton("RULES");
        rules.setBounds(530, 400, 120, 40);
        rules.setBackground(new Color(247, 15, 24));
        rules.setForeground(new Color(255, 219, 1));
        rules.setFont(new Font("Tahoma", Font.BOLD, 25));
        rules.addActionListener(this);
        panel.add(rules);

        back = new JButton("BACK");
        back.setBounds(670, 400, 120, 40);
        back.setBackground(new Color(247, 15, 24));
        back.setForeground(new Color(255, 219, 1));
        back.setFont(new Font("Tahoma", Font.BOLD, 25));
        back.addActionListener(this);
        panel.add(back);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == rules) {
            String name = tfname.getText();
            setVisible(false);
            new Rules(name);
        } else if (ae.getSource() == back) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
