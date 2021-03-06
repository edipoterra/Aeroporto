package Aeroporto;

public class FilaVoo {
    private static final Integer maxAvioes = 12;
    private Integer itens = new Integer(0);
    private boolean primeiro = false;
    private Aviao aviao = null;

    private synchronized boolean isFull() {
        if (this.itens >= maxAvioes) {
        if (!this.primeiro) this.primeiro = true;
            return true;
        }
        else {
            return false;
        }
    }

    private synchronized boolean isEmpty() {
        if (this.itens <= 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public synchronized void add(Aviao aviao) {
        while (isFull()) {
            try {
                synchronized (this) {
                    wait();
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.aviao = aviao;
        itens++;
        synchronized (this) {
            notifyAll();
        }
    }

    public synchronized void remove() {

        while (isEmpty()) {
            try {
                synchronized (this) {
                    wait();
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        itens--;
        System.out.println(Thread.currentThread().getName()
            + " aterrisou o aviao");
        synchronized (this) {
            notifyAll();
        }
    }

    public synchronized boolean isRemovable() {
        return this.primeiro;
    }

    public Aviao getAviao(){
        return aviao;
    }


}
