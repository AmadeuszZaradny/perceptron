import component.MainWindow;
import processing.core.PApplet;

public class AppRunner{

    public static void main (String[] args) {
        String[] processingArgs= {"component.MainWindow"};
        PApplet.runSketch(processingArgs, new MainWindow());
    }
}
