package com.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.awt.Point;

import com.util.Global;

public class NPC {
    protected LinkedList<Point> rocks = new LinkedList<>();

    protected void init() {
        int x, y;
        for (x = 0; x < Global.width; x++) {
            for (y = 0; y < Global.height; y++) {
                // 只在边缘绘制
                if (x == 0 || y == 0 || (x + 1) == Global.width || (y + 1) == Global.height) {// 判断是否为边缘坐标
                    rocks.add(new Point(x, y));
                }
            }
        }
    }

    public void draw(Graphics g) {
        init();// 生成墙壁的坐标点
        for (Point p : rocks) {
            // 砖块绘制成橘色
            g.setColor(Color.orange);
            // 绘制3d样式的矩形
            g.fill3DRect(p.x * Global.component_w, p.y * Global.component_h, Global.component_w, Global.component_h, true);
        }
    }
}
