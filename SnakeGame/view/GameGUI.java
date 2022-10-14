package view;

import controller.SnakeUserInterface;
import model.SnakeModel;

import javax.swing.*;
import java.awt.*;

public class GameGUI extends JPanel implements SnakeUserInterface {
    int width;
    int height;
    SnakeModel snakeModel = new SnakeModel();
    int unit;

    public GameGUI() {
        super();
        this.width = 1000;
        this.height = (int) (this.width*.8);
        this.unit = (int) (width*0.025);
        this.setPreferredSize(new Dimension(this.width, this.height));
        this.setBackground(Color.BLACK);
    }

    @Override
    public void draw(SnakeModel snakeModel) {
        this.snakeModel = snakeModel;
        this.repaint();
    }

    public void paint(Graphics g) {
        this.setBackground(Color.black);
        g.setColor(Color.black);
        g.fillRect(0, 0, width, height - 6 * unit);
        g.setColor(Color.darkGray);
        g.fillRect(0, height - 6 * unit, width,  6*unit);
        g.setColor(Color.GRAY);
        g.fillRect(unit, height - 5 * unit, width - 2 * unit, 4 * unit);
        g.setFont(new Font("Symbola", Font.BOLD, (int) (1.5* unit)));
        g.setColor(Color.BLACK);
        g.drawString("Score: " + (this.snakeModel.getSnakeSize() - 4), 2 * unit, (int) (height - 2.5 * unit));
        g.setColor(Color.WHITE);
        for (int w = 0; w < snakeModel.getSnakeSize(); w++) {
            if (w == 0) {
                g.setColor(Color.RED);
            }
            g.fillRect(snakeModel.getX(w), snakeModel.getY(w), (int) (unit * 0.92), (int) (unit * 0.92));
            g.setColor(Color.WHITE);
        }
        g.setColor(Color.yellow);
        g.fillOval(this.snakeModel.getCoinX(), this.snakeModel.getCoinY(), unit, unit);
    }

    @Override
    public void setShow(boolean b) {
        setVisible(b);
    }
}




