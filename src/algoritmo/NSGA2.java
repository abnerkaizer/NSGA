package algoritmo;

import individuo.Individuo;
import individuo.IndividuoFactory;
import individuo.IndividuoShafferFactory;
import problema.Problema;
import problema.ProblemaShaffe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NSGA2 {
    public static void execute(IndividuoFactory infFactory,int nPop, int qtdEpocas){
        List<Individuo> pop = new ArrayList<>(nPop);
        for (int i = 0; i < nPop; i++) {
            pop.add(infFactory.getIndividuo());
        }
        int e = 1;
        while(e<= qtdEpocas){
            List<Individuo> Q = new ArrayList<>(nPop);
            makeOffspring(Q, pop);
        }
    }
    public static void makeOffspring(List<Individuo> q, List<Individuo> pop){
        Random rand = new Random();
        List<Individuo> popAux = new ArrayList<>(pop.size());
        popAux.addAll(pop);
        while(popAux.size()>1){
            int i = rand.nextInt(popAux.size());
            Individuo p1 = popAux.remove(i);
            i = rand.nextInt(popAux.size());
            Individuo p2 = popAux.remove(i);
        }
    }
    public static void main(String[] args) {
        IndividuoFactory indFactory = new IndividuoShafferFactory();
        execute(indFactory,20,100);
    }
}
