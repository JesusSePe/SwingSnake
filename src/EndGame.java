import java.awt.*;
import java.util.Arrays;

public class EndGame extends Exception {
    public EndGame(String errorMessage, Throwable err) {
        super(errorMessage, err);
        java.awt.Window win[] = java.awt.Window.getWindows();
        for(int i=0;i<win.length;i++){
            win[i].dispose();
        }
        new ranking();
    }
}
