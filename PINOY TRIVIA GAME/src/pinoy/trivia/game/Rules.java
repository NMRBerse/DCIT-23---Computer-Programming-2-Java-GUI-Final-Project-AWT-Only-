package pinoy.trivia.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener {

    String name;
    JButton start, back;

    Rules(String name) {
        this.name = name;

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load background image
                ImageIcon backgroundImage = new ImageIcon(Login.class.getResource("/icons/rules.png"));
                Image img = backgroundImage.getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(null);
        getContentPane().add(panel);
        setSize(1240, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel heading = new JLabel("Welcome " + name + " to FILO-QUIZ GAME");
        heading.setBounds(280, 120, 800, 110);
        heading.setFont(new Font("Impact", Font.PLAIN, 50));
        heading.setForeground(new Color(143, 125, 12));
        panel.add(heading);

        JLabel rules = new JLabel();
        rules.setBounds(300, 180, 700, 350);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rules.setText(
                "<html>"
                + "Answer multiple-choice Filipino trivia questions correctly to score points." + "<br><br>"
                + "1. Each question has four answers." + "<br><br>"
                + "2. You have 15 seconds to choose an answer." + "<br><br>"
                + "3. Correct answer: 10 points." + "<br><br>"
                + "4. The game have 10 rounds." + "<br><br>"
                + "Enjoy the challenge and have fun!" + "<br><br>"
                + "<html>"
        );
        panel.add(rules);

        back = new JButton("BACK");
        back.setBounds(530, 500, 120, 40);
        back.setBackground(new Color(247, 15, 24));
        back.setForeground(new Color(255, 219, 1));
        back.setFont(new Font("Tahoma", Font.BOLD, 25));
        back.addActionListener(this);
        panel.add(back);

        start = new JButton("START");
        start.setBounds(670, 500, 120, 40);
        start.setBackground(new Color(247, 15, 24));
        start.setForeground(new Color(255, 219, 1));
        start.setFont(new Font("Tahoma", Font.BOLD, 25));
        start.addActionListener(this);
        panel.add(start);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            setVisible(false);
            new Quiz(name);
        } else {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Rules("User");
    }
}
