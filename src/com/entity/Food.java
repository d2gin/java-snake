package com.entity;

import java.awt.Graphics;
import java.util.Random;
import java.awt.Point;
import java.awt.Color;

import com.util.Global;

public class Food {
    protected Point local = new Point();

    public Food() {
        init();
    }

    /**
     * 生成随机数
     * @param start
     * @param end
     * @return
     */
    public int randL(int start, int end) {
        Random random = new Random();
        return random.nextInt(end) % (end - start + 1) + start;
    }

    public boolean isEated(Snake snake) {
        Point head = snake.gethead();
        if (local.x == head.x && local.y == head.y) {
            int x = this.randL(1, Global.width - 2);
            int y = this.randL(1, Global.height - 2);
            local.x = x;
            local.y = y;
            snake.growth();
            Global.score++;
            System.out.println("蛇吃了食物,现在食物的位置是(" + local.x + "," + local.y + ")");
            return true;
        }
        return false;
    }

    public void init() {
        int x, y;
        x = this.randL(1, Global.width - 2);
        y = this.randL(1, Global.height - 2);
        local.x = x;
        local.y = y;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fill3DRect(local.x * Global.component_w, local.y * Global.component_h, Global.component_w, Global.component_h, true);
    }
}
