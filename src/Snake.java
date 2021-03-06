import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.ConsoleHandler;

public class Snake {
    public Sentido snt;
    ArrayList<Nodo> snake = new ArrayList<Nodo>();
    public boolean eatenEgg = false;
    private int headX = 0;
    private int headY = 0;
    private int lastNodeX = 0;
    private int lastNodeY = 0;

    public int getLastNodeX() {
        return lastNodeX;
    }

    public void setLastNodeX(int lastNodeX) {
        this.lastNodeX = lastNodeX;
    }

    public int getLastNodeY() {
        return lastNodeY;
    }

    public void setLastNodeY(int lastNodeY) {
        this.lastNodeY = lastNodeY;
    }

    public int getHeadX() {
        return headX;
    }

    public void setHeadX(int headX) {
        this.headX = headX;
    }

    public int getHeadY() {
        return headY;
    }

    public void setHeadY(int headY) {
        this.headY = headY;
    }

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
                try {
                    avance(0, -20);
                } catch (EndGame e) {
                    e.printStackTrace();
                }
                break;
            case Abajo:
                try {
                    avance(0, 20);
                } catch (EndGame e) {
                    e.printStackTrace();
                }
                break;
            case Derecha:
                try {
                    avance(20, 0);
                } catch (EndGame e) {
                    e.printStackTrace();
                }
                break;
            case Izquierda:
                try {
                    avance(-20, 0);
                } catch (EndGame e) {
                    e.printStackTrace();
                }
                break;
        }

    }

    public void avance(int x, int y) throws EndGame {
        // New error for custom exception
        Throwable err = new Throwable();
        // Advance body
        for (int n=0;n<snake.size();n++) {
            // Head case
            if (n==0) {
                // Store last position
                snake.get(n).setLastPosX(snake.get(n).getPosX());
                snake.get(n).setLastPosY(snake.get(n).getPosY());
                // Store new position
                snake.get(n).setPosX(snake.get(n).getPosX() + x);
                snake.get(n).setPosY(snake.get(n).getPosY() + y);
                // Save head new position for checks
                setHeadX(snake.get(n).getPosX());
                setHeadY(snake.get(n).getPosY());
                // Check if you got out of the map
                if(headX < 60 ||  headX > 720) {
                    throw new EndGame("Te has salido del tablero. Fin del juego", err);
                }
                if(headY < 60 ||  headY > 540) {
                    throw new EndGame("Te has salido del tablero. Fin del juego", err);
                }

            }
            // Rest of the body case
            else {
                // Store last position
                snake.get(n).setLastPosX(snake.get(n).getPosX());
                snake.get(n).setLastPosY(snake.get(n).getPosY());
                // Set new position
                snake.get(n).setPosX(snake.get(n-1).getLastPosX() );
                snake.get(n).setPosY(snake.get(n-1).getLastPosY() );
                // Store part position for checks
                lastNodeX = snake.get(n).getPosX();
                lastNodeY = snake.get(n).getPosY();
                // Check if you did bite yourself
                if(lastNodeX == headX && lastNodeY == headY) {
                    throw new EndGame("Te has mordido. Fin del juego", err);
                }
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
        }
    }
}

