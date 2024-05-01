package util;

import individuo.Individuo;
import java.util.List;
import java.util.Random;

public class Mutation {
    public void mutate(List<Individuo> children, double lower, double upper) {
        Random rand = new Random();
        boolean mutated = false;
        double[] aux;
        for (Individuo child : children) {
            aux = child.getVars();
            for (int i = 0; i < aux.length; i++) {
                if (Math.random() >= 0.15) {
                    aux[i] += rand.nextGaussian();
                    aux[i] = RepairSolution.repair(aux[i], lower, upper);
                    mutated = true;
                }
            }
            if (!mutated) {
                int i = rand.nextInt(aux.length);
                aux[i] += rand.nextGaussian();
                aux[i] = RepairSolution.repair(aux[i], lower, upper);
            }
            child.setVars(aux);
        }
    }
}
