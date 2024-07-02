package pinoy.trivia.game;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {

    Score(String name, int score) {
        setSize(1240, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(null) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon(Login.class.getResource("/icons/score.png"));
                Image img = backgroundImage.getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };
        setContentPane(panel);

        JLabel heading = new JLabel("Thank you " + name + " for playing FILO-QUIZ GAME");
        heading.setBounds(350, 300, 700, 70);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(heading);

        JLabel lblscore = new JLabel("Your score is " + score);
        lblscore.setBounds(480, 400, 600, 50);
        lblscore.setFont(new Font("Tahoma", Font.BOLD, 40));
        lblscore.setForeground(new Color(255, 219, 0));
        add(lblscore);

        JButton submit = new JButton("PLAY AGAIN");
        submit.setBounds(530, 480, 200, 40);
        submit.setBackground(new Color(247, 15, 24));
        submit.setForeground(new Color(255, 219, 1));
        submit.setFont(new Font("Tahoma", Font.BOLD, 25));
        submit.addActionListener(this);
        add(submit);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new Score("User", 0);
    }
}
