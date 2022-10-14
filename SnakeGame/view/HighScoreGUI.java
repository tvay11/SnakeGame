package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class HighScoreGUI extends JFrame implements ActionListener {
    JFrame mainFrame;
    JPanel mainPanel;
    JLabel title;
    JButton optionButton;
    JLabel scoreText;

    public HighScoreGUI() throws FileNotFoundException {
        this.mainFrame = new JFrame("High scores");
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainPanel = new JPanel();
        this.mainPanel.setPreferredSize(new Dimension(1000, 800));
        this.mainPanel.setLayout(null);
        this.mainPanel.setBackground(Color.black);
        File file = new File("Highscore.txt");
        Scanner scan = new Scanner(file);
        ArrayList<Integer> scores = new ArrayList<Integer>();
        while (scan.hasNext()) {
            scores.add(scan.nextInt());
        }

        Collections.sort(scores);
        Collections.reverse(scores);
        Font scorefont = new Font("Monospaced", Font.BOLD + Font.ITALIC, 30);
        int k = 75;
        int count = 0;
        for (int a : scores) {
            k += 25;
            count += 1;
            this.scoreText = new JLabel(count + ". " + a);
            this.scoreText.setBounds(500 - 150, k, 500, 300);
            this.scoreText.setFont(scorefont);
            this.scoreText.setForeground(Color.white);
            this.mainPanel.add(this.scoreText);
            if (count == 5) {
                break;
            }
        }

        this.title = new JLabel("High Scores");
        this.title.setBounds(500 - 150, 0, 500, 300);
        Font titleFont = new Font("Monospaced", Font.BOLD + Font.ITALIC, 50);
        this.title.setForeground(Color.WHITE);
        this.title.setFont(titleFont);
        this.mainPanel.add(this.title);
        this.optionButton = new JButton("Menu");
        this.optionButton.addActionListener(this);
        this.optionButton.setBounds(500 - 120 / 2, 600, 150, 75);
        this.optionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new MenuGUI();
                mainFrame.setVisible(false);
            }
        });

        this.mainPanel.add(this.optionButton);
        this.mainFrame.add(this.mainPanel);
        this.mainFrame.pack();
        this.mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //DO NOTHING
    }
}
