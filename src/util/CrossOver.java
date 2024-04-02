package util;

import individuo.Individuo;
import individuo.IndividuoFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CrossOver {
    public List<Individuo> recombinar(IndividuoFactory indFactory,Individuo p1, Individuo p2){
        List<Individuo> filhos = new ArrayList<>();
        Random rand = new Random();
        filhos.add(indFactory.getIndividuo());
        filhos.add(indFactory.getIndividuo());
        double [] aux1 = new double[p1.getVars().length];
        double [] aux2 = new double[p1.getVars().length];
        double alpha = rand.nextGaussian()*0.1;
        for (int i = 0; i < p1.getVars().length; i++) {
            aux1[i] = p1.getVars()[i] + alpha*Math.abs(p1.getVars()[i]-p2.getVars()[i]);
            aux2[i] = p2.getVars()[i] + alpha*Math.abs(p1.getVars()[i]-p2.getVars()[i]);
        }
        filhos.getFirst().setVars(aux1);
        filhos.getLast().setVars(aux2);
        return filhos;
    }
}
