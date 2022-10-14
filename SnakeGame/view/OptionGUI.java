package view;

import controller.SnakeController;
import model.SnakeModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionGUI {
    JFrame mainFrame;
    JPanel mainPanel;
    JLabel title;
    JButton optionButton1;
    JButton optionButton2;
    JButton optionButton3;
    JButton optionButton4;
    int height;
    int width;

    public OptionGUI() {
        this.width = 1000;
        this.height = (int) (width * .8);
        SnakeModel snakeModel = new SnakeModel();
        GameGUI gameGUI = new GameGUI();
        this.mainFrame = new JFrame("Options");
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainPanel = new JPanel();
        this.mainPanel.setPreferredSize(new Dimension(1000, 800));
        this.mainPanel.setLayout(null);
        this.mainPanel.setBackground(Color.BLACK);

        this.title = new JLabel("Difficulty");
        this.title.setBounds(300, 0, 500, 300);
        Font titleFont = new Font("Monospaced", Font.BOLD + Font.ITALIC, 70);
        this.title.setFont(titleFont);
        this.title.setForeground(Color.WHITE);
        this.mainPanel.add(this.title);
        this.optionButton1 = new JButton("Easy");
        this.optionButton1.setBounds(300, 300, 100, 100);
        this.optionButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame newFrame = new JFrame("Snake");
                newFrame.setSize(width, (int) (width * .8));
                newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                newFrame.getContentPane().add(gameGUI);
                newFrame.setVisible(true);
                SnakeController snakeController = new SnakeController(snakeModel, 250, gameGUI);

                newFrame.addKeyListener(snakeController);
                newFrame.pack();
                snakeController.startNewGame();
                mainFrame.setVisible(false);
            }
        });

        this.mainPanel.add(this.optionButton1);
        this.optionButton2 = new JButton("Medium");
        this.optionButton2.setBounds(450, 300, 100, 100);
        this.optionButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame newFrame = new JFrame("Snake");
                newFrame.setSize(width, (int) (width * .8));
                newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                newFrame.getContentPane().add(gameGUI);
                newFrame.setVisible(true);
                SnakeController snakeController = new SnakeController(snakeModel, 150, gameGUI);

                newFrame.addKeyListener(snakeController);
                newFrame.pack();
                snakeController.startNewGame();
                mainFrame.setVisible(false);
            }
        });

        this.mainPanel.add(this.optionButton2);
        this.optionButton3 = new JButton("Hard");
        this.optionButton3.setBounds(600, 300, 100, 100);
        this.optionButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame newFrame = new JFrame("Snake");
                newFrame.setSize(width, (int) (width * .8));
                newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                newFrame.getContentPane().add(gameGUI);
                newFrame.setVisible(true);
                SnakeController snakeController = new SnakeController(snakeModel, 75, gameGUI);

                newFrame.addKeyListener(snakeController);
                newFrame.pack();
                snakeController.startNewGame();
                mainFrame.setVisible(false);
            }
        });

        this.optionButton4 = new JButton("Menu");
        this.optionButton4.setBounds(500 - 120 / 2, 600, 150, 75);
        this.optionButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new MenuGUI();
                mainFrame.setVisible(false);
            }
        });

        this.mainPanel.add(this.optionButton4);
        this.mainPanel.add(this.optionButton3);
        this.mainFrame.add(this.mainPanel);
        this.mainFrame.pack();
        this.mainFrame.setVisible(true);
    }
}

