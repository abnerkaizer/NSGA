package problema;

public class ProblemaDTLZ1 extends Problema{
    private final int numberOfObjectives;
    private final int nVars;

    public ProblemaDTLZ1(int nVars, int numberOfObjectives) {
        this.nVars = nVars;
        this.numberOfObjectives = numberOfObjectives;

    }
    public double[] avaliar(double[] vars) {

        double[] f = new double[numberOfObjectives];
        double[] x = new double[nVars];

        int k = nVars - numberOfObjectives + 1;

        System.arraycopy(vars, 0, x, 0, nVars);

        double g = 0.0;
        for (int i = nVars - k; i < nVars; i++) {
            g += (x[i] - 0.5) * (x[i] - 0.5) - Math.cos(20.0 * Math.PI * (x[i] - 0.5));
        }

        g = 100 * (k + g);
        for (int i = 0; i < numberOfObjectives; i++) {
            f[i] = (1.0 + g) * 0.5;
        }

        for (int i = 0; i < numberOfObjectives; i++) {
            for (int j = 0; j < numberOfObjectives - (i + 1); j++) {
                f[i] *= x[j];
            }
            if (i != 0) {
                int aux = numberOfObjectives - (i + 1);
                f[i] *= 1 - x[aux];
            }
        }

        return f;
    }
    @Override
    public int getNvars() {
        return nVars;
    }
}
