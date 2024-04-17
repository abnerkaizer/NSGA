package util;

import individuo.Individuo;
import individuo.IndividuoFactory;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CrossOver {
    public List<Individuo> crossoverBLXa(@NotNull IndividuoFactory indFactory, @NotNull Individuo p1, Individuo p2, double lower, double upper) {
        List<Individuo> children = new ArrayList<>(2);
        Random rand = new Random();
        children.add(indFactory.getIndividuo());
        children.add(indFactory.getIndividuo());
        double[] aux1 = new double[p1.getVars().length];
        double[] aux2 = new double[p1.getVars().length];
        double alpha = rand.nextGaussian() * 0.1;
        for (int i = 0; i < p1.getVars().length; i++) {
            aux1[i] = p1.getVars()[i] + alpha * Math.abs(p1.getVars()[i] - p2.getVars()[i]);
            aux2[i] = p2.getVars()[i] + alpha * Math.abs(p1.getVars()[i] - p2.getVars()[i]);
            aux1[i] = RepairSolution.repair(aux1[i],lower, upper);
            aux2[i] = RepairSolution.repair(aux2[i],lower, upper);
        }
        children.getFirst().setVars(aux1);
        children.getLast().setVars(aux2);
        return children;
    }
}
