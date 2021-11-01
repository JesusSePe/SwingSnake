import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class FramePrincipal extends JFrame{
    private int cell_width =20;
    private int cell_height =20;
    private int rows =25;
    private int cols =34;
    private int speed;
    private JPanel panel1= new JPanel();
    private Snake snk=new Snake(new Sentido(Direccion.Arriba));
    public Egg egg=new Egg();

    public Egg getEgg() {
        return egg;
    }

    public void setEgg(Egg egg) {
        this.egg = egg;
    }

    public FramePrincipal() throws HeadlessException {
        setSize ( 800, 600 );
        setLocationRelativeTo ( null ); //centering the frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Snake");
        getContentPane().setBackground(Color.white);
        setResizable(false);

        setVisible(true);

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub

            }
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_DOWN) {
                    System.out.println("down");
                    Sentido dir= new Sentido(Direccion.Abajo);
                    snk.setSnt(dir);
                    snk.printSnake(getGraphics());
                }
                if(e.getKeyCode()==KeyEvent.VK_UP) {
                    System.out.println("up");
                    Sentido dir= new Sentido(Direccion.Arriba);
                    snk.setSnt(dir);
                    snk.printSnake(getGraphics());
                }
                if(e.getKeyCode()==KeyEvent.VK_LEFT) {
                    System.out.println("left");
                    Sentido dir= new Sentido(Direccion.Izquierda);
                    snk.setSnt(dir);
                    snk.printSnake(getGraphics());

                }
                if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
                    System.out.println("right");
                    Sentido dir= new Sentido(Direccion.Derecha);
                    snk.setSnt(dir);
                    snk.printSnake(getGraphics());
                }
                checkEgg();
                System.out.println("X: " + snk.getHeadX() + " Y: " + snk.getHeadY());
            }


            @Override
            public void keyReleased(KeyEvent e) {
                checkEgg();
            }
        });

    }

    public void checkEgg(){
        // Check if you ate the egg
        if (snk.getHeadX()==getEgg().getPosX() && snk.getHeadY() == getEgg().getPosY()) {
            snk.setEatenEgg(true);
            login.getPlayer().setpts(login.getPlayer().getpts() + 100);
            this.setEgg(new Egg());
            this.repaint();
        }
        // Increase snake size in case of eating egg
        if(snk.isEatenEgg()) {
            Nodo nodo = new Nodo(snk.getLastNodeX(), snk.getLastNodeY());
            snk.getSnake().add(nodo);
            snk.setEatenEgg(false);
        }
    }


    public void paint(Graphics g) {
        super.paint(g);
        snk.printSnake(getGraphics());
        //bordes
        g.setColor(Color.green);
        g.fillRect(0, 0, 60, 600);
        g.fillRect(740, 0, 60, 600);
        g.fillRect(0, 0, 800, 60);
        g.fillRect(0, 560, 800, 40);

        //egg
        g.setColor(Color.red);
        g.fillOval(egg.getPosX(), egg.getPosY(), cell_width, cell_height);

        //while (true) {

        //System.out.println(snk.toString());





        for (int i = 0; i < 35; ++i) {
            Color c = g.getColor();
            g.setColor(Color.BLACK);
            //  lineas horizontales
            if (i<26) {
                g.drawLine(60, 60+i*cell_width, cols*cell_height+60,60+i*cell_width );
            }

            //  lineas verticales
            g.drawLine(60 + i*cell_height, 60 , 60 + i*cell_height ,60 +rows*cell_width );
        }
	       /* try{ //speed
	        	Thread.sleep(300);
	        }catch (InterruptedException e) { }
       // }
        */

    	/*g.fillRect(snk.getSnake().get(0).getPosX(),snk.getSnake().get(0).getPosY(), cell_width, cell_height);
    	g.fillRect(snk.getSnake().get(1).getPosX(),snk.getSnake().get(1).getPosY(), cell_width, cell_height);
    	g.fillRect(snk.getSnake().get(2).getPosX(),snk.getSnake().get(2).getPosY(), cell_width, cell_height);*/
    }
}
