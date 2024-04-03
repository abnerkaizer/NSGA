package algoritmo;

import individuo.Individuo;
import individuo.IndividuoFactory;
import individuo.IndividuoShafferFactory;
import util.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NSGA2 {
    private final static double lower = -10, upper = 10;

    public static void execute(IndividuoFactory indFactory, int nPop, int qtdEpocas) {
        List<Individuo> pop = new ArrayList<>(nPop);
        for (int i = 0; i < nPop; i++) {
            pop.add(indFactory.getIndividuo());
        }
        int e = 1;
        QuickSort qs = new QuickSort();
        while (e <= qtdEpocas) {
            List<Individuo> Q = new ArrayList<>(nPop);
            makeOffspring(Q, pop, indFactory);
            List<Individuo> R = new ArrayList<>(nPop * 2);
            R.addAll(pop);
            R.addAll(Q);
            FNDS fnds = new FNDS();
            List<List<Individuo>> F = fnds.execute(R);
            List<Individuo> popNew = new ArrayList<>(nPop);
            int i = 0;
            while (popNew.size() + F.get(i).size() <= nPop) {
                popNew.addAll(F.get(i));
                i++;
            }
            List<Individuo> finalF = F.get(i);
            if (popNew.size() < nPop) {
                CrowdingDistance cd = new CrowdingDistance();
                cd.avaliar(finalF);
                qs.sort(finalF);
                int popNewSize = popNew.size();
                for (int j = 0; j < nPop - popNewSize; j++) {
                    popNew.add(finalF.get(j));
                }
            }
            pop = popNew;
            if (e % 20 == 0 || e == 1) {
                System.out.println("Epoca = " + e);
                imprimirPop(popNew);
                System.out.println();
            }
            e++;
        }
    }

    private static void imprimirPop(List<Individuo> popNew) {
        for (int i = 0; i < popNew.size(); i++) {
            Individuo ind = popNew.get(i);
            System.out.print("(");
            double[] objs = ind.getObjs();
            for (int j = 0; j < objs.length; j++) {
                if (j == objs.length - 1) {
                    System.out.printf("%f", objs[j]);
                    System.out.print(") ");
                } else {
                    System.out.printf("%f", objs[j]);
                    System.out.print(";");
                }
            }
        }
    }

    public static void makeOffspring(List<Individuo> q, List<Individuo> pop, IndividuoFactory indFactory) {
        Random rand = new Random();
        List<Individuo> popAux = new ArrayList<>(pop.size());
        popAux.addAll(pop);
        CrossOver co = new CrossOver();
        Mutation m = new Mutation();
        List<Individuo> children = new ArrayList<>();
        while (popAux.size() > 1) {
            int i = rand.nextInt(popAux.size());
            Individuo p1 = popAux.remove(i);
            i = rand.nextInt(popAux.size());
            Individuo p2 = popAux.remove(i);
            children.addAll(co.crossoverBLXa(indFactory, p1, p2, lower, upper));
        }
        m.mutate(children, lower, upper);
        pop.addAll(children);
    }

    public static void main(String[] args) {
        IndividuoFactory indFactory = new IndividuoShafferFactory();
        execute(indFactory, 20, 100);
    }
}
