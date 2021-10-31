import java.util.*;

public class Egg {

    private int posX;
    private int posY;
    //constructor
    public Egg() {

        boolean y_Ok=true;
        boolean x_Ok=true;
        int x_Number = 0;
        int y_Number=0;

        while (x_Ok) {
            x_Number = (int)(Math.random() * 37);
            if (x_Number>=3 && x_Number<=37) {

                x_Ok=false;
                x_Number=x_Number*20;
            }
        }
        while (y_Ok) {
            y_Number = (int)(Math.random() * 28);
            if (y_Number>=3 && y_Number<=28) {
                System.out.println("b");
                y_Ok=false;
                y_Number=y_Number*20;
            }
        }
        this.posX = x_Number;


        this.posY = y_Number;
    }

    //setget
    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    //metodos

    //drawEgg(Graphics g)


}