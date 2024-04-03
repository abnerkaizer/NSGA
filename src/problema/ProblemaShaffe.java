package problema;

public class ProblemaShaffe extends Problema {
    @Override
    public double[] avaliar(double[] vars) {
        int nVars = 2;
        double[] objs = new double[nVars];
        objs[0] = Math.pow(vars[0] - 1, 2) + Math.pow(vars[1], 2);
        objs[1] = Math.pow(vars[0], 2) + Math.pow(vars[1] - 1, 2);
        return objs;
    }

    @Override
    public int getNvars() {
        return 2;
    }
}
