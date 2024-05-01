package algoritmo;

import individuo.Individuo;
import individuo.IndividuoFactory;
import util.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NSGA2 {
    private final double lowerBound, upperBound;

    public NSGA2(double lowerBound, double upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public void execute(IndividuoFactory indFactory, int nPop, int qtdEpocas) {
        List<Individuo> pop = new ArrayList<>(nPop);
        for (int i = 0; i < nPop; i++) {
            pop.add(indFactory.getIndividuo());
        }
        int e = 1;
        QuickSort qs = new QuickSort();
        while (e <= qtdEpocas) {
            makeOffspring(pop, indFactory);
            List<Individuo> R = new ArrayList<>(nPop * 2);
            R.addAll(pop);
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
            if (e == 1||e==10||e==50||e==100||e==1000) {
                System.out.println("Epoca = " + e);
                imprimirPop(popNew);
                System.out.println();
            }
            e++;
        }
    }

    private void imprimirPop(List<Individuo> popNew) {
        for (Individuo ind : popNew) {
            System.out.print("(");
            double[] objs = ind.getObjs();
            for (int i = 0; i < objs.length; i++) {
                if (i == objs.length - 1) {
                    System.out.printf("%f", objs[i]);
                    System.out.print(") ");
                } else {
                    System.out.printf("%f", objs[i]);
                    System.out.print(";");
                }
            }
        }
    }

    private void makeOffspring(List<Individuo> pop, IndividuoFactory indFactory) {
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
            children.addAll(co.crossoverBLXa(indFactory, p1, p2, lowerBound, upperBound));
        }
        m.mutate(children, lowerBound, upperBound);
        pop.addAll(children);
    }
}
