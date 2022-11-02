package com.util;

import java.awt.event.*;

import com.entity.*;

public class Listener extends KeyAdapter {
    protected Snake snake;

    public Listener(Snake snake) {
        this.snake = snake;
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                System.out.println("按下左键");
                snake.changeD(-1);
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("按下右键");
                snake.changeD(1);
                break;
            case KeyEvent.VK_UP:
                System.out.println("按下上键");
                snake.changeD(-2);
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("按下下键");
                snake.changeD(2);
                break;
        }
    }
}
