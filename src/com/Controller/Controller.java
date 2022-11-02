package com.Controller;

import com.entity.*;
import com.util.Global;
import com.view.Panel;

public class Controller {
    protected Snake snake;
    protected Food food;
    public NPC npc;
    public Panel panel;

    public Controller(Snake snake, Food food, NPC npc, Panel panel) {
        this.npc = npc;
        this.food = food;
        this.panel = panel;
    }

    public void snakemove(Snake sn) {
        sn.isboom();
        sn.isEatSelf();
        if (food.isEated(sn) && Global.speed > 100) {
            Global.speed -= 10;// 如果蛇体太长时，将移动速度降低
        }
        System.out.println("现在分数: " + Global.score + ", 现在的速度: " + Global.speed);
        panel.display(sn, this.food, this.npc);
    }

    public void startG() {
        this.snake.startmove();
    }
}
