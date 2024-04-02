package algoritmo;

import individuo.Individuo;
import individuo.IndividuoFactory;
import individuo.IndividuoShafferFactory;
import problema.Problema;
import problema.ProblemaShaffe;
import util.CrossOver;
import util.Mutar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NSGA2 {
    public static void execute(IndividuoFactory indFactory,int nPop, int qtdEpocas){
        List<Individuo> pop = new ArrayList<>(nPop);
        for (int i = 0; i < nPop; i++) {
            pop.add(indFactory.getIndividuo());
        }
        int e = 1;
        while(e <= qtdEpocas){
            List<Individuo> Q = new ArrayList<>(nPop);
            makeOffspring(Q, pop,indFactory);
        }
    }
    public static void makeOffspring(List<Individuo> q, List<Individuo> pop, IndividuoFactory indFactory){
        Random rand = new Random();
        List<Individuo> popAux = new ArrayList<>(pop.size());
        popAux.addAll(pop);
        CrossOver co = new CrossOver();
        Mutar m = new Mutar();
        List<Individuo> filhos = new ArrayList<>();
        while(popAux.size()>1){
            int i = rand.nextInt(popAux.size());
            Individuo p1 = popAux.remove(i);
            i = rand.nextInt(popAux.size());
            Individuo p2 = popAux.remove(i);
            filhos.addAll(co.recombinar(indFactory,p1,p2));
        }
        m.mutar(filhos);
        pop.addAll(filhos);
    }
    public static void main(String[] args) {
        IndividuoFactory indFactory = new IndividuoShafferFactory();
        execute(indFactory,20,100);
    }
}
