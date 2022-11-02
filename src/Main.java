import com.Controller.*;
import com.entity.*;
import com.util.*;
import com.view.*;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        Snake snake = new Snake();// 蛇体
        Food food = new Food();// 食物
        NPC npc = new NPC();// 墙壁
        Panel panel = new Panel();// JPanel面板 用于容载和绘制游戏组件
        Controller c = new Controller(snake, food, npc, panel);// 游戏控制
        JFrame frame = new JFrame("测试");// 启动一个窗口
        Listener listener = new Listener(snake);// 按键监听

        frame.addKeyListener(listener);// 设置监听器
        frame.add(panel);// 添加面板
        frame.setSize(Global.width * Global.component_w + 100, Global.width * Global.component_h + 100);// 配置窗口大小
        snake.setmove(c);// 注册游戏控制器
        snake.startmove();// 蛇体开始移动
        frame.setVisible(true);// 显示窗口
    }
}
