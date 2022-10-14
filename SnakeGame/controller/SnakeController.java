package controller;

import model.Direction;
import model.SnakeModel;
import view.MenuGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class SnakeController implements KeyListener, ActionListener, java.io.Serializable {
    SnakeModel snakeModel;
    SnakeUserInterface userInterface;
    Timer timer;
    int duration;

    public SnakeController(SnakeModel snakeModel, int difficulty, SnakeUserInterface userInterface) {
        this.snakeModel = snakeModel;
        this.userInterface = userInterface;
        this.duration = difficulty;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        snakeModel.move();
        this.userInterface.draw(this.snakeModel);
        if (snakeModel.hitWall() || snakeModel.hitSelf()) {
            endGame();
        } else if (snakeModel.checkForCoin()) {
            snakeModel.placeNewCoin();
        }
    }

    public void startNewGame() {
        timer = new Timer(duration, this);
        timer.start();
        snakeModel.placeNewCoin();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            snakeModel.setDirection(Direction.DIRECTION.RIGHT);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            snakeModel.setDirection(Direction.DIRECTION.LEFT);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            snakeModel.setDirection(Direction.DIRECTION.UP);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            snakeModel.setDirection(Direction.DIRECTION.DOWN);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // ignore this
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // ignore this
    }

    public void endGame() {
        this.timer.stop();
        try {
            File file = new File("Highscore.txt");
            Scanner scan = new Scanner(file);
            ArrayList<Integer> scores = new ArrayList<Integer>();
            while (scan.hasNext()) {
                scores.add(scan.nextInt());
            }
            if (this.snakeModel.getSnakeSize() - 4 > 0) {
                scores.add(this.snakeModel.getSnakeSize() - 4);
            }
            PrintWriter writer = new PrintWriter(file);
            for (int a : scores) {
                writer.println(a);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();    
        }
        JFrame mainFrame = new JFrame();
        int choice = JOptionPane.showConfirmDialog(mainFrame, "You " + "score:" + (this.snakeModel.getSnakeSize() - 4) + " Play again?", "Results", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            this.snakeModel = new SnakeModel();
            startNewGame();
        } else {            new MenuGUI();
            this.userInterface.setShow(false);
        }

    }
}
