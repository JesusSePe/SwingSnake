import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Snake {
    public Sentido snt;
    ArrayList<Nodo> snake = new ArrayList<Nodo>();
    public boolean eatenEgg = false;

    //constructor
    public Snake(Sentido snt) {
        super();

        this.snt = snt;
        this.snake.add(new Nodo());
        this.snake.add(new Nodo(snake.get(0).getPosX()+20,snake.get(0).getPosY()));
        this.snake.add(new Nodo(snake.get(1).getPosX()+20,snake.get(1).getPosY()));
        this.snake.add(new Nodo(snake.get(2).getPosX()+20,snake.get(2).getPosY()));
        this.snake.add(new Nodo(snake.get(3).getPosX()+20,snake.get(3).getPosY()));
        this.snake.add(new Nodo(snake.get(4).getPosX()+20,snake.get(4).getPosY()));

    }

    //getset
    public Sentido getSnt() {
        return snt;
    }
    public void setSnt(Sentido snt) {
        this.snt = snt;
    }

    public ArrayList<Nodo> getSnake() {
        return snake;
    }
    public void setSnake(ArrayList<Nodo> snake) {

    }
    public boolean isEatenEgg() {
        return eatenEgg;
    }
    public void setEatenEgg(boolean eatenEgg) {
        this.eatenEgg = eatenEgg;
    }

    @Override
    public String toString() {
        return "Snake [snake=" + snake.toString() + ", eatenEgg=" + eatenEgg + "]";
    }

    //metodos

    //metodos

    public void avanzar() {
        Direccion nuevaDireccion = snt.getDireccion();

        switch(nuevaDireccion) {
            case Arriba:
                System.out.println("Vamos para arriba");
                avance(0, -20);
                break;
            case Abajo:
                System.out.println("Vamos para abajo");
                avance(0, 20);
                break;
            case Derecha:
                System.out.println("Vamos para la derecha");
                avance(20, 0);
                break;
            case Izquierda:
                System.out.println("Vamos para la izquierda");
                avance(-20, 0);
                break;
        }
    }

    public void avance(int x, int y) {
        for (int n=0;n<snake.size();n++) {

            if (n==0) {
                snake.get(n).setLastPosX(snake.get(n).getPosX());
                snake.get(n).setLastPosY(snake.get(n).getPosY());

                snake.get(n).setPosX(snake.get(n).getPosX() + x);
                snake.get(n).setPosY(snake.get(n).getPosY() + y);
            }
            else {
                snake.get(n).setLastPosX(snake.get(n).getPosX());
                snake.get(n).setLastPosY(snake.get(n).getPosY());

                snake.get(n).setPosX(snake.get(n-1).getLastPosX() );
                snake.get(n).setPosY(snake.get(n-1).getLastPosY() );
            }


        }
    }
    public void draw(Graphics g) {

        for (Nodo n: this.snake) {
            g.setColor(Color.DARK_GRAY);
            g.fillRect(n.getPosX(), n.getPosY(), 20, 20);


        }



    }

    public void printSnake(Graphics g) {
        this.avanzar();
        this.draw(g);
        //borrar ultimo cuadrado

        g.setColor(Color.WHITE);
        g.fillRect(this.getSnake().get(this.getSnake().size()-1).getLastPosX(),this.getSnake().get(this.getSnake().size()-1).getLastPosY(),20,20);
        g.setColor(Color.black);
        g.drawRect(this.getSnake().get(this.getSnake().size()-1).getLastPosX(),this.getSnake().get(this.getSnake().size()-1).getLastPosY(),20,20);

    }
    public void keyTyped(KeyEvent ev) {
        if (ev.getKeyCode() == KeyEvent.VK_UP ) {
            System.out.println("downnnnnnnnnnnnnn");

        }
    }
}
