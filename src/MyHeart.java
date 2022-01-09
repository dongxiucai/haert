import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * 心心
 */
public class MyHeart extends JFrame implements Runnable {

    // 定义加载窗口大小
    public static final int GAME_WIDTH = 500;
    public static final int GAME_HEIGHT = 310;
    // 获取屏幕窗口大小
    public static final int WIDTH = Toolkit.getDefaultToolkit()
            .getScreenSize().width;
    public static final int HEIGHT = Toolkit.getDefaultToolkit()
            .getScreenSize().height;
    public static int i = 10;

    public MyHeart() {
        // 设置窗口标题
        this.setTitle("随心就好");
        // 设置窗口初始位置
        this.setLocation((WIDTH - GAME_WIDTH) / 2, (HEIGHT - GAME_HEIGHT) / 2);
        // 设置窗口大小
        this.setSize(GAME_WIDTH, GAME_HEIGHT);
        // 设置背景色
        this.setBackground(Color.black);
        // 设置窗口关闭方式
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置窗口显示
        this.setVisible(true);
        // 禁止窗口拉伸
        this.setResizable(false);
    }


    @Override
    public void paint(Graphics g) {

        double x, y, r;
        Image OffScreen = createImage(GAME_WIDTH, GAME_HEIGHT);
        Graphics drawOffScreen = OffScreen.getGraphics();

        //设置画笔颜色
        drawOffScreen.setColor(Color.PINK);
        drawOffScreen.setFont(new Font("Courier", Font.ITALIC, 20));
        // 绘制字体
        // 判断 i 大小
        if (i < 500) {
            drawOffScreen.drawString("若水三千", i, 60);
            drawOffScreen.drawString("我取一瓢", i + 10, 90);
            drawOffScreen.drawString("人潮拥挤", i - 20, 120);
            drawOffScreen.drawString("我只要你", i - 10, 150);
            drawOffScreen.drawString("句子我抄的", i + 30, 200);
            drawOffScreen.drawString("但喜欢你是真的", i - 50, 230);
        } else {
            i = 10;
        }

        //设置画笔颜色
        drawOffScreen.setColor(Color.white);
        // 绘制下雪 随机数
        if (i < 300) {
            for (int j = 10; j < 500; j += 10) {
                drawOffScreen.drawString("*", j, new Random().nextInt(j + i));
            }
        } else {
            i = 10;
        }

        //设置画笔颜色
        drawOffScreen.setColor(Color.RED);
        // 绘制心形
        for (int i = 0; i < 90; i++) {
            for (int j = 0; j < 90; j++) {
                r = Math.PI / 45 * i * (1 - Math.sin(Math.PI / 45 * j)) * 18;
                x = r * Math.cos(Math.PI / 45 * j) * Math.sin(Math.PI / 45 * i)
                        + GAME_WIDTH / 2;
                y = -r * Math.sin(Math.PI / 45 * j) + GAME_HEIGHT / 4;

                // 绘制椭圆
                drawOffScreen.fillOval((int) x, (int) y, 2, 2);
            }

            // 生成图片
            /*Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(50f));
            g2.drawImage(OffScreen,0,0,this);*/
            g.drawImage(OffScreen, 0, 0, this);
        }

        // 加10
        i += 10;

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(300);
                this.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}