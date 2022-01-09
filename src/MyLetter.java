import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 想说的话
 */
public class MyLetter extends JFrame implements Runnable {

    // 定义加载窗口大小
    public static final int GAME_WIDTH = 200;
    public static final int GAME_HEIGHT = 500;
    // 获取屏幕窗口大小
    public static final int WIDTH = Toolkit.getDefaultToolkit()
            .getScreenSize().width;
    public static final int HEIGHT = Toolkit.getDefaultToolkit()
            .getScreenSize().height;
    public static int i = 10;

    public MyLetter() {
        // 设置窗口标题
        this.setTitle("随心就好");
        // 设置窗口初始位置
        this.setLocation((WIDTH - GAME_WIDTH) / 2, (HEIGHT - GAME_HEIGHT) / 2);
        // 设置窗口大小
        this.setSize(GAME_WIDTH, GAME_HEIGHT);
        // 设置背景色
        this.setBackground(Color.white);
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
        drawOffScreen.setColor(Color.BLACK);
        // drawOffScreen.setFont(new Font("Courier", Font.ITALIC, 20));
        // 绘制字体
        // 判断 i 大小

        File file = new File("D:\\个人文件\\想说的话.txt");
        try {
            FileInputStream inputStream = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            List<String> lines = new ArrayList<>();
            String line = "";
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

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