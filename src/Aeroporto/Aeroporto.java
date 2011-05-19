package Aeroporto;

public class Aeroporto {

    public static void main(String[] args){
        //CRIANDO FILAS DIVERSAS E VARIADAS
        FilaDecolagem decolagem = new FilaDecolagem();
        FilaAterrisagem aterrisagem = new FilaAterrisagem();
        FilaVoo voo = new FilaVoo();
        FilaOnibus bus = new FilaOnibus();

        //CRIANDO PRODUTORES ....
        Guiche guiche = null;
        for (int i = 0; i < 3; i++){
            guiche = new Guiche(bus, "Guiche " + i);
            guiche.start();
        }

        //avioes
        Aviao aviao = null;
        for (int i = 0; i < 12; i++){
            aviao = new Aviao(decolagem, bus, "Aviao " + i);
            aviao.start();
        }

        // criar threads de voo para controla-las
        Voo voando = null;
        for (int i = 0; i < 12; i ++){
            voando = new Voo(voo, aterrisagem, "Voo numero " + i);
            voando.start();
        }

        PistaDecolagem decola = null;
        PistaAterrisagem aterrisa = null;

        for (int i = 0; i < 2; i++){
            decola = new PistaDecolagem(decolagem, voo, "Pista decolagem " + i);
            decola.start();

            aterrisa = new PistaAterrisagem(aterrisagem, "Pista aterrisagem " + i);
            aterrisa.start();
        }
    }
}
