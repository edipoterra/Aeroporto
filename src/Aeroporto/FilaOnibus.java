package Aeroporto;

public class FilaOnibus {
    private static final Integer max = 3;
    private Integer itens = new Integer(0);
    private Integer cont = new Integer(0);
    private boolean primeiro = false;

    private synchronized boolean isFull() {
        if (this.itens >= max) {
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

    public synchronized void add(int cont) {
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
        itens++;
        this.cont = cont;
        synchronized (this) {
            notifyAll();
        }
    }

    public synchronized void remove() {
        while (isEmpty()) {
            try {
                synchronized (this) {
                    wait();
                    System.out.println(Thread.currentThread().getName() + " Esperando voo...");
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        itens--;
        System.out.println(Thread.currentThread().getName()
            + " pegou os passageiros do onibus");
        synchronized (this) {
            notifyAll();
        }
    }

    public synchronized boolean isRemovable() {
        return this.primeiro;
    }

    public Integer getCont(){
        return cont;
    }

}
