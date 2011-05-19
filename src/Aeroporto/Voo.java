/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Aeroporto;

/**
 *
 * @author edipoterra
 */
public class Voo extends Thread{
    private FilaVoo fila;
    private FilaAterrisagem aterrisa;
    private Aviao aviao = null;

    public Voo(FilaVoo fila, FilaAterrisagem aterrisa, String string){
        this.fila = fila;
        this.aterrisa = aterrisa;
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
                fila.getAviao();
                fila.remove();
                System.out.println("Aviao durante o voo");
                try {
                    sleep(15000);
                    aterrisa.add(aviao);
                } catch (InterruptedException ex) {
                    System.out.println("Aconteceu algum erro inesperado!!!");
                }

            }
        }

    }

    //Gera numero aleatorio de espera
    private long random() {
        Double random = Math.random() * 100;
        return (long) (random.intValue() % 10);
    }

}
