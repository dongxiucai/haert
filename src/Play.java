import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * 播放音乐
 * My Love
 */
class Play implements Runnable{

    @Override
    public void run() {
        // 音乐播放路径
        String path = new File("").getAbsolutePath();
        File file = new File(path + "\\myLove\\MyLove.wav");
        try {
            while (true){
                FileInputStream fis = new FileInputStream(file);
                BufferedInputStream stream = new BufferedInputStream(fis);
                Player player = new Player(stream);
                player.play();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}