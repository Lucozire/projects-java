import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ShittyFrames {

    public static Random random = new Random();
    public static int height = 1080;
    public static int width = 1920;
    public static JFrame[] frame = new JFrame[20];
    public static int intensity = 6;
    public static int id;

    public static void main(String[] args) {


        for (int i = 0; i < frame.length; i++) {

            int randomheight = random.nextInt(0,height);
            int randomwidth = random.nextInt(0,width);


            frame[i] = new JFrame();
            frame[i].setSize(100,100);
            frame[i].setVisible(true);
            frame[i].setAlwaysOnTop(true);
            if (i != 0){
                frame[i].setLocation(randomwidth,randomheight);
            }

            id = i;

            multithread mthread = new multithread();
            mthread.start();

        }

    }

}
class multithread extends Thread {
    public void run() {
    windowmove(ShittyFrames.id);
    }
    public void windowmove(int window){
        double sine=0;
        while(true){
            try{
                if(window == ShittyFrames.frame.length){
                window = 0;
            }


                ShittyFrames.frame[window].setLocation(ShittyFrames.frame[window].getLocation().x + ShittyFrames.random.nextInt((-10- ShittyFrames.random.nextInt(0,1))* ShittyFrames.intensity,11* ShittyFrames.intensity), ShittyFrames.frame[window].getLocation().y + ShittyFrames.random.nextInt((-10- ShittyFrames.random.nextInt(0,1))* ShittyFrames.intensity,11* ShittyFrames.intensity));

                Point location = ShittyFrames.frame[window].getLocation();

                if (location.x >= ShittyFrames.width){
                    ShittyFrames.frame[window].setLocation(ShittyFrames.width/4, ShittyFrames.height/4);
                } else if (location.x <= 0){
                    ShittyFrames.frame[window].setLocation(ShittyFrames.width/4, ShittyFrames.height/4);
                }
                if (location.y >= ShittyFrames.height){
                    ShittyFrames.frame[window].setLocation(ShittyFrames.width/4, ShittyFrames.height/4);
                } else if (location.y <= 0){
                    ShittyFrames.frame[window].setLocation(ShittyFrames.width/4, ShittyFrames.height/4);
                }
            }
            catch (Exception e){
                System.out.println("Error");
            }
        window ++; sine=sine+0.01f;
        }

    }
}