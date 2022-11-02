package com.view;

import java.awt.Graphics;
import javax.swing.JPanel;

import com.entity.*;

public class Panel extends JPanel {
    NPC npc;
    Snake snake;
    Food food;

    public void display(Snake snake, Food food, NPC npc) {
        this.npc = npc;
        this.snake = snake;
        this.food = food;
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.food.draw(g);
        this.snake.draw(g);
        this.npc.draw(g);
    }
}
