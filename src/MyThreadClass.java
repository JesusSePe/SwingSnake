public class MyThreadClass implements Runnable{

    private boolean  pause = false;
    private Snake snk;

    private Thread hilo=new Thread(this);

    public MyThreadClass(boolean pause, Snake snk) {
        super();
        this.pause = pause;
        this.snk = snk;
        hilo.start();
    }

    public Thread getHilo() {
        return hilo;
    }

    public void setHilo(Thread hilo) {
        this.hilo = hilo;
    }

    public void run() {
        while (true) {
            try{ //speed
                Thread.sleep(500);
            }catch (InterruptedException e) { }
        }
    }
}