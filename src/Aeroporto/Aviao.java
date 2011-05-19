package Aeroporto;

public class Aviao extends Thread{
    private int thread1;
    private int numPass;
    private Passageiro[] passageiros = new Passageiro[100];
    private FilaDecolagem decola;
    private FilaOnibus bus;

    public Aviao(FilaDecolagem decola, FilaOnibus bus, String string){
        this.bus = bus;
        this.decola = decola;
        this.setName(string);
        System.out.println("Criando o aviao " + this.getName());
    }

    public int getThread1() {
        return thread1;
    }

    @Override
    public void run(){
        while(true){
            try {
                sleep(random());
            } catch (InterruptedException ex) {
                System.out.println("Aconteceu algum erro inesperado!!!");
            }
            if (bus.isRemovable()){
                numPass = bus.getCont();
                bus.remove();
                System.out.println("Recebendo onibus com " + numPass + "passageiros");
                decola.add(this);
                try {
                    sleep(3000);
                } catch (InterruptedException ex) {
                    System.out.println("Aconteceu algum erro inesperado!!!");
                }
            }
        }
    }

    public void setNumPass(int numPass) {
        this.numPass = numPass;
    }

    public int getNumPass() {
        return numPass;
    }

    @Override
    public void start(){
        Thread t = new Thread(this);
        t.start();
    }

    public void pausa(int millis){
        try{
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean decolou(){
        return true;
    }

    public void setThread1(int thread1) {
        this.thread1 = thread1;
    }

    private long random() {
        Double random = Math.random() * 100;
        return (long) (random.intValue() % 10);
    }

}
