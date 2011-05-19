package Aeroporto;

public class PistaDecolagem extends Thread{
    private FilaDecolagem fila;
    private FilaVoo voo;
    private Aviao aviao = null;

    public PistaDecolagem(FilaDecolagem fila, FilaVoo voo, String string){
        this.fila = fila;
        this.voo = voo;
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
                System.out.println("Decolando aviao");
                try {
                    sleep(3000);
                    voo.add(aviao);

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
