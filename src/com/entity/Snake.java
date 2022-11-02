package com.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.awt.Point;

import com.util.Global;
import com.Controller.*;

public class Snake {
    protected LinkedList<Point> body = new LinkedList<>();
    protected int width = 5;
    protected int nowdirect = -1;
    protected int olddirect = 1;
    protected Controller con;
    protected boolean alive = true;

    public Snake() {
        init();
    }

    protected void init() {
        int i;
        int x = Math.round((float) (Global.width / 2));
        int y = Math.round((float) (Global.height / 2));
        for (i = 1; i <= this.width; i++) {
            body.add(new Point(x * i, y));
        }
    }

    public void growth() {
        System.out.println("蛇开始变长");
        Point foot = body.getLast();
        int x = foot.x;
        int y = foot.y;
        Point head = body.getFirst();
        x = head.x;
        y = head.y;
		/*switch(this.nowdirect){
			case -1:
				//左移
				x++;
				break;
			case 1:
				x--;
				//右移
				break;
			case -2:
				//上移
				y++;
				break;
			case 2:
				//下移
				y--;
				break;	
		}*/
        switch (this.nowdirect) {
            case -1:
                //左移
                x--;
                break;
            case 1:
                x++;
                //右移
                break;
            case -2:
                //上移
                y--;
                break;
            case 2:
                //下移
                y++;
                break;
        }
        body.addFirst(new Point(x, y));
    }

    public void changeD(int d) {
        if (d != -this.nowdirect) {
            //不能回头
            this.olddirect = this.nowdirect;
            this.nowdirect = d;
        } else {
            System.out.println(d + "/" + this.olddirect + "不能掉头");
        }
    }

    protected void move() {
        Point n = body.getFirst();
        int x = n.x;
        int y = n.y;
        body.removeLast();// 蛇尾减掉一个像素
        switch (this.nowdirect) {
            case -1:
                //左移
                x--;
                break;
            case 1:
                x++;
                //右移
                break;
            case -2:
                //上移
                y--;
                break;
            case 2:
                //下移
                y++;
                break;
        }
        body.addFirst(new Point(x, y));// 蛇头增加一个像素 完成移动
    }

    public void isEatSelf() {
        Point head = body.getFirst();
        int x = head.x;
        int y = head.y;
        if (body.lastIndexOf(head) != -1 && body.lastIndexOf(head) != 0) {
            System.out.println("碰到自己");
            alive = false;
        }
    }

    public void isboom() {
        Point head = body.getFirst();

        if (head.x < 1) {
            alive = false;
            System.out.println("来到起点x坐标");
        } else if (head.x > Global.width - 2) {
            alive = false;
            System.out.println("来到末尾x坐标");
        }

        if (head.y < 1) {
            alive = false;
            System.out.println("来到起点y坐标");
        } else if (head.y > (Global.height - 2)) {
            alive = false;
            System.out.println("来到末尾y坐标");
        }
    }

    public Point gethead() {
        return body.getFirst();
    }

    public void startmove() {
        new th().start();
    }

    public void setmove(Controller c) {
        con = c;
    }

    public void draw(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.GRAY);
        for (Point b : body) {
            // 绘制一个扁平的矩形
            g.fillRect(b.x * Global.component_w, b.y * Global.component_h, Global.component_w, Global.component_h);
        }
        g.setColor(c);
    }

    /**
     * 内部线程类
     */
    class th extends Thread {
        public void run() {
            while (alive) {
                move();// 通过线程来移动蛇体，单线程中死循环会堵塞其他业务代码
                con.snakemove(Snake.this);
                try {
                    Thread.sleep(Global.speed);// 线程等待
                } catch (Exception ignored) {
                }
            }
        }
    }
}
