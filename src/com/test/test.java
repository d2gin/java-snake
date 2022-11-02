package com.test;

import com.Controller.*;
import com.entity.*;
import com.view.*;
import com.util.*;

import javax.swing.JFrame;

public class test {
    public static void main(String[] args) {
        NPC npc = new NPC();
        Snake snake = new Snake();
        Food food = new Food();
        Panel panel = new Panel();
        Controller c = new Controller(snake, food, npc, panel);
        JFrame frame = new JFrame("贪吃蛇");
        Listener listen = new Listener(snake);

        frame.setSize(Global.width * Global.component_w + 100, Global.height * Global.component_h + 100);
        frame.addKeyListener(listen);
        snake.setmove(c);
        snake.startmove();
        frame.add(panel);
        frame.setVisible(true);
    }

}
