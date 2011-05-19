package Aeroporto;

public class Guiche extends Thread{
    private int thread1;
    private Passageiro onibus[];
    private int cont;
    public int lotacao;
    private int tempo;

    private FilaOnibus bus;
    

    public Guiche(FilaOnibus bus, String string){
        this.bus = bus;
        this.setName(string);

        onibus= new Passageiro[100];
        cont = 0;
        tempo = 0;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    @Override
    public void run() {
        int i;
        while(true) {
            if ((cont > 99)||(tempo > 10000)){
                tempo = 0;
                if (cont > 60){
                    try {
                        sleep(1);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Enviando onibus para aviao...");
                    bus.add(cont);

                    cont = 0;
                }
            }
            else{
                Passageiro p = new Passageiro();
                onibus[cont] = p;
                System.out.println("O passageiro" + cont + " foi colocado no lugar " + cont);
            }
            cont++;
            tempo = tempo + 200;
            pausa(200);
        }
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

    public void setThread1(int thread1) {
        this.thread1 = thread1;
    }

    public int getThread1() {
        return thread1;
    }

    public Passageiro[] getOnibus(){
        return onibus;
    }

    public void setOnibus(Passageiro[] onibus) {
        this.onibus = onibus;
    }

}