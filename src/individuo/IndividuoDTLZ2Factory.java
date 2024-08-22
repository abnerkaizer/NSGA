package individuo;

import problema.Problema;
import problema.ProblemaDTLZ2;

public class IndividuoDTLZ2Factory implements IndividuoFactory{
    private final Problema problema;
    private final int nVars;

    public IndividuoDTLZ2Factory(int nVars,int numberOfObjectives){
        this.problema = new ProblemaDTLZ2(nVars, numberOfObjectives);
        this.nVars = nVars;
    }
    public Individuo getIndividuo(){
        double[] vars = new double[nVars];
        for (int i = 0; i < vars.length; i++) {
            vars[i] = Math.random();
        }
//        double [] vars = new double[] {0.68920914, 0., 0.37193993, 0.73608056, 0.71348334, 0., 0.60386215};
        return new Individuo(this.problema, vars);
    }
}
