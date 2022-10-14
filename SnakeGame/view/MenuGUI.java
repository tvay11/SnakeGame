package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;


public class MenuGUI extends JFrame implements ActionListener{
    JFrame mainFrame;
    JPanel mainPanel;
    JButton playButton;
    JLabel title;
    JButton highScore;
    int Buttonwidth;
    int Buttonheight;
    int boardWidth;
    int boardHeight;


    public MenuGUI() {
        this.boardHeight=800;
        this.boardWidth=1000;
        this.Buttonheight=75;
        this.Buttonwidth=150;
        this.mainFrame = new JFrame("Menu");
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainPanel = new JPanel();
        this.mainPanel.setPreferredSize(new Dimension(1000, 800));
        this.mainPanel.setLayout(null);
        this.mainPanel.setBackground(Color.BLACK);
        this.title = new JLabel("Snake");
        this.title.setBounds(400, 50, 300, 300);
        Font titleFont = new Font("Monospaced", Font.BOLD + Font.ITALIC, 70);
        this.title.setFont(titleFont);
        this.title.setForeground(Color.WHITE);
        this.mainPanel.add(this.title);
        this.playButton = new JButton("Play");
        this.playButton.addActionListener(this);
        this.playButton.setBounds(500 - Buttonwidth / 2, 350, Buttonwidth, Buttonheight);
        this.playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new OptionGUI();
                mainFrame.setVisible(false);
            }
        });

        this.mainPanel.add(this.playButton);
        this.highScore = new JButton("High scores");
        this.highScore.addActionListener(this);
        this.highScore.setBounds(500 - Buttonwidth / 2, 500, Buttonwidth, Buttonheight);
        this.highScore.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new HighScoreGUI();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                mainFrame.setVisible(false);
            }
        });

        this.mainPanel.add(this.highScore);
        this.mainFrame.add(this.mainPanel);
        this.mainFrame.pack();
        this.mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //
    }
}



