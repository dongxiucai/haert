import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * 比个小心心
 */
public class BiXin {

    public static void main(String[] args) throws Exception{

        Play play = new Play();
        MyHeart myHeart = new MyHeart();

        Thread p = new Thread(play);
        Thread h = new Thread(myHeart);
        p.start();
        h.start();
    }
}
