package pinoy.trivia.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {

    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;

    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;

    String name;

    Quiz(String name) {
        this.name = name;
        setBounds(0, 0, 1240, 700);
        getContentPane().setBackground(Color.CYAN);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(null) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon(Login.class.getResource("/icons/quiz.png"));
                Image img = backgroundImage.getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };
        setContentPane(panel);

        qno = new JLabel();
        qno.setBounds(260, 120, 50, 120);
        qno.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        qno.setForeground(new Color(255, 219, 0));
        add(qno);

        question = new JLabel();
        question.setBounds(300, 120, 900, 120);
        question.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        question.setForeground(new Color(255, 219, 0));
        add(question);

        questions[0][0] = "<html>Argentina, Chile, Colombia, Cuba, the Dominican Republic, Mexico,<br>"
                + " the Philippines, and Uruguay all use a currency with what four-letter name?</html>";
        questions[0][1] = "Yen";
        questions[0][2] = "Peso";
        questions[0][3] = "Euro";
        questions[0][4] = "Dollar";

        questions[1][0] = "<html>Filipina Lea Salonga has supplied the singing voice of two Disney <br>"
                + "princesses -- Mulan in 1998, and what princess who discovered<br>"
                + " \"A Whole New World\" in 1992's \"Aladdin?\"</html>";
        questions[1][1] = "Aurora";
        questions[1][2] = "Snow White";
        questions[1][3] = "Jasmine";
        questions[1][4] = "Anna";

        questions[2][0] = "<html>What international competition has been won by women from the Philippines<br>"
                + "on four occasions: Gloria Diaz in 1969, Margie Moran in 1971, Pia Wurtzbach in <br>"
                + "2015, and Catriona Gray in 2018?</html>";
        questions[2][1] = "Miss Universe";
        questions[2][2] = "Miss Earth";
        questions[2][3] = "Miss International";
        questions[2][4] = "Miss World";

        questions[3][0] = "<html>The flag of the Philippines is flown differently to reflect the state of<br>"
                + "the country. When the blue side is up, it’s a sign of peace. Which state <br>"
                + "is the country in when the flag is flying red side up?</html>";
        questions[3][1] = "Love";
        questions[3][2] = "War";
        questions[3][3] = "Unity";
        questions[3][4] = "Hope";

        questions[4][0] = "<html>Batad and Banaue are two of the prominent Terraces of the Philippine <br>"
                + "Cordilleras, dedicated to the irrigation and production of what food stuff?</html>";
        questions[4][1] = "Rice";
        questions[4][2] = "Fish";
        questions[4][3] = "Fruits";
        questions[4][4] = "Pork";

        questions[5][0] = "<html>A portmanteau of their last names, which moniker was given to the three <br>"
                + "priests who were falsely accused of (and executed for) treason during the <br>"
                + "El Motín de Cavite of 1872?</html>";
        questions[5][1] = "Majoha";
        questions[5][2] = "Gomburza";
        questions[5][3] = "Zaburgo";
        questions[5][4] = "GomeBurgoZamo";

        questions[6][0] = "<html>With over 1.39 billion SMS messages sent daily in the country in 2007, <br>"
                + "the Philippines has been frequently named the “text capital of the world”. <br>"
                + "The acronym “SMS” is short for what three-word texting term?</html>";
        questions[6][1] = "Super Mail System";
        questions[6][2] = "Short Mailing System";
        questions[6][3] = "Super Messaging System";
        questions[6][4] = "Short Messaging System";

        questions[7][0] = "<html>The St. Joseph Parish Church in Las Pinas, Philippines has an organ with <br>"
                + "pipes and keys made from what hollow, tubular evergreen?</html>";
        questions[7][1] = "Narra";
        questions[7][2] = "Oak";
        questions[7][3] = "Bamboo";
        questions[7][4] = "Mahogany";

        questions[8][0] = "<html>Its name meaning \"inside the walls\" in Latin, what walled area in the city <br>"
                + "of Manila is home to Fort Santiago and Manila Cathedral?</html>";
        questions[8][1] = "Intramuros";
        questions[8][2] = "Rizal Park";
        questions[8][3] = "Magellan’s Cross";
        questions[8][4] = "University of Sto. Tomas";

        questions[9][0] = "<html>What event is considered the start of the <br>"
                + "Philippine Revolution against Spanish rule?</html>";
        questions[9][1] = "The Cry of Pugad Lawin";
        questions[9][2] = "The Battle of Manila Bay";
        questions[9][3] = "The Execution of Jose Rizal";
        questions[9][4] = "The Signing of the Treaty of Paris";

        answers[0][1] = "Peso";
        answers[1][1] = "Jasmine";
        answers[2][1] = "Miss Universe";
        answers[3][1] = "War";
        answers[4][1] = "Rice";
        answers[5][1] = "Gomburza";
        answers[6][1] = "Short Messaging System";
        answers[7][1] = "Bamboo";
        answers[8][1] = "Intramuros";
        answers[9][1] = "The Cry of Pugad Lawin";

        opt1 = new JRadioButton();
        opt1.setBounds(300, 240, 500, 30);
        opt1.setOpaque(false);
        opt1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        opt1.setForeground(new Color(244, 251, 248));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(300, 280, 500, 30);
        opt2.setOpaque(false);
        opt2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        opt2.setForeground(new Color(244, 251, 248));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(300, 320, 500, 30);
        opt3.setOpaque(false);
        opt3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        opt3.setForeground(new Color(244, 251, 248));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(300, 360, 500, 30);
        opt4.setOpaque(false);
        opt4.setFont(new Font("Tahoma", Font.PLAIN, 20));
        opt4.setForeground(new Color(244, 251, 248));
        add(opt4);

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        next = new JButton("NEXT");
        next.setBounds(300, 450, 150, 40);
        next.setBackground(new Color(247, 15, 24));
        next.setForeground(new Color(255, 219, 1));
        next.setFont(new Font("Tahoma", Font.BOLD, 25));
        next.addActionListener(this);
        add(next);

        lifeline = new JButton("50-50 LIFELINE");
        lifeline.setBounds(480, 450, 250, 40);
        lifeline.setBackground(new Color(247, 15, 24));
        lifeline.setForeground(new Color(255, 219, 1));
        lifeline.setFont(new Font("Tahoma", Font.BOLD, 25));
        lifeline.addActionListener(this);
        add(lifeline);

        submit = new JButton("SUBMIT");
        submit.setBounds(760, 450, 150, 40);
        submit.setBackground(new Color(247, 15, 24));
        submit.setForeground(new Color(255, 219, 1));
        submit.setFont(new Font("Tahoma", Font.BOLD, 25));
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        start(count);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            ans_given = 1;
            if (groupoptions.getSelection() == null) {
               useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count);
        } else if (ae.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            new Score(name, score);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        String time = "Time left - " + timer + " seconds";
        g.setColor(Color.RED);
        g.setFont(new Font("Times New Roman", Font.BOLD, 25));

        if (timer > 0) {
            g.drawString(time, 500, 135);
        } else {
            g.drawString("Times up!!", 550, 135);
        }

        timer--;

        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) {
                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }

                for (int i = 0; i < useranswers.length; i++) {
                    if (useranswers[i][0].equals(answers[i][1])) {
                        score += 10;
                    } else {
                        score += 0;
                    }
                }
                setVisible(false);
                new Score(name, score);
            } else {
                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count++;
                start(count);
            }
        }

    }

    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        groupoptions.clearSelection();
    }

    public static void main(String[] args) {
        new Quiz("User");
    }
}