package Aeroporto;

public class PistaAterrisagem extends Thread{
    private FilaAterrisagem fila;
    private Aviao aviao;

    public PistaAterrisagem(FilaAterrisagem fila, String string){
        this.fila = fila;
        this.setName(string);
    }


    @Override
    public void run(){
        while(true){
            try {
                sleep(random());
            } catch (InterruptedException ex) {
                System.out.println("Aconteceu algum erro inesperado!!!");
            }
            if (fila.isRemovable()){
                aviao = fila.getAviao();
                fila.remove();
                System.out.println("Aterrisando aviao " + Thread.currentThread().getName());
                System.out.println("Fim de viagem!!!");
                System.out.println("------------------------------------------");
                System.out.println("Envia avioes para estacionamento");
                try {
                    sleep(3000);
                } catch (InterruptedException ex) {
                    System.out.println("Aconteceu algum erro inesperado!!!");
                }
            }
        }
    }

    private long random() {
        Double random = Math.random() * 100;
        return (long) (random.intValue() % 10);
    }    
}
