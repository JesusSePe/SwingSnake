import java.awt.*;
import javax.swing.*;

public class panelfondo extends JPanel {


    Color colorfondo= Color.green;
    int tamMax,tam,can,res;
    //tamMax tamaño del panel
    // tam tamaño de los cuadrados
    //can cantidad de cuadrados

    public panelfondo (int tamMax, int can) {
        this.tamMax=tamMax;
        this.can=can;
        this.tam=tamMax/tam;
        this.res=tamMax%can;
    }
    @Override
    public void paint(Graphics pintor) {
        super.paint(pintor);
        pintor.setColor(colorfondo);
        for (int i = 0; i < can; i++) {
            for (int j = 0; j < can; j++) {
                pintor.fillRect(res/2+i*tam,res/2+j*tam, tam-1, tam-1);

            }

        }
    }

}