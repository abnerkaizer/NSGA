package individuo;

import problema.Problema;
import problema.ProblemaShaffe;


public class IndividuoShafferFactory implements IndividuoFactory {
    private final Problema problema;

    public IndividuoShafferFactory() {
        this.problema = new ProblemaShaffe();
    }

    public Individuo getIndividuo() {
        double[] vars = new double[2];
        for (int i = 0; i < vars.length; i++) {
            vars[i] = Math.random() * 100 - 50;
        }

        return new Individuo(this.problema, vars);
    }
}
