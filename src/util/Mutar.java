package util;

import individuo.Individuo;

import java.util.List;
import java.util.Random;

public class Mutar {
    public void mutar(List<Individuo> filhos){
        double rand;
        Random r = new Random();
        double [] aux;
        for (Individuo filho : filhos) {
            rand = Math.random();
            aux = filho.getVars();
            if (rand >= 0.15) {
                aux[r.nextInt(aux.length)] += r.nextGaussian();
            } else {
                aux[r.nextInt(aux.length)] += r.nextGaussian();
            }
            filho.setVars(aux);
        }
    }
}
